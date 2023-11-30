package bridge.model;

import bridge.model.vo.Movement;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridgeInfo;

    public BridgeGame(List<String> bridgeInfo) {
        this.bridgeInfo = bridgeInfo;
    }

    public void move(String movement, Integer currentPosition) {
        if (!bridgeInfo.get(currentPosition).equals(movement)) {
        }
    }

    public void retry() {
    }
}
