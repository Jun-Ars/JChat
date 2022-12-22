package main.java.interfaceAdapters;

import main.java.features.writeMessage.WriteMessageFailedException;
import main.java.features.writeMessage.WriteMessageOutputBoundary;
import main.java.features.writeMessage.WriteMessageResponseModel;

public class WriteMessagePresenter implements WriteMessageOutputBoundary {
    @Override
    public WriteMessageResponseModel presentSuccess(WriteMessageResponseModel responseModel) {
        return responseModel;
    }

    @Override
    public WriteMessageFailedException presentError(String error) {
        throw new WriteMessageFailedException(error);
    }
}
