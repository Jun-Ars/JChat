package main.java.features.writeMessage;

import main.java.entities.Message;

public class MessageValidator {
    public static void ValidateWriteMessage(final Message message) {
        if ((message.getCommand() == null || message.getCommand().isEmpty()) &&
                (message.getMsg() == null || message.getMsg().isEmpty())) {
            throw new WriteMessageFailedException("Command and Message both empty.");
        }

        if ((message.getCommand() != null && message.getCommand().equals("broadcast")) &&
                (message.getMsg() == null || message.getMsg().isEmpty())) {
            throw new WriteMessageFailedException("Cannot broadcast an empty Message.");
        }

        if ((message.getAuthor() == null || message.getAuthor().getName().isEmpty())) {
            throw new WriteMessageFailedException("Author cannot be blank.");
        }

        if (message.getCommand().equals("dm") && (message.getTarget() == null || message.getTarget().isEmpty())) {
            throw new WriteMessageFailedException("DM Target cannot be empty.");
        }
    }
}
