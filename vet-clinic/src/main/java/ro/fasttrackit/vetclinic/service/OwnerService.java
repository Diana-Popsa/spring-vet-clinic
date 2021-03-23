package ro.fasttrackit.vetclinic.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ro.fasttrackit.vetclinic.model.ConsultationDto;
import ro.fasttrackit.vetclinic.model.OwnerDto;
import ro.fasttrackit.vetclinic.model.OwnerWithPetDto;
import ro.fasttrackit.vetclinic.model.entity.ConsultationEntity;
import ro.fasttrackit.vetclinic.model.entity.OwnerEntity;
import ro.fasttrackit.vetclinic.repository.ConsultationRepository;
import ro.fasttrackit.vetclinic.repository.OwnerRepository;
import ro.fasttrackit.vetclinic.repository.PetRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OwnerService {
    @Value("${server.port}")
    private String serverPort;

    private final OwnerRepository repository;
    private final PetRepository petRepository;
    private final ConsultationRepository consultationRepository;

    public OwnerService(OwnerRepository injectedOwnerRep, PetRepository petRepository, ConsultationRepository consultationRepository) {
        this.repository = injectedOwnerRep;
        this.petRepository = petRepository;
        this.consultationRepository = consultationRepository;
    }


    private OwnerDto mapOwnerEntityToResponse(OwnerEntity ownerEntity) {
        OwnerDto response = new OwnerDto();
        response.setId(ownerEntity.getId());
        response.setFirstName(ownerEntity.getFirstName());
        response.setLastName(ownerEntity.getLastName());
        response.setCnp(ownerEntity.getCnp());
        response.setEmail(ownerEntity.getEmail());
        response.setPhoneNumber(ownerEntity.getPhoneNumber());
        return response;
    }

    @Transactional
    public OwnerDto createNewOwner(OwnerDto request) {
        OwnerEntity newOwner = new OwnerEntity();
        newOwner.setFirstName(request.getFirstName());
        newOwner.setLastName(request.getLastName());
        newOwner.setCnp(request.getCnp());
        newOwner.setPhoneNumber(request.getPhoneNumber());
        newOwner.setEmail(request.getEmail());

        OwnerEntity savedOwnerEntity = this.repository.save(newOwner);
        return mapOwnerEntityToResponse(savedOwnerEntity);
    }


    @Transactional
    public List<OwnerDto> findAllOwners() {
        return this.repository.findAll()
                .stream()
                .map(ownerEntity -> mapOwnerEntityToResponse(ownerEntity))
                .collect(Collectors.toList());
    }

    @Transactional
    public OwnerDto getOwnerById(Long ownerId) {
        return this.repository.findById(ownerId)
                .map(entity -> mapOwnerEntityToResponse(entity))
                .get();
    }

    @Transactional
    public OwnerDto updateOwner(OwnerDto requested) {
        OwnerEntity ownerUpdate = new OwnerEntity();
        ownerUpdate.setId(requested.getId());
        ownerUpdate.setFirstName(requested.getFirstName());
        ownerUpdate.setLastName(requested.getLastName());
        ownerUpdate.setCnp(requested.getCnp());
        ownerUpdate.setPhoneNumber(requested.getPhoneNumber());
        ownerUpdate.setEmail(requested.getEmail());

        OwnerEntity updateOwner = this.repository.save(ownerUpdate);
        return mapOwnerEntityToResponse(updateOwner);
    }


    @Transactional
    public void deleteOwnerById(Long id) {
        this.repository.deleteById(id);
    }


    @Transactional
    public List<OwnerWithPetDto> ownerWithPets(List<Long> ownerId) {
        List<OwnerEntity> ownerEntityList;
        if (!ownerId.isEmpty()) {
            ownerEntityList = this.repository.findAllById(ownerId);
        } else {
            ownerEntityList = this.repository.findAll();
        }

        List<String> pets = new ArrayList<>();
        List<OwnerWithPetDto> ownersWithPetsResponseDto = new ArrayList<>();
        for (int o = 0; o < ownerEntityList.size(); o++) {
            OwnerWithPetDto ownerWithPetDto = new OwnerWithPetDto();
            ownerWithPetDto.setLastName(ownerEntityList.get(o).getLastName());
            ownerWithPetDto.setFirstName(ownerEntityList.get(o).getFirstName());
            ownerWithPetDto.setCnp(ownerEntityList.get(o).getCnp());
            ownerWithPetDto.setPhoneNr(ownerEntityList.get(o).getPhoneNumber());

            List<ConsultationEntity> consultationEntity;
            consultationEntity = ownerEntityList.get(o).getConsultation();
            List<OwnerWithPetDto> ownerWithPet;
            for (int p = 0; p < consultationEntity.size(); p++) {
                pets.add(consultationEntity.get(p).getPet().getName());
            }
            ownerWithPetDto.setPets(pets);
            ownersWithPetsResponseDto.add(ownerWithPetDto);

        }
        return ownersWithPetsResponseDto;
    }


    @Transactional
    public List<OwnerWithPetDto> allOwnerPets(List<Long> id, ConsultationDto consult) {
    //    Optional<ConsultationEntity> optionalConsultationEntity = consultationRepository.findOwnersWithPets(consult.getPetId(), consult.getOwnerId());
        List<OwnerEntity> allById = this.repository.findAllById(id);
        List<OwnerWithPetDto> ownersWithPetsResponseDto = new ArrayList<>();
        List<String> pets = new ArrayList<>();
        if (!id.isEmpty()) {
            for (OwnerEntity ownerEntity : allById) {
                OwnerWithPetDto ownerWithPetDto = new OwnerWithPetDto();
                ownerWithPetDto.setFirstName(ownerEntity.getFirstName());
                ownerWithPetDto.setLastName(ownerEntity.getLastName());
                ownerWithPetDto.setCnp(ownerEntity.getCnp());
                ownerWithPetDto.setPhoneNr(ownerEntity.getPhoneNumber());


                List<ConsultationEntity> consultationEntity;
                consultationEntity = ownerEntity.getConsultation();
                for (int p = 0; p < consultationEntity.size(); p++) {
                    pets.add(consultationEntity.get(p).getPet().getName());
                }
                ownerWithPetDto.setPets(pets);
                ownersWithPetsResponseDto.add(ownerWithPetDto);
            }
        } else {
            this.repository.findAll().forEach(ownerEntity -> {
                OwnerWithPetDto ownersWithPetDto = new OwnerWithPetDto();
                ownersWithPetDto.setFirstName(ownerEntity.getFirstName());
                ownersWithPetDto.setLastName(ownerEntity.getLastName());
                ownersWithPetDto.setCnp(ownerEntity.getCnp());
                ownersWithPetDto.setPhoneNr(ownerEntity.getPhoneNumber());

                List<ConsultationEntity> consultationEntity;
                consultationEntity = ownerEntity.getConsultation();
                for (int p = 0; p < consultationEntity.size(); p++) {
                    pets.add(consultationEntity.get(p).getPet().getName());
                }
                ownersWithPetDto.setPets(pets);
                ownersWithPetsResponseDto.add(ownersWithPetDto);
            });
        }
        return ownersWithPetsResponseDto;
    }


}
