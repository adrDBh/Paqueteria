package Controllers;

import Functions.FXFunctions;
import Functions.TableFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class newEmployeeEmailController {

    FXFunctions fx = new FXFunctions();
    @FXML
    private TextField lblEmail;

    @FXML
    private TextField lblDescription;
    private int ID;

    public void onFinish(ActionEvent event) {
        new TableFunctions().newEmployeeEmail(ID, lblEmail.getText().trim(), lblDescription.getText().trim());
        fx.makeNewINFOalert("Exito", "Se insertó el correo: " + lblEmail.getText().trim()).showAndWait();
        fx.hideCurrentWindow(event);
    }

    public void initialize(int ID) {
        this.ID = ID;
    }

}
