package main.java.entities;

public class CommonUserFactory {
    public CommonUser create(String username) {
        return new CommonUser(username);
    }
}
