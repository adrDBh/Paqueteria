package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class trackingResultController {
    @FXML
    private Label lblEmployee, lblUrgent, lblTransporte, lblPeso, lblCliente, lblFolio, lblOrigen, lblDestino, lblLocalizacion, lblDescription;

    public void initialize(String Folio, String Origen, String Localizacion, String Descripcion, String Transportista, String Destino, String Transporte, String Urgente, String Peso) {
        this.lblFolio.setText(Folio);
        this.lblOrigen.setText(Origen);
        this.lblLocalizacion.setText(Localizacion);
        this.lblDescription.setText(Descripcion);
        this.lblEmployee.setText(Transportista);
        this.lblDestino.setText(Destino);
        this.lblTransporte.setText(Transporte);
        this.lblUrgent.setText(Urgente);
        this.lblPeso.setText(Peso);
    }
}
