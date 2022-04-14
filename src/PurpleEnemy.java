import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * One of the 3 types of enemies. This will be further implemented with variation later on.
 */
public class PurpleEnemy extends Enemy {
    public PurpleEnemy() {
        damage = 1;
        health = 1;
        getCircle().setFill(Color.PURPLE);
        updateHealth();
    }
}
