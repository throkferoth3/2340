import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VictoryScreen {
    public Scene getScene() {
        return scene;
    }
    private BorderPane mainPane = new BorderPane();
    private Scene scene = new Scene(mainPane, Controller.getScreenWidth(),
            Controller.getScreenHeight());
    private int spacing = 10;
    private VBox top = new VBox(spacing);
    private Text victoryText = new Text("Victory!");
    private static Text stat1 = new Text("stat1");
    private static Text stat2 = new Text("stat2");
    private static Text stat3 = new Text("stat3");
    private Button retryButton = new Button("Restart");

    public VictoryScreen() {
        retryButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Controller.switchToWelcome();
            }
        });
        top.setAlignment(Pos.CENTER);
        top.getChildren().addAll(victoryText, stat1, stat2, stat3);
        mainPane.setTop(top);
        mainPane.setCenter(retryButton);
    }
    public static void updateStats() {
        if (!PlayerInfo.getIsAlive()) {
            return;
        }
        stat1.setText("Damage Taken: " + PlayerInfo.getDamageTaken());
        stat2.setText("Upgrades Purchased: " + PlayerInfo.getUpgradesPurchased());
        stat3.setText("Towers Placed: " + PlayerInfo.getTowersPlaced());
    }

}
