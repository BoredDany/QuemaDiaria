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
    public void  verifyCredentials(String username, String password, Trainer trainer) throws TrainerException {
        if(!trainer.getCredentials().verifyCredentials(username, password)){
            throw new TrainerException("Credentials are not correct");
        }
    }
    public void  trainerExists(Trainer trainer) throws TrainerException {
        if(trainer == null){
            throw new TrainerException("Trainer not found");
        }
    }
    public void doLogin(String username, String password) throws TrainerException {
        Trainer trainer = persistence.consultByUsername(username);
        trainerExists(trainer);
        verifyCredentials(username, password,trainer);
        System.out.println("Logged in: " + trainer.getCredentials());
    }
}
