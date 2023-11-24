package ing.soft.quemadiariaproject.Model.DTOs;

import java.util.Date;

public class CertificateDTO {
    private String TrainerUsername;
    private String institution;
    private String expeditionDate;
    private String description;
    private String link;
    private String title;

    public CertificateDTO(String trainerUsername, String institution, String expeditionDate,
                          String description, String link, String title) {
        TrainerUsername = trainerUsername;
        this.institution = institution;
        this.expeditionDate = expeditionDate;
        this.description = description;
        this.link = link;
        this.title = title;
    }

    public String getTrainerUsername() {
        return TrainerUsername;
    }

    public String getInstitution() {
        return institution;
    }

    public String getExpeditionDate() {
        return expeditionDate;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public void setTrainerUsername(String trainerUsername) {
        TrainerUsername = trainerUsername;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setExpeditionDate(String expeditionDate) {
        this.expeditionDate = expeditionDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CertificateDTO{" +
                "TrainerUsername='" + TrainerUsername + '\'' +
                ", institution='" + institution + '\'' +
                ", expeditionDate=" + expeditionDate +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
