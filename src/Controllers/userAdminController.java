package Controllers;

import Functions.FXFunctions;
import Functions.TableFunctions;
import Models.userModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class userAdminController {

    FXFunctions fx = new FXFunctions();
    TableFunctions tf = new TableFunctions();
    int currentID;
    userModel um;
    private ObservableList<userModel> data;
    @FXML
    private TableView<userModel> userTable;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField lastloginDP;
    @FXML
    private TextField createdatDP;
    @FXML
    private Button delBtn;
    @FXML
    private Button saveBtn;
    @FXML
    private Button editBtn;
    @FXML
    private Button newBtn;

    @FXML
    void onNew(ActionEvent event) {
        udButtons(true);
        activateFields(false);
        saveBtn.setDisable(false);
        cleanFields();
    }

    @FXML
    void onSave(ActionEvent event) {
        boolean status = false;
        if (usernameField.getText().trim().isEmpty() || usernameField.getText() == null) {
            fx.makeNewERRORalert("ERROR", "El campo de usuario está vacío y/o contiene solo espacios en blanco.").showAndWait();
        } else if (passwordField.getText().trim().isEmpty() || passwordField.getText() == null) {
            fx.makeNewERRORalert("ERROR", "El campo de contraseña está vacío y/o contiene solo espacios en blanco.").showAndWait();
        } else {
            status = tf.CreateUser(usernameField.getText().trim(), passwordField.getText().trim());
            if (!status) {
                fx.makeNewERRORalert("ERROR", "El nombre de usuario " + usernameField.getText() + " ya está registrado").showAndWait();
                cleanFields();
            } else {
                refreshTable();
                fx.makeNewINFOalert("Exito", "El usuario " + usernameField.getText() + " se creó con éxito, ahora puede ser utilizado para acceder al sistema.").showAndWait();
                cleanFields();
            }
        }
    }

    @FXML
    void onDelete(ActionEvent event) {
        Optional<ButtonType> decision = fx.makeNewConfirmationAlert("Confirmación", "Eliminar entrada", "Estás seguro que quieres elminiar la entrada seleccionada?").showAndWait();
        if (decision.get() == ButtonType.OK) {
            tf.deleteUser(currentID);
            refreshTable();
            cleanFields();
        }
    }

    @FXML
    void onEdit(ActionEvent event) {
        if (um.getUsername().equals(usernameField.getText().trim()) && um.getPassword().equals(passwordField.getText().trim())) {
            fx.makeNewERRORalert("ERROR", "Datos identicos, porfavor realiza alguna modificación.").showAndWait();
        } else {
            tf.editUser(usernameField.getText().trim(), passwordField.getText().trim(), currentID);
            refreshTable();
            cleanFields();
        }
    }

    @FXML
    void onMouseAction(MouseEvent event) {
        um = userTable.getSelectionModel().getSelectedItem();
        if (um != null) {
            activateFields(false);
            saveBtn.setDisable(true);
            udButtons(false);
            usernameField.setText(um.getUsername());
            passwordField.setText(um.getPassword());
            this.currentID = Integer.parseInt(um.getId());
            createdatDP.setText(um.getCa().subSequence(0, um.getCa().indexOf(" ")).toString());
            lastloginDP.setText(um.getLl().equals("N/A") ? "N/A" : um.getLl().subSequence(0, um.getLl().indexOf(" ")).toString());
        }
    }

    void refreshTable() {
        try {
            data = FXCollections.observableArrayList();
            ResultSet rs = new TableFunctions().getTableData();
            while (rs.next()) {
                String LastLogin = rs.getString("LastLogin") == null ? "N/A" : rs.getString("LastLogin");
                data.add(new userModel(
                        rs.getString("idLogin"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("CreatedAt"),
                        LastLogin
                ));
                userTable.setItems(data);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    void activateFields(boolean deactivate) {
        usernameField.setDisable(deactivate);
        passwordField.setDisable(deactivate);
    }

    void cleanFields() {
        usernameField.setText("");
        passwordField.setText("");
        createdatDP.setText("");
        lastloginDP.setText("");
    }

    void udButtons(boolean deactivate) {
        delBtn.setDisable(deactivate);
        editBtn.setDisable(deactivate);
    }

}