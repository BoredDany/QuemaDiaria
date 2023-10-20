package ing.soft.quemadiariaproject.Model.UseCases;

import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.Persistence;

public class Register {
    private Persistence persistence;
    public Register(Persistence persistence){
        this.persistence = persistence;
    }
    public void verifyFullFields(Trainer trainer) throws TrainerException {
        if(trainer.getName().isEmpty() || trainer.getIdentification().isEmpty()
                || trainer.getEmail().isEmpty() || trainer.getCredentials().getUsername().isEmpty()
                || trainer.getCredentials().getPassword().isEmpty()){
            throw new TrainerException("Missing information");
        }
    }
    public void verifyIdentification(String identification) throws TrainerException {
        String ID_REGEX = "^[A-Za-z0-9]{8,12}$";
        if(!identification.matches(ID_REGEX)){
            throw new TrainerException("Invalid email");
        }
    }
    public void verifyEmail(String email) throws TrainerException {
        String EMAIL_REGEX = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        if(!email.matches(EMAIL_REGEX)){
            throw new TrainerException("Invalid email");
        }
    }
    public void verifyPassword(String password) throws TrainerException {
        String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        if(!password.matches(PASSWORD_REGEX)){
            throw new TrainerException("Invalid password");
        }
    }
    public void verifyAccount(String username, String email) throws TrainerException {
        if(persistence.isRegistered(username, email)){
            throw new TrainerException("Account already exists");
        }
    }
    public void registerTrainer(Trainer trainer) throws TrainerException {
        verifyFullFields(trainer);
        verifyEmail(trainer.getEmail());
        verifyPassword(trainer.getCredentials().getPassword());
        verifyAccount(trainer.getCredentials().getUsername(), trainer.getEmail());
        persistence.saveTrainer(trainer);
    }
}
