package bridge.util;

public class InputConverter {

    private InputConverter() {
    }

    public static Integer convertStringToInteger(String input) {
        return Integer.valueOf(input);
    }
}
