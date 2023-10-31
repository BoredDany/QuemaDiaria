package ing.soft.quemadiariaproject.Model.Domain.Entities;

public class Program {
    String TrainerUsername;
    String name;
    String description;
    String duration;
    int likes;
    int views;

    public Program(String trainerUsername, String name, String description) {
        TrainerUsername = trainerUsername;
        this.name = name;
        this.description = description;
    }

    public Program(String trainerUsername, String name, String description, String duration, int likes, int views) {
        TrainerUsername = trainerUsername;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.likes = likes;
        this.views = views;
    }

    public Program(String name, String duration, int likes, int views) {
        this.name = name;
        this.duration = duration;
        this.likes = likes;
        this.views = views;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
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