package ro.fasttrackit.vetclinic.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ro.fasttrackit.vetclinic.model.PetDto;
import ro.fasttrackit.vetclinic.model.entity.PetEntity;
import ro.fasttrackit.vetclinic.repository.PetRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {
    @Value("${server.port}")
    private String serverPort;

    private final PetRepository repository;

    public PetService(PetRepository injectedRepo) {
        this.repository = injectedRepo;
    }

    @Transactional
    public List<PetDto> findAllPets() {
        return this.repository.findAll()
                .stream()
                .map(petEntity -> mapEntityToResponse(petEntity))
                .collect(Collectors.toList());
    }

    @Transactional
    public PetDto getPetById(Long petId) {
        return this.repository.findById(petId)
                .map(entity -> mapEntityToResponse(entity))
                .get();
    }


    @Transactional
    public PetDto createNewPet(PetDto request) {
        PetEntity newPet = new PetEntity();
        newPet.setName(request.getName());
        newPet.setType(request.getType());

        PetEntity savedPetEntity = this.repository.save(newPet);
        return mapEntityToResponse(savedPetEntity);
    }


    @Transactional
    public PetDto updatePet(PetDto requested) {
        PetEntity petUpdate = new PetEntity();
        petUpdate.setId(requested.getId());
        petUpdate.setName(requested.getName());
        petUpdate.setType(requested.getType());

        PetEntity updatePet = this.repository.save(petUpdate);
        return mapEntityToResponse(updatePet);
    }

    @Transactional
    public void deletePetById(Long id) {
        this.repository.deleteById(id);
    }



    private PetDto mapEntityToResponse(PetEntity petEntity) {
        PetDto response = new PetDto();
        response.setId(petEntity.getId());
        response.setName(petEntity.getName());
        response.setType(petEntity.getType());
        return response;
    }
}
