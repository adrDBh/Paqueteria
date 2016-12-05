package Controllers;

import Functions.FXFunctions;
import Functions.TableFunctions;
import Functions.Utilities;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


import java.io.IOException;

public class editPhoneController {

    private int CurrentID;
    TableFunctions tf = new TableFunctions();
    FXFunctions fx = new FXFunctions();
    @FXML
    private TextField lblPhoneNumber;

    @FXML
    private TextField lblDescription;

    @FXML
    void onFinish(ActionEvent event) throws IOException {
        tf.editPhone(CurrentID, lblPhoneNumber.getText().trim(), lblDescription.getText().trim());
        fx.makeNewINFOalert("Exito", "se actualizó el teléfono").showAndWait();
        fx.hideCurrentWindow(event);
    }

    public void initialize(int ID, String Phone, String Description) {
        this.CurrentID = ID;
        lblPhoneNumber.setText(Phone);
        lblDescription.setText(Description);
    }
}
