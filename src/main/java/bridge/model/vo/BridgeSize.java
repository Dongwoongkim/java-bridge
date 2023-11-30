package bridge.model.vo;

public class BridgeSize {

    private final Integer size;

    public BridgeSize(Integer size) {
        validate(size);
        this.size = size;
    }

    private void validate(Integer size) {
        if (size <= 2 || size >= 21) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getSize() {
        return size;
    }
}
