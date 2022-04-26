import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Controller class that starts the tower defense game when run.
 *
 */
public class Controller extends Application {
    private static Stage window;
    private static Scene welcomeScreen;
    private static Scene configScreen;
    private static Scene gameScreen;
    private static Scene gameOverScreen;
    private static Scene victoryScreen;

    private static int difficulty;
    private static String name;
    private static final int SCREEN_HEIGHT = 600;
    private static final int SCREEN_WIDTH = 1000;
    /**
     * Start method that sets up the game when launched.
     *
     * @param primaryStage The window of the game.
     */
    public void start(Stage primaryStage) {
        difficulty = -1;
        name = "";

        window = primaryStage;
        InitialConfig initialConfig = new InitialConfig();
        configScreen = initialConfig.getScene();
        WelcomeScreen welcomeScreenTemp = new WelcomeScreen();
        welcomeScreen = welcomeScreenTemp.getScene();
        MainGame mainGame = new MainGame();
        gameScreen = mainGame.getScene();
        GameOverScreen gameOver = new GameOverScreen();
        gameOverScreen = gameOver.getScene();
        VictoryScreen victory = new VictoryScreen();
        victoryScreen = victory.getScene();

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
        InitialConfig.reset();
        PlayerInfo.resetStats();
    }

    /**
     * Changes scene to the main game
     *
     */
    public static void switchToGame() {
        window.setScene(gameScreen);
        PlayerInfo.setIsAlive(true);
        PlayerInfo.resetRounds();
    }
    public static void switchToGameOver() {
        window.setScene(gameOverScreen);
        GameOverScreen.updateStats();
        PlayerInfo.setIsAlive(false);
    };
    public static void switchToVictory() {
        window.setScene(victoryScreen);
        VictoryScreen.updateStats();
    }
    public static int getScreenHeight() {
        return SCREEN_HEIGHT;
    }
    public static int getScreenWidth() {
        return SCREEN_WIDTH;
    }
    public static Stage getWindow() {
        return window;
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
