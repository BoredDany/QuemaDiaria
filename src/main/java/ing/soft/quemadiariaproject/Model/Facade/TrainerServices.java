package ing.soft.quemadiariaproject.Model.Facade;

import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Persistence.Files.FilePersistence;
import ing.soft.quemadiariaproject.Model.UseCases.Login;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.Persistence;
import ing.soft.quemadiariaproject.Model.UseCases.Register;

public class TrainerServices implements TrainerFacade{
    private Persistence persistence = new FilePersistence();
    private Login login = new Login(persistence);
    private Register register = new Register(persistence);

    @Override
    public Trainer doLogin(String username, String password) throws TrainerException {
        return login.doLogin(username, password);
    }

    @Override
    public void registerTrainer(Trainer trainer) throws TrainerException {
        register.registerTrainer(trainer);
    }
}
