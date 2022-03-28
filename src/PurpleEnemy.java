import javafx.scene.paint.Color;

/**
 * One of the 3 types of enemies. This will be further implemented with variation later on.
 */
public class PurpleEnemy extends Enemy {
    public PurpleEnemy(int health) {
        super(health);
        getDisplay().setFill(Color.PURPLE);
    }
}
