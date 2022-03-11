import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class Path {
    private int width = Controller.getScreenWidth() - 25;
    private int height = Controller.getScreenHeight() / 10;
    private Rectangle display;
    private int buffer = 15;
    public Path() {
        display = new Rectangle(-100, Controller.getScreenHeight() / 2d - 100, width, height);
        display.setFill(Color.BURLYWOOD);
    }
    public Rectangle getDisplay() {
        return display;
    }
    public boolean isWithin(double x, double y) {
        if ((y >= Controller.getScreenHeight() / 2d - 100 - buffer
                && y <= Controller.getScreenHeight() / 2d - 100 + height + buffer)
                && (x >= -100 - buffer && x <= -100 + width + buffer)) {
            return true;
        }
        return false;
    }
}
