package ing.soft.quemadiariaproject.Model.Facade;

import ing.soft.quemadiariaproject.Model.DTOs.CertificateDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Certificate;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;

public interface CertificateFacade {
    void saveCertificate(CertificateDTO certificate) throws TrainerException;
    void consultByUsername(String username);
}
