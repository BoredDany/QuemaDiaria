package ing.soft.quemadiariaproject.Model.Domain.Exceptions;

import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;

public class TrainerException extends Exception{
    public TrainerException(String message){
        super(message);
    }
}
