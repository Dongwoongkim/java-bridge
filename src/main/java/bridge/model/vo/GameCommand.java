package bridge.model.vo;

public class GameCommand {

    private static final String EXIT_SIGN = "Q";
    private static final String RESTART_SIGN = "R";
    private final String command;

    public GameCommand(String command) {
        validate(command);
        this.command = command;
    }

    private void validate(String command) {
        if (!command.equals(EXIT_SIGN) && !command.equals(RESTART_SIGN)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isRestart() {
        return command.equals(RESTART_SIGN);
    }
}
