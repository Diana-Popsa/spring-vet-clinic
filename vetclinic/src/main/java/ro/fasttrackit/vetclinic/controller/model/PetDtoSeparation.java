package ro.fasttrackit.vetclinic.controller.model;

import ro.fasttrackit.vetclinic.model.Species;
import ro.fasttrackit.vetclinic.model.entity.PetEntity;

import java.util.Optional;

public class PetDtoSeparation {

private Long id;
private String name;
private Species type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Species getType() {
        return type;
    }

    public void setType(Species type) {
        this.type = type;
    }


}
