package ro.fasttrackit.vetclinic.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "consultation")
public class ConsultationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "diagnosis")
    private String diagnosis;
    @Column(name = "recommendation")
    private String recommendation;
    @Column(name = "comments")
    private String comments;
    @Column(name = "date_of_scheduling")
    @Temporal(TemporalType.DATE)
    private Date dateOfScheduling;
    @Column(name = "date_of_consultation")
    @Temporal(TemporalType.DATE)
    private Date dateOfConsultation;


    @ManyToOne
    private PetEntity pet;

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PetEntity getPet() {
        return pet;
    }

    public void setPet(PetEntity pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "ConsultationEntity{" +
                "id=" + id +
                ", diagnosis='" + diagnosis + '\'' +
                ", recommendation='" + recommendation + '\'' +
                ", comments='" + comments + '\'' +
                ", dateOfScheduling=" + dateOfScheduling +
                ", dateOfConsultation=" + dateOfConsultation +
                ", pet=" + pet +
                '}';
    }
}
