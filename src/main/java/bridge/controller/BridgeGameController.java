package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.vo.BridgeSize;
import bridge.model.vo.Movement;
import bridge.util.InputConverter;
import bridge.util.InputValidator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();

        BridgeSize bridgeSize = initBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> brideInfo = bridgeMaker.makeBridge(bridgeSize.getSize());

        System.out.println(brideInfo.toString());

        BridgeGame bridgeGame = new BridgeGame(brideInfo);

        for (int currentPostion = 0; currentPostion < bridgeSize.getSize(); currentPostion ++) {
            Movement movement = initMovement();
            bridgeGame.move(movement.getMove(), currentPostion);

        }
    }

    private Movement initMovement() {
        while (true) {
            try {
                String moving = inputView.readMoving();
                InputValidator.validateMovement(moving);
                return new Movement(moving);
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    private BridgeSize initBridgeSize() {
        while (true) {
            try {
                String size = inputView.readBridgeSize();
                InputValidator.validateBridgeSize(size);
                return new BridgeSize(InputConverter.convertStringToInteger(size));
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }
}
