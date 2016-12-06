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
    void locatePackage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/trackingSearchView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Fast MX - Búscar por código de rastreo");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    public void serviceManagement(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/serviceManagementView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("FastMX - Administración de servicios");
        serviceManagementController smc = loader.getController();
        smc.refreshTable();
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    public void registerService(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/registerServiceView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("FastMX - Registro de servicios");
        registerServiceController rsc = loader.getController();
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    void loginAdmin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/userAdminView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("FastMX - Administración de usuarios");
        userAdminController mc = loader.getController();
        mc.refreshTable();
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    public void employeeManagement(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/employeeManagementView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Administración de empleados");
        employeeManagementController emc = loader.getController();
        emc.refreshTable();
        stage.centerOnScreen();
        stage.show();

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
