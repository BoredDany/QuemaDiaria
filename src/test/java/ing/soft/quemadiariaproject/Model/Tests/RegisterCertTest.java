package ing.soft.quemadiariaproject.Model.Tests;

import ing.soft.quemadiariaproject.Model.DTOs.CertificateDTO;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Persistence.Files.FilePersistenceCert;
import ing.soft.quemadiariaproject.Model.UseCases.RegisterCert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterCertTest {
    private RegisterCert registerCert = new RegisterCert(new FilePersistenceCert());
    private CertificateDTO certificateDTO;
    @BeforeEach
    void setUp() {
        certificateDTO = new CertificateDTO("", "", "", "", "", "");
    }

    @AfterEach
    void tearDown() {

    }
    @Test
    void futureDate(){
        String date = "20/05/2025";
        assertThrows(TrainerException.class, () -> registerCert.verifydate(date));
    }
    @Test
    void emptyCertificate(){
        assertThrows(TrainerException.class, () -> registerCert.SaveNewCertificate(certificateDTO));
    }
}