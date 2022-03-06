import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//This is an example and was used for testing placement.
//Delete / rework when adding actual towers.
public class DefaultTower extends Tower {
    public DefaultTower(Double X, Double Y) {
        super(X, Y);
        display = new Rectangle(height, width);
        display.setFill(Color.GREEN);
    }

}