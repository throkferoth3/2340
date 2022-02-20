import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

public class MainGame {
    private static BorderPane mainPane = new BorderPane();
    private static Text healthText;
    private static Text moneyText;
    private static int health;
    private static int money;
    private static HBox playerInfo = new HBox();
    private static Rectangle path;
    private static HBox center = new HBox();
    private static Circle monument;

    Scene scene = new Scene(mainPane, 500, 300);

    public static void initialize() {
        switch (Controller.getDifficulty()) {
            case 0:
                health = 20;
                money = 100;
                break;
            case 1:
                health = 15;
                money = 75;
                break;
            case 2:
                health = 10;
                money = 50;
                break;
        }
        moneyText = new Text("Money: " + money);
        healthText = new Text("Health: " + health);
        playerInfo.getChildren().addAll(moneyText, healthText);
    }

    public MainGame() {
        moneyText = new Text();
        healthText = new Text();
        playerInfo.getChildren().addAll(moneyText, healthText);
        mainPane.setTop(playerInfo);

        path = new Rectangle(400, 50);
        path.setFill(Color.BURLYWOOD);
        monument = new Circle(30);
        center.getChildren().addAll(path, monument);
        mainPane.setCenter(center);
    }

    public Scene getScene() {
        return scene;
    }
}
