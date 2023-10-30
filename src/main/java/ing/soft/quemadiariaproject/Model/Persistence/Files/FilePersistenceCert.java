package ing.soft.quemadiariaproject.Model.Persistence.Files;

import com.google.gson.*;
import ing.soft.quemadiariaproject.Model.DTOs.CertificateDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Certificate;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.PersistenceCert;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilePersistenceCert implements PersistenceCert {
    @Override
    public void saveCertificate(Certificate certificate) {
        try {
            List<Certificate> certificateListList = consultListCertificates();
            //System.out.println("Registering certificate: " + certificate);
            certificateListList.add(certificate);
            FileWriter fileWriter = new FileWriter("Certificates.json");
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            gson.toJson(certificateListList, fileWriter);
            fileWriter.close();
            //System.out.println("Information successfully saved");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error managing the file", e);
        }
    }

    @Override
    public List<Certificate> consultListCertificates() {
        Gson gson = new Gson();
        try {
            Path filePath = Path.of("Certificates.json");
            String content = Files.readString(filePath);
            List<Certificate> certificateList = new ArrayList<>();
            try {
                Certificate[] certificates = gson.fromJson(content, Certificate[].class);
                if(certificates == null)
                    return new ArrayList<>();
                return new ArrayList<>(List.of(certificates));
            } catch (JsonSyntaxException e) {
                if (e.getMessage().equals(
                        "Expected BEGIN_OBJECT but was BEGIN_ARRAY")) {
                    JsonArray jsonArray = new JsonParser()
                            .parse(content)
                            .getAsJsonArray();
                    for (int i = 0; i < jsonArray.size(); i++) {
                        Certificate certificate = gson.fromJson(jsonArray.get(i), Certificate.class);
                        certificateList.add(certificate);
                    }
                    return certificateList;
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
    public List<Certificate> consultByUsername(String username) {
        return consultListCertificates().
                stream().
                filter(certificate -> certificate.getTrainerUsername().equals(username)).
                toList();
    }

    @Override
    public boolean isRegistered(String username, String institution, String expeditionDate, String title) {
        return consultListCertificates().
                stream().
                filter(certificate -> certificate.verifyCertificate(username,
                        institution, expeditionDate,
                        title)).
                findFirst().isPresent();
    }

    @Override
    public void updateFile(List<Certificate> certificateList) {
        try {
            //System.out.println("Saving certificates to file...");
            FileWriter fileWriter = new FileWriter("Certificates.json");
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            gson.toJson(certificateList, fileWriter);
            fileWriter.close();
            //System.out.println("Certificates successfully saved to file");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error managing the file", e);
        }
    }

    @Override
    public CertificateDTO consult(String username, String title, String institution, String expDate) {
        for(Certificate c: consultByUsername(username)){
            if(c.getTitle().equals(title) &&
                    c.getExpeditionDate().equals(expDate) &&
                    c.getInstitution().equals(institution)){
                CertificateDTO certificateDTO = new CertificateDTO(username,
                        c.getInstitution(), c.getExpeditionDate(),
                        c.getDescription(), c.getLink(), c.getTitle());
                return certificateDTO;
            }
        }
        return null;
    }
}
