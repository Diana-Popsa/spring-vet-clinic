package ro.fasttrackit.vetclinic.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ro.fasttrackit.vetclinic.model.VetDto;
import ro.fasttrackit.vetclinic.model.entity.VetEntity;
import ro.fasttrackit.vetclinic.repository.VetRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VetService {
    @Value("${server.port}")
    private String serverPort;

    private final VetRepository repository;

    public VetService(VetRepository injectedRepository){
        this.repository = injectedRepository;
    }
    private VetDto mapEntityToResponse(VetEntity vetEntity){
        VetDto response = new VetDto();
        response.setId(vetEntity.getId());
        response.setFirstName(vetEntity.getFirstName());
        response.setLastName(vetEntity.getLastName());
        response.setCnp(vetEntity.getCnp());
        response.setYearOfGraduation(vetEntity.getYearOfGraduation());
        response.setSpecialization(vetEntity.getSpecialization());
        response.setPhoneNumber(vetEntity.getPhoneNumber());
        response.setEmail(vetEntity.getEmail());
        return response;
    }

    @Transactional
    public VetDto getVetById(Long vetId){
        return this.repository.findById(vetId)
                .map(entity -> mapEntityToResponse(entity))
                .get();
    }

    @Transactional
    public List<VetDto> findAllVets(){
        return this.repository.findAll()
                .stream()
                .map(vetEntity -> mapEntityToResponse(vetEntity))
                .collect(Collectors.toList());
    }

    @Transactional
    public VetDto createNewVet(VetDto request){
        VetEntity newVet = new VetEntity();
        newVet.setFirstName(request.getFirstName());
        newVet.setLastName(request.getLastName());
        newVet.setCnp(request.getCnp());
        newVet.setYearOfGraduation(request.getYearOfGraduation());
        newVet.setSpecialization(request.getSpecialization());
        newVet.setPhoneNumber(request.getPhoneNumber());
        newVet.setEmail(request.getEmail());

        VetEntity savedVetEntity = this.repository.save(newVet);
        return mapEntityToResponse(savedVetEntity);
    }

    @Transactional
    public VetDto updateVet(VetDto requested){
        VetEntity vetUpdate = new VetEntity();
        vetUpdate.setId(requested.getId());
        vetUpdate.setFirstName(requested.getFirstName());
        vetUpdate.setLastName(requested.getLastName());
        vetUpdate.setCnp(requested.getCnp());
        vetUpdate.setYearOfGraduation(requested.getYearOfGraduation());
        vetUpdate.setSpecialization(requested.getSpecialization());
        vetUpdate.setPhoneNumber(requested.getPhoneNumber());
        vetUpdate.setEmail(requested.getEmail());

        VetEntity updatedVet = this.repository.save(vetUpdate);
        return mapEntityToResponse(updatedVet);
    }

    @Transactional
    public void deleteVetById(Long id){
        this.repository.deleteById(id);
    }
}
