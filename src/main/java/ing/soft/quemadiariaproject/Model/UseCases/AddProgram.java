package ing.soft.quemadiariaproject.Model.UseCases;

import ing.soft.quemadiariaproject.Model.Domain.Entities.Program;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.Persistence;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.PersistenceProg;

public class AddProgram {
    private PersistenceProg persistence;
    public AddProgram(PersistenceProg persistence){
        this.persistence = persistence;
    }

    public void verifyFullFields(Program program) throws TrainerException {
        if(program.getName().isEmpty() || program.getTrainerUsername().isEmpty()
                || program.getDuration().isEmpty() || program.getDescription().isEmpty()){
            throw new TrainerException("Missing information");
        }
    }
    public void verifyIdentification(String identification) throws TrainerException {
        String ID_REGEX = "^[A-Za-z0-9]{8,12}$";
        if(!identification.matches(ID_REGEX)){
            throw new TrainerException("Invalid identification");
        }
    }
    public void AddProgram (Program program) throws TrainerException {
        verifyFullFields(program);
        persistence.saveProgram(program);
    }

}