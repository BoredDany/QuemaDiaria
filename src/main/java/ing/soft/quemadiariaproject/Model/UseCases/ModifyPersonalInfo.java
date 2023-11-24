package ing.soft.quemadiariaproject.Model.UseCases;

import ing.soft.quemadiariaproject.Model.DTOs.TrainerDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Credential;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Persistence.Files.FilePersistence;

import java.util.ArrayList;
import java.util.List;

public class ModifyPersonalInfo {
    private Register register = new Register(new FilePersistence());
    public void verifyEmptyField(String data) throws TrainerException{
        if(data.isEmpty()){
            throw new TrainerException("Empty field");
        }
    }
    public void verifySocialmedia(String socialmedia, List<String> socialMedia) throws TrainerException{
        if(socialMedia != null){
            for(String s: socialMedia){
                if(s.equals(socialmedia)){
                    throw new TrainerException("Socialmedia already registered");
                }
            }
        }
    }
    public TrainerDTO modifyName(String name, TrainerDTO trainerDTO) throws TrainerException {
        verifyEmptyField(name);
        trainerDTO.setName(name);
        register.updateTrainer(trainerDTO);
        return trainerDTO;
    }
    public TrainerDTO modifyID(String id, TrainerDTO trainerDTO) throws TrainerException {
        verifyEmptyField(id);
        register.verifyIdentification(id);
        trainerDTO.setIdentification(id);
        return trainerDTO;
    }
    public TrainerDTO modifyEmail(String email, TrainerDTO trainerDTO) throws TrainerException {
        verifyEmptyField(email);
        register.verifyEmail(email);
        if(!email.equals(trainerDTO.getEmail())){
            register.verifyAccount(trainerDTO.getUsername(), email);
        }
        trainerDTO.setEmail(email);
        return trainerDTO;
    }
    public TrainerDTO modifySpeciality(String speciality, TrainerDTO trainerDTO) throws TrainerException {
        verifyEmptyField(speciality);
        trainerDTO.setSpeciality(speciality);
        return trainerDTO;
    }
    public TrainerDTO addSocialmedia(String socialmedia, TrainerDTO trainerDTO) throws TrainerException {
        verifyEmptyField(socialmedia);
        verifySocialmedia(socialmedia, trainerDTO.getSocialMedia());
        List<String> socialmediaT = new ArrayList<>();
        if(trainerDTO.getSocialMedia() != null){
            socialmediaT.addAll(trainerDTO.getSocialMedia());
        }
        socialmediaT.add(socialmedia);
        trainerDTO.setSocialMedia(socialmediaT);
        return trainerDTO;
    }
    public void removeSocialmedia(String socialmedia, TrainerDTO trainerDTO) throws TrainerException {
        if(socialmedia == null){
            throw new TrainerException("Any socialmedia selected");
        }
        trainerDTO.getSocialMedia().remove(socialmedia);
    }
    public TrainerDTO modifyUsername(String username, TrainerDTO trainerDTO) throws TrainerException {
        verifyEmptyField(username);
        if(!username.equals(trainerDTO.getUsername())){
            register.verifyUsername(username);
        }
        trainerDTO.setUsername(username);
        return trainerDTO;
    }
    public void modifyPasswordCheck(String previousPassword, String newPassword, String confirmNew)
            throws TrainerException {
        verifyEmptyField(previousPassword);
        verifyEmptyField(newPassword);
        verifyEmptyField(confirmNew);
        register.verifyPassword(newPassword);
    }
}
