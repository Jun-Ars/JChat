package main.java.features.NewUser;

public interface NewUserOutputBoundary {
    NewUserResponseModel presentSuccess(NewUserResponseModel responseModel);
    NewUserResponseModel presentError(String error);
}
