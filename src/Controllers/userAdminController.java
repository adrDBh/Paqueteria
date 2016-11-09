package Controllers;

import Functions.DBRequests;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class userAdminController implements Initializable {
    DBRequests db = new DBRequests();
    @FXML
    private ObservableList<ObservableList> datos;
    private TableView TableView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void fillTable() {

        datos = FXCollections.observableArrayList();

    }
}
