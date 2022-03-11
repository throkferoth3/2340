import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 * One of the 3 types of towers. This will be further implemented with variation later on.
 */
public class GreenTower extends Tower {
    public GreenTower(Double x, Double y) {
        super(x, y);
        display = new Rectangle(height, width);
        display.setFill(Color.GREEN);
    }

}