package bridge.exception;

public class InvalidCommandException extends IllegalArgumentException {
    public InvalidCommandException(String exitSign, String restartSign) {
        super(String.format("재시작/종료 명령어는 %s or %s 만 입력 가능합니다.", exitSign, restartSign));
    }
}
