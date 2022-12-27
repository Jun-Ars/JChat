package main.java.features.writeMessage;

import main.java.entities.Message;

public class WriteMessageInteractor implements WriteMessageInputBoundary {
    final MessageRepositoryInterface messageRepository;
    final WriteMessageOutputBoundary presenter;

    public WriteMessageInteractor(MessageRepositoryInterface messageRepository, WriteMessageOutputBoundary presenter) {
        this.messageRepository = messageRepository;
        this.presenter = presenter;
    }

    @Override
    public WriteMessageResponseModel create(WriteMessageRequestModel requestModel) {

        Message messageToWrite = new Message.Builder()
                .setAuthor(requestModel.getAuthor())
                .setCommandAndMessage(requestModel.getMessage())
                .build();

        MessageValidator.ValidateWriteMessage(messageToWrite);

        System.out.println(messageToWrite);

        WriteMessageResponseModel responseModel = new WriteMessageResponseModel(
                messageToWrite.getAuthor(),
                messageToWrite.getCommand(),
                messageToWrite.getTarget(),
                messageToWrite.getMsg(),
                messageToWrite.getDateCreated()
        );

        return presenter.presentSuccess(responseModel);
    }
}
