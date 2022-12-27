import main.java.entities.Command;
import main.java.entities.Message;
import main.java.features.writeMessage.WriteMessageFailedException;
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


    }
}
