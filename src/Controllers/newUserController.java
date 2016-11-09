package Controllers;

import Functions.DBRequests;
import Functions.FXFunctions;
import MainRunnable.MainRunnable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class newUserController {
    FXFunctions fx = new FXFunctions();
    DBRequests db = new DBRequests();

    @FXML
    private TextField txtUsernameField;

    @FXML
    private PasswordField txtPasswordField;

    @FXML
    private PasswordField txtPasswordFieldVerification;


    @FXML
    void createNewUser(ActionEvent event) {
        boolean created;
        if (txtUsernameField.getText().trim().isEmpty() || txtUsernameField.getText() == null) {
            fx.makeNewERRORalert("ERROR", "El campo de usuario está vacío y/o contiene solo espacios en blanco.").showAndWait();
        } else if (txtPasswordField.getText().trim().isEmpty() || txtPasswordField.getText() == null) {
            fx.makeNewERRORalert("ERROR", "El campo de contraseña está vacío y/o contiene solo espacios en blanco.").showAndWait();
        } else if (txtPasswordFieldVerification.getText().trim().isEmpty() || txtPasswordFieldVerification.getText() == null) {
            fx.makeNewERRORalert("ERROR", "El campo de verificación está vacío y/o contiene solo espacios en blanco.").showAndWait();
        } else {
            if (txtPasswordField.getText().trim().equals(txtPasswordFieldVerification.getText().trim())) {
                // USER CREATION
                created = db.CreateUser(txtUsernameField.getText().trim(), txtPasswordField.getText().trim());
                if (!created) {
                    fx.makeNewERRORalert("ERROR", "El nombre de usuario " + txtUsernameField.getText().trim() + " ya está registrado").showAndWait();
                    txtUsernameField.setText("");
                    txtPasswordField.setText("");
                    txtPasswordFieldVerification.setText("");
                } else {
                    fx.makeNewINFOalert("Exito", "El usuario " + txtUsernameField.getText().trim() + " se creó con éxito ahora puede ser utilizado para iniciar sesión.").showAndWait();
                    try {
                        fx.hideCurrentWindow(event);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                fx.makeNewERRORalert("ERROR", "Las contraseñas no coinciden.").showAndWait();
            }
        }
    }
}
