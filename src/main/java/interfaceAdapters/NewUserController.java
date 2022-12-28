package main.java.interfaceAdapters;

import main.java.features.NewUser.NewUserInputBoundary;
import main.java.features.NewUser.NewUserRequestModel;
import main.java.features.NewUser.NewUserResponseModel;

public class NewUserController {
    final NewUserInputBoundary newUserGateway;

    public NewUserController(NewUserInputBoundary newUserGateway) {
        this.newUserGateway = newUserGateway;
    }

    public NewUserResponseModel create(String username) {
        NewUserRequestModel requestModel = new NewUserRequestModel(username);
        return newUserGateway.create(requestModel);
    }
}
