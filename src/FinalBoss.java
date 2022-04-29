import javafx.scene.paint.Color;

public class FinalBoss extends Enemy {
    public FinalBoss() {
        damage = 5;
        health = 5;
        setSize(25);
        getCircle().setFill(Color.GREEN);
        updateHealth();
    }

    private void setSize(int size) {
        getCircle().setRadius(size);
    }
}
