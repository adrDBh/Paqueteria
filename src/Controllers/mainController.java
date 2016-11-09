package Controllers;

import Functions.FXFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class mainController implements Initializable {
    @FXML
    private Label lblUsername;
    @FXML
    private Label lblLastSeen;

    public void setLblUsername(String text) {
        lblUsername.setText(text);
    }

    public void setLblLastSeen(String text) {
        lblLastSeen.setText(text);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    void gotoUsers(ActionEvent event) throws IOException {
        // Hide window and show the new one.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/userAdminView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Administración de usuarios");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }
}
