package ing.soft.quemadiariaproject.Model.UseCases;

import ing.soft.quemadiariaproject.Model.DTOs.TrainerDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Credential;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.Persistence;

import java.util.List;

public class Register {
    private Persistence persistence;
    public Register(Persistence persistence){
        this.persistence = persistence;
    }

    public void verifyFullFields(TrainerDTO trainerDTO, String password) throws TrainerException {
        if(trainerDTO.getName().isEmpty() || trainerDTO.getIdentification().isEmpty()
                || trainerDTO.getEmail().isEmpty() || trainerDTO.getUsername().isEmpty()
                || password.isEmpty()){
            throw new TrainerException("Missing information");
        }
    }
    public void verifyIdentification(String identification) throws TrainerException {
        String ID_REGEX = "^[A-Za-z0-9]{8,12}$";
        if(!identification.matches(ID_REGEX)){
            throw new TrainerException("Invalid identification");
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
    public void verifyUsername(String username) throws TrainerException {
        for(Trainer t: persistence.consultListTrainers()){
            if(t.getCredentials().getUsername().equals(username)){
                throw new TrainerException("Account already exists");
            }
        }
    }
    public void registerTrainer(TrainerDTO trainerDTO, String password) throws TrainerException {
        verifyFullFields(trainerDTO, password);
        verifyEmail(trainerDTO.getEmail());
        verifyPassword(password);
        verifyAccount(trainerDTO.getUsername(), trainerDTO.getEmail());
        Trainer trainer = new Trainer(trainerDTO.getName(), trainerDTO.getIdentification(),
                trainerDTO.getEmail(), new Credential(trainerDTO.getUsername(), password));
        persistence.saveTrainer(trainer);
    }
    public void updateTrainer(TrainerDTO trainerDTO) {
        List<Trainer> trainers = persistence.consultListTrainers();
        for (int i = 0; i < trainers.size(); i++) {
            Trainer t = trainers.get(i);
            if (t.getCredentials().getUsername().equals(trainerDTO.getUsername())) {
                Trainer trainerModified = new Trainer(trainerDTO.getName(), trainerDTO.getIdentification(),
                        trainerDTO.getEmail(), trainerDTO.getSocialMedia(), t.getCredentials(),
                        trainerDTO.getSpeciality());
                trainers.set(i, trainerModified);
            }
        }
        persistence.updateFile(trainers);
    }
    public void updateUsername(String oldUsername, TrainerDTO trainerDTO){
        List<Trainer> trainers = persistence.consultListTrainers();
        for (int i = 0; i < trainers.size(); i++) {
            Trainer t = trainers.get(i);
            if (t.getCredentials().getUsername().equals(oldUsername)) {
                Credential newCredential = new Credential(trainerDTO.getUsername(), t.getCredentials().getPassword());
                Trainer trainerModified = new Trainer(trainerDTO.getName(), trainerDTO.getIdentification(),
                        trainerDTO.getEmail(), trainerDTO.getSocialMedia(), newCredential,
                        trainerDTO.getSpeciality());
                trainers.set(i, trainerModified);
            }
        }
        persistence.updateFile(trainers);
    }
    public void updatePassword(String previousPassword, String newPassword, String confirmNew,
                               String username) throws TrainerException {
        List<Trainer> trainers = persistence.consultListTrainers();
        for (int i = 0; i < trainers.size(); i++) {
            Trainer t = trainers.get(i);
            if (t.getCredentials().getUsername().equals(username)) {
                if(!t.getCredentials().verifyCredentials(username, previousPassword)){
                    throw new TrainerException("Credentials are not correct");
                }
                if(!newPassword.equals(confirmNew)){
                    throw new TrainerException("Confirmation is not correct");
                }
                Credential newCredential = new Credential(t.getCredentials().getUsername(), newPassword);
                Trainer trainerModified = new Trainer(t.getName(), t.getIdentification(),
                        t.getEmail(), t.getSocialMedia(), newCredential,
                        t.getSpeciality());
                trainers.set(i, trainerModified);
            }
        }
        persistence.updateFile(trainers);
    }
}
