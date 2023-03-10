package main.java.interfaceAdapters;

import main.java.features.saveUser.SaveUserInputBoundary;
import main.java.features.saveUser.SaveUserResponseModel;
import main.java.features.saveUser.SaveUserRequestModel;

public class SaveUserController{
    final SaveUserInputBoundary saveUserGateway;

    public SaveUserController(SaveUserInputBoundary saveUserGateway) {
        this.saveUserGateway = saveUserGateway;
    }

    public SaveUserResponseModel create(String username, String pin) {
        SaveUserRequestModel requestModel = new SaveUserRequestModel(username, pin);
        return saveUserGateway.create(requestModel);
    }
}
