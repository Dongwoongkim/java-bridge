package bridge.model;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> answer;
    private boolean gameEnd;
    private Integer currentPosition;
    private Integer trialCount;

    public BridgeGame(List<String> answer) {
        this.answer = answer;
        this.gameEnd = false;
        this.currentPosition = 0;
        this.trialCount = 1;
    }

    public void move(String sign) {
        String currentAnswer = answer.get(currentPosition);
        if (currentAnswer.equals(sign)) {
            this.currentPosition++;
            return;
        }
        this.currentPosition++;
        this.gameEnd = true;
    }

    public void retry() {
        this.gameEnd = false;
        this.currentPosition = 0;
        this.trialCount++;
    }

    public void exit() {
        this.gameEnd = true;
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public boolean isSuccess() {
        return currentPosition == answer.size();
    }

    public Integer getTrialCount() {
        return trialCount;
    }

    public String getUpperSide(String sign) {
        String upper = "[";
        String downSide = "[";

        // 이전 스탭
        for (int i = 0; i < currentPosition - 1; i++) {
            if (answer.get(i).equals("U")) {
                upper += " O ";
            }

            if (!answer.get(i).equals("U")) {
                upper += "   ";
            }

            upper += "|";
        }

        for (int i = 0; i < currentPosition - 1; i++) {
            if (answer.get(i).equals("D")) {
                downSide += " O ";
            }

            if (!answer.get(i).equals("D")) {
                downSide += "   ";
            }

            downSide += "|";
        }

        // 현재 스탭 U && 정답 U
        if (answer.get(currentPosition - 1).equals("U") && sign.equals("U")) {
            upper += " O ";
            downSide += "   ";
        }

        // 현재 스탭 D && 정답 D
        if (answer.get(currentPosition - 1).equals("D") && sign.equals("D")) {
            downSide += " O ";
            upper += "   ";
        }

        // 현재 스탭 D && 정답 U
        if (answer.get(currentPosition - 1).equals("U") && sign.equals("D")) {
            System.out.println(3);
            downSide += " X ";
            upper += "   ";
        }

        // 현재 스탭 U && 정답 D
        if (answer.get(currentPosition - 1).equals("D") && sign.equals("U")) {
            System.out.println("4");
            downSide += "   ";
            upper += " X ";
        }

        upper += "]";
        downSide += "]";
        return upper + "\n" + downSide;
    }

}
