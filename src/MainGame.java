import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.awt.*;

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

    private ShopEntry redShop = new ShopEntry(new int[] {15, 20, 25}, 0, "RED");
    private ShopEntry greenShop = new ShopEntry(new int[] {10, 15, 20}, 1, "GREEN");
    private ShopEntry blueShop = new ShopEntry(new int[] {20, 25, 30}, 2, "BLUE");

    private StartCombat startCombat = new StartCombat();

    private static Boolean placementActive = false;
    private static int currentTowerIndicator = 0;

    private Scene scene = new Scene(mainPane,
            Controller.getScreenWidth(), Controller.getScreenHeight());

    public static void initialize() {
        PlayerInfo.initHealthAndMoney();
        moneyText.setText("Money: " + PlayerInfo.getMoney() + " ");
        healthText.setText("Health: " + PlayerInfo.getHealth());
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

        shopDisplay.getChildren().addAll(redShop.getDisplay(),
                greenShop.getDisplay(), blueShop.getDisplay());

        redShop.getDisplay().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                redShop.buyTower();
            }
        });
        greenShop.getDisplay().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                greenShop.buyTower();
            }
        });
        blueShop.getDisplay().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                blueShop.buyTower();
            }
        });

        startCombat.getDisplay().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!StartCombat.getInCombat()) {
                    startCombat.startCombat();
                }
            }
        });

        shopDisplay.getChildren().add(insufficientMoneyText);
        topUI.getChildren().addAll(shopDisplay, startCombat.getDisplay());

        center.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (placementActive) {
                    if (path.isWithin(mouseEvent.getX(), mouseEvent.getY())
                            || !PlayerInfo.validPlacement(mouseEvent.getX() - 15,
                                    mouseEvent.getY() - 15)) {
                        insufficientMoneyText.setText("   Invalid location");
                    } else {
                        switch (currentTowerIndicator) {
                            case 0:
                                Tower redTower = new RedTower(mouseEvent.getX(),
                                        mouseEvent.getY());
                                ((Rectangle) redTower.getDisplay()).setX(mouseEvent.getX()
                                        - redTower.getWidth() / 2d);
                                ((Rectangle) redTower.getDisplay()).setY(mouseEvent.getY()
                                        - redTower.getHeight() / 2d);
                                center.getChildren().add(redTower.getDisplay());
                                PlayerInfo.addTower(redTower);
                                break;
                            case 1:
                                Tower greenTower = new GreenTower(mouseEvent.getX(),
                                        mouseEvent.getY());
                                ((Rectangle) greenTower.getDisplay()).setX(mouseEvent.getX()
                                        - greenTower.getWidth() / 2d);
                                ((Rectangle) greenTower.getDisplay()).setY(mouseEvent.getY()
                                        - greenTower.getHeight() / 2d);
                                center.getChildren().add(greenTower.getDisplay());
                                PlayerInfo.addTower(greenTower);
                                break;
                            case 2:
                                Tower blueTower = new BlueTower(mouseEvent.getX(),
                                        mouseEvent.getY());
                                ((Rectangle) blueTower.getDisplay()).setX(mouseEvent.getX()
                                        - blueTower.getWidth() / 2d);
                                ((Rectangle) blueTower.getDisplay()).setY(mouseEvent.getY()
                                        - blueTower.getHeight() / 2d);
                                center.getChildren().add(blueTower.getDisplay());
                                PlayerInfo.addTower(blueTower);
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
    public static Boolean getPlacementActive() {
        return placementActive;
    }
    public static void setPlacementActive(boolean p) {
        placementActive = p;
    }
    public static Text getMoneyText() {
        return moneyText;
    }
    public static void updateHealthText() {healthText.setText("Health: " + PlayerInfo.getHealth());};
    public static Text getInsufficientMoneyText() {
        return insufficientMoneyText;
    }
    public static void setCurrentTowerIndicator(int ti) {
        currentTowerIndicator = ti;
    }
    public static AnchorPane getCenter() {
        return center;
    }
}
