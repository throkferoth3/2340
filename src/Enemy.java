import javafx.scene.shape.*;

abstract class Enemy {
    protected static int idCount = 0;
    public Enemy() {
        id = idCount;
        idCount++;
    }
    private Circle display = new Circle(15);
    protected int id;
    protected int health;
    protected int damage;
    protected double x;
    protected double y = Controller.getScreenHeight() / 2d - 100 + 31;

    public double getX() {
        return x;
    }

    public void setX(double h) {
        x = h;
    }
    public double getY() {
        return y;
    }
    public int getId() {
        return id;
    }
    public Circle getDisplay() {
        return display;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int newHealth) {
        health = newHealth;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int newDamage) {
        damage = newDamage;
    }
}
