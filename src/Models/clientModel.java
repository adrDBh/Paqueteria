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

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return Name.get();
    }

    public SimpleStringProperty nameProperty() {
        return Name;
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public String getAPP() {
        return APP.get();
    }

    public SimpleStringProperty APPProperty() {
        return APP;
    }

    public void setAPP(String APP) {
        this.APP.set(APP);
    }

    public String getAPM() {
        return APM.get();
    }

    public SimpleStringProperty APMProperty() {
        return APM;
    }

    public void setAPM(String APM) {
        this.APM.set(APM);
    }

    public String getPhoneNumber() {
        return PhoneNumber.get();
    }

    public SimpleStringProperty phoneNumberProperty() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber.set(phoneNumber);
    }

    public String getPhoneDescription() {
        return PhoneDescription.get();
    }

    public SimpleStringProperty phoneDescriptionProperty() {
        return PhoneDescription;
    }

    public void setPhoneDescription(String phoneDescription) {
        this.PhoneDescription.set(phoneDescription);
    }

    public String getEmailAddress() {
        return EmailAddress.get();
    }

    public SimpleStringProperty emailAddressProperty() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.EmailAddress.set(emailAddress);
    }

    public String getEmailDescription() {
        return EmailDescription.get();
    }

    public SimpleStringProperty emailDescriptionProperty() {
        return EmailDescription;
    }

    public void setEmailDescription(String emailDescription) {
        this.EmailDescription.set(emailDescription);
    }
}
