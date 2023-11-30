package bridge.util;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateLength(String length) {
        if (length.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (!isNumeric(length)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateMovement(String movement) {
        if (movement.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNumeric(String length) {
        try {
            Integer.valueOf(length);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
