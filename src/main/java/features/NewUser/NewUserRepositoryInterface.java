package main.java.features.NewUser;

public interface NewUserRepositoryInterface {
    boolean pinUserAlreadyExists(String identifier);
    void save(NewUserRequestModel requestModel);
}
