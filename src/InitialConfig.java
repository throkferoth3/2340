import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

public class InitialConfig {

    private BorderPane mainPane = new BorderPane();

    private int spacing = 10;

    private HBox topPane = new HBox(spacing);
    private Text nameText;
    private TextField nameTextBox;
    private Button nameEnter;
    private Text invalidName = new Text("");

    private HBox bottomPane = new HBox(spacing);

    private GridPane centerPane = new GridPane();

    private String name = "";

    private Button easyButton = new Button("Easy");
    private Button normalButton = new Button("Normal");
    private Button hardButton = new Button("Hard");

    private int difficulty = -1;
    private Text difficultyText = new Text("Difficulty: ");

    private Button continueButton = new Button("Continue");
    private Button backButton = new Button("Back");
    private Text failContinue = new Text("");

    private Scene scene = new Scene(mainPane, Controller.getScreenWidth(),
            Controller.getScreenHeight());


    public InitialConfig() {
        mainPane.getChildren().clear();
        topPane.getChildren().clear();
        bottomPane.getChildren().clear();
        centerPane.getChildren().clear();

        mainPane.setTop(topPane);
        mainPane.setBottom(bottomPane);

        centerPane.setHgap(spacing);
        centerPane.setVgap(spacing);
        centerPane.setPadding(new Insets(spacing, spacing, spacing, spacing));
        mainPane.setCenter(centerPane);

        topPane.setAlignment(Pos.CENTER);
        centerPane.setAlignment(Pos.CENTER);
        bottomPane.setAlignment(Pos.CENTER);

        nameText = new Text("Name: ");
        nameTextBox = new TextField();
        nameTextBox.setPromptText("Enter your name here");
        nameTextBox.setFocusTraversable(false);
        nameEnter = new Button("Enter");
        nameEnter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                name = nameTextBox.getText();
                if (isNameValid(name)) {
                    nameText.setText("Name: " + name);
                    PlayerInfo.setName(name);
                    invalidName.setText("");
                } else {
                    invalidName.setText("Invalid name.");
                }
            }
        });
        topPane.getChildren().addAll(nameText, nameTextBox, nameEnter, invalidName);

        easyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                difficulty = 0;
                difficultyText.setText("Difficulty: Easy");
                PlayerInfo.setDifficulty(0);
            }
        });
        normalButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                difficulty = 1;
                difficultyText.setText("Difficulty: Normal");
                PlayerInfo.setDifficulty(1);
            }
        });
        hardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                difficulty = 2;
                difficultyText.setText("Difficulty: Hard");
                PlayerInfo.setDifficulty(2);
            }
        });

        centerPane.setConstraints(easyButton, 0, 5);
        centerPane.setConstraints(normalButton, 10, 5);
        centerPane.setConstraints(hardButton, 20, 5);
        centerPane.setConstraints(difficultyText, 10, 10);

        centerPane.getChildren().addAll(easyButton, normalButton, hardButton, difficultyText);

        continueButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (isNameValid(name) && difficulty != -1) {
                    failContinue.setText("");
                    Controller.switchToGame();
                    MainGame.initialize();
                } else {
                    failContinue.setText("You must enter a name and select a difficulty.");
                }
            }
        });
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Controller.switchToWelcome();
            }
        });

        bottomPane.getChildren().addAll(continueButton, backButton, failContinue);
    }

    private Boolean isNameValid(String name) {
        if (name == "" || name == null || name.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public Scene getScene() {
        return scene;
    }
    public static void main(String[] args) {
    }
}