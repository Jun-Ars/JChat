package main.java.features.writeMessage;

public interface WriteMessageInputBoundary {
    WriteMessageResponseModel create(WriteMessageRequestModel input);
}
