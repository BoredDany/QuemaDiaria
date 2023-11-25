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

    public List<ProgramDTO> trainerProgramsStatistics(String username){
        List<Program> programs;
        List<ProgramDTO> programsStatistics = new ArrayList<>();
        programs = persistence.consultByUsername(username);
        for(Program p : programs){
            ProgramDTO pDTO = new ProgramDTO(username, p.getName(), p.getLikes(),
                    p.getViews(), p.getSubscriptors(), p.getAcomplishment());
            programsStatistics.add(pDTO);
        }
        return programsStatistics;
    }
    public double avgLikes(List<ProgramDTO> programDTOS){
        double likes = 0, total  = 0;
        for(ProgramDTO p : programDTOS){
            total++;
            likes+=p.getLikes();
        }
        return likes/total;
    }
    public double avgViews(List<ProgramDTO> programDTOS){
        double views = 0, total  = 0;
        for(ProgramDTO p : programDTOS){
            total++;
            views+=p.getViews();
        }
        return views/total;
    }
    public double avgSubs(List<ProgramDTO> programDTOS){
        double subs = 0, total  = 0;
        for(ProgramDTO p : programDTOS){
            total++;
            subs+=p.getSubscriptors();
        }
        return subs/total;
    }
    public double avgAcom(List<ProgramDTO> programDTOS){
        double acom = 0, total  = 0;
        for(ProgramDTO p : programDTOS){
            total++;
            acom+=p.getAcomplishment();
        }
        return acom/total;
    }
}