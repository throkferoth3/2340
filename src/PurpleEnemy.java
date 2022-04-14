import javafx.scene.paint.Color;

/**
 * One of the 3 types of enemies. This will be further implemented with variation later on.
 */
public class PurpleEnemy extends Enemy {
    public PurpleEnemy() {
        damage = 15;
        health = 20;
        getDisplay().setFill(Color.PURPLE);
    }
}
