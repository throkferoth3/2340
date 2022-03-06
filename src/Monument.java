import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class Monument {
    private Circle display;
    public Monument() {
        display = new Circle(Controller.getScreenWidth() - 150, Controller.getScreenHeight() / 2 - 70, Controller.getScreenHeight() / 20);
        display.setFill(Color.BLACK);
    }
    public Circle getDisplay() {
        return display;
    }
}
