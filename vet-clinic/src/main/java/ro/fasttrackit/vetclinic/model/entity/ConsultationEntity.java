package ro.fasttrackit.vetclinic.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "consultation")
public class ConsultationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_of_consultation")
    private LocalDate dateOfConsultation;

    @ManyToOne
    private VetEntity vet;

    @ManyToOne
    private OwnerEntity owner;

    @ManyToOne
    private PetEntity pet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consultation")
    private List<DiagnosisEntity> diagnosis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfConsultation() {
        return dateOfConsultation;
    }

    public void setDateOfConsultation(LocalDate dateOfConsultation) {
        this.dateOfConsultation = dateOfConsultation;
    }

    public VetEntity getVet() {
        return vet;
    }

    public void setVet(VetEntity vet) {
        this.vet = vet;
    }

    public OwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(OwnerEntity owner) {
        this.owner = owner;
    }

    public PetEntity getPet() {
        return pet;
    }

    public void setPet(PetEntity pet) {
        this.pet = pet;
    }

    public List<DiagnosisEntity> getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(List<DiagnosisEntity> diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "ConsultationEntity{" +
                "id=" + id +
                ", dateOfConsultation=" + dateOfConsultation +
                ", vet=" + vet +
                ", owner=" + owner +
                ", pet=" + pet +
                ", diagnosis=" + diagnosis +
                '}';
    }
}
