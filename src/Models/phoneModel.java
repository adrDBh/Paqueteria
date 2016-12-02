package Models;

import javafx.beans.property.SimpleStringProperty;

public class phoneModel {

    private final SimpleStringProperty id;
    private final SimpleStringProperty phone;
    private final SimpleStringProperty description;

    public phoneModel(String id, String phone, String description) {
        this.id = new SimpleStringProperty(id);
        this.phone = new SimpleStringProperty(phone);
        this.description = new SimpleStringProperty(description);
    }

    public String getId() {
        return id.get();
    }

    public String getPhone() {
        return phone.get();
    }

    public String getDescription() {
        return description.get();
    }


}
