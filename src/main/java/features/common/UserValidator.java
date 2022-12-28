package main.java.features.common;

import main.java.entities.User;
import main.java.features.saveUser.SaveUserFailedException;

public class UserValidator {
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

    public static void validate(final User user) {
        validateUsername(user);
    }
}
