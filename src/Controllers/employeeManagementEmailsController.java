package Controllers;

import Functions.FXFunctions;
import Functions.TableFunctions;
import Models.emailModel;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class employeeManagementEmailsController {

    @FXML
    private Label lblEmployeeName;

    @FXML
    private TableView<emailModel> emailTable;
    private ObservableList<emailModel> data;
    private int CurrentEmployeeID;
    private emailModel em;
    private int CurrentID;
    private FXFunctions fx = new FXFunctions();
    private TableFunctions tf = new TableFunctions();


    @FXML
    void onNew(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/newEmployeeEmailView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Añadir un correo");
        newEmployeeEmailController nec = loader.getController();
        nec.initialize(CurrentEmployeeID);
        stage.centerOnScreen();
        stage.show();
        stage.setOnHiding(event1 -> Platform.runLater(() -> refreshTable()));
    }

    @FXML
    void onEdit(ActionEvent event) throws IOException {
        if (CurrentID != 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/editEmployeeEmailView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Editar un email");
            editEmployeeEmailController eec = loader.getController();
            eec.initialize(Integer.parseInt(em.getId()), em.getEmail(), em.getDescription());
            stage.centerOnScreen();
            stage.show();
            stage.setOnHiding(event1 -> Platform.runLater(() -> refreshTable()));
        }
    }

    @FXML
    void onDelete(ActionEvent event) {
        if (CurrentID != 0) {
            Optional<ButtonType> decision = fx.makeNewConfirmationAlert("Confirmación", "Eliminar entrada", "Estás seguro que quieres elminiar la entrada seleccionada?").showAndWait();
            if (decision.get() == ButtonType.OK) {
                tf.delEmployeeEmail(CurrentID);
                refreshTable();
            }
        }
    }

    public void initialize(String Name, int ID) {
        this.lblEmployeeName.setText(Name);
        this.CurrentEmployeeID = ID;
    }

    void refreshTable() {
        try {
            data = FXCollections.observableArrayList();
            ResultSet rs = new TableFunctions().getEmployeeEmails(CurrentEmployeeID);
            while (rs.next()) {
                data.add(new emailModel(
                        rs.getString("idEmail"),
                        rs.getString("Correo"),
                        rs.getString("Descripcion")
                ));
                emailTable.setItems(data);
            }
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
        }
    }

    public void onMouseAction(MouseEvent event) {
        em = emailTable.getSelectionModel().getSelectedItem();
        if (em != null) {
            this.CurrentID = Integer.parseInt(em.getId());
            System.out.println(CurrentID);
        }
    }
}
