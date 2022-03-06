import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class MainGame {
    private static BorderPane mainPane = new BorderPane();
    private static Text healthText;
    private static Text moneyText;
    private static Text insufficientMoneyText;
    private static HBox topUI = new HBox(20);
    private static HBox playerInfoDisplay = new HBox();
    private static HBox shopDisplay = new HBox();
    private static AnchorPane center = new AnchorPane();

    private static Path path;
    private static Monument monument;

    private ShopEntry exampleTowerShop = new ShopEntry(new int[] {15, 20, 25}, 0, "EXAMPLE");

    private static Boolean placementActive = false;
    private int currentTowerIndicator;

    private Scene scene = new Scene(mainPane, Controller.getScreenWidth(), Controller.getScreenHeight());

    public static void initialize() {
        PlayerInfo.initHealthAndMoney();
        moneyText = new Text("Money: " + PlayerInfo.getMoney() + " ");
        healthText = new Text("Health: " + PlayerInfo.getHealth());
        playerInfoDisplay.getChildren().addAll(moneyText, healthText);
    }

    public MainGame() {
        moneyText = new Text();
        healthText = new Text();
        playerInfoDisplay.getChildren().addAll(moneyText, healthText);
        topUI.getChildren().addAll(playerInfoDisplay);

        mainPane.setTop(topUI);

        path = new Path();
        monument = new Monument();
        center.getChildren().addAll(path.getDisplay(), monument.getDisplay());
        mainPane.setCenter(center);

        insufficientMoneyText = new Text("");

        shopDisplay.getChildren().addAll(exampleTowerShop.getDisplay());

        exampleTowerShop.getDisplay().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (!placementActive) {
                    if (PlayerInfo.getMoney() >= exampleTowerShop.getCost()) {
                        currentTowerIndicator = exampleTowerShop.getTowerIndicator();
                        placementActive = true;
                        PlayerInfo.setMoney(PlayerInfo.getMoney() - exampleTowerShop.getCost());
                        moneyText.setText("Money: " + PlayerInfo.getMoney() + " ");

                    } else {
                        insufficientMoneyText.setText("   Insufficient funds");
                    }
                } else {
                    insufficientMoneyText.setText(   "Already placing tower");
                }
            }
        });
        //ADD TOWERS HERE

        shopDisplay.getChildren().add(insufficientMoneyText);
        topUI.getChildren().add(shopDisplay);

        center.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (placementActive) {
                    if (path.isWithin(mouseEvent.getX(), mouseEvent.getY()) ||
                            !PlayerInfo.validPlacement(mouseEvent.getX() - 15, mouseEvent.getY() - 15)) {
                        insufficientMoneyText.setText("   Invalid location");
                    } else {
                        switch (currentTowerIndicator) {
                            case 0:
                                Tower newTower = new DefaultTower(mouseEvent.getX(), mouseEvent.getY());
                                ((Rectangle) newTower.getDisplay()).setX(mouseEvent.getX() - newTower.getWidth() / 2d);
                                ((Rectangle) newTower.getDisplay()).setY(mouseEvent.getY() - newTower.getHeight() / 2d);
                                center.getChildren().add(newTower.getDisplay());
                                PlayerInfo.addTower(newTower);
                                break;
                            default:
                                break;
                        }
                        insufficientMoneyText.setText("");
                        placementActive = false;
                    }
                }
            }
        });
    }
    public Scene getScene() {
        return scene;
    }
}
