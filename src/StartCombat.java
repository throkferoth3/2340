import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.scene.shape.Polyline;
import java.util.Timer;
import java.util.TimerTask;


public class StartCombat {

    Path path = new Path();
    double X;
    double Y;
    private Button startCombatButton = new Button("start combat");
    private int counter = 0;
    private Polyline pathLine = new Polyline();
    private static boolean inCombat = false;

    public StartCombat() {
        X = path.getDisplay().getX();
        Y = path.getDisplay().getY() + 31;
        pathLine.getPoints().addAll(new Double[] {
                X, Y,
                (double) Controller.getScreenWidth() - 195, Y
        });
    }

    public Button getDisplay() {
        return startCombatButton;
    }

    public void startCombat() {
        inCombat = true;
        makeTimer().scheduleAtFixedRate(spawnEnemies(5, 5, 1), 0, 1000);
    }

    public Timer makeTimer() {
        return new Timer();
    }

    public TimerTask spawnEnemies(int numberOfEnemies, int speed, int damage) {
        TimerTask enemySpawner = new TimerTask() {
            int enemyIndicator = 0;
            Enemy enemy = new PurpleEnemy(15);
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (counter == numberOfEnemies) {
                        inCombat = false;
                        counter = 0;
                        cancel();
                    }
                    switch (enemyIndicator) {
                        case 0:
                            enemy = new PurpleEnemy(15);
                            enemyIndicator++;
                            break;
                        case 1:
                            enemy = new YellowEnemy(15);
                            enemyIndicator++;
                            break;
                        case 2:
                            enemy = new OrangeEnemy(15);
                            enemyIndicator = 0;
                            break;
                    }
                    Circle enemyDisplay = enemy.getDisplay();
                    MainGame.getCenter().getChildren().add(enemyDisplay);
                    PathTransition transition = new PathTransition();
                    transition.setNode(enemyDisplay); // set to enemy later
                    transition.setDuration(Duration.seconds(speed));
                    transition.setPath(pathLine);
                    transition.setCycleCount(1);
                    transition.setInterpolator(Interpolator.LINEAR);
                    transition.setOnFinished(actionEvent -> {
                        // if (enemy.getHealth() != 0) { // for when enemies can die
                        MainGame.getCenter().getChildren().remove(enemyDisplay);
                        PlayerInfo.takeDamage(damage);
                        MainGame.updateHealthText();
                        //}
                    });
                    counter += 1;
                    transition.play();
                });
            }
        };
        return enemySpawner;
    }

    public static boolean getInCombat() {
        return inCombat;
    }
}