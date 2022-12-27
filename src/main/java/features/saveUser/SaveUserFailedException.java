package main.java.features.saveUser;

public class SaveUserFailedException extends RuntimeException{
    public SaveUserFailedException(String error) {
        super(error);
    }
}
