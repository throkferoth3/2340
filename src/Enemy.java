import javafx.scene.layout.StackPane;
import javafx.scene.shape.*;

import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

import java.util.ArrayList;

abstract class Enemy {
    protected static int idCount = 0;
    private Text text;
    private Circle circle = new Circle(15);
    private StackPane display;
    protected int id;
    protected int health = 1;
    protected int damage;
    protected double x;
    protected double y = Controller.getScreenHeight() / 2d - 100 + 31;

    public Enemy() {
        id = idCount;
        idCount++;
        display = createDisplay();
    }
    /**
     * List of towers that have already attacked this enemy.
     */
    private ArrayList<Tower> attackers = new ArrayList<Tower>();
    public void addAttacker(Tower t) {
        attackers.add(t);
    }
    public ArrayList<Tower> getAttackers() {
        return attackers;
    }
    public double getX() {
        return x;
    }

    public StackPane createDisplay() {
        text = createInitText();
        StackPane display = new StackPane();
        display.getChildren().addAll(circle, text);
        return display;
    }

    public Text createInitText() {
        Text text = new Text("" + getHealth());
        text.setBoundsType(TextBoundsType.VISUAL);
        text.setStyle(
                "-fx-font-family: \"Times New Roman\";"
                        + "-fx-font-style: italic;"
                        + "-fx-font-size: 36px;"
        );
        return text;
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
    public StackPane getDisplay() {
        return display;
    }
    public Circle getCircle() {
        return circle;
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
    public Text getEnemyHealthText() {
        return text;
    }
    public void updateHealth() {
        text.setText("" + getHealth());
    }
}
