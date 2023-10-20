package ing.soft.quemadiaria.Model.UseCases;

import ing.soft.quemadiaria.Model.Domain.Entities.Trainer;
import ing.soft.quemadiaria.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiaria.Model.UseCases.Persistence.Persistence;

public class Register {
    private Persistence persistence;
    public Register(Persistence persistence){
        this.persistence = persistence;
    }
    public void registerTrainer(Trainer trainer) throws TrainerException {
        if(persistence.isRegistered(trainer.getCredentials().getUsername())){
            throw new TrainerException("Already used username");
        }
        persistence.saveTrainer(trainer);
        System.out.println("Saved: " + trainer);
    }
}
