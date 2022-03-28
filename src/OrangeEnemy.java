import javafx.scene.paint.Color;

/**
 * One of the 3 types of enemies. This will be further implemented with variation later on.
 */
public class OrangeEnemy extends Enemy {
    public OrangeEnemy(int health) {
        super(health);
        getDisplay().setFill(Color.ORANGE);
    }
}
