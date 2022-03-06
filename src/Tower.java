import javafx.scene.shape.*;
abstract class Tower {

    protected static int[] cost;
    protected static int towerIndicator;
    protected Shape display;
    protected int width = 30;
    protected int height = 30;
    protected double posX;
    protected double posY;

    public Tower(Double X, Double Y) {
        posY = Y - height / 2d;
        posX = X - width / 2d;
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

    public void setPosition(double X, double Y) {
        posX = X;
        posY = Y;
    }
    public boolean isWithin(double X, double Y) {

        if (X >= posX - width && X <= posX + width && Y <= posY + height && Y >= posY - height) {
            return true;
        }
        return false;
    }
}