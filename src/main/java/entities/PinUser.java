package main.java.entities;

public class PinUser implements User{
    private String name;
    private int pin;

    public PinUser(String name, int pin) {
        this.name = name;
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
