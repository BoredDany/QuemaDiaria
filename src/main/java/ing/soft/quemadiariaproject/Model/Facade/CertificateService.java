package ing.soft.quemadiariaproject.Model.Facade;

import ing.soft.quemadiariaproject.Controller.CentralController;
import ing.soft.quemadiariaproject.Model.DTOs.CertificateDTO;
import ing.soft.quemadiariaproject.Model.DTOs.TrainerDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Certificate;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Persistence.Files.FilePersistenceCert;
import ing.soft.quemadiariaproject.Model.UseCases.RegisterCert;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.PersistenceCert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class CertificateService implements CertificateFacade{
    PersistenceCert persistence = new FilePersistenceCert();
    RegisterCert certificateRegister = new RegisterCert(persistence);
    @Override
    public void saveCertificate(CertificateDTO certificate) throws TrainerException {
        certificateRegister.SaveNewCertificate(certificate);
    }
    public void consultByUsername(String username){
        certificateRegister.getTrainerCerts(username);
    }

    @Override
    public CertificateDTO getCertificate(String username, String title, String institution, String expDate) {
        return persistence.consult(username, title, institution, expDate);
    }

    @Override
    public List<String> getResumeCert() {
        consultByUsername(CentralController.getTrainerDTO().getUsername());
        List<String>items = new ArrayList<>();
        for(CertificateDTO c: CentralController.getCertificatesDTO()){
            items.add(c.getTitle()+ "\n" + c.getInstitution() + "\n" + c.getExpeditionDate());
        }
        return items;
    }

    @Override
    public void deleteCertificate(CertificateDTO certificateDTO) throws TrainerException {
        certificateRegister.removeCertificate(certificateDTO);
    }

}
