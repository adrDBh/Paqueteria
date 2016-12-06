package Controllers;

import Functions.FXFunctions;
import Functions.TableFunctions;
import com.sun.management.VMOption;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.webkit.Utilities;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class registerServiceController {
    private FXFunctions fx = new FXFunctions();
    private TabPane tabs = new TabPane();
    private Functions.Utilities u = new Functions.Utilities();
    private TableFunctions tf = new TableFunctions();
    private String[] clientNameSplit, EmployeeNameSplit;

    @FXML
    private TextField lblAlto, lblAncho, lblPeso, lblDescripcion, lblLargo, Origin_lblStreet, Origin_lblStreetNum, Origin_lblColony, Origin_lblCity, Origin_lblState, Destiny_lblStreet, Destiny_lblStreetNum, Destiny_lblColony, Destiny_lblCity, Destiny_lblState, lblCost, Origin_CP, Destiny_CP;

    @FXML
    private Tab Tab1, Tab2, Tab3, Tab4, Tab5, Tab6;

    @FXML
    private ComboBox<String> cbUsers, cbEmployee, Fragil, Prioridad, cbTransport;


    @FXML
    void onFinishTab1(ActionEvent event) {
        if (cbUsers.getValue() != null) {
            Tab1.setDisable(true);
            Tab2.setDisable(false);
            tabs.getSelectionModel().select(Tab2);
            System.out.println("===============");
            clientNameSplit = u.splitNames(cbUsers.getValue().trim());
            System.out.println("===============");
        } else {
            fx.makeNewERRORalert("Error", "Porfavor selecciona un valor de la lista antes de continuar").showAndWait();
        }
    }

    @FXML
    void onFinishTab2(ActionEvent event) {
        if (!(Fragil.getValue() == null |
                Prioridad.getValue() == null |
                lblPeso.getText().trim().isEmpty() |
                lblAlto.getText().isEmpty() |
                lblLargo.getText().trim().isEmpty() |
                lblAncho.getText().trim().isEmpty() |
                lblDescripcion.getText().trim().isEmpty())) {
            Tab2.setDisable(true);
            Tab3.setDisable(false);
            tabs.getSelectionModel().select(Tab3);
            System.out.println("===============");
            System.out.println(Fragil.getValue());
            System.out.println(Prioridad.getValue());
            System.out.println("===============");
        } else {
            fx.makeNewERRORalert("Error", "Algún campo está vacío").showAndWait();
        }
    }


    @FXML
    void onFinishTab3(ActionEvent event) {
        if (cbEmployee.getValue() != null) {
            Tab3.setDisable(true);
            Tab4.setDisable(false);
            tabs.getSelectionModel().select(Tab4);
            System.out.println("===============");
            EmployeeNameSplit = u.splitNames(cbEmployee.getValue());
            System.out.println("===============");
        } else {
            fx.makeNewERRORalert("Error", "Porfavor selecciona un valor de la lista antes de continuar").showAndWait();
        }
    }

    @FXML
    void onFinishTab4(ActionEvent event) {
        if (!(Origin_lblStreet.getText().trim().isEmpty() |
                Origin_lblStreetNum.getText().trim().isEmpty() |
                Origin_lblColony.getText().trim().isEmpty() |
                Origin_lblCity.getText().trim().isEmpty() |
                Origin_lblState.getText().trim().isEmpty() |
                Origin_CP.getText().isEmpty())) {
            Tab4.setDisable(true);
            Tab5.setDisable(false);
            tabs.getSelectionModel().select(Tab5);
        } else {
            fx.makeNewERRORalert("Error", "Algún campo está vacío").showAndWait();
        }
    }

    @FXML
    public void onFinishTab5(ActionEvent event) {
        if (!(Destiny_lblStreet.getText().trim().isEmpty() |
                Destiny_lblStreetNum.getText().trim().isEmpty() |
                Destiny_lblColony.getText().trim().isEmpty() |
                Destiny_lblCity.getText().trim().isEmpty() |
                Destiny_lblState.getText().trim().isEmpty()) |
                Destiny_CP.getText().trim().isEmpty()) {
            Tab5.setDisable(true);
            Tab6.setDisable(false);
            tabs.getSelectionModel().select(Tab6);
        } else {
            fx.makeNewERRORalert("Error", "Algún campo está vacío").showAndWait();
        }
    }

    @FXML
    public void onFinishALL(Event event) {
        if (!(lblCost.getText().trim().isEmpty() | cbTransport.getValue() == null)) {
            System.out.println("Survey is finished");
            String FOIL = u.RandomFoilNumberGen();
            tf.newService(clientNameSplit[0], clientNameSplit[1], clientNameSplit[2],
                    Fragil.getValue().trim(), Prioridad.getValue().trim(), lblPeso.getText().trim(),
                    lblAlto.getText().trim(), lblLargo.getText().trim(), lblAncho.getText().trim(),
                    lblDescripcion.getText().trim(), EmployeeNameSplit[0], EmployeeNameSplit[1],
                    EmployeeNameSplit[2], Origin_lblStreet.getText().trim(), Origin_lblStreetNum.getText().trim(),
                    Origin_lblColony.getText().trim(), Origin_CP.getText().trim(), Origin_lblCity.getText().trim(),
                    Origin_lblState.getText().trim(), Origin_lblState.getText().trim(), Destiny_lblStreet.getText().trim(),
                    Destiny_lblStreetNum.getText().trim(), Destiny_lblColony.getText().trim(), Destiny_CP.getText().trim(),
                    Destiny_lblCity.getText().trim(), Destiny_lblState.getText().trim(), Destiny_lblState.getText(),
                    FOIL, lblCost.getText().trim(), cbTransport.getValue().trim());
            fx.makeFoilDialog(FOIL).showAndWait();
            fx.hideCurrentWindow(event);
        } else {
            fx.makeNewERRORalert("Error", "Rellena todos los valores.").showAndWait();
        }
    }

    @FXML
    void onNewEmployee(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/employeeManagementNewView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Fast MX - Nuevo empleado");
        stage.centerOnScreen();
        stage.show();
        stage.setOnHiding(event1 -> Platform.runLater(() -> fillcbEmployee()));
    }

    @FXML
    void onNewClient(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/clientManagementNewView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Fast MX - Nuevo cliente");
        stage.centerOnScreen();
        stage.show();
        stage.setOnHiding(event1 -> Platform.runLater(() -> fillcbUsers()));
    }

    public void initialize() {
        tabs.getTabs().addAll(Tab1, Tab2, Tab3, Tab4, Tab5, Tab6);
        fillcbUsers();
        fillcbEmployee();
        Fragil.getItems().addAll("Sí", "No");
        Prioridad.getItems().addAll("Alta", "Normal");
        cbTransport.getItems().addAll("Aéreo", "Terrestre", "Marítimo");
    }

    void fillcbUsers() {
        try {
            cbUsers.getItems().clear();
            ResultSet rs = new TableFunctions().getClientData();
            while (rs.next()) {
                cbUsers.getItems().add(
                        rs.getString("Nombre") + " " + rs.getString("Apeido_Paterno") + " " + rs.getString("Apeido_Materno")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        }
    }

    void fillcbEmployee() {
        try {
            cbEmployee.getItems().clear();
            ResultSet rs = new TableFunctions().getEmployeeData();
            while (rs.next()) {
                cbEmployee.getItems().add(
                        rs.getString("Nombre") + " " + rs.getString("Apellido_Paterno") + " " + rs.getString("Apellido_Materno")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        }
    }
}