package ing.soft.quemadiaria.Model.Domain.Entities;

public class Credential {
    private String username;
    private String password;
    public Credential(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean verifyCredentials(String username, String password){
        return this.password.equals(password) && this.username.equals(username);
    }

    @Override
    public String toString() {
        return "Credential{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
