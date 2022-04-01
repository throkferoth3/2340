import javafx.scene.shape.*;

abstract class Enemy {
    public Enemy() {
    }
    private Circle display = new Circle(15);
    protected int health;
    protected int damage;

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
