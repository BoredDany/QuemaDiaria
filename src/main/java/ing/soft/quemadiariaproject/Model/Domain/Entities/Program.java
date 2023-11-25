package ing.soft.quemadiariaproject.Model.Domain.Entities;

public class Program {
    private String TrainerUsername;
    private String name;
    private String description;
    private String duration;
    private int likes;
    private int views;
    private int subscriptors;
    private int acomplishment;

    public Program(String trainerUsername, String name, String description, String duration, int likes, int views, int subscriptors, int acomplishment) {
        TrainerUsername = trainerUsername;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.likes = likes;
        this.views = views;
        this.subscriptors = subscriptors;
        this.acomplishment = acomplishment;
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

    public int getLikes() {
        return likes;
    }

    public int getViews() {
        return views;
    }

    public String getDuration() {
        return duration;
    }

    public int getSubscriptors() {
        return subscriptors;
    }

    public int getAcomplishment() {
        return acomplishment;
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