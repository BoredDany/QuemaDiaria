package ing.soft.quemadiariaproject.Model.UseCases.Persistence;

import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;

import java.util.List;
import java.util.Optional;

public interface Persistence {
    void saveTrainer(Trainer trainer);
    List<Trainer> consultListTrainers();
    Trainer consultByUsername(String username);
    boolean isRegistered(String username, String email);
    public void updateFile(List<Trainer> trainerList);
}
