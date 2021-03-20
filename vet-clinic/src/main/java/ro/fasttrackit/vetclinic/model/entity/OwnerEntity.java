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
    private String cnp;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;

    @ManyToMany
    @JoinColumn(name = "id", unique = true)
    private List<PetEntity> pet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<ConsultationEntity> consultation;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public List<PetEntity> getPet() {
        return pet;
    }

    public void setPet(List<PetEntity> pet) {
        this.pet = pet;
    }

    public List<ConsultationEntity> getConsultation() {
        return consultation;
    }

    public void setConsultation(List<ConsultationEntity> consultation) {
        this.consultation = consultation;
    }

    @Override
    public String toString() {
        return "OwnerEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cnp=" + cnp +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", pet=" + pet +
                ", consultation=" + consultation +
                '}';
    }
}
