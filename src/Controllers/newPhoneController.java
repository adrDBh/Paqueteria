package Controllers;

import Functions.FXFunctions;
import Functions.TableFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class newPhoneController {
    private int ClientID;
    FXFunctions fx = new FXFunctions();
    @FXML
    private TextField lblPhoneNumber;

    @FXML
    private TextField lblDescription;

    public void initialize(int ClientID) {
        this.ClientID = ClientID;
    }

    public void onFinish(ActionEvent event) {
        new TableFunctions().newPhone(ClientID, lblPhoneNumber.getText().trim(), lblDescription.getText().trim());
        fx.makeNewINFOalert("Exito", "Se insertó el teléfono: " + lblPhoneNumber.getText().trim()).showAndWait();
        fx.hideCurrentWindow(event);
    }
}
