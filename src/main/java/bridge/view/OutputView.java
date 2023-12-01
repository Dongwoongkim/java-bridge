package bridge.view;

public class OutputView {

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printMap(String upperSide) {
        System.out.println(upperSide);
    }

    public void printResult(boolean isSuccess, Integer count) {
        System.out.println();
        if (isSuccess) {
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + count);
            return;
        }
        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + count);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
