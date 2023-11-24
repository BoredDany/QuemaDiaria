package ing.soft.quemadiariaproject.Model.Facade;

import ing.soft.quemadiariaproject.Model.DTOs.CertificateDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Certificate;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;

import java.util.List;

public interface CertificateFacade {
    void saveCertificate(CertificateDTO certificate) throws TrainerException;
    void consultByUsername(String username);
    CertificateDTO getCertificate(String username, String title, String institution, String expDate);
    List<String> getResumeCert();
    void deleteCertificate(CertificateDTO certificateDTO) throws TrainerException;
    void modifyCertificate(CertificateDTO oldCertificate, CertificateDTO newCertificate) throws TrainerException;
}
