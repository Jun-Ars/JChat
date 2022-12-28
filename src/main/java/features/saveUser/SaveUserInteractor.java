package main.java.features.saveUser;

import main.java.entities.PinUser;
import main.java.entities.PinUserFactory;

public class SaveUserInteractor implements SaveUserInputBoundary{
    final SaveUserRepositoryInterface userRepository;
    final SaveUserOutputBoundary presenter;
    final PinUserFactory pinUserFactory;

    public SaveUserInteractor(SaveUserRepositoryInterface userRepository, SaveUserOutputBoundary presenter, PinUserFactory pinUserFactory) {
        this.userRepository = userRepository;
        this.presenter = presenter;
        this.pinUserFactory = pinUserFactory;
    }

    @Override
    public SaveUserResponseModel create(NewUserRequestModel requestModel) {
//        if (userRepository.existsByName(requestModel.getUsername())) {
//            return presenter.presentError("Username already taken.");
//        }

        PinUser userToSave = pinUserFactory.create(requestModel.getUsername(), requestModel.getPin());

        PinUserValidator.validate(userToSave);

        SaveUserResponseModel responseModel = new SaveUserResponseModel(
                userToSave.getName(),
                userToSave.getPin(),
                userToSave.getDateCreated()
        );

        return presenter.presentSuccess(responseModel);
    }
}
