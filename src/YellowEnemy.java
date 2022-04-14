import javafx.scene.paint.Color;

/**
 * One of the 3 types of enemies. This will be further implemented with variation later on.
 */
public class YellowEnemy extends Enemy {
    public YellowEnemy() {
        damage = 1;
        health = 2;
        getCircle().setFill(Color.YELLOW);
        updateHealth();
    }
}
