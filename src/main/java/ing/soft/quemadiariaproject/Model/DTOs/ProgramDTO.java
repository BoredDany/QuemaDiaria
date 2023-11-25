package ing.soft.quemadiariaproject.Model.DTOs;

public class ProgramDTO {
    private String TrainerUsername;
    private String name;
    private String description;
    private String duration;
    private int likes;
    private int views;
    private int subscriptors;
    private int acomplishment;

    public ProgramDTO(String trainerUsername, String name, int likes, int views, int subscriptors, int acomplishment) {
        TrainerUsername = trainerUsername;
        this.name = name;
        this.likes = likes;
        this.views = views;
        this.subscriptors = subscriptors;
        this.acomplishment = acomplishment;
    }

    public ProgramDTO(String trainerUsername, String name, String description) {
        TrainerUsername = trainerUsername;
        this.name = name;
        this.description = description;
    }

    public void setTrainerUsername(String trainerUsername) {
        TrainerUsername = trainerUsername;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setSubscriptors(int subscriptors) {
        this.subscriptors = subscriptors;
    }

    public void setAcomplishment(int acomplishment) {
        this.acomplishment = acomplishment;
    }

    public String getDuration() {
        return duration;
    }

    public int getLikes() {
        return likes;
    }

    public int getViews() {
        return views;
    }

    public int getSubscriptors() {
        return subscriptors;
    }

    public int getAcomplishment() {
        return acomplishment;
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