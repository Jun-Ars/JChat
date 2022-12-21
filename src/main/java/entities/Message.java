package main.java.entities;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Message {
    private final String author;
    private final String[] command = new String[2];
    private String msg;
    private final Date dateCreated = new Date();
    //TODO: Move placeholder commands so that they're not tied to entity
    static final List<String> TARGETTED_COMMANDS = Arrays.asList("dm", "setname");
    static final List<String> COMMANDS = Arrays.asList("help", "quit", "q");

    Message(String author, String str) {
        this.author = author;

        if (str.startsWith("/")) {
            setCommandTargetMsg(str);
        }
        else {
            this.command[0] = "broadcast";
            this.msg = str;
        }
    }

    private void setCommandTargetMsg(String str) {
        String[] CommandMsg = str.split(" ", 2);

        this.command[0] = CommandMsg[0].substring(1);

        if (TARGETTED_COMMANDS.contains(this.command[0])) {
            setTargetMessage(CommandMsg[1]);
        }
    }

    private void setTargetMessage(String str) {
        String[] TargetMsg = str.split(" ", 2);
        this.command[1] = TargetMsg[0];
        if (TargetMsg.length == 2) {
            this.msg = TargetMsg[1];
        }
    }

    @Override
    public String toString() {
        return "Message{" +
                "author='" + author + '\'' +
                ", command=" + Arrays.toString(command) +
                ", msg='" + msg + '\'' +
                ", dateCreated='" + dateCreated +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public String[] getCommand() {
        return command;
    }

    public String getMsg() {
        return msg;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public static void main(String[] args) {
        Message m1 = new Message("Dr.Seuss", "Hello everyone!");
        Message m2 = new Message("Dr.Seuss", "/help");
        Message m3 = new Message("Dr.Seuss", "/dm GeorgeOrwell Hello everyone!");
        Message m4 = new Message("Dr.Seuss", "/setname GeorgeOrwell");
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
        System.out.println(m4);
        System.out.println(m2.getMsg());
    }
}
