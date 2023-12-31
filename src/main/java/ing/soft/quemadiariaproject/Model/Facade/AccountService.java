package ing.soft.quemadiariaproject.Model.Facade;

import ing.soft.quemadiariaproject.Controller.CentralController;
import ing.soft.quemadiariaproject.Model.DTOs.TrainerDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.EmailSender;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Persistence.Files.FilePersistence;
import ing.soft.quemadiariaproject.Model.UseCases.Login;
import ing.soft.quemadiariaproject.Model.UseCases.ModifyPersonalInfo;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.Persistence;
import ing.soft.quemadiariaproject.Model.UseCases.Register;

public class AccountService implements AccountFacade {
    private Persistence persistence = new FilePersistence();
    private Login login = new Login(persistence);
    private Register register = new Register(persistence);
    private ModifyPersonalInfo modifydata = new ModifyPersonalInfo();

    @Override
    public void doLogin(String username, String password) throws TrainerException {
        login.doLogin(username, password);
    }

    @Override
    public void registerTrainer(TrainerDTO trainerDTO, String password) throws TrainerException {
        register.registerTrainer(trainerDTO, password);
    }

    @Override
    public void modifyName(String name, TrainerDTO trainerDTO) throws TrainerException {
        TrainerDTO updatedTrainer = modifydata.modifyName(name, trainerDTO);
        register.updateTrainer(updatedTrainer);
    }

    @Override
    public void modifyID(String id, TrainerDTO trainerDTO) throws TrainerException {
        TrainerDTO updatedTrainer = modifydata.modifyID(id, trainerDTO);
        register.updateTrainer(updatedTrainer);
    }

    @Override
    public void modifyEmail(String email, TrainerDTO trainerDTO) throws TrainerException {
        TrainerDTO updatedTrainer = modifydata.modifyEmail(email, trainerDTO);
        register.updateTrainer(updatedTrainer);
    }

    @Override
    public void modifySpeciality(String speciality, TrainerDTO trainerDTO) throws TrainerException {
        TrainerDTO updatedTrainer = modifydata.modifySpeciality(speciality, trainerDTO);
        register.updateTrainer(updatedTrainer);
    }

    @Override
    public void addSocialmedia(String socialmedia, TrainerDTO trainerDTO) throws TrainerException {
        TrainerDTO updatedTrainer = modifydata.addSocialmedia(socialmedia, trainerDTO);
        register.updateTrainer(updatedTrainer);
    }

    @Override
    public void removeSocialmedia(String socialmedia, TrainerDTO trainerDTO) throws TrainerException {
        modifydata.removeSocialmedia(socialmedia, trainerDTO);
        register.updateTrainer(trainerDTO);
    }

    @Override
    public void modifyUsername(String username, TrainerDTO trainerDTO) throws TrainerException {
        String oldUsername = trainerDTO.getUsername();
        modifydata.modifyUsername(username, trainerDTO);
        register.updateUsername(oldUsername, trainerDTO);
    }

    @Override
    public void modifyPassword(String previousPassword, String newPassword,
                               String confirmNew, String username) throws TrainerException {
        modifydata.modifyPasswordCheck(previousPassword, newPassword, confirmNew);
        register.updatePassword(previousPassword, newPassword, confirmNew, username);
    }

    @Override
    public void verifyEmail(TrainerDTO trainerDTO){
        int code = EmailSender.generateCode();
        CentralController.setConfirmationCode(code);
        EmailSender.sendConfirmationEmail(trainerDTO.getEmail(), code);
    }

    @Override
    public void verifyAll(TrainerDTO trainerDTO, String password) throws  TrainerException{
        register.verifyAll(trainerDTO, password);
    }
}
