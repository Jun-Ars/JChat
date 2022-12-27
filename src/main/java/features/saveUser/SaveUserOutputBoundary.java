package main.java.features.saveUser;

public interface SaveUserOutputBoundary {

    SaveUserResponseModel presentSuccess(SaveUserResponseModel responseModel);
    SaveUserResponseModel presentError(String error);
}
