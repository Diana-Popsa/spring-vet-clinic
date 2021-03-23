package ro.fasttrackit.vetclinic.model;


import java.time.LocalDate;

public class ConsultationDto {
    private Long id;
    private LocalDate dateOfConsultation;
    private Long vetId;
    private Long petId;
    private Long ownerId;

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
                ", dateOfConsultation=" + dateOfConsultation +
                ", vetId=" + vetId +
                ", petId=" + petId +
                ", ownerId=" + ownerId +
                '}';
    }
}
