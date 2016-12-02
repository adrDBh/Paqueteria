package Controllers;


import Functions.TableFunctions;
import Models.phoneModel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class clientPhoneManagerController {

    @FXML
    private Label lblClientName;
    @FXML
    private TableView<phoneModel> phoneTable;
    private ObservableList<phoneModel> data;
    private int CurrentClientID;
    private int CurrentID;
    private phoneModel cpm;

    public void refreshTable() {
        try {
            data = FXCollections.observableArrayList();
            ResultSet rs = new TableFunctions().getPhoneData(CurrentClientID);
            while (rs.next()) {
                data.add(new phoneModel(
                        rs.getString("idTelefono"),
                        rs.getString("Numero"),
                        rs.getString("Descripcion")
                ));
                phoneTable.setItems(data);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void initialize(String clientName, int id) {
        this.CurrentClientID = id;
        lblClientName.setText(clientName);

    }

    @FXML
    void onNew(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/newPhoneView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Añadir un teléfono");
        newPhoneController npc = loader.getController();
        npc.initialize(CurrentClientID);
        stage.centerOnScreen();
        stage.show();
        stage.setOnHiding(event1 -> Platform.runLater(() -> refreshTable()));
    }


    @FXML
    void onEdit(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/editPhoneView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Editar un teléfono");
        editPhoneController epc = loader.getController();
        epc.initialize(Integer.parseInt(cpm.getId()), cpm.getPhone(), cpm.getDescription());
        stage.centerOnScreen();
        stage.show();
        stage.setOnHiding(event1 -> Platform.runLater(() -> refreshTable()));
    }

    public void onMouseAction(MouseEvent mouseEvent) {
        cpm = phoneTable.getSelectionModel().getSelectedItem();
        if (cpm != null) {
            this.CurrentID = Integer.parseInt(cpm.getId());
        }
    }
}
