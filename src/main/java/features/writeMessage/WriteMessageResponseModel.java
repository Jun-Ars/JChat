package main.java.features.writeMessage;

import java.util.Date;

public class WriteMessageResponseModel {
    private final String author;
    private final String message;
    private final String command;
    private final String target;
    private final Date dateCreated;

    public WriteMessageResponseModel(String author, String command, String target, String message, Date dateCreated) {
        this.author = author;
        this.command = command;
        this.target = target;
        this.message = message;
        this.dateCreated = dateCreated;
    }

    public String getAuthor() {
        return author;
    }

    public String getCommand() {
        return command;
    }

    public String getTarget() {
        return target;
    }

    public String getMessage() {
        return message;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
}
