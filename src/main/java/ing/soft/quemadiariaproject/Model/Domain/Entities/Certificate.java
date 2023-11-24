package ing.soft.quemadiariaproject.Model.Domain.Entities;

import java.util.Date;

public class Certificate {
    private String TrainerUsername;
    private String institution;
    private String expeditionDate;
    private String description;
    private String link;
    private String title;

    public Certificate(String trainerUsername, String institution, String expeditionDate,
                       String description, String link, String title) {
        TrainerUsername = trainerUsername;
        this.institution = institution;
        this.expeditionDate = expeditionDate;
        this.description = description;
        this.link = link;
        this.title = title;
    }
    public boolean verifyCertificate(String trainerUsername, String institution, String expeditionDate, String title){
        return this.TrainerUsername.equals(trainerUsername) && this.institution.equals(institution)
                && this.expeditionDate.equals(expeditionDate) && this.title.equals(title);
    }
    public String getTrainerUsername() {
        return TrainerUsername;
    }

    public String getTitle() {
        return title;
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

    @Override
    public String toString() {
        return "Certificate{" +
                "TrainerUsername='" + TrainerUsername + '\'' +
                ", institution='" + institution + '\'' +
                ", expeditionDate=" + expeditionDate +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
