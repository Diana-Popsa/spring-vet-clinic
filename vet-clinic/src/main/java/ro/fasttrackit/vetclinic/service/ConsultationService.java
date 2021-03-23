package ro.fasttrackit.vetclinic.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ro.fasttrackit.vetclinic.model.ConsultationDto;
import ro.fasttrackit.vetclinic.model.entity.ConsultationEntity;
import ro.fasttrackit.vetclinic.model.entity.OwnerEntity;
import ro.fasttrackit.vetclinic.model.entity.PetEntity;
import ro.fasttrackit.vetclinic.model.entity.VetEntity;
import ro.fasttrackit.vetclinic.model.message.ConsultationMessageDto;
import ro.fasttrackit.vetclinic.repository.ConsultationRepository;
import ro.fasttrackit.vetclinic.repository.OwnerRepository;
import ro.fasttrackit.vetclinic.repository.PetRepository;
import ro.fasttrackit.vetclinic.repository.VetRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultationService {
    @Value("${server.port}")
    private String serverPort;

    private final ConsultationRepository repository;
    private final PetRepository petRepository;
    private final VetRepository vetRepository;
    private final OwnerRepository ownerRepository;
    private final RabbitTemplate template;
    private final DirectExchange directExchange;


    public ConsultationService(ConsultationRepository injectedRepo, PetRepository injectedPetRepository, VetRepository injectedVetRepository, OwnerRepository injectedOwnerRepository, RabbitTemplate template, DirectExchange directExchange) {
        this.repository = injectedRepo;
        this.petRepository = injectedPetRepository;
        this.vetRepository = injectedVetRepository;
        this.ownerRepository = injectedOwnerRepository;
        this.template = template;
        this.directExchange = directExchange;

    }

    @Transactional
    public List<ConsultationDto> findAllConsultations() {
        return this.repository.findAll()
                .stream()
                .map(consultationEntity -> mapEntityToResponse(consultationEntity))
                .collect(Collectors.toList());
    }

    @Transactional
    public ConsultationDto createNewConsultation(ConsultationDto request) {
        ConsultationEntity newConsultation = new ConsultationEntity();

        newConsultation.setDateOfConsultation(request.getDateOfConsultation());
        newConsultation.setVet(vetRepository.findVetById(request.getVetId()));
        newConsultation.setOwner(ownerRepository.findOwnerById(request.getOwnerId()));
        newConsultation.setPet(petRepository.findPetById(request.getPetId()));

        ConsultationEntity savedConsultationEntity = this.repository.save(newConsultation);


        ConsultationMessageDto consultationCreatedMessage = new ConsultationMessageDto();
        consultationCreatedMessage.setId(newConsultation.getId());
        consultationCreatedMessage.setPetName(newConsultation.getPet().getName());
        consultationCreatedMessage.setVetName(newConsultation.getVet().getFirstName() + "  "
                + newConsultation.getVet().getLastName());
        consultationCreatedMessage.setOwnerName(newConsultation.getOwner().getFirstName() + " "
                + newConsultation.getOwner().getLastName());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String messageConverted = objectMapper.writeValueAsString(consultationCreatedMessage);
            template.convertAndSend(directExchange.getName(), "consultation-msg", messageConverted);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return mapEntityToResponse(savedConsultationEntity);
    }

    @Transactional
    public ConsultationDto getConsultationById(Long consultationId) {
        return this.repository.findById(consultationId)
                .map(entity -> mapEntityToResponse(entity))
                .get();
    }

    @Transactional
    public ConsultationDto updateConsultation(ConsultationDto requested) {
        ConsultationEntity consultationUpdate = new ConsultationEntity();
        consultationUpdate.setId(requested.getId());
        consultationUpdate.setVet(vetRepository.findVetById(requested.getVetId()));
        consultationUpdate.setPet(petRepository.findPetById(requested.getPetId()));
        consultationUpdate.setOwner(ownerRepository.findOwnerById(requested.getOwnerId()));
        consultationUpdate.setDateOfConsultation(requested.getDateOfConsultation());

        ConsultationEntity updatedConsult = this.repository.save(consultationUpdate);
        return mapEntityToResponse(updatedConsult);
    }

    @Transactional
    public void deleteConsultationById(Long id) {
        this.repository.deleteById(id);
    }


    private ConsultationDto mapEntityToResponse(ConsultationEntity consultationEntity) {
        ConsultationDto response = new ConsultationDto();
        response.setId(consultationEntity.getId());
        response.setDateOfConsultation(consultationEntity.getDateOfConsultation());
        response.setVetId(consultationEntity.getVet().getId());
        response.setOwnerId(consultationEntity.getOwner().getId());
        response.setPetId(consultationEntity.getPet().getId());
        return response;
    }

}
