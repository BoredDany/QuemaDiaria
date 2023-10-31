package ing.soft.quemadiariaproject.Model.DTOs;

public class ProgramDTO {
    String TrainerUsername;
    String name;
    String description;

    public ProgramDTO(){}
    public ProgramDTO(String trainerUsername, String name, String description) {
        TrainerUsername = trainerUsername;
        this.name = name;
        this.description = description;
    }

    public String getTrainerUsername() {
        return TrainerUsername;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ProgramDTO{" +
                "TrainerUsername='" + TrainerUsername + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}