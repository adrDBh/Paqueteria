package Controllers;


import Functions.FXFunctions;
import Functions.TableFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class updateLocationController {

    private int CurrentID;
    TableFunctions tf = new TableFunctions();
    FXFunctions fx = new FXFunctions();

    @FXML
    private TextField lblLocation;

    @FXML
    void onFinish(ActionEvent event) {
        tf.updateLocation(CurrentID, lblLocation.getText().trim());
        fx.makeNewINFOalert("Exito", "se actualizó la localización").showAndWait();
        fx.hideCurrentWindow(event);
    }

    public void initialize(int ID, String Location) {
        this.CurrentID = ID;
        lblLocation.setText(Location);
    }
}
