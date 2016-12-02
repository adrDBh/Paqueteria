package Models;

import javafx.beans.property.SimpleStringProperty;

public class clientModel {

    private final SimpleStringProperty id;
    private final SimpleStringProperty Name;
    private final SimpleStringProperty APP;
    private final SimpleStringProperty APM;

    public clientModel(String id, String Name, String APP, String APM) {
        this.id = new SimpleStringProperty(id);
        this.Name = new SimpleStringProperty(Name);
        this.APP = new SimpleStringProperty(APP);
        this.APM = new SimpleStringProperty(APM);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public String getName() {
        return Name.get();
    }

    public SimpleStringProperty nameProperty() {
        return Name;
    }

    public String getAPP() {
        return APP.get();
    }

    public SimpleStringProperty APPProperty() {
        return APP;
    }

    public String getAPM() {
        return APM.get();
    }

    public SimpleStringProperty APMProperty() {
        return APM;
    }
}