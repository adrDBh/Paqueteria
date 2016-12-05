package Controllers;

import Functions.FXFunctions;
import Functions.TableFunctions;
import Models.emailModel;
import Models.phoneModel;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class clientManagementEmailController {

    private ObservableList<emailModel> data;
    private int CurrentClientID;
    private int CurrentID;
    private emailModel em;
    FXFunctions fx = new FXFunctions();
    TableFunctions tf = new TableFunctions();

    @FXML
    private Label lblClientName;
    @FXML
    private TableView<emailModel> emailTable;

    @FXML
    void onNew(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/newEmailView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Añadir un correo");
        newEmailController nec = loader.getController();
        nec.initialize(CurrentClientID);
        stage.centerOnScreen();
        stage.show();
        stage.setOnHiding(event1 -> Platform.runLater(() -> refreshTable()));
    }

    @FXML
    void onEdit(ActionEvent event) throws IOException {
        if (CurrentID != 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/editEmailView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Editar un email");
            editEmailController eec = loader.getController();
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
                tf.delEmail(CurrentID);
                refreshTable();
            }
        }
    }

    @FXML
    public void initialize(String Cliente, int ID) {
        this.CurrentClientID = ID;
        lblClientName.setText(Cliente);
    }

    public void refreshTable() {
        try {
            data = FXCollections.observableArrayList();
            ResultSet rs = new TableFunctions().getEmailData(CurrentClientID);
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

    @FXML
    public void onMouseAction(MouseEvent mouseEvent) {
        em = emailTable.getSelectionModel().getSelectedItem();
        if (em != null) {
            this.CurrentID = Integer.parseInt(em.getId());
        }
    }
}
