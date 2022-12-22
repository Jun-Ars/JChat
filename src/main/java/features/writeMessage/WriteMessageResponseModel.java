package main.java.features.writeMessage;

import java.util.Date;

public class WriteMessageResponseModel {
    private final String author;
    private final String message;
    private final Date dateCreated;

    public WriteMessageResponseModel(String author, String message, Date dateCreated) {
        this.author = author;
        this.message = message;
        this.dateCreated = dateCreated;
    }

    String getAuthor() {
        return author;
    }

    String getMessage() {
        return message;
    }

    Date getDateCreated() {
        return dateCreated;
    }
}
