package ing.soft.quemadiariaproject.Model.Facade;

import ing.soft.quemadiariaproject.Model.DTOs.ProgramDTO;
import ing.soft.quemadiariaproject.Model.Persistence.Files.FilePersistenceProg;
import ing.soft.quemadiariaproject.Model.UseCases.ProgramManagement;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.PersistenceProg;

import java.util.ArrayList;
import java.util.List;

public class ProgramService implements ProgramFacade {
    private PersistenceProg persistence = new FilePersistenceProg();
    private ProgramManagement programManagement = new ProgramManagement(persistence);

    @Override
    public List<String> programsResume(String username) {
        List<String> resume = new ArrayList<>();
        for(ProgramDTO pDTO : programManagement.trainerPrograms(username)){
            resume.add("NOMBRE: " + pDTO.getName() + "\n" + pDTO.getDescription());
        }
        return resume;
    }

    @Override
    public List<ProgramDTO> trainerProgramsStatistics(String username) {
        return programManagement.trainerProgramsStatistics(username);
    }

    @Override
    public double avgViews(List<ProgramDTO> programDTOS) {
        return programManagement.avgViews(programDTOS);
    }

    @Override
    public double avgLikes(List<ProgramDTO> programDTOS) {
        return programManagement.avgLikes(programDTOS);
    }

    @Override
    public double avgSubs(List<ProgramDTO> programDTOS) {
        return programManagement.avgSubs(programDTOS);
    }

    @Override
    public double avgAcomp(List<ProgramDTO> programDTOS) {
        return programManagement.avgAcom(programDTOS);
    }
}
