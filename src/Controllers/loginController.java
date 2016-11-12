package Controllers;

import Functions.DBRequests;
import Functions.FXFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class loginController {
    DBRequests db = new DBRequests();
    FXFunctions fx = new FXFunctions();

    @FXML
    private TextField lblUsername;
    @FXML
    private TextField lblPassword;

    @FXML
    private void LoginAction(ActionEvent event) throws IOException {
        if (db.getLogin(lblUsername.getText().trim(), lblPassword.getText().trim())) {
            fx.hideCurrentWindow(event);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/mainView.fxml"));
            Parent root = loader.load();
            mainController mc = loader.getController();
            mc.initialize(db.getUser(), db.getLastLogin());
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Ventana principal");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();
        } else if (lblUsername.getText().trim().isEmpty() || lblUsername.getText() == null) {
            fx.makeNewERRORalert("Error de inicio de sesión", "El campo de usuario está vacío").showAndWait();
        } else if (lblPassword.getText().trim().isEmpty() || lblUsername.getText() == null) {
            fx.makeNewERRORalert("Error de inicio de sesión", "El campo de contraseña está vacío").showAndWait();
        } else {
            fx.makeNewERRORalert("Error de inicio de sesión", "Los datos de inicio de sesión son incorrectos, intentalo de nuevo.").showAndWait();
            lblUsername.setText("");
            lblPassword.setText("");
        }
    }
}
