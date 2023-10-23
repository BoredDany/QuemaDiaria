package ing.soft.quemadiariaproject.Model.Domain.Entities;

public class Program {
    String TrainerUsername;
    String name;
    String description;

    public Program(String trainerUsername, String name, String description) {
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
        return "Program{" +
                "TrainerUsername='" + TrainerUsername + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
