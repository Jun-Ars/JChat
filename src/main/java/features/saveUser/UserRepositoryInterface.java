package main.java.features.saveUser;

public interface UserRepositoryInterface {
    boolean existsByName(String identifier);
    void save(SaveUserRequestModel requestModel);
}
