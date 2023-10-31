package ing.soft.quemadiariaproject.Model.Persistence.Files;

import com.google.gson.*;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Program;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.PersistenceProg;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FilePersistenceProg implements PersistenceProg {
    public List<Program> consultProgramsList() {
        Gson gson = new Gson();
        try {
            Path filePath = Path.of("Programs.json");
            String content = Files.readString(filePath);
            List<Program> programList = new ArrayList<>();
            try {
                Program[] programs = gson.fromJson(content, Program[].class);
                if (programs == null)
                    return new ArrayList<>();
                return new ArrayList<>(List.of(programs));
            } catch (JsonSyntaxException e) {
                if (e.getMessage().equals(
                        "Expected BEGIN_OBJECT but was BEGIN_ARRAY")) {
                    JsonArray jsonArray = new JsonParser()
                            .parse(content)
                            .getAsJsonArray();
                    for (int i = 0; i < jsonArray.size(); i++) {
                        Program program = gson.fromJson(jsonArray.get(i), Program.class);
                        programList.add(program);
                    }
                    return programList;
                } else {
                    // Handle other JSON parsing errors
                    e.printStackTrace();
                    throw new RuntimeException("Error managing the file", e);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error managing the file", e);
        }
    }
    public void saveProgram(Program program) {
        try {
            List<Program> programList = consultProgramsList();
            System.out.println("Registering program: " + program);
            programList.add(program);
            FileWriter fileWriter = new FileWriter("Programs.json");
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            gson.toJson(programList, fileWriter);
            fileWriter.close();
            System.out.println("Information successfully saved");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error managing the file", e);
        }
    }
}
