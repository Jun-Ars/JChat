import main.java.entities.Command;
import main.java.entities.Message;
import main.java.features.writeMessage.WriteMessageInputBoundary;
import main.java.features.writeMessage.WriteMessageInteractor;
import main.java.features.writeMessage.WriteMessageResponseModel;
import main.java.interfaceAdapters.WriteMessageController;
import main.java.interfaceAdapters.WriteMessagePresenter;

public class Main {
    public static void main(String[] args) {
        WriteMessagePresenter presenter = new WriteMessagePresenter();
        WriteMessageInputBoundary writeMessageData = new WriteMessageInteractor(null, presenter);
        WriteMessageController controller = new WriteMessageController(writeMessageData);
        Message msg01 = new Message.Builder().setAuthor("Jun").setCommandAndMessage("/dm John test").build();
        System.out.println(msg01);
        Command c = new Command("quit", null);
        Message msg02 = new Message("Jun", c, "test");
        System.out.println(msg02);
        WriteMessageResponseModel success = controller.create("Jimmetheus", "/dm john Hey is everyone getting this?");
    }
}
