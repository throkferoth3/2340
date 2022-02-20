import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controller class that starts the tower defense game when run.
 *
 */
public class Controller extends Application{
    private static Stage window;
    private static Scene welcomeScreen, configScreen, gameScreen;
    /**
     * Start method that sets up the game when launched.
     *
     * @param primaryStage The window of the game.
     */
    public void start(Stage primaryStage) {
        window = primaryStage;
        InitialConfig initialConfig = new InitialConfig();
        configScreen = initialConfig.getScene();
        WelcomeScreen welcomeScreenTemp = new WelcomeScreen();
        welcomeScreen = welcomeScreenTemp.getScene();

        window.setTitle("Game Title");
        window.setScene(welcomeScreen);
        window.show();
    }

    /**
     * Closes the window of the game when event activates.
     *
     */
    public static void quitAction() {
        window.close();
    }

    /**
     * Changes scene to the configuration screen.
     *
     */
    public static void switchToConfig() {
        window.setScene(configScreen);
    }

    /**
     * Changes scene to the welcome screen.
     *
     */
    public static void switchToWelcome() {
        window.setScene(welcomeScreen);
    }
    /**
     * Main method that launches the game.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
