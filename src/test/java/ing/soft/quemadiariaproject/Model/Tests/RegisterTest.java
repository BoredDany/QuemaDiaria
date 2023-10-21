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
        String email = "ana";
        assertThrows(TrainerException.class, () -> register.verifyEmail(email));
    }

    @Test
    void invalidPassword() {
        Credential badCredentials = new Credential("name", "123");
        assertThrows(TrainerException.class, () -> register.verifyPassword(badCredentials.getPassword()));
    }

    @Test
    void emailRegistered() {
        String email = "ana@gmail.com";
        assertThrows(TrainerException.class, () -> register.verifyAccount(trainer.getCredentials().getUsername(), email));
    }

    @Test
    void usernameRegistered() {
        Credential credentials = new Credential("ana", "123");
        assertThrows(TrainerException.class, () -> register.verifyAccount(credentials.getUsername(), trainer.getEmail()));
    }

    @Test
    void correctData() {
        Credential credentials = new Credential("user", "Example12*Cred#");
        Trainer trainer = new Trainer("ana","123456789", "ana@gmail.com", credentials);
        assertThrows(TrainerException.class, () -> register.registerTrainer(trainer));
    }

}