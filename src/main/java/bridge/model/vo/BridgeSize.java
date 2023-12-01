package bridge.model.vo;

import bridge.exception.InvalidBridgeSizeException;

public class BridgeSize {

    private static final Integer MIN_SIZE = 3;
    private static final Integer MAX_SIZE = 20;

    private final Integer size;

    public BridgeSize(Integer size) {
        validate(size);
        this.size = size;
    }

    private void validate(Integer size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new InvalidBridgeSizeException(MIN_SIZE, MAX_SIZE);
        }
    }

    public Integer getSize() {
        return size;
    }
}
