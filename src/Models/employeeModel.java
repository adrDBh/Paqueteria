package Models;

import javafx.beans.property.SimpleStringProperty;

public class employeeModel {
    private final SimpleStringProperty id;
    private final SimpleStringProperty Name;
    private final SimpleStringProperty APP;
    private final SimpleStringProperty APM;
    private final SimpleStringProperty Turn;

    public employeeModel(String id, String Name, String APP, String APM, String Turn) {
        this.id = new SimpleStringProperty(id);
        this.Name = new SimpleStringProperty(Name);
        this.APP = new SimpleStringProperty(APP);
        this.APM = new SimpleStringProperty(APM);
        this.Turn = new SimpleStringProperty(Turn);
    }

    public String getId() {
        return id.get();
    }

    public String getName() {
        return Name.get();
    }

    public String getAPP() {
        return APP.get();
    }

    public String getAPM() {
        return APM.get();
    }

    public String getTurn() {
        return Turn.get();
    }
}
