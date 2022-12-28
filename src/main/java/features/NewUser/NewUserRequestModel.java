package main.java.features.NewUser;

public class NewUserRequestModel {
    private final String username;

    public NewUserRequestModel(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
