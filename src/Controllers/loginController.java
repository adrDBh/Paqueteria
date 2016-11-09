package Controllers;

import Functions.FXFunctions;
import Functions.DBRequests;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    DBRequests db = new DBRequests();
    FXFunctions fx = new FXFunctions();
    private int failedAttempts = 0;

    @FXML
    private TextField lblUsername;
    @FXML
    private TextField lblPassword;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void LoginAction(ActionEvent event) throws IOException {
        if (db.getLogin(lblUsername.getText().trim(), lblPassword.getText().trim())) {
            System.out.println("Signed in as: " + lblUsername.getText());
            // Hide window and show the new one.
            fx.hideCurrentWindow(event);
            // Render second window.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/mainView.fxml"));
            Parent root = loader.load();
            mainController mc = loader.getController();
            mc.setLblUsername(db.getUser());
            mc.setLblLastSeen(db.getLastLogin());
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Ventana principal");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();
            // End rendering the second window.
        } else if (lblUsername.getText().trim().isEmpty() || lblUsername.getText().equals(null)) {
            fx.makeNewERRORalert("Error de inicio de sesión", "El campo de usuario está vacío").showAndWait();
        } else if (lblPassword.getText().trim().isEmpty() || lblUsername.getText().equals(null)) {
            fx.makeNewERRORalert("Error de inicio de sesión", "El campo de contraseña está vacío").showAndWait();
        } else {
            failedAttempts++;
            System.err.println("Failed login attempt " + failedAttempts);
            System.out.println("User: " + lblUsername.getText());
            System.out.println("Password: " + lblPassword.getText());
            fx.makeNewERRORalert("Error de inicio de sesión", "Los datos de inicio de sesión son incorrectos, intentalo de nuevo.").showAndWait();
            // Erase both labels and try again.
            lblUsername.setText("");
            lblPassword.setText("");
        }

    }

    @FXML
    private void CreateUserAction(ActionEvent event) throws IOException {
        // NOT BEING USED
        fx.hideCurrentWindow(event);
        // Render second window.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/newUserView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Crear nuevo usuario");
        stage.setResizable(false);
        stage.show();
    }
}
