package Controllers;

import Functions.FXFunctions;
import Functions.TableFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class newEmailController {
    FXFunctions fx = new FXFunctions();
    @FXML
    private TextField lblEmail;

    @FXML
    private TextField lblDescription;
    private int ClientID;

    public void onFinish(ActionEvent event) {
        new TableFunctions().newEmail(ClientID, lblEmail.getText().trim(), lblDescription.getText().trim());
        fx.makeNewINFOalert("Exito", "Se insertó el correo: " + lblEmail.getText().trim()).showAndWait();
        fx.hideCurrentWindow(event);
    }

    public void initialize(int ClientID) {
        this.ClientID = ClientID;
    }
}
