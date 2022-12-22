package main.java.entities;

public class Command {
    private String command;
    private String target;

    public Command(String command, String target) {
        this.command = command;
        this.target = target;
    }

    public Command() {

    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
