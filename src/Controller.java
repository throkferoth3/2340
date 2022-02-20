import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller extends Application{
    private static Stage window;
    private static Scene welcomeScreen, configScreen, gameScreen;

    public void start(Stage primaryStage) {
        window = primaryStage;

        window.setTitle("Game Title");

        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
