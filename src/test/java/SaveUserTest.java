import main.java.entities.CommonUser;
import main.java.entities.PinUserFactory;
import main.java.entities.User;
import main.java.features.saveUser.SaveUserFailedException;
import main.java.features.saveUser.SaveUserInputBoundary;
import main.java.features.saveUser.SaveUserInteractor;
import main.java.features.saveUser.SaveUserResponseModel;
import main.java.features.writeMessage.WriteMessageFailedException;
import main.java.features.writeMessage.WriteMessageResponseModel;
import main.java.interfaceAdapters.SaveUserController;
import main.java.interfaceAdapters.SaveUserPresenter;
import org.junit.Assert;
import org.junit.Test;

public class SaveUserTest {
    SaveUserPresenter presenter = new SaveUserPresenter();
    PinUserFactory factory = new PinUserFactory();
    SaveUserInputBoundary saveUserData = new SaveUserInteractor(null, presenter, factory);
    SaveUserController controller = new SaveUserController(saveUserData);

    @Test
    public void testPinUserCreation() {
        User commonUser1 = new CommonUser("Jimmetheus");

        // Successful PinUser Creation from CommonUser - 6 Numbers
        try {
            SaveUserResponseModel pinUser = controller.create(commonUser1.getName(),"123456");
            Assert.assertEquals("123456", pinUser.getPin());
            Assert.assertEquals("Jimmetheus", pinUser.getUsername());
        } catch (SaveUserFailedException e) {
            e.printStackTrace();
        }

        // Successful PinUser Creation from CommonUser - 3 Numbers
        try {
            SaveUserResponseModel pinUser = controller.create(commonUser1.getName(),"123");
            Assert.assertEquals("123", pinUser.getPin());
            Assert.assertEquals("Jimmetheus", pinUser.getUsername());
        } catch (SaveUserFailedException e) {
            e.printStackTrace();
        }

        // Successful PinUser Creation from CommonUser - All Zeroes
        try {
            SaveUserResponseModel pinUser = controller.create(commonUser1.getName(),"0000");
            Assert.assertEquals("0000", pinUser.getPin());
            Assert.assertEquals("Jimmetheus", pinUser.getUsername());
        } catch (SaveUserFailedException e) {
            e.printStackTrace();
        }

        // Failed PinUser Creation - Name contains whitespace
        try {
            SaveUserResponseModel pinUser = controller.create(" test person ","12345");
        } catch (SaveUserFailedException e) {
            Assert.assertEquals("Username cannot contain whitespace.", e.getMessage());
        }

        // Failed PinUser Creation - Name too short
        try {
            SaveUserResponseModel pinUser = controller.create("ab","12345");
        } catch (SaveUserFailedException e) {
            Assert.assertEquals("Username must be at least 3 characters long.", e.getMessage());
        }

        // Failed PinUser Creation - Name too long
        try {
            SaveUserResponseModel pinUser = controller.create("abcdefghijklmnop","12345");
        } catch (SaveUserFailedException e) {
            Assert.assertEquals("Username must be at most 12 characters long.", e.getMessage());
        }

        // Failed PinUser Creation - Name contains whitespace
        try {
            SaveUserResponseModel pinUser = controller.create("test person","12345");
        } catch (SaveUserFailedException e) {
            Assert.assertEquals("Username cannot contain whitespace.", e.getMessage());
        }

        // Failed PinUser Creation - Name and pin contains whitespace
        try {
            SaveUserResponseModel pinUser = controller.create("\ntest","123 45");
        } catch (SaveUserFailedException e) {
            Assert.assertEquals("Username cannot contain whitespace.", e.getMessage());
        }

        // Failed PinUser Creation - Empty Pin
        try {
            SaveUserResponseModel pinUser = controller.create(commonUser1.getName(),"");
        } catch (SaveUserFailedException e) {
            Assert.assertEquals("Pin cannot be empty.", e.getMessage());
        }

        // Failed PinUser Creation - Short Pin
        try {
            SaveUserResponseModel pinUser = controller.create(commonUser1.getName(),"12");
        } catch (SaveUserFailedException e) {
            Assert.assertEquals("Pin must be at least 3 characters long.", e.getMessage());
        }

        // Failed PinUser Creation - Long Pin
        try {
            SaveUserResponseModel pinUser = controller.create(commonUser1.getName(),"123456789");
        } catch (SaveUserFailedException e) {
            Assert.assertEquals("Pin must be at most 6 characters long.", e.getMessage());
        }

        // Failed PinUser Creation -  Non-numeric Pin (with spaces)
        try {
            SaveUserResponseModel pinUser = controller.create(commonUser1.getName(),"\n123");
        } catch (SaveUserFailedException e) {
            Assert.assertEquals("Pin must only contain numerical characters.", e.getMessage());
        }

        // Failed PinUser Creation -  Non-numeric Pin (with alphabetical characters)
        try {
            SaveUserResponseModel pinUser = controller.create(commonUser1.getName(),"a123c");
        } catch (SaveUserFailedException e) {
            Assert.assertEquals("Pin must only contain numerical characters.", e.getMessage());
        }

        // Failed PinUser Creation -  Non-numeric Pin (with spaces and alphabetical characters)
        try {
            SaveUserResponseModel pinUser = controller.create(commonUser1.getName(),"\n 123a");
        } catch (SaveUserFailedException e) {
            Assert.assertEquals("Pin must only contain numerical characters.", e.getMessage());
        }

        // Failed PinUser Creation -  Non-numeric Pin (negative number)
        try {
            SaveUserResponseModel pinUser = controller.create(commonUser1.getName(),"-123");
        } catch (SaveUserFailedException e) {
            Assert.assertEquals("Pin must only contain numerical characters.", e.getMessage());
        }

        // Failed PinUser Creation -  All alphabetical characters
        try {
            SaveUserResponseModel pinUser = controller.create(commonUser1.getName(),"12 12");
        } catch (SaveUserFailedException e) {
            Assert.assertEquals("Pin must only contain numerical characters.", e.getMessage());
        }
    }
}
