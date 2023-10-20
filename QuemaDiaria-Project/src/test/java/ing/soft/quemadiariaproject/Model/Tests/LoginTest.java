package ing.soft.quemadiariaproject.Model.Tests;

import ing.soft.quemadiariaproject.Model.Domain.Entities.Credential;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Persistence.Files.FilePersistence;
import ing.soft.quemadiariaproject.Model.UseCases.Login;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LoginTest {
    private Login login;
    private Trainer trainer;
    private Credential credential;
    private Persistence persistence;
    @BeforeEach
    void setUp() {
        this.login = new Login(new FilePersistence());
        this.credential = new Credential("", "");
        this.trainer = new Trainer("", "", "",credential);
        this.persistence = new FilePersistence();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void incorrectCPassword(){
        List<Trainer> trainers = persistence.consultListTrainers();
        trainer = trainers.get(0);
        assertThrows(TrainerException.class, () -> login.verifyCredentials(trainer.getCredentials().getUsername(), "", trainer));
    }

    @Test
    void TrainerNotRegistered(){
        trainer = null;
        assertThrows(TrainerException.class, () -> login.trainerExists(trainer));
    }
}