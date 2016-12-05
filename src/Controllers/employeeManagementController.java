package Controllers;

import Functions.FXFunctions;
import Functions.TableFunctions;
import Models.employeeModel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

public class employeeManagementController {
    private FXFunctions fx = new FXFunctions();
    private TableFunctions tf = new TableFunctions();
    private ObservableList<employeeModel> data;
    private employeeModel ce;
    private int currentID;

    @FXML
    private TableView<employeeModel> employeeTable;

    @FXML
    private Label lblRows;


    @FXML
    void onNew(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/employeeManagementNewView.fxml"));
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/employeeManagementEditView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Editar un empleado");
            editEmployeeController eec = loader.getController();
            eec.initialize(Integer.parseInt(ce.getId()), ce.getName(), ce.getAPP(), ce.getAPM(), ce.getTurn());
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
                tf.deleteEmployee(currentID);
                refreshTable();
            }
        }
    }

    void refreshTable() {
        try {
            int rows = 0;
            data = FXCollections.observableArrayList();
            ResultSet rs = new TableFunctions().getEmployeeData();
            while (rs.next()) {
                rows++;
                data.add(new employeeModel(
                        rs.getString("idEmpleado"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido_Paterno"),
                        rs.getString("Apellido_Materno"),
                        rs.getString("Turno")
                ));
                employeeTable.setItems(data);
            }
            lblRows.setText(Integer.toString(rows));
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        }

    }

    @FXML
    public void onMouseAction(MouseEvent mouseEvent) {
        ce = employeeTable.getSelectionModel().getSelectedItem();
        if (ce != null) {
            this.currentID = Integer.parseInt(ce.getId());
            System.out.println(currentID);
        }
    }

    @FXML
    void onDelPressed(KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.DELETE)) {
            onDelete();
        }
    }

    @FXML
    void onEmployeeEmails(ActionEvent event) throws IOException {
        if (currentID != 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/employeeManagementEmailsView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Administración de correos");
            employeeManagementEmailsController emec = loader.getController();
            emec.initialize(ce.getName(), Integer.parseInt(ce.getId()));
            emec.refreshTable();
            stage.centerOnScreen();
            stage.show();
        }
    }
}
