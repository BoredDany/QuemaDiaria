package ing.soft.quemadiariaproject.Model.UseCases.Persistence;

import ing.soft.quemadiariaproject.Model.Domain.Entities.Program;

import java.util.List;

public interface PersistenceProg {
    List<Program> consultProgramsList();
    void saveProgram(Program program);
    List<Program> consultByUsername(String username);
}
