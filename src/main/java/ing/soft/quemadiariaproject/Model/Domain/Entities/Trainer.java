package ing.soft.quemadiariaproject.Model.Domain.Entities;

import java.util.List;

public class Trainer {
    private String name;
    private String identification;
    private String email;
    private String contact;
    private List<String> socialMedia;
    private Credential credentials;
    private String speciality;
    private List<Program> programs;
    private List<Certificate> certificates;

    public Trainer(String name, String identification, String email, Credential credentials) {
        this.name = name;
        this.identification = identification;
        this.email = email;
        this.credentials = credentials;
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
    public String getContact() {
        return contact;
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
    public List<Program> getPrograms() {
        return programs;
    }
    public List<Certificate> getCertificates() {
        return certificates;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "name='" + name + '\'' +
                ", identification='" + identification + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", socialMedia=" + socialMedia +
                ", credentials=" + credentials +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
