package ro.fasttrackit.vetclinic.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "consultation")
public class ConsultationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_of_scheduling")
    @Temporal(TemporalType.DATE)
    private Date dateOfScheduling;

    @Column(name = "date_of_consultation")
    @Temporal(TemporalType.DATE)
    private Date dateOfConsultation;

    @ManyToOne(cascade = CascadeType.ALL)
    private VetEntity vet;

    @ManyToOne(cascade = CascadeType.ALL)
    private OwnerEntity owner;

    @ManyToOne(cascade = CascadeType.ALL)
    private PetEntity pet;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DiagnosisEntity> diagnosis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getDateOfScheduling() {
        return dateOfScheduling;
    }

    public void setDateOfScheduling(Date dateOfScheduling) {
        this.dateOfScheduling = dateOfScheduling;
    }

    public Date getDateOfConsultation() {
        return dateOfConsultation;
    }

    public void setDateOfConsultation(Date dateOfConsultation) {
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
                ", dateOfScheduling=" + dateOfScheduling +
                ", dateOfConsultation=" + dateOfConsultation +
                ", vet=" + vet +
                ", owner=" + owner +
                ", pet=" + pet +
                ", diagnosis=" + diagnosis +
                '}';
    }
}
