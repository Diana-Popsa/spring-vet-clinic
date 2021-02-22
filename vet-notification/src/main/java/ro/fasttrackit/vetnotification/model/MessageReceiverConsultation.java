package ro.fasttrackit.vetnotification.model;

public class MessageReceiverConsultation {
    private String vetName;
    private String petName;
    private String ownerName;
    private String diagnosis;

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

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public String toString() {
        return "MessageReceiverConsultation{" +
                "vetName='" + vetName + '\'' +
                ", petName='" + petName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }
}
