package Controllers;

import Functions.FXFunctions;
import Functions.TableFunctions;
import javafx.collections.FXCollections;
import Models.userModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.io.IOException;
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

    @FXML
    public void onRefresh(ActionEvent event) {
        try {
            fillTable();
            new FXFunctions().makeNewINFOalert("Correcto", "Tabla actualizada correctamente").showAndWait();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onNewUser(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/newUserView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Nuevo usuario");
        stage.setResizable(false);
        stage.show();
    }
}
