import main.java.entities.Command;
import main.java.entities.Message;
import main.java.features.writeMessage.WriteMessageFailedException;
import main.java.features.writeMessage.WriteMessageInputBoundary;
import main.java.features.writeMessage.WriteMessageInteractor;
import main.java.features.writeMessage.WriteMessageResponseModel;
import main.java.interfaceAdapters.WriteMessageController;
import main.java.interfaceAdapters.WriteMessagePresenter;
import org.junit.Assert;
import org.junit.Test;

public class WriteMessageTest {
    WriteMessagePresenter presenter = new WriteMessagePresenter();
    WriteMessageInputBoundary writeMessageData = new WriteMessageInteractor(null, presenter);
    WriteMessageController controller = new WriteMessageController(writeMessageData);


    @Test
    public void testMessageCreation(){
        // Failed Message - Empty message
        try {
            WriteMessageResponseModel failure = controller.create("FailPerson",
                    "");
        } catch (WriteMessageFailedException e) {
            Assert.assertEquals("Cannot broadcast an empty Message.", e.getMessage());
        }

        // Successful DM Messages
        try {
            WriteMessageResponseModel successfulMessage1 = controller.create("Jimmetheus",
                    "/dm JohnHa Hey, are you getting this?");
            WriteMessageResponseModel successfulMessage2 = controller.create("JohnHa",
                    "/dm Jimmetheus I got it!");

            Assert.assertEquals("Hey, are you getting this?", successfulMessage1.getMessage());
            Assert.assertEquals("JohnHa", successfulMessage1.getTarget());
            Assert.assertEquals("dm", successfulMessage1.getCommand());
            Assert.assertEquals("Jimmetheus", successfulMessage1.getAuthor());
        } catch (WriteMessageFailedException e) {
            e.printStackTrace();
        }

        // Failed Message - Empty Author
        try {
            WriteMessageResponseModel failure = controller.create("", "blah blah blah");
        } catch (WriteMessageFailedException e) {
            Assert.assertEquals("Author cannot be blank.", e.getMessage());
        }
    }
}
