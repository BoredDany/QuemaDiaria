package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.HelloApplication;
import ing.soft.quemadiariaproject.Model.DTOs.CertificateDTO;
import ing.soft.quemadiariaproject.Model.DTOs.ProgramDTO;
import ing.soft.quemadiariaproject.Model.DTOs.TrainerDTO;
import ing.soft.quemadiariaproject.Model.DTOs.WalletDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class CentralController {
    static CentralController centralController;
    private static Stage stage;
    private static TrainerDTO trainerDTO;
    private static List<CertificateDTO> certificatesDTO;
    private static CertificateDTO certificateDTO;
    private static List<ProgramDTO> programsDTO;
    private static ProgramDTO programDTO;
    private static WalletDTO walletDTO;
    public static CentralController getInstance(){
        if(centralController == null){
            stage = new Stage();
            centralController = new CentralController();
            trainerDTO = new TrainerDTO();
        }
        return centralController;
    }

    public static CertificateDTO getCertificateDTO() {
        return certificateDTO;
    }

    public static void setCertificateDTO(CertificateDTO certificateDTO) {
        CentralController.certificateDTO = certificateDTO;
    }

    public static WalletDTO getWalletDTO() {
        return walletDTO;
    }

    public static void setWalletDTO(WalletDTO walletDTO) {
        CentralController.walletDTO = walletDTO;
    }

    public static List<ProgramDTO> getProgramsDTO() {
        return programsDTO;
    }

    public static void setProgramsDTO(List<ProgramDTO> programsDTO) {
        CentralController.programsDTO = programsDTO;
    }

    public static void setProgramDTO(ProgramDTO programDTO) {
        CentralController.programDTO = programDTO;
    }

    public static ProgramDTO getProgramDTO() {
        return programDTO;
    }

    public static List<CertificateDTO> getCertificatesDTO() {
        return certificatesDTO;
    }

    public static void setCertificatesDTO(List<CertificateDTO> certificatesDTO) {
        CentralController.certificatesDTO = certificatesDTO;
    }

    public static void setCentralController(CentralController centralController) {
        CentralController.centralController = centralController;
    }

    public static void setTrainerDTO(TrainerDTO trainerDto){
        trainerDTO = trainerDto;
    }
    public static TrainerDTO getTrainerDTO(){
        return trainerDTO;
    }
    public void loadScreen(String file) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(file));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
    public void openScreen(String file) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(file));
        Stage newStage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        newStage.setScene(scene);
        newStage.show();
    }

}
