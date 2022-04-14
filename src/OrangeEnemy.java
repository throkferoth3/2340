import javafx.scene.paint.Color;

/**
 * One of the 3 types of enemies. This will be further implemented with variation later on.
 */
public class OrangeEnemy extends Enemy {
    public OrangeEnemy() {
        damage = 1;
        health = 3;
        getCircle().setFill(Color.ORANGE);
        updateHealth();
    }
}
