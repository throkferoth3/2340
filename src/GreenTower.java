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
    
    public void addHealth() {
        PlayerInfo.setHealth(PlayerInfo.getHealth() + 1);
    }
}
