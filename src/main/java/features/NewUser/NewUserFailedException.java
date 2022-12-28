package main.java.features.NewUser;

public class NewUserFailedException extends RuntimeException{
    public NewUserFailedException(String error) {
        super(error);
    }
}
