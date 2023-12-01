package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.vo.BridgeSize;
import bridge.model.vo.GameCommand;
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
        List<String> answer = bridgeMaker.makeBridge(bridgeSize.getSize());
        
        startGame(new BridgeGame(answer));
    }

    private void startGame(BridgeGame bridgeGame) {
        while (!bridgeGame.isGameEnd()) {
            Movement movement = initMovement();
            String sign = movement.getSign();
            bridgeGame.move(sign);

            outputView.printMap(bridgeGame.drawMap(sign));

            checkGameEnd(bridgeGame);
            checkGameSuccess(bridgeGame, sign);
        }
    }

    private void checkGameSuccess(BridgeGame bridgeGame, String sign) {
        if (bridgeGame.isSuccess()) {
            outputView.printResult(bridgeGame.isSuccess(), bridgeGame.getTrialCount(), bridgeGame.drawMap(sign));
            bridgeGame.exit();
        }
    }

    private void checkGameEnd(BridgeGame bridgeGame) {
        if (bridgeGame.isGameEnd()) {
            GameCommand gameCommand = initGameCommand();
            checkRestart(bridgeGame, gameCommand);
        }
    }

    private void checkRestart(BridgeGame bridgeGame, GameCommand gameCommand) {
        if (gameCommand.isRestart()) {
            bridgeGame.retry();
        }
    }

    private GameCommand initGameCommand() {
        while (true) {
            try {
                String command = inputView.readGameCommand();
                GameCommand gameCommand = new GameCommand(command);
                return gameCommand;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
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
