package main.java.entities;

import java.util.Date;

public class PinUser implements User{
    private String name;
    private String pin;
    private final Date dateCreated = new Date();

    public PinUser(String name, String pin) {
        this.name = name;
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
