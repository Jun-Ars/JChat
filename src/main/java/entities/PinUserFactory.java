package main.java.entities;

public class PinUserFactory{
    public PinUser create(String username, String pin) {
        return new PinUser(username, pin);
    }
}
