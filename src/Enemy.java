import javafx.scene.shape.*;

abstract class Enemy {
    public Enemy(int health) {
        this.health = health;
    }
    private Circle display = new Circle(15);
    private int health;

    public Circle getDisplay() {
        return display;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int newHealth) {
        health = newHealth;
    }
}