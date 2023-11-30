package bridge.model.vo;

public class Movement {

    private static final String UP = "U";
    private static final String DOWN = "D";

    private final String move;

    public Movement(String move) {
        validate(move);
        this.move = move;
    }

    private void validate(String move) {
        if (!move.equals(UP) && !move.equals(DOWN)) {
            throw new IllegalArgumentException();
        }
    }

    public String getMove() {
        return move;
    }
}
