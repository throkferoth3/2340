import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.scene.shape.Polyline;
import java.util.Timer;
import java.util.TimerTask;


public class StartCombat {

    private Path path = new Path();
    private double x;
    private double y;
    private Button startCombatButton = new Button("start combat");
    private int counter = 1;
    private Polyline pathLine = new Polyline();
    private static boolean inCombat = false;

    public StartCombat() {
        x = path.getDisplay().getX();
        y = path.getDisplay().getY() + 31;
        pathLine.getPoints().addAll(new Double[] {x, y,
            (double) Controller.getScreenWidth() - 195, y});
    }

    public Button getDisplay() {
        return startCombatButton;
    }

    public void startCombat() {
        setInCombat(true);
        makeTimer().scheduleAtFixedRate(spawnEnemies(2, 5, 1, 0), 0, 1000);
        makeTimer().scheduleAtFixedRate(spawnEnemies(2, 5, 1, 1), 2000, 1000);
        makeTimer().scheduleAtFixedRate(spawnEnemies(2, 5, 1, 2), 4000, 1000);
        TimerTask buttonRespawn = new TimerTask() {
            private Enemy enemy;
            @Override
            public void run() {
                Platform.runLater(() -> {
                    setInCombat(false);
                    MainGame.getTopUI().getChildren().add(getDisplay());
                    cancel();
                });
            }
        };
        makeTimer().scheduleAtFixedRate(buttonRespawn, 10000, 1000);
    }

    public Timer makeTimer() {
        return new Timer();
    }

    public TimerTask spawnEnemies(int numberOfEnemies, int speed, int damage, int enemyIndicator) {
        TimerTask enemySpawner = new TimerTask() {
            private Enemy enemy;
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
                        enemy = new PurpleEnemy();

                        break;
                    case 1:
                        enemy = new YellowEnemy();

                        break;
                    case 2:
                        enemy = new OrangeEnemy();

                        break;
                    default:
                        break;
                    }
                    PlayerInfo.getEnemyMap().put(enemy.getId(), enemy);

                    DoubleProperty xValue0 = new SimpleDoubleProperty();
                    xValue0.bind(enemy.getDisplay().translateXProperty());
                    xValue0.addListener(new ChangeListener() {
                        @Override
                        public void changed(ObservableValue arg0, Object arg1, Object arg2) {
                            enemy.setX((double) arg2);
                        }
                    });
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
                        PlayerInfo.getEnemyMap().remove(enemy.getId());
                        //}
                    });
                    counter += 1;
                    transition.play();
                });
            }
        };
        return enemySpawner;
    }
    public static void setInCombat(boolean c) {
        inCombat = c;
    }
    public static boolean getInCombat() {
        return inCombat;
    }
}