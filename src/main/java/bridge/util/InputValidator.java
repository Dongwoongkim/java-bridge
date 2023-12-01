package bridge.util;

import bridge.exception.InvalidBridgeSizeException;
import bridge.exception.InvalidMovementException;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateBridgeSize(String size) {
        if (size.isEmpty()) {
            throw new InvalidBridgeSizeException();
        }
        if (!isNumeric(size)) {
            throw new InvalidBridgeSizeException();
        }
    }

    public static void validateMovement(String movement) {
        if (movement.isEmpty()) {
            throw new InvalidMovementException();
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
