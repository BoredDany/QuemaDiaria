package ing.soft.quemadiariaproject.Model.Tests;

import ing.soft.quemadiariaproject.Model.DTOs.TrainerDTO;
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
    private TrainerDTO trainer;
    private String password;

    @BeforeEach
    void setUp() {
        this.register = new Register(new FilePersistence());
        this.password = "";
        this.trainer = new TrainerDTO("", "", "","");
    }

    @AfterEach
    void tearDown() {
        this.password = "";
        this.trainer = new TrainerDTO("", "", "","");
    }

    @Test
    void emptyFields() {
        assertThrows(TrainerException.class, () -> register.verifyFullFields(trainer, password));
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
        assertThrows(TrainerException.class, () -> register.verifyAccount(trainer.getUsername(), email));
    }

    @Test
    void usernameRegistered() {
        String username = "ana1";
        String email = "";
        assertThrows(TrainerException.class, () -> register.verifyAccount(username, email));
    }

    @Test
    void correctData() {
        TrainerDTO trainerDTO = new TrainerDTO("ana","123456789", "ana@gmail.com", "user");
        String password = "Example12*Cred#";
        assertThrows(TrainerException.class, () -> register.registerTrainer(trainerDTO,password));
    }

}