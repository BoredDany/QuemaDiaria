package ing.soft.quemadiariaproject.Model.UseCases;

import ing.soft.quemadiariaproject.Model.DTOs.ProgramDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Program;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.PersistenceProg;

import java.util.ArrayList;
import java.util.List;

public class ProgramManagement {
    private PersistenceProg persistence;
    public ProgramManagement(PersistenceProg persistence){
        this.persistence = persistence;
    }

    public List<ProgramDTO> trainerPrograms(String username){
        List<Program> programs;
        List<ProgramDTO> resume = new ArrayList<>();
        programs = persistence.consultByUsername(username);
        for(Program p : programs){
            ProgramDTO pDTO = new ProgramDTO(username, p.getName(), p.getDescription());
            resume.add(pDTO);
        }
        return resume;
    }
}