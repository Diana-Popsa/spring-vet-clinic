package ro.fasttrackit.vetclinic.controller.model;

import ro.fasttrackit.vetclinic.model.entity.OwnerEntity;

import java.util.Optional;

public class OwnerDtoSeparation {
    private Optional<OwnerEntity> ownerEntity;
    private Long ownerId;

    public Optional<OwnerEntity> getOwnerEntity() {
        return ownerEntity;
    }

    public void setOwnerEntity(Optional<OwnerEntity> ownerEntity) {
        this.ownerEntity = ownerEntity;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
