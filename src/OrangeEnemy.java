import javafx.scene.paint.Color;

/**
 * One of the 3 types of enemies. This will be further implemented with variation later on.
 */
public class OrangeEnemy extends Enemy {
    public OrangeEnemy() {
        d = 10;
        health = 15;
        getDisplay().setFill(Color.ORANGE);
    }
}
