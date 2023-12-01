package bridge.exception;

public class InvalidMovementException extends IllegalArgumentException {

    public InvalidMovementException() {
        super("[ERROR] 이동 명령어에는 빈 값이 들어올 수 없습니다.");
    }

    public InvalidMovementException(String up, String down) {
        super(String.format("[ERROR] 이동 명령어는 %s or %s 만 입력 가능합니다.", up, down));
    }
}
