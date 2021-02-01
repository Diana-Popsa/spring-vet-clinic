package ro.fasttrackit.vetclinic.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ro.fasttrackit.vetclinic.model.Owner;
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


    @Transactional
    private Owner mapOwnerEntityToResponse(OwnerEntity ownerEntity) {
        Owner response = new Owner();
        response.setId(ownerEntity.getId());
        response.setFirstName(ownerEntity.getFirstName());
        response.setLastName(ownerEntity.getLastName());
        response.setCnp(ownerEntity.getCnp());
        return response;
    }

    @Transactional
    public Owner createNewOwner(Owner request) {
        OwnerEntity newOwner = new OwnerEntity();
        newOwner.setFirstName(request.getFirstName());
        newOwner.setLastName(request.getLastName());
        newOwner.setCnp(request.getCnp());

        OwnerEntity savedOwnerEntity = this.repository.save(newOwner);
        return mapOwnerEntityToResponse(savedOwnerEntity);
    }


    @Transactional
    public List<Owner> findAllOwners() {
        return this.repository.findAll().stream().map(ownerEntity -> mapOwnerEntityToResponse(ownerEntity))
                .collect(Collectors.toList());
    }

    @Transactional
    public Owner getOwnerById(Long ownerId) {
        return this.repository.findOwnerById(ownerId).map(ownerEntity -> mapOwnerEntityToResponse(ownerEntity))
                .get();
    }

    @Transactional
    public Owner updateOwner(Owner requested) {
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
