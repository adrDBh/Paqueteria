package Models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class userModel {

    private final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleStringProperty Usuario = new SimpleStringProperty();
    private final SimpleStringProperty Password = new SimpleStringProperty();
    private final SimpleStringProperty CreatedAt = new SimpleStringProperty();
    private final SimpleStringProperty LastLogin = new SimpleStringProperty();

    public int getId() {
        return id.get();
    }

    public String getUsuario() {
        return Usuario.get();
    }

    public String getPassword() {
        return Password.get();
    }

    public String getCreatedAt() {
        return CreatedAt.get();
    }

    public String getLastLogin() {
        return LastLogin.get();
    }
}
