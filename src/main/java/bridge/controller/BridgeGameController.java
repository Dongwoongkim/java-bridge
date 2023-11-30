package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeMaker;
import bridge.model.vo.BridgeSize;
import bridge.util.InputConverter;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        BridgeSize bridgeSize = initBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeMaker.makeBridge(bridgeSize.getSize());
    }

    private BridgeSize initBridgeSize() {
        String size = inputView.readBridgeSize();
        return new BridgeSize(InputConverter.convertStringToInteger(size));
    }
}
