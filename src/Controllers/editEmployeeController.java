package Controllers;

import Functions.FXFunctions;
import Functions.TableFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class editEmployeeController {

    private int CurrentID;
    private TableFunctions tf = new TableFunctions();
    private FXFunctions fx = new FXFunctions();

    @FXML
    private TextField lblName, lblTurno, lblAPP, lblAPM;

    @FXML
    void onFinish(ActionEvent event) throws IOException {
        tf.editEmployee(CurrentID, lblName.getText().trim(), lblAPP.getText().trim(), lblAPM.getText().trim(), lblTurno.getText().trim());
        fx.makeNewINFOalert("Éxito", "se actualizó el empleado").showAndWait();
        fx.hideCurrentWindow(event);
    }

    @FXML
    void initialize(int ID, String name, String APP, String APM, String turno) {
        this.CurrentID = ID;
        lblName.setText(name);
        lblAPP.setText(APP);
        lblAPM.setText(APM);
        lblTurno.setText(turno);
    }
}
