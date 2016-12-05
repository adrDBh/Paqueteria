package Controllers;

import Functions.FXFunctions;
import Functions.TableFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.Optional;

public class newEmployeeController {

    private FXFunctions fx = new FXFunctions();
    @FXML
    private TextField lblName, lblAPP, lblAPM, lblEmail, lblEmailDescription, lblTurno;

    @FXML
    void onFinish(ActionEvent event) {
        Optional<ButtonType> decision = fx.makeNewConfirmationAlert("Confirmación", "Crear nuevo empleado", "los datos ingresados son correctos?").showAndWait();
        if (new TableFunctions().createEmployee(
                lblName.getText().trim(),
                lblAPP.getText().trim(),
                lblAPM.getText().trim(),
                lblEmail.getText().trim(),
                lblEmailDescription.getText().trim(),
                lblTurno.getText().trim()) && decision.get() == ButtonType.OK) {
            fx.makeNewINFOalert("Exito", "Se creó el empleado: " + lblName.getText().trim()).showAndWait();
            fx.hideCurrentWindow(event);
        } else {
            fx.makeNewERRORalert("Error", "El empleado " + lblName.getText() + " ya existe, intentálo nuevamente.").showAndWait();
            lblName.setText("");
            lblAPP.setText("");
            lblAPM.setText("");
            lblEmail.setText("");
            lblEmailDescription.setText("");
        }
    }
}
