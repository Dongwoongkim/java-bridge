package bridge.model;

public class BridgeGameMap {

    private String upSide;
    private String downSide;

    public BridgeGameMap(String upSide, String downSide) {
        this.upSide = upSide;
        this.downSide = downSide;
    }

    public String getUpSide() {
        return upSide;
    }

    public String getDownSide() {
        return downSide;
    }
}
