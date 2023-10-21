package ing.soft.quemadiariaproject.Model.Facade;

import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;

public interface TrainerFacade {
    public Trainer doLogin(String username, String password) throws TrainerException;
    public void registerTrainer(Trainer trainer) throws TrainerException;
}
