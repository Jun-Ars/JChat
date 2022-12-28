package main.java.features.saveUser;

public interface SaveUserInputBoundary {
    SaveUserResponseModel create(NewUserRequestModel input);
}
