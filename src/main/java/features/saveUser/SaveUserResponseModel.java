package main.java.features.saveUser;

import java.util.Date;

public class SaveUserResponseModel {
    private final String username;
    private final String pin;
    private final Date dateCreated;

    public SaveUserResponseModel(String username, String pin, Date dateCreated) {
        this.username = username;
        this.pin = pin;
        this.dateCreated = dateCreated;
    }

    public String getUsername() {
        return username;
    }

    public String getPin() {
        return pin;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
}
