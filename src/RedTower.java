import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 * One of the 3 types of towers. This tower shoots at enemies within its range.
 */
public class RedTower extends Tower {
    protected double range = 50;
    public RedTower(Double x, Double y) {
        super(x, y);
        display = new Rectangle(height, width);
        display.setFill(Color.RED);
    }

    public boolean inRange(double targetX, double targetY) {
        return Math.pow(posX - targetX, 2) + Math.pow(posY - targetY, 2) <= range;
    }
}