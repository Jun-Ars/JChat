package main.java.entities;

import java.util.Date;

public class CommonUser implements User{
    private String name;
    private final Date dateCreated = new Date();

    public CommonUser(String name) {
        this.name = name;
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
