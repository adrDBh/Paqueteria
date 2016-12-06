package Models;

import javafx.beans.property.SimpleStringProperty;

public class serviceModel {
    private final SimpleStringProperty id;
    private final SimpleStringProperty desc;
    private final SimpleStringProperty client;
    private final SimpleStringProperty localization;
    private final SimpleStringProperty employee;
    private final SimpleStringProperty idLocation;

    public serviceModel(String id, String desc, String client, String localization, String employee, String idLocation) {
        this.id = new SimpleStringProperty(id);
        this.desc = new SimpleStringProperty(desc);
        this.client = new SimpleStringProperty(client);
        this.localization = new SimpleStringProperty(localization);
        this.employee = new SimpleStringProperty(employee);
        this.idLocation = new SimpleStringProperty(idLocation);
    }

    public String getId() {
        return id.get();
    }

    public String getDesc() {
        return desc.get();
    }

    public String getClient() {
        return client.get();
    }

    public String getLocalization() {
        return localization.get();
    }

    public String getEmployee() {
        return employee.get();
    }

    public String getidLocation() {
        return idLocation.get();
    }
}
