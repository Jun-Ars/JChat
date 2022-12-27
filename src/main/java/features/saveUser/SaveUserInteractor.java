package main.java.features.saveUser;

import main.java.entities.PinUser;
import main.java.entities.PinUserFactory;

public class SaveUserInteractor implements SaveUserInputBoundary{
    final UserRepositoryInterface userRepository;
    final SaveUserOutputBoundary presenter;
    final PinUserFactory pinUserFactory;

    public SaveUserInteractor(UserRepositoryInterface userRepository, SaveUserOutputBoundary presenter, PinUserFactory pinUserFactory) {
        this.userRepository = userRepository;
        this.presenter = presenter;
        this.pinUserFactory = pinUserFactory;
    }

    @Override
    public SaveUserResponseModel create(SaveUserRequestModel requestModel) {
//        if (userRepository.existsByName(requestModel.getUsername())) {
//            return presenter.presentError("Username already taken.");
//        }

        PinUser userToSave = pinUserFactory.create(requestModel.getUsername(), requestModel.getPin());

        PinUserValidator.ValidatePinUser(userToSave);

        SaveUserResponseModel responseModel = new SaveUserResponseModel(
                userToSave.getName(),
                userToSave.getPin(),
                userToSave.getDateCreated()
        );

        return presenter.presentSuccess(responseModel);
    }
}
