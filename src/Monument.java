import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class Monument {
    private Circle display;
    public Monument() {
        display = new Circle(370, Controller.getScreenHeight() / 2 - 75, 30);
        display.setFill(Color.BLACK);
    }
    public Circle getDisplay() {
        return display;
    }
}
