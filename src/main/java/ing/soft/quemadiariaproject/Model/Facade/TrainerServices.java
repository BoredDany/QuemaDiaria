package ing.soft.quemadiariaproject.Model.Facade;

import ing.soft.quemadiariaproject.Model.DTOs.TrainerDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Persistence.Files.FilePersistence;
import ing.soft.quemadiariaproject.Model.UseCases.Login;
import ing.soft.quemadiariaproject.Model.UseCases.ModifyPersonalInfo;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.Persistence;
import ing.soft.quemadiariaproject.Model.UseCases.Register;

public class TrainerServices implements TrainerFacade {
    private Persistence persistence = new FilePersistence();
    private Login login = new Login(persistence);
    private Register register = new Register(persistence);
    private ModifyPersonalInfo modifydata = new ModifyPersonalInfo();

    @Override
    public Trainer doLogin(String username, String password) throws TrainerException {
        return login.doLogin(username, password);
    }

    @Override
    public void registerTrainer(Trainer trainer) throws TrainerException {
        register.registerTrainer(trainer);
    }

    @Override
    public void modifyName(String name, TrainerDTO trainerDTO) throws TrainerException {
        TrainerDTO updatedTrainer = modifydata.modifyName(name, trainerDTO);
        register.updateTrainer(updatedTrainer);
    }

    @Override
    public void modifyID(String id, TrainerDTO trainerDTO) throws TrainerException {
        register.verifyIdentification(id);
        TrainerDTO updatedTrainer = modifydata.modifyID(id, trainerDTO);
        register.updateTrainer(updatedTrainer);
    }

    @Override
    public void modifyEmail(String email, TrainerDTO trainerDTO) throws TrainerException {
        register.verifyEmail(email);
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
}
