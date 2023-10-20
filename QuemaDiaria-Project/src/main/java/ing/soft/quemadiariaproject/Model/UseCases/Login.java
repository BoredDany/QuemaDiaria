package ing.soft.quemadiariaproject.Model.UseCases;

import ing.soft.quemadiariaproject.Model.Domain.Entities.Credential;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.Persistence;

public class Login {
    private Persistence persistence;
    public Login(Persistence persistence){
        this.persistence = persistence;
    }
    public void doLogin(String username, String password) throws TrainerException {
        Trainer trainer = persistence.consultByUsername(username);
        if(!trainer.getCredentials().verifyCredentials(username, password)){
            throw new TrainerException("Credentials are not correct");
        }
        System.out.println("Logged in: " + trainer.getCredentials());
    }
}
