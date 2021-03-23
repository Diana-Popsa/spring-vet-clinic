package ro.fasttrackit.vetnotification.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageReceiverConsultation {
    private Long id;
    private String vetName;
    private String petName;
    private String ownerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVetName() {
        return vetName;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }


    @Override
    public String toString() {
        return "MessageReceiverConsultation{" +
                "id=" + id +
                ", vetName='" + vetName + '\'' +
                ", petName='" + petName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
