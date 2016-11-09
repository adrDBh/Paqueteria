package Controllers;

import Functions.FXFunctions;
import Functions.TableFunctions;
import javafx.collections.FXCollections;
import Models.userModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class userAdminController implements Initializable {

    @FXML
    private TableView<userModel> tblView;
    private ObservableList<userModel> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void fillTable() throws SQLException {
        data = FXCollections.observableArrayList();
        ResultSet results = new TableFunctions().getTableData();
        while (results.next()) {
            data.add(new userModel(results.getString("idLogin"),
                    results.getString("Username"),
                    results.getString("Password"),
                    results.getString("CreatedAt"),
                    results.getString("LastLogin")
            ));
            tblView.setItems(data);
        }
    }

    public void onRefresh(ActionEvent event) {
        try {
            fillTable();
            new FXFunctions().makeNewINFOalert("Correcto", "Tabla actualizada correctamente").showAndWait();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
