package Controllers;

import Functions.FXFunctions;
import Functions.TableFunctions;
import Models.clientModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class clientManagementController {
    FXFunctions fx = new FXFunctions();
    TableFunctions tf = new TableFunctions();
    int currentID;
    clientModel cm;

    private ObservableList<clientModel> data;
    @FXML
    private TableView<clientModel> clientTable;

    @FXML
    void onNew(ActionEvent event) {
    }

    @FXML
    void onEdit(ActionEvent event) {
    }

    @FXML
    void onDelete() {
        Optional<ButtonType> decision = fx.makeNewConfirmationAlert("Confirmación", "Eliminar entrada", "Estás seguro que quieres elminiar la entrada seleccionada?").showAndWait();
        if (decision.get() == ButtonType.OK) {
            tf.deleteClient(currentID);
        }
    }

    @FXML
    void onDelPressed(KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.DELETE)) {
            System.err.println(cm.getId());
            onDelete();
        }
    }

    public void onMouseAction(MouseEvent mouseEvent) {
        cm = clientTable.getSelectionModel().getSelectedItem();
        if (cm != null) {
            System.out.println(cm.getId());
            this.currentID = Integer.parseInt(cm.getId());
        }
    }

    void refreshTable() {
        try {
            data = FXCollections.observableArrayList();
            ResultSet rs = new TableFunctions().getClientData();
            while (rs.next()) {
                data.add(new clientModel(
                        rs.getString("idCliente"),
                        rs.getString("Nombre"),
                        rs.getString("Apeido_Paterno"),
                        rs.getString("Apeido_Materno"),
                        rs.getString("Numero"),
                        rs.getString("Descripcion"),
                        rs.getString("Correo"),
                        rs.getString(8)
                ));
                clientTable.setItems(data);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
