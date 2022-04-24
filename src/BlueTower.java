import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * One of the 3 types of towers. This tower slows enemies by 10 percent.
 */
public class BlueTower extends Tower {
    public BlueTower(Double x, Double y) {
        super(x, y);
        display = new Rectangle(height, width);
        display.setFill(Color.BLUE);
    }
    protected double slowMultiplier = 1.1;
    @Override
    public void upgrade() {
        display.setFill(Color.DARKBLUE);
        slowMultiplier = 1.2;
        isUpgraded = true;
    }
    public double getSlowMultiplier() {
        return slowMultiplier;
    }
}