package Models;

import javafx.beans.property.SimpleStringProperty;


public class userModel {

    private final SimpleStringProperty id;
    private final SimpleStringProperty username;
    private final SimpleStringProperty password;
    private final SimpleStringProperty ca;
    private final SimpleStringProperty ll;

    public userModel(String id, String username, String password, String created_at, String last_login) {
        this.id = new SimpleStringProperty(id);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.ca = new SimpleStringProperty(created_at);
        this.ll = new SimpleStringProperty(last_login);
    }

    public String getId() {
        return id.get();
    }

    public String getUsername() {
        return username.get();
    }

    public String getPassword() {
        return password.get();
    }

    public String getCa() {
        return ca.get();
    }

    public String getLl() {
        return ll.get();
    }
}

