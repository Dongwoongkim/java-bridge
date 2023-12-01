package bridge.exception;

public class InvalidBridgeSizeException extends IllegalArgumentException {

    public InvalidBridgeSizeException() {
        super("[ERROR] 다리의 길이에는 빈 값이나 문자를 입력할 수 없습니다.");
    }

    public InvalidBridgeSizeException(Integer minSize, Integer maxSize) {
        super(String.format("[ERROR] 다리의 길이는 최소 %d , 최대 %d 까지 입니다.", minSize, maxSize));
    }
}
