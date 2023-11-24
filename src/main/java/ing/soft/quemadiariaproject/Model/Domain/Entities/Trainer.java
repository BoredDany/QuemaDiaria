package ing.soft.quemadiariaproject.Model.Domain.Entities;

import java.util.List;

public class Trainer {
    private String name;
    private String identification;
    private String email;
    private List<String> socialMedia;
    private Credential credentials;
    private String speciality;

    public Trainer(String name, String identification, String email, Credential credentials) {
        this.name = name;
        this.identification = identification;
        this.email = email;
        this.credentials = credentials;
    }

    public Trainer(String name, String identification, String email,
                   List<String> socialMedia, Credential credentials,
                   String speciality) {
        this.name = name;
        this.identification = identification;
        this.email = email;
        this.socialMedia = socialMedia;
        this.credentials = credentials;
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }
    public String getIdentification() {
        return identification;
    }
    public String getEmail() {
        return email;
    }
    public List<String> getSocialMedia() {
        return socialMedia;
    }
    public Credential getCredentials(){
        return this.credentials;
    }
    public String getSpeciality() {
        return speciality;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "name='" + name + '\'' +
                ", identification='" + identification + '\'' +
                ", email='" + email + '\'' +
                ", socialMedia=" + socialMedia +
                ", credentials=" + credentials +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
