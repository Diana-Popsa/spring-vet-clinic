package ro.fasttrackit.vetclinic.controller.model;

import ro.fasttrackit.vetclinic.model.entity.PetEntity;

import java.util.Optional;

public class PetDtoSeparation {
private Optional<PetEntity> petEntity;
private Long petId;

    public Optional<PetEntity> getPetEntity() {
        return petEntity;
    }

    public void setPetEntity(Optional<PetEntity> petEntity) {
        this.petEntity = petEntity;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }
}
