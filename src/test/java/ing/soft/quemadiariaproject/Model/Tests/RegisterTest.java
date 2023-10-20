package ing.soft.quemadiariaproject.Model.Tests;

import ing.soft.quemadiariaproject.Model.Domain.Entities.Credential;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Persistence.Files.FilePersistence;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.Persistence;
import ing.soft.quemadiariaproject.Model.UseCases.Register;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
class RegisterTest  {
    private Register register;
    private Trainer trainer;
    private Credential credential;

    @BeforeEach
    void setUp() {
        this.register = new Register(new FilePersistence());
        this.credential = new Credential("", "");
        this.trainer = new Trainer("", "", "",credential);
    }

    @AfterEach
    void tearDown() {
        this.credential = new Credential("", "");
        this.trainer = new Trainer("", "", "",credential);
    }

    @Test
    void emptyFields() {
        assertThrows(TrainerException.class, () -> register.verifyFullFields(trainer));
    }

    @Test
    void invalididentification() {
        assertThrows(TrainerException.class, () -> register.verifyIdentification(trainer.getIdentification()));
    }

    @Test
    void invalidEmail() {
        trainer.setEmail("ana");
        assertThrows(TrainerException.class, () -> register.verifyEmail(trainer.getEmail()));
    }

    @Test
    void invalidPassword() {
        Credential badCredentials = new Credential("name", "123");
        trainer.setCredentials(badCredentials);
        assertThrows(TrainerException.class, () -> register.verifyPassword(trainer.getCredentials().getPassword()));
    }

    @Test
    void emailRegistered() {
        trainer.setEmail("ana@gmail.com");
        assertThrows(TrainerException.class, () -> register.verifyAccount(trainer.getCredentials().getUsername(), trainer.getEmail()));
    }

    @Test
    void usernameRegistered() {
        Credential credentials = new Credential("ana", "123");
        trainer.setCredentials(credentials);
        assertThrows(TrainerException.class, () -> register.verifyAccount(trainer.getCredentials().getUsername(), trainer.getEmail()));
    }

    @Test
    void correctData() {
        Credential credentials = new Credential("user", "Example12*Cred#");
        trainer.setCredentials(credentials);
        trainer.setName("ana");
        trainer.setIdentification("12345");
        trainer.setEmail("ana@gmail.com");
        assertThrows(TrainerException.class, () -> register.registerTrainer(trainer));
    }

}