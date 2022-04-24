import javafx.scene.shape.*;
abstract class Tower {

    protected static int[] cost;
    protected static int towerIndicator;
    protected Shape display;
    protected int width = 30;
    protected int height = 30;
    protected double posX;
    protected double posY;
    protected boolean isUpgraded = false;
    protected static int upgradeCost = 30;

    public Tower(Double x, Double y) {
        posY = y - height / 2d;
        posX = x - width / 2d;
    }

    public Shape getDisplay() {
        return display;
    }

    public static int getCost() {
        return cost[PlayerInfo.getDifficulty()];
    }

    public static int getTowerIndicator() {
        return towerIndicator;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public double getPosX() {
        return posX;
    }
    public double getPosY() {
        return posY;
    }
    public boolean getUpgraded() {
        return isUpgraded;
    }
    public void setUpgraded(boolean isUpgraded) {
        this.isUpgraded = isUpgraded;
    }

    public void setPosition(double x, double y) {
        posX = x;
        posY = y;
    }
    public void place(double x, double y) {
        ((Rectangle) display).setX(x);
        ((Rectangle) display).setY(y);
    }
    public boolean isWithin(double x, double y) {
        if (x >= posX - width && x <= posX + width && y <= posY + height && y >= posY - height) {
            return true;
        }
        return false;
    }
    public static int getUpgradeCost() {
        return upgradeCost;
    }
    public abstract void upgrade();

    //abstract public boolean inRange(double x, double y);
}