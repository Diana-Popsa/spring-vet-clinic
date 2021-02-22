package ro.fasttrackit.vetclinic.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "consultation")
public class ConsultationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "recommendation")
    private String recommendation;
    @Column(name = "date_of_scheduling")
    @Temporal(TemporalType.DATE)
    private Date dateOfScheduling;
    @Column(name = "date_of_consultation")
    @Temporal(TemporalType.DATE)
    private Date dateOfConsultation;

    @ManyToOne
    private VetEntity vet;

    @ManyToOne
    private OwnerEntity owner;

    @ManyToOne
    private PetEntity pet;

    @OneToMany(cascade = CascadeType.ALL)
    //@ManyToMany(mappedBy = "consultation")
    private List<DiagnosisEntity> diagnosis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
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
                ", recommendation='" + recommendation + '\'' +
                ", dateOfScheduling=" + dateOfScheduling +
                ", dateOfConsultation=" + dateOfConsultation +
                ", vet=" + vet +
                ", owner=" + owner +
                ", pet=" + pet +
                ", diagnosis=" + diagnosis +
                '}';
    }
}
