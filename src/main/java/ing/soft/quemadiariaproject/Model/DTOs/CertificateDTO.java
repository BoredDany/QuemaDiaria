package ing.soft.quemadiariaproject.Model.DTOs;

import java.util.Date;

public class CertificateDTO {
    private String TrainerUsername;
    private String institution;
    private Date expeditionDate;
    private String description;
    private String link;
    private String title;

    public CertificateDTO(String trainerUsername, String institution, Date expeditionDate,
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

    public Date getExpeditionDate() {
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
