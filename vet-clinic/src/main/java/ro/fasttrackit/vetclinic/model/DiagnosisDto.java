package ro.fasttrackit.vetclinic.model;

public class DiagnosisDto {
    private Long id;
    private Long consultationID;
    private String title;
    private String description;
    private String recommendations;

    private Long consultationId;

    public Long getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Long consultationId) {
        this.consultationId = consultationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getConsultationID() {
        return consultationID;
    }

    public void setConsultationID(Long consultationID) {
        this.consultationID = consultationID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    @Override
    public String toString() {
        return "DiagnosisDto{" +
                "id=" + id +
                ", consultationID=" + consultationID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", recommendations='" + recommendations + '\'' +
                ", consultationId=" + consultationId +
                '}';
    }
}
