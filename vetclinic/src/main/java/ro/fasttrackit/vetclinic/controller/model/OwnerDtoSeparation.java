package ro.fasttrackit.vetclinic.controller.model;

import ro.fasttrackit.vetclinic.model.entity.OwnerEntity;

import java.util.Optional;

public class OwnerDtoSeparation {
   private Long id;
   private String firstName;
   private String lastName;
   private Long cnp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getCnp() {
        return cnp;
    }

    public void setCnp(Long cnp) {
        this.cnp = cnp;
    }
}
