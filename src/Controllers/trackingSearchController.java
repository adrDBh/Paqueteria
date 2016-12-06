package Controllers;

import Functions.FXFunctions;
import Functions.TableFunctions;
import com.sun.corba.se.spi.activation.LocatorPackage.ServerLocationPerORB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sun.security.krb5.internal.crypto.Des;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class trackingSearchController {

    private String Folio, Origen, Localizacion, Cliente, Descripcion, Transportista, Destino, Transporte, Urgente, Peso;

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
            StringFill();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/trackingResultView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Fast MX - Rastreo");
            trackingResultController trc = loader.getController();
            trc.initialize(Folio, Origen, Localizacion, Cliente, Descripcion, Transportista, Destino, Transporte, Urgente, Peso);
            stage.centerOnScreen();
            stage.show();
        }
    }

    void StringFill() {
        try {
            ResultSet rs = new TableFunctions().searchTrackingNumber(lblTrackingCode.getText().trim());
            while (rs.next()) {
                Folio = rs.getString(1);
                Origen = rs.getString(2);
                Localizacion = rs.getString(3);
                Cliente = rs.getString(4);
                Descripcion = rs.getString(5);
                Transportista = rs.getString(6);
                Destino = rs.getString(7);
                Transporte = rs.getString(8);
                Urgente = rs.getString(9);
                Peso = rs.getString(10);
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        }

    }
}
