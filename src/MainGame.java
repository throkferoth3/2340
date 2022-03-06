import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;

public class MainGame {
    private static BorderPane mainPane = new BorderPane();
    private static Text healthText;
    private static Text moneyText;
    private static Text insufficientMoneyText;
    private static HBox playerInfoDisplay = new HBox();
    private static HBox towerSubMenu = new HBox();
    private static Path path;
    private static Monument monument;
    private static Group center = new Group();
    private static Button defaultTowerButton = new Button("default tower");
    private static DefaultTower defaultTower;
    private static VBox towerButton1Vbox = new VBox();
    private static GridPane rightPane = new GridPane();

    private Scene scene = new Scene(mainPane, Controller.getScreenWidth(), Controller.getScreenHeight());

    public static void initialize() {
        defaultTower = new DefaultTower(PlayerInfo.getDifficulty());
        switch (PlayerInfo.getDifficulty()) {
        case 0:
            PlayerInfo.setHealth(20);
            PlayerInfo.setMoney(100);
            break;
        case 1:
            PlayerInfo.setHealth(15);
            PlayerInfo.setMoney(75);
            break;
        case 2:
            PlayerInfo.setHealth(10);
            PlayerInfo.setMoney(50);
            break;
        default:
            break;
        }
        moneyText = new Text("Money: " + PlayerInfo.getMoney());
        healthText = new Text("Health: " + PlayerInfo.getHealth());
        playerInfoDisplay.getChildren().addAll(moneyText, healthText);
    }

    public MainGame() {
        moneyText = new Text();
        healthText = new Text();
        playerInfoDisplay.getChildren().addAll(moneyText, healthText);
        mainPane.setTop(playerInfoDisplay);

        path = new Path();
        monument = new Monument();
        center.getChildren().addAll(path.getDisplay(), monument.getDisplay());
        mainPane.setCenter(center);

        insufficientMoneyText = new Text("");
        towerButton1Vbox.getChildren().addAll(insufficientMoneyText, defaultTowerButton);
        rightPane.getChildren().addAll(towerButton1Vbox);
        mainPane.setRight(rightPane);
        rightPane.setAlignment(Pos.CENTER_LEFT);
        rightPane.setPadding(new Insets(75));
        defaultTowerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (defaultTower.buyTower()) {
                    moneyText.setText("Money: " + PlayerInfo.getMoney());
                } else {
                    insufficientMoneyText.setText("insufficient funds");
                }
            }
        });
    }

    public Scene getScene() {
        return scene;
    }
}
