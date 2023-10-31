package ing.soft.quemadiariaproject.Model.Facade;

import ing.soft.quemadiariaproject.Model.Persistence.Files.FilePersistenceProg;
import ing.soft.quemadiariaproject.Model.UseCases.AddProgram;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.PersistenceProg;

public class ProgramService {
    private PersistenceProg persistence = new FilePersistenceProg();
    private AddProgram addProgram = new AddProgram(persistence);

}
