package ing.soft.quemadiariaproject.Model.Domain.Entities;

public class Certificate {
    String TrainerUsername;
    String title;

    public Certificate(String trainerUsername, String title) {
        TrainerUsername = trainerUsername;
        this.title = title;
    }

    public String getTrainerUsername() {
        return TrainerUsername;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "TrainerUsername='" + TrainerUsername + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
