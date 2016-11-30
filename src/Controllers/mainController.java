package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


public class mainController {
    @FXML
    private Label lblUsername;
    @FXML
    private Label lblLastSeen;

    @FXML
    public void initialize(String lblUsername, String lblLastSeen) {
        this.lblUsername.setText(lblUsername);
        this.lblLastSeen.setText(lblLastSeen == null ? "N/A" : lblLastSeen);
    }

    @FXML
    void locatePackage(ActionEvent event) {
        // RASTREO
    }

    @FXML
    public void serviceManagement(ActionEvent event) {
        // ADMINISTRACION DE SERVICIOS
    }

    @FXML
    public void registerService(ActionEvent event) {
        // REGISTRO DE SERVICIOS
    }

    @FXML
    void loginAdmin(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/userAdminView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Administración de usuarios");
        userAdminController mc = loader.getController();
        mc.refreshTable();
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    public void employeeManagement(ActionEvent event) {
    }

    @FXML
    public void clientManagement(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/clientManagementView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Administración de clientes");
        clientManagementController cmc = loader.getController();
        cmc.refreshTable();
        stage.centerOnScreen();
        stage.show();
    }
}
