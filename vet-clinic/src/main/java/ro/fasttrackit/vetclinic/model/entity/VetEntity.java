package ro.fasttrackit.vetclinic.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "vet")
public class VetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "cnp")
    private String cnp;
    @Column(name = "year_of_Graduation")
    private LocalDate yearOfGraduation;
    @Column(name = "specialization")
    private String specialization;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vet")
    private List<ConsultationEntity> consultation;

    public LocalDate getYearOfGraduation() {
        return yearOfGraduation;
    }

    public void setYearOfGraduation(LocalDate yearOfGraduation) {
        this.yearOfGraduation = yearOfGraduation;
    }

    public List<ConsultationEntity> getConsultation() {
        return consultation;
    }

    public void setConsultation(List<ConsultationEntity> consultation) {
        this.consultation = consultation;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

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

    @Override
    public String toString() {
        return "VetEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cnp='" + cnp + '\'' +
                ", yearOfGraduation=" + yearOfGraduation +
                ", specialization='" + specialization + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
