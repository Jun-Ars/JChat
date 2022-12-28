package main.java.interfaceAdapters;

import main.java.features.NewUser.NewUserFailedException;
import main.java.features.NewUser.NewUserOutputBoundary;
import main.java.features.NewUser.NewUserResponseModel;

public class NewUserPresenter implements NewUserOutputBoundary {

    @Override
    public NewUserResponseModel presentSuccess(NewUserResponseModel responseModel) {
        return responseModel;
    }

    @Override
    public NewUserResponseModel presentError(String error) {
        throw new NewUserFailedException(error);
    }
}
