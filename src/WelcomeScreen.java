import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * Class that creates the title screen of the game
 *
 */
public class WelcomeScreen {

    // Declaring/Initializing variables
    private BorderPane pane = new BorderPane();
    private Text welcomeBanner = new Text("Team 104 Tower Defense Game");
    private HBox topPane = new HBox();
    private Button startButton = new Button("start");
    private Button quitButton = new Button("quit");
    private HBox centerPane = new HBox(100);
    private Scene scene = new Scene(pane, 500, 300);

    /**
     * Constructor that puts together panes and buttons onto the screen
     */
    public WelcomeScreen() {
        // setting panes and boxes
        topPane.getChildren().add(welcomeBanner);
        pane.setTop(topPane);
        centerPane.getChildren().addAll(startButton, quitButton);
        pane.setCenter(centerPane);

        // Aligning buttons and title
        topPane.setAlignment(Pos.BOTTOM_CENTER);
        centerPane.setAlignment(Pos.CENTER);

        quitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Controller.quitAction();
            }
        });

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Controller.switchToConfig();
            }
        });
    }

    /**
     * Returns the default welcome screen
     *
     * @return The welcome screen scene
     */
    public Scene getScene() {
        return scene;
    }

}