package bridge.model;

import bridge.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int start = 0; start < size; start++) {
            makeEachBridge(bridge);
        }
        
        return bridge;
    }

    private void makeEachBridge(List<String> bridge) {
        if (bridgeNumberGenerator.generate() == 1) {
            bridge.add("U");
            return;
        }
        bridge.add("D");
    }
}
