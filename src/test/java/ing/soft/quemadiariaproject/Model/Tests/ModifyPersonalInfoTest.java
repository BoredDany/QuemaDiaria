package ing.soft.quemadiariaproject.Model.Tests;

import ing.soft.quemadiariaproject.Model.DTOs.TrainerDTO;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.UseCases.ModifyPersonalInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModifyPersonalInfoTest {
    private TrainerDTO trainer;
    private ModifyPersonalInfo modifyPersonalInfo = new ModifyPersonalInfo();

    @BeforeEach
    void setUp() {
        trainer = new TrainerDTO("", "", "", null, "", "");
    }
    @AfterEach
    void tearDown() {
    }
    @Test
    void emptyName(){
        String name = "";
        assertThrows(TrainerException.class, () -> modifyPersonalInfo.modifyName(name, trainer));
    }
    @Test
    void emptyID(){
        String id = "";
        assertThrows(TrainerException.class, () -> modifyPersonalInfo.modifyID(id, trainer));
    }
    @Test
    void incompleteID(){
        String id = "123";
        assertThrows(TrainerException.class, () -> modifyPersonalInfo.modifyID(id, trainer));
    }
    @Test
    void badEmail(){
        String email = "123";
        assertThrows(TrainerException.class, () -> modifyPersonalInfo.modifyEmail(email, trainer));
    }
    @Test
    void emailRegistered(){
        String email = "ana@gmail.com";
        assertThrows(TrainerException.class, () -> modifyPersonalInfo.modifyEmail(email, trainer));
    }
    @Test
    void userNameRegistered(){
        String username = "ana1";
        assertThrows(TrainerException.class, () -> modifyPersonalInfo.modifyUsername(username, trainer));
    }
    @Test
    void badPassword(){
        String password = "1234abc";
        assertThrows(TrainerException.class, () -> modifyPersonalInfo.modifyPasswordCheck("", password, password));
    }
}