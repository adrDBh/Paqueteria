package Controllers;


import Functions.FXFunctions;
import Functions.TableFunctions;
import Models.clientModel;
import Models.serviceModel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class serviceManagementController {
    @FXML
    private TableView<serviceModel> serviceTable;
    private serviceModel cs;
    private ObservableList<serviceModel> data;
    private int currentID;
    private FXFunctions fx = new FXFunctions();
    private TableFunctions tf = new TableFunctions();
    private int CurrentLOCATIONID;

    @FXML
    void onDeleteService() {
        if (currentID != 0) {
            Optional<ButtonType> decision = fx.makeNewConfirmationAlert("Confirmación", "Eliminar entrada", "Estás seguro que quieres elminiar el servicio seleccionada?").showAndWait();
            if (decision.get() == ButtonType.OK) {
                tf.deleteService(currentID);
                refreshTable();
            }
        }
    }

    @FXML
    void onDelPressed(KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.DELETE)) {
            onDeleteService();
        }
    }

    @FXML
    void onMouseAction(MouseEvent event) {
        cs = serviceTable.getSelectionModel().getSelectedItem();
        if (cs != null) {
            System.out.println(cs.getId());
            this.currentID = Integer.parseInt(cs.getId());
            this.CurrentLOCATIONID = Integer.parseInt(cs.getidLocation());
        }
    }

    @FXML
    void onUpdateLocation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/updateLocationView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("FastMX - Actualizar localizacion");
        updateLocationController ulc = loader.getController();
        ulc.initialize(CurrentLOCATIONID, cs.getLocalization());
        stage.centerOnScreen();
        stage.show();
        stage.setOnHiding(event1 -> Platform.runLater(() -> refreshTable()));
    }

    public void refreshTable() {
        try {
            data = FXCollections.observableArrayList();
            ResultSet rs = new TableFunctions().getServiceData();
            while (rs.next()) {
                data.add(new serviceModel(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                ));
                serviceTable.setItems(data);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
