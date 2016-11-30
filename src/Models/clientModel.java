package Models;

import javafx.beans.property.SimpleStringProperty;

public class clientModel {

    private final SimpleStringProperty id;
    private final SimpleStringProperty Name;
    private final SimpleStringProperty APP;
    private final SimpleStringProperty APM;
    private final SimpleStringProperty PhoneNumber;
    private final SimpleStringProperty PhoneDescription;
    private final SimpleStringProperty EmailAddress;
    private final SimpleStringProperty EmailDescription;

    public clientModel(String id, String Name, String APP, String APM, String PhoneNumber, String PhoneDescription, String EmailAddress, String EmailDescription) {
        this.id = new SimpleStringProperty(id);
        this.Name = new SimpleStringProperty(Name);
        this.APP = new SimpleStringProperty(APP);
        this.APM = new SimpleStringProperty(APM);
        this.PhoneNumber = new SimpleStringProperty(PhoneNumber);
        this.PhoneDescription = new SimpleStringProperty(PhoneDescription);
        this.EmailAddress = new SimpleStringProperty(EmailAddress);
        this.EmailDescription = new SimpleStringProperty(EmailDescription);
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

    public String getPhoneNumber() {
        return PhoneNumber.get();
    }

    public SimpleStringProperty phoneNumberProperty() {
        return PhoneNumber;
    }

    public String getPhoneDescription() {
        return PhoneDescription.get();
    }

    public SimpleStringProperty phoneDescriptionProperty() {
        return PhoneDescription;
    }

    public String getEmailAddress() {
        return EmailAddress.get();
    }

    public SimpleStringProperty emailAddressProperty() {
        return EmailAddress;
    }

    public String getEmailDescription() {
        return EmailDescription.get();
    }

    public SimpleStringProperty emailDescriptionProperty() {
        return EmailDescription;
    }
}
