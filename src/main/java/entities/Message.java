package main.java.entities;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Message {
    private String id;
    private final User author;
    private final Command command;
    private final String msg;
    private final Date dateCreated = new Date();


    public Message(User author, Command command, String msg) {
        this.author = author;
        this.command = command;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "author='" + author.getName() + '\'' +
                ", command=" + command.getCommand() +
                ", target=" + command.getTarget() +
                ", msg='" + msg + '\'' +
                ", dateCreated='" + dateCreated +
                '}';
    }

    public User getAuthor() {
        return author;
    }

    public String getCommand() {
        return command.getCommand();
    }

    public String getTarget() {
        return command.getTarget();
    }

    public String getMsg() {
        return msg;
    }

    public Date getDateCreated() {
        return dateCreated;
    }


    public static class Builder {
        private User author;
        private Command command;
        private String msg;

        //TODO: Move placeholder commands so that they're not tied to entity
        static final List<String> TARGETTED_COMMANDS = Arrays.asList("dm", "setname");
        static final List<String> COMMANDS = Arrays.asList("help", "quit", "q");
        public Builder setAuthor(String author) {
            this.author = new CommonUser(author);
            return this;
        }

        public Builder setCommandAndMessage(String commandAndMessage) {
            if (commandAndMessage.startsWith("/")) {
                this.command = new Command();
                separateCommandAndMessage(commandAndMessage);
            }
            else {
                this.command = new Command("broadcast", null);
                this.msg = commandAndMessage;
            }
            return this;
        }

        private void separateCommandAndMessage(String str) {
            String[] CommandMsg = str.split(" ", 2);

            command.setCommand(CommandMsg[0].substring(1));

            if (TARGETTED_COMMANDS.contains(this.command.getCommand())) {
                separateTargetAndMessage(CommandMsg[1]);
            }
        }

        private void separateTargetAndMessage(String str) {
            String[] TargetMsg = str.split(" ", 2);
            this.command.setTarget(TargetMsg[0]);
            if (TargetMsg.length == 2) {
                this.msg = TargetMsg[1];
            }
        }

        public Message build() {
            return new Message(author, command, msg);
        }
    }
}
