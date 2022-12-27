package main.java.features.saveUser;

import main.java.entities.PinUser;
import main.java.entities.User;

public class PinUserValidator {
    public static void validateUsername(final User user) {
        if (user.getName() != null && user.getName().matches(".*\\s.*")) {
            throw new SaveUserFailedException("Username cannot contain whitespace.");
        }

        if (user.getName() != null && user.getName().length() < 3) {
            throw new SaveUserFailedException("Username must be at least 3 characters long.");
        }

        if (user.getName() != null && user.getName().length() > 12) {
            throw new SaveUserFailedException("Username must be at most 12 characters long.");
        }

        if (user.getName() == null || user.getName().isEmpty()) {
            throw new SaveUserFailedException("Username cannot be blank.");
        }
    }
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
