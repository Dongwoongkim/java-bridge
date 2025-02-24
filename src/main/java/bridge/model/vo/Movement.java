package bridge.model.vo;

import bridge.exception.InvalidMovementException;

public class Movement {

    private static final String UP = "U";
    private static final String DOWN = "D";

    private final String sign;

    public Movement(String sign) {
        validate(sign);
        this.sign = sign;
    }

    private void validate(String sign) {
        if (!sign.equals(UP) && !sign.equals(DOWN)) {
            throw new InvalidMovementException(UP, DOWN);
        }
    }

    public String getSign() {
        return sign;
    }
}
