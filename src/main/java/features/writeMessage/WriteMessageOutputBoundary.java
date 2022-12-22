package main.java.features.writeMessage;

public interface WriteMessageOutputBoundary {

    WriteMessageResponseModel presentSuccess(WriteMessageResponseModel responseModel);
    WriteMessageFailedException presentError(String error);
}
