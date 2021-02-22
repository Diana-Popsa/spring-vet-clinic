package ro.fasttrackit.vetclinic.model;


import java.util.Date;
import java.util.List;

public class ConsultationDto {
    private Long id;
    private Date dateOfScheduling;
    private Date dateOfConsultation;

    //    private VetDto vet;
//    private OwnerDto owner;
//    private PetDto pet;
    private Long diagnosisId;

    private Long vetId;
    private Long petId;
    private Long ownerId;

    public Long getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(Long diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

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

    public Long getVetId() {
        return vetId;
    }

    public void setVetId(Long vetId) {
        this.vetId = vetId;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "ConsultationDto{" +
                "id=" + id +
                ", dateOfScheduling=" + dateOfScheduling +
                ", dateOfConsultation=" + dateOfConsultation +
                ", diagnosisId=" + diagnosisId +
                ", vetId=" + vetId +
                ", petId=" + petId +
                ", ownerId=" + ownerId +
                '}';
    }
}
