package ro.fasttrackit.vetclinic.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "owner")
public class OwnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "cnp")
    private Long cnp;

    @ManyToMany
    @JoinColumn(name = "pet_id", unique = true)
    private List<PetEntity> pet;

    public List<PetEntity> getPetEntity() {
        return pet;
    }

    public void setPetEntity(List<PetEntity> petEntity) {
        this.pet = petEntity;
    }

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

    @Override
    public String toString() {
        return "OwnerEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cnp=" + cnp +
                ", pet=" + pet +
                '}';
    }
}
