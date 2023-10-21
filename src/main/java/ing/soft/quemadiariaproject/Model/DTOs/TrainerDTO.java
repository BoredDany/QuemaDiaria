package ing.soft.quemadiariaproject.Model.DTOs;

import ing.soft.quemadiariaproject.Model.Domain.Entities.Certificate;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Credential;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Program;

import java.util.List;

public class TrainerDTO {
    private String name;
    private String identification;
    private String email;
    private List<String> socialMedia;
    private String username;
    private String speciality;

    public TrainerDTO(String name, String identification, String email, List<String> socialMedia, String username, String speciality) {
        this.name = name;
        this.identification = identification;
        this.email = email;
        this.socialMedia = socialMedia;
        this.username = username;
        this.speciality = speciality;
    }
    public TrainerDTO(){

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIdentification() {
        return identification;
    }
    public void setIdentification(String identification) {
        this.identification = identification;
    }
    public String getEmail() {
        return email;
    }
    public List<String> getSocialMedia() {
        return socialMedia;
    }
    public String getUsername() {
        return username;
    }
    public String getSpeciality() {
        return speciality;
    }

    @Override
    public String toString() {
        return "TrainerDTO{" +
                "name='" + name + '\'' +
                ", identification='" + identification + '\'' +
                ", email='" + email + '\'' +
                ", socialMedia=" + socialMedia +
                ", username='" + username + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}

