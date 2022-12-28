package main.java.features.NewUser;

import java.util.Date;

public class NewUserResponseModel {
    private final String username;
    private final Date dateCreated;

    public NewUserResponseModel(String username, Date dateCreated) {
        this.username = username;
        this.dateCreated = dateCreated;
    }

    public String getUsername() {
        return username;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
}
