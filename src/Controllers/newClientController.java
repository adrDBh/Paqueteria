package Controllers;

import Functions.FXFunctions;
import Functions.TableFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.Optional;


public class newClientController {
    FXFunctions fx = new FXFunctions();
    @FXML
    private TextField lblName;

    @FXML
    private TextField lblAPP;

    @FXML
    private TextField lblAPM;

    @FXML
    private TextField lblEmail;

    @FXML
    private TextField lblPhoneDescription;

    @FXML
    private TextField lblPhone;

    @FXML
    private TextField lblEmailDescription;

    @FXML
    void onFinish(ActionEvent event) {
        Optional<ButtonType> decision = fx.makeNewConfirmationAlert("Confirmación", "Crear nuevo usuario", "los datos ingresados son correctos?").showAndWait();
        if (new TableFunctions().createClient(
                lblName.getText().trim(),
                lblAPP.getText().trim(),
                lblAPM.getText().trim(),
                lblPhone.getText().trim(),
                lblPhoneDescription.getText().trim(),
                lblEmail.getText().trim(),
                lblEmailDescription.getText().trim()) && decision.get() == ButtonType.OK) {
            fx.makeNewINFOalert("Exito", "Se creó el cliente: " + lblName.getText().trim()).showAndWait();
            fx.hideCurrentWindow(event);
        } else {
            fx.makeNewERRORalert("Error", "El cliente " + lblName.getText() + " ya existe, intentálo nuevamente.").showAndWait();
            lblName.setText("");
            lblAPP.setText("");
            lblAPM.setText("");
            lblPhone.setText("");
            lblPhoneDescription.setText("");
            lblEmail.setText("");
            lblEmailDescription.setText("");
        }
    }
}
