package Functions;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.Alert;

public class FXFunctions {


    public void hideCurrentWindow(Event e) {
        ((Node) (e.getSource())).getScene().getWindow().hide();
    }

    public Alert makeNewINFOalert(String title, String content) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setContentText(content);
        return a;
    }

    public Alert makeNewERRORalert(String title, String content) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setContentText(content);
        return a;
    }

    public Alert makeNewalert(String title, String content) {
        Alert a = new Alert(Alert.AlertType.NONE);
        a.setTitle(title);
        a.setContentText(content);
        return a;
    }

    public Alert makeNewConfirmationAlert(String title, String header, String content) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle(title);
        a.setContentText(content);
        a.setHeaderText(header);
        return a;
    }
}
