package main.java.features.writeMessage;

public class WriteMessageRequestModel {
    private final String author;
    private final String message;

    public WriteMessageRequestModel(String author, String message) {
        this.author = author;
        this.message = message;
    }

    String getAuthor() {
        return author;
    }

    String getMessage() {
        return message;
    }
}
