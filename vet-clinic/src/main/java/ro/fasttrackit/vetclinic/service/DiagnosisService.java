package ro.fasttrackit.vetclinic.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ro.fasttrackit.vetclinic.model.DiagnosisDto;
import ro.fasttrackit.vetclinic.model.entity.DiagnosisEntity;
import ro.fasttrackit.vetclinic.repository.ConsultationRepository;
import ro.fasttrackit.vetclinic.repository.DiagnosisRepository;

import javax.transaction.Transactional;

@Service
public class DiagnosisService {
    @Value("${server.port}")
    private String serverPort;

    private final DiagnosisRepository repository;
    private final ConsultationRepository consultationRepository;
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange directExchange;

    public DiagnosisService(DiagnosisRepository injectedRepo, ConsultationRepository injectedConsultationRepository, RabbitTemplate injectedRabbitTemplate, DirectExchange injectedDirectExchange){
        this.repository = injectedRepo;
        this.consultationRepository = injectedConsultationRepository;
        this.rabbitTemplate = injectedRabbitTemplate;
        this.directExchange = injectedDirectExchange;
    }

    private DiagnosisDto mapEntityToResponse(DiagnosisEntity diagnosisEntity){
        DiagnosisDto response = new DiagnosisDto();
        response.setId(diagnosisEntity.getId());
        response.setConsultationID(diagnosisEntity.getConsultation().getId());
        response.setTitle(diagnosisEntity.getTitle());
        response.setDescription(diagnosisEntity.getDescription());
        response.setRecommendations(diagnosisEntity.getRecommendations());

        return response;
    }
    @Transactional
    public DiagnosisDto createNewDiagnosis(DiagnosisDto request){
        DiagnosisEntity newDiagnosis = new DiagnosisEntity();
        newDiagnosis.setConsultation(consultationRepository.findConsultationById(request.getConsultationID()));
        newDiagnosis.setDescription(request.getDescription());
        newDiagnosis.setTitle(request.getTitle());
        newDiagnosis.setRecommendations(request.getRecommendations());

        DiagnosisEntity savedDiagnosis = this.repository.save(newDiagnosis);

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            String messageConverted = objectMapper.writeValueAsString(request);
            rabbitTemplate.convertAndSend(directExchange.getName(), "diagnosis", messageConverted);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return mapEntityToResponse(savedDiagnosis);
    }

}
