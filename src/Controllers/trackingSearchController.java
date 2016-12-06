package Controllers;

import Functions.FXFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class trackingSearchController {

    private FXFunctions fx = new FXFunctions();

    @FXML
    private TextField lblTrackingCode;

    @FXML
    void onSearch(ActionEvent event) throws IOException {
        if (lblTrackingCode.getText().trim().length() > 22) {
            fx.makeNewERRORalert("Error", "El código de rastreo excede de los 22 caracteres.").showAndWait();
        } else if (lblTrackingCode.getText().trim().length() < 22) {
            fx.makeNewERRORalert("Error", "El código de rastreo no cumple con los 22 dígitos.").showAndWait();
        } else if (lblTrackingCode.getText().trim().length() == 22) {
            fx.hideCurrentWindow(event);
            // THINGS TO DO AFTER PASSING THE VALIDATION
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/trackingResultView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Fast MX - Rastreo");
            trackingResultController trc = loader.getController();
            // trc.initialize(); // PARAMETROS A PASAR CON UNA CONSULTA
            stage.centerOnScreen();
            stage.show();
        }
    }
}
