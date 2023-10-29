package ing.soft.quemadiariaproject.Model.Facade;

import ing.soft.quemadiariaproject.Model.DTOs.TrainerDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;

public interface AccountFacade {
    Trainer doLogin(String username, String password) throws TrainerException;
    void registerTrainer(Trainer trainer) throws TrainerException;
    void modifyName(String name, TrainerDTO trainerDTO) throws TrainerException;
    void modifyID(String id, TrainerDTO trainerDTO) throws TrainerException;
    void modifyEmail(String email, TrainerDTO trainerDTO) throws TrainerException;
    void modifySpeciality(String speciality, TrainerDTO trainerDTO) throws TrainerException;
    void addSocialmedia(String socialmedia, TrainerDTO trainerDTO) throws TrainerException;
    void removeSocialmedia(String socialmedia, TrainerDTO trainerDTO) throws TrainerException;
    void modifyUsername(String username, TrainerDTO trainerDTO) throws TrainerException;
    void modifyPassword(String previousPassword, String newPassword, String confirmNew,
                        String username) throws TrainerException;
}
