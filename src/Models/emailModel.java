package Models;

import javafx.beans.property.SimpleStringProperty;

public class emailModel {
    private final SimpleStringProperty id;
    private final SimpleStringProperty email;
    private final SimpleStringProperty description;

    public emailModel(String id, String phone, String description) {
        this.id = new SimpleStringProperty(id);
        this.email = new SimpleStringProperty(phone);
        this.description = new SimpleStringProperty(description);
    }

    public String getId() {
        return id.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getDescription() {
        return description.get();
    }
}
