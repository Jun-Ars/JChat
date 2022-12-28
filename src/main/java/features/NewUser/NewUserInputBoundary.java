package main.java.features.NewUser;

import main.java.features.saveUser.NewUserRequestModel;

public interface NewUserInputBoundary {
    NewUserResponseModel create(NewUserRequestModel input);
}
