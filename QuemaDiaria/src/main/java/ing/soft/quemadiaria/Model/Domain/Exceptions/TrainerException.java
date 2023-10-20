package ing.soft.quemadiaria.Model.Domain.Exceptions;

import ing.soft.quemadiaria.Model.Domain.Entities.Trainer;

public class TrainerException extends Exception{
    public TrainerException(String message){
        super(message);
    }
}
