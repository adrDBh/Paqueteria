package Controllers;


import Functions.FXFunctions;
import Functions.TableFunctions;
import Models.emailModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class editEmailController {
    private int CurrentID;
    private TableFunctions tf = new TableFunctions();
    private FXFunctions fx = new FXFunctions();

    @FXML
    private TextField lblEmail, lblDescription;

    @FXML
    void onFinish(ActionEvent event) throws IOException {
        tf.editEmail(CurrentID, lblEmail.getText().trim(), lblDescription.getText().trim());
        fx.makeNewINFOalert("Exito", "se actualizó el email").showAndWait();
        fx.hideCurrentWindow(event);
    }

    @FXML
    public void initialize(int ID, String Email, String Description) {
        System.out.println(ID);
        this.CurrentID = ID;
        lblEmail.setText(Email);
        lblDescription.setText(Description);
    }

}
