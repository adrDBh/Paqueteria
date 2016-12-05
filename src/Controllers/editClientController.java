package Controllers;

import Functions.FXFunctions;
import Functions.TableFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class editClientController {
    private int CurrentID;
    TableFunctions tf = new TableFunctions();
    FXFunctions fx = new FXFunctions();

    @FXML
    private TextField lblName;

    @FXML
    private TextField lblAPP;

    @FXML
    private TextField lblAPM;

    @FXML
    void onFinish(ActionEvent event) throws IOException {
        tf.editClient(CurrentID, lblName.getText().trim(), lblAPP.getText().trim(), lblAPM.getText().trim());
        fx.makeNewINFOalert("Exito", "se actualizó el cliente").showAndWait();
        fx.hideCurrentWindow(event);
    }

    @FXML
    void initialize(int ID, String name, String APP, String APM) {
        this.CurrentID = ID;
        lblName.setText(name);
        lblAPP.setText(APP);
        lblAPM.setText(APM);
    }

}