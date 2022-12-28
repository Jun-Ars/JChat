package main.java.features.NewUser;

import main.java.entities.CommonUser;
import main.java.entities.CommonUserFactory;

public class NewUserInteractor implements NewUserInputBoundary{
    final NewUserRepositoryInterface userRepository;
    final NewUserOutputBoundary presenter;
    final CommonUserFactory commonUserFactory;

    public NewUserInteractor(NewUserRepositoryInterface userRepository, NewUserOutputBoundary presenter, CommonUserFactory commonUserFactory) {
        this.userRepository = userRepository;
        this.presenter = presenter;
        this.commonUserFactory = commonUserFactory;
    }

    @Override
    public NewUserResponseModel create(NewUserRequestModel requestModel) {
//        if (userRepository.existsByName(requestModel.getUsername())) {
//            return presenter.presentError("Username already taken.");
//        }

        CommonUser userToSave = commonUserFactory.create(requestModel.getUsername());

        CommonUserValidator.validate(userToSave);

        NewUserResponseModel responseModel = new NewUserResponseModel(
                userToSave.getName(),
                userToSave.getDateCreated()
        );

        return presenter.presentSuccess(responseModel);
    }
}

