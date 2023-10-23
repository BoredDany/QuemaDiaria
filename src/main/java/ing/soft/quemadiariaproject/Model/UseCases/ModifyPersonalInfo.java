package ing.soft.quemadiariaproject.Model.UseCases;

import ing.soft.quemadiariaproject.Model.DTOs.TrainerDTO;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;

import java.util.ArrayList;
import java.util.List;

public class ModifyPersonalInfo {

    public void verifyEmptyField(String data) throws TrainerException{
        if(data.isEmpty()){
            throw new TrainerException("Empty field");
        }
    }
    public TrainerDTO modifyName(String name, TrainerDTO trainerDTO) throws TrainerException {
        verifyEmptyField(name);
        trainerDTO.setName(name);
        return trainerDTO;
    }
    public TrainerDTO modifyID(String id, TrainerDTO trainerDTO) throws TrainerException {
        verifyEmptyField(id);
        trainerDTO.setIdentification(id);
        return trainerDTO;
    }
    public TrainerDTO modifyEmail(String email, TrainerDTO trainerDTO) throws TrainerException {
        verifyEmptyField(email);
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
        List<String> socialmediaT = new ArrayList<>();
        if(trainerDTO.getSocialMedia() != null){
            socialmediaT.addAll(trainerDTO.getSocialMedia());
        }
        socialmediaT.add(socialmedia);
        trainerDTO.setSocialMedia(socialmediaT);
        return trainerDTO;
    }

}
