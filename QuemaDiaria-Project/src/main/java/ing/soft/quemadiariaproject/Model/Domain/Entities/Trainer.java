package ing.soft.quemadiariaproject.Model.Domain.Entities;

import java.util.List;

public class Trainer {
    private String name;
    private String identification;
    private String email;
    private String contact;
    private List<String> socialMedia;
    private Credential credentials;

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
    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setSocialMedia(List<String> socialMedia) {
        this.socialMedia = socialMedia;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "name='" + name + '\'' +
                ", identification='" + identification + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", socialMedia=" + socialMedia +
                '}';
    }
}
