import javafx.scene.shape.*;
abstract class Tower {

    protected static int[] cost;
    protected static int towerIndicator;
    protected Shape display;
    protected int width = 30;
    protected int height = 30;
    protected double posX;
    protected double posY;

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

    public void setPosition(double x, double y) {
        posX = x;
        posY = y;
    }
    public boolean isWithin(double x, double y) {
        if (x >= posX - width && x <= posX + width && y <= posY + height && y >= posY - height) {
            return true;
        }
        return false;
    }

    //abstract public boolean inRange(double x, double y);
}