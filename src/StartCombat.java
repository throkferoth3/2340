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
    private Timer enemySpawnTimer = new Timer();
    private int counter = 0;
    private Polyline pathLine = new Polyline();
    private static boolean inCombat = false;

    private TimerTask enemySpawner = new TimerTask() {
        @Override
        public void run() {
            Platform.runLater(() -> {
                if (counter == 5) { // number of enemies
                    inCombat = false;
                    cancel();
                }
                Circle circle = new Circle(15); // temp enemy
                circle.setFill(Color.RED);
                MainGame.getCenter().getChildren().add(circle);
                PathTransition transition = new PathTransition();
                transition.setNode(circle); // set to enemy later
                transition.setDuration(Duration.seconds(5)); // can be changed to change enemy speed
                transition.setPath(pathLine);
                transition.setCycleCount(1);
                transition.setOnFinished(actionEvent -> {
                   // if (enemy.getHealth() != 0) { // for when enemies can die
                        MainGame.getCenter().getChildren().remove(circle);
                        PlayerInfo.setHealth(PlayerInfo.getHealth() - 1); // can be changed later
                        MainGame.updateHealthText();
                    //}
                });
                counter += 1;
                transition.play();
            });
        }
    };

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
        enemySpawnTimer.scheduleAtFixedRate(enemySpawner, 0, 1000);
    }

    public static boolean getInCombat() {
        return inCombat;
    }
}