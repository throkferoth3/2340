import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class Path {
    private int width = 500;
    private int height = 50;
    private Rectangle display;
    public Path() {
        display = new Rectangle(-100, Controller.getScreenHeight() / 2 - 100, width, height);
        display.setFill(Color.BURLYWOOD);
    }
    public Rectangle getDisplay() {
        return display;
    }
    public boolean isWithin(int x, int y) {
        if (y >= Controller.getScreenHeight() / 2 - 100 || y <= Controller.getScreenHeight() / 2 - 100 + height ||
                x >= -100 || x <= -100 + width) {
            return true;
        }
        return false;
    }
}
