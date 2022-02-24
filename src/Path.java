import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class Path {
    private Rectangle display = new Rectangle(400, 50);
    public Path() {
        display = new Rectangle(400, 50);
        display.setFill(Color.BURLYWOOD);
    }
    public Rectangle getDisplay() {
        return display;
    }
}
