package ro.fasttrackit.vetclinic.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ro.fasttrackit.vetclinic.model.OwnerDto;
import ro.fasttrackit.vetclinic.model.entity.OwnerEntity;
import ro.fasttrackit.vetclinic.repository.OwnerRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerService {
    @Value("${server.port}")
    private String serverPort;

    private final OwnerRepository repository;

    public OwnerService(OwnerRepository injectedOwnerRep) {
        this.repository = injectedOwnerRep;
    }



    private OwnerDto mapOwnerEntityToResponse(OwnerEntity ownerEntity) {
        OwnerDto response = new OwnerDto();
        response.setId(ownerEntity.getId());
        response.setFirstName(ownerEntity.getFirstName());
        response.setLastName(ownerEntity.getLastName());
        response.setCnp(ownerEntity.getCnp());
        return response;
    }

    @Transactional
    public OwnerDto createNewOwner(OwnerDto request) {
        OwnerEntity newOwner = new OwnerEntity();
        newOwner.setFirstName(request.getFirstName());
        newOwner.setLastName(request.getLastName());
        newOwner.setCnp(request.getCnp());

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

        OwnerEntity updateOwner = this.repository.save(ownerUpdate);
        return mapOwnerEntityToResponse(updateOwner);
    }

    @Transactional
    public void deleteOwnerById(Long id) {
        this.repository.deleteById(id);
    }

}
