package ing.soft.quemadiariaproject.Model.UseCases.Persistence;

import ing.soft.quemadiariaproject.Model.DTOs.CertificateDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Certificate;

import java.util.Date;
import java.util.List;

public interface PersistenceCert {
    void saveCertificate(Certificate certificate);
    List<Certificate> consultListCertificates();
    List<Certificate> consultByUsername(String username);
    boolean isRegistered(String username, String institution, String expeditionDate, String title);
    void updateFile(List<Certificate> certificateList);
    CertificateDTO consult(String username, String title, String institution, String expDate);
    void updateCertificates(CertificateDTO certificateDTO);
}
