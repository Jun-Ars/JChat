package main.java.features.writeMessage;

public interface WriteMessageOutputBoundary {

    WriteMessageResponseModel presentSuccess(WriteMessageResponseModel responseModel);
    WriteMessageResponseModel presentError(String error);
}
