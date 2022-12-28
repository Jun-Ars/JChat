package main.java.features.saveUser;

public class NewUserRequestModel {
    private final String username;
    private final String pin;

    public NewUserRequestModel(String username, String pin) {
        this.username = username;
        this.pin = pin;
    }

    public String getUsername() {
        return username;
    }

    public String getPin() {
        return pin;
    }
}
