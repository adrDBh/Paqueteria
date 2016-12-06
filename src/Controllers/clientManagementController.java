package Controllers;

import Functions.FXFunctions;
import Functions.TableFunctions;
import Models.clientModel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
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
    private Label lblRows;

    @FXML
    void onNew(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/clientManagementNewView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Crear nuevo cliente");
        stage.centerOnScreen();
        stage.show();
        stage.setOnHiding(event1 -> Platform.runLater(() -> refreshTable()));
    }

    @FXML
    void onEdit(ActionEvent event) throws IOException {
        if (currentID != 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/clientManagementEditview.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Editar un cliente");
            editClientController ecc = loader.getController();
            ecc.initialize(Integer.parseInt(cm.getId()), cm.getName(), cm.getAPP(), cm.getAPM());
            stage.centerOnScreen();
            stage.show();
            stage.setOnHiding(event1 -> Platform.runLater(() -> refreshTable()));
        }
    }

    @FXML
    void onDelete() {
        if (currentID != 0) {
            Optional<ButtonType> decision = fx.makeNewConfirmationAlert("Confirmación", "Eliminar entrada", "Estás seguro que quieres elminiar la entrada seleccionada?").showAndWait();
            if (decision.get() == ButtonType.OK) {
                tf.deleteClient(currentID);
                refreshTable();
            }
        }
    }

    @FXML
    void onDelPressed(KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.DELETE)) {
            onDelete();
        }
    }

    public void onMouseAction(MouseEvent mouseEvent) {
        cm = clientTable.getSelectionModel().getSelectedItem();
        if (cm != null) {
            this.currentID = Integer.parseInt(cm.getId());
        }
    }

    void refreshTable() {
        try {
            int rows = 0;
            data = FXCollections.observableArrayList();
            ResultSet rs = new TableFunctions().getClientData();
            while (rs.next()) {
                rows++;
                data.add(new clientModel(
                        rs.getString("idCliente"),
                        rs.getString("Nombre"),
                        rs.getString("Apeido_Paterno"),
                        rs.getString("Apeido_Materno")
                ));
                clientTable.setItems(data);
            }
            lblRows.setText(Integer.toString(rows));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void onClientEmails(ActionEvent event) throws IOException {
        if (currentID != 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/clientManagementEmailsView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Administración de correos");
            clientManagementEmailController cmec = loader.getController();
            System.out.println("ID DEL CLIENTE: " + cm.getId());
            cmec.initialize(cm.getName(), Integer.parseInt(cm.getId()));
            cmec.refreshTable();
            stage.centerOnScreen();
            stage.show();
        }


    }

    @FXML
    public void onClientPhones(ActionEvent event) throws IOException {
        if (currentID != 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/clientPhoneView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Administración de teléfonos");
            clientPhoneManagerController cpmc = loader.getController();
            cpmc.initialize(cm.getName(), Integer.parseInt(cm.getId()));
            cpmc.refreshTable();
            stage.centerOnScreen();
            stage.show();
        }
    }
}