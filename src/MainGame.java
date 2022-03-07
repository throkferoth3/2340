import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
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

    private ShopEntry exampleTowerShop = new ShopEntry(new int[] {15, 20, 25}, 0, "RED");

    private static Boolean placementActive = false;
    private int currentTowerIndicator = 0;

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

        exampleTowerShop.getDisplay().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (e.getButton() == MouseButton.SECONDARY && !placementActive) {
                    switch (currentTowerIndicator) {
                        case 0:
                            currentTowerIndicator++;
                            exampleTowerShop.getDisplay().setText("GREEN");
                            break;
                        case 1:
                            currentTowerIndicator++;
                            exampleTowerShop.getDisplay().setText("BLUE");
                            break;
                        case 2:
                            currentTowerIndicator = 0;
                            exampleTowerShop.getDisplay().setText("RED");
                            break;
                        default:
                            break;
                    }
                } else {
                    if (!placementActive) {
                        if (PlayerInfo.getMoney() >= exampleTowerShop.getCost()) {
                            placementActive = true;
                            PlayerInfo.setMoney(PlayerInfo.getMoney() - exampleTowerShop.getCost());
                            moneyText.setText("Money: " + PlayerInfo.getMoney() + " ");

                        } else {
                            insufficientMoneyText.setText("   Insufficient funds");
                        }
                    } else {
                        insufficientMoneyText.setText("Already placing tower");
                    }
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
                                Tower redTower = new RedTower(mouseEvent.getX(), mouseEvent.getY());
                                ((Rectangle) redTower.getDisplay()).setX(mouseEvent.getX() - redTower.getWidth() / 2d);
                                ((Rectangle) redTower.getDisplay()).setY(mouseEvent.getY() - redTower.getHeight() / 2d);
                                center.getChildren().add(redTower.getDisplay());
                                PlayerInfo.addTower(redTower);
                                break;
                            case 1:
                                Tower greenTower = new GreenTower(mouseEvent.getX(), mouseEvent.getY());
                                ((Rectangle) greenTower.getDisplay()).setX(mouseEvent.getX() - greenTower.getWidth() / 2d);
                                ((Rectangle) greenTower.getDisplay()).setY(mouseEvent.getY() - greenTower.getHeight() / 2d);
                                center.getChildren().add(greenTower.getDisplay());
                                PlayerInfo.addTower(greenTower);
                                break;
                            case 2:
                                Tower blueTower = new BlueTower(mouseEvent.getX(), mouseEvent.getY());
                                ((Rectangle) blueTower.getDisplay()).setX(mouseEvent.getX() - blueTower.getWidth() / 2d);
                                ((Rectangle) blueTower.getDisplay()).setY(mouseEvent.getY() - blueTower.getHeight() / 2d);
                                center.getChildren().add(blueTower.getDisplay());
                                PlayerInfo.addTower(blueTower);
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
    public Boolean getPlacementActive() {
        return placementActive;
    }
}
