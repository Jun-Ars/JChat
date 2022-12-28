package main.java.features.saveUser;

public interface SaveUserRepositoryInterface {
    boolean pinUserAlreadyExists(String identifier);
    void save(NewUserRequestModel requestModel);
}
