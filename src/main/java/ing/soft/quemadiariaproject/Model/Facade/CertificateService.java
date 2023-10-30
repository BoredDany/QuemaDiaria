package ing.soft.quemadiariaproject.Model.Facade;

import ing.soft.quemadiariaproject.Model.DTOs.CertificateDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Certificate;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Persistence.Files.FilePersistenceCert;
import ing.soft.quemadiariaproject.Model.UseCases.RegisterCert;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.PersistenceCert;

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
}
