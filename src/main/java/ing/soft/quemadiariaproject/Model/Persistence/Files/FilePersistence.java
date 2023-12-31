package ing.soft.quemadiariaproject.Model.Persistence.Files;

import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.Persistence;
import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FilePersistence implements Persistence {
    @Override
    public void saveTrainer(Trainer trainer) {
        try {
            List<Trainer> usuarioList = consultListTrainers();
            //System.out.println("Registering trainer: " + trainer);
            usuarioList.add(trainer);
            FileWriter fileWriter = new FileWriter("Usuarios.json");
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            gson.toJson(usuarioList, fileWriter);
            fileWriter.close();
            //System.out.println("Information successfully saved");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error managing the file", e);
        }
    }

    @Override
    public List<Trainer> consultListTrainers() {
        Gson gson = new Gson();
        try {
            Path filePath = Path.of("Usuarios.json");
            String content = Files.readString(filePath);
            List<Trainer> usersList = new ArrayList<>();
            try {
                Trainer[] users = gson.fromJson(content, Trainer[].class);
                if(users == null)
                    return new ArrayList<>();
                return new ArrayList<>(List.of(users));
            } catch (JsonSyntaxException e) {
                if (e.getMessage().equals(
                        "Expected BEGIN_OBJECT but was BEGIN_ARRAY")) {
                    JsonArray jsonArray = new JsonParser()
                            .parse(content)
                            .getAsJsonArray();
                    for (int i = 0; i < jsonArray.size(); i++) {
                        Trainer user = gson.fromJson(jsonArray.get(i), Trainer.class);
                        usersList.add(user);
                    }
                    return usersList;
                } else {
                    // Handle other JSON parsing errors
                    e.printStackTrace();
                    throw new RuntimeException("Error managing the file", e);
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error managing the file", e);
        }
    }

    @Override
    public Trainer consultByUsername(String username) {
        return consultListTrainers().
                stream().
                filter(usuario -> usuario.getCredentials().getUsername().equals(username)).
                findFirst().
                orElse(null);
    }

    @Override
    public boolean isRegistered (String username, String email) {
        return consultListTrainers().
                stream().
                filter(usuario -> usuario.getCredentials().getUsername().equals(username) || usuario.getEmail().equals(email)).
                findFirst().isPresent();
    }

    @Override
    public void updateFile(List<Trainer> trainerList) {
        try {
            //System.out.println("Saving trainers to file...");
            FileWriter fileWriter = new FileWriter("Usuarios.json");
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            gson.toJson(trainerList, fileWriter);
            fileWriter.close();
            //System.out.println("Trainers successfully saved to file");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error managing the file", e);
        }
    }

}
