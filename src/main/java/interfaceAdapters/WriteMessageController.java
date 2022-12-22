package main.java.interfaceAdapters;

import main.java.features.writeMessage.WriteMessageInputBoundary;
import main.java.features.writeMessage.WriteMessageRequestModel;
import main.java.features.writeMessage.WriteMessageResponseModel;

public class WriteMessageController {
    final WriteMessageInputBoundary writeMessageGateway;

    public WriteMessageController(WriteMessageInputBoundary writeMessageGateway) {
        this.writeMessageGateway = writeMessageGateway;
    }

    public WriteMessageResponseModel create(String author, String msg) {
        WriteMessageRequestModel requestModel = new WriteMessageRequestModel(author, msg);
        return writeMessageGateway.create(requestModel);
    }

}
