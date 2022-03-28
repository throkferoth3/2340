import javafx.scene.paint.Color;

/**
 * One of the 3 types of enemies. This will be further implemented with variation later on.
 */
public class YellowEnemy extends Enemy {
    public YellowEnemy(int health) {
        super(health);
        getDisplay().setFill(Color.YELLOW);
    }
}
