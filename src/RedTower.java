import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 * One of the 3 types of towers. This will be further implemented with variation later on.
 */
public class RedTower extends Tower {
    public RedTower(Double X, Double Y) {
        super(X, Y);
        display = new Rectangle(height, width);
        display.setFill(Color.RED);
    }
}