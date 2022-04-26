import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * One of the 3 types of towers.
 * This tower heals the player's monument by 1 at the end of each round.
 */
public class GreenTower extends Tower {
    public GreenTower(Double x, Double y) {
        super(x, y);
        display = new Rectangle(height, width);
        display.setFill(Color.GREEN);
    }
    protected int healthIncrement = 1;
    public void addHealth() {
        PlayerInfo.setHealth(PlayerInfo.getHealth() + healthIncrement);
    }
    public void upgrade() {
        display.setFill(Color.DARKGREEN);
        healthIncrement = 2;
        isUpgraded = true;
        PlayerInfo.incrementUpgradesPurchased();
    }
    public int getHealthIncrement() {
        return healthIncrement;
    }
}
