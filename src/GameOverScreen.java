import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameOverScreen {
    public Scene getScene() {
        return scene;
    }
    private BorderPane mainPane = new BorderPane();
    private Scene scene = new Scene(mainPane, Controller.getScreenWidth(),
            Controller.getScreenHeight());
    private int spacing = 10;
    private VBox top = new VBox(spacing);
    private Text gameOverText = new Text("GAME OVER");
    private Text consolingText = new Text("Better luck next time");
    private Button retryButton = new Button("Restart");

    public GameOverScreen() {
        retryButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                InitialConfig.reset();
                Controller.switchToWelcome();
            }
        });
        top.setAlignment(Pos.CENTER);
        top.getChildren().addAll(gameOverText, consolingText);
        mainPane.setTop(top);
        mainPane.setCenter(retryButton);
    }
}
