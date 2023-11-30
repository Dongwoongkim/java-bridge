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

    public Integer getCurrentPosition() {
        return currentPosition;
    }

    public List<String> getAnswer() {
        return answer;
    }
}
