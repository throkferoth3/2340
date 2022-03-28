import javafx.scene.shape.*;

abstract class Enemy {

    private Circle display = new Circle(Controller.getScreenWidth() - 35);
    private int health;

    public Circle getDisplay() {
        return display;
    }

    public void setHealth(int newHealth) {
        health = newHealth;
    }
}