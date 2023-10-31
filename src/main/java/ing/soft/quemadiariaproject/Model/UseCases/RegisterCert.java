package ing.soft.quemadiariaproject.Model.UseCases;

import ing.soft.quemadiariaproject.Controller.CentralController;
import ing.soft.quemadiariaproject.Controller.CertificateController;
import ing.soft.quemadiariaproject.Model.DTOs.CertificateDTO;
import ing.soft.quemadiariaproject.Model.DTOs.TrainerDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Certificate;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.PersistenceCert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegisterCert {
    PersistenceCert registerCertificate;

    public RegisterCert(PersistenceCert registerCertificate) {
        this.registerCertificate = registerCertificate;
    }
    public void verifyEmptyFields(CertificateDTO certificateDTO) throws TrainerException {
        if(certificateDTO.getDescription().isEmpty() || certificateDTO.getInstitution().isEmpty()
                || certificateDTO.getTrainerUsername().isEmpty() || certificateDTO.getExpeditionDate() == null
                || certificateDTO.getTitle().isEmpty()){
            throw new TrainerException("Missing information");
        }
    }
    public void verifyCertRegistered(String username, String institution, String expeditionDate, String title) throws TrainerException {
        if(registerCertificate.isRegistered(username, institution, expeditionDate, title)){
            throw new TrainerException("Certificate already registered");
        }

    }
    public void verifydate(String date) throws TrainerException {
        String [] infoDate = date.split("/");
        int day = Integer.parseInt(infoDate[0]);
        int moth = Integer.parseInt(infoDate[1]);
        int year = Integer.parseInt(infoDate[2]);
        LocalDate fdate = LocalDate.of(year, moth, day);
        if(fdate.isAfter(LocalDate.now())){
            throw new TrainerException("Invalid date");
        }
    }
    public void SaveNewCertificate(CertificateDTO certificateDTO) throws TrainerException {
        verifyEmptyFields(certificateDTO);
        verifyCertRegistered(certificateDTO.getTrainerUsername(), certificateDTO.getInstitution(),
                certificateDTO.getExpeditionDate(), certificateDTO.getTitle());
        verifydate(certificateDTO.getExpeditionDate());
        Certificate certificate = new Certificate(certificateDTO.getTrainerUsername(),
                certificateDTO.getInstitution(), certificateDTO.getExpeditionDate(),
                certificateDTO.getDescription(), certificateDTO.getLink(),
                certificateDTO.getTitle());
        registerCertificate.saveCertificate(certificate);
    }
    public void getTrainerCerts(String username){
        List<CertificateDTO> certificateList = new ArrayList<>();
        for(Certificate c: registerCertificate.consultByUsername(username)){
            CertificateDTO cDTO = new CertificateDTO(c.getTrainerUsername(),
                    c.getInstitution(), c.getExpeditionDate(), c.getDescription(),
                    c.getLink(), c.getTitle());
            certificateList.add(cDTO);
        }
        CentralController.setCertificatesDTO(certificateList);
    }
}
