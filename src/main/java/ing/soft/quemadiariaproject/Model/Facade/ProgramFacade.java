package ing.soft.quemadiariaproject.Model.Facade;

import ing.soft.quemadiariaproject.Model.DTOs.ProgramDTO;

import java.util.List;

public interface ProgramFacade {
    List<String> programsResume(String username);
    List<ProgramDTO> trainerProgramsStatistics(String username);
    double avgViews(List<ProgramDTO> programDTOS);
    double avgLikes(List<ProgramDTO> programDTOS);
    double avgSubs(List<ProgramDTO> programDTOS);
    double avgAcomp(List<ProgramDTO> programDTOS);
}
