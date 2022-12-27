package main.java.interfaceAdapters;

import main.java.features.saveUser.SaveUserFailedException;
import main.java.features.saveUser.SaveUserOutputBoundary;
import main.java.features.saveUser.SaveUserResponseModel;

public class SaveUserPresenter implements SaveUserOutputBoundary {

    @Override
    public SaveUserResponseModel presentSuccess(SaveUserResponseModel responseModel) {
        return responseModel;
    }

    @Override
    public SaveUserResponseModel presentError(String error) {
        throw new SaveUserFailedException(error);
    }
}
