package main.java.features.saveUser;

import main.java.entities.PinUser;
import main.java.entities.User;
import main.java.features.common.UserValidator;

public class PinUserValidator extends UserValidator {
    public static void validatePin(final PinUser user) {
        if (user.getPin() == null || user.getPin().isEmpty()) {
            throw new SaveUserFailedException("Pin cannot be empty.");
        }

        if (user.getPin().length() < 3) {
            throw new SaveUserFailedException("Pin must be at least 3 characters long.");
        }

        if (user.getPin().length() > 6) {
            throw new SaveUserFailedException("Pin must be at most 6 characters long.");
        }

        if (!user.getPin().strip().equals(user.getPin())) {
            throw new SaveUserFailedException("Pin must only contain numerical characters.");
        }

        try {
            int shouldBeInt = Integer.parseInt(user.getPin());
            if (shouldBeInt < 0) {
                throw new SaveUserFailedException("Pin must only contain numerical characters.");
            }
        } catch (NumberFormatException e) {
            throw new SaveUserFailedException("Pin must only contain numerical characters.");
        }
    }

    public static void validate(final PinUser user) {
        validateUsername(user);
        validatePin(user);
    }
}
