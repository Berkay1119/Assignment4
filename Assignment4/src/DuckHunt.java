import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class DuckHunt extends Application {

    private static Stage STAGE;

    private static Settings settings;
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        STAGE=primaryStage;
        SceneTemplate startScene=new StartScene();
        Scene welcomeScene = startScene.CreateScene();
        
        SceneTemplate artSelectionSceneIns = new ArtSelectionScene();
        Scene artSelectionScene = artSelectionSceneIns.CreateScene();

        welcomeScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                STAGE.setScene(artSelectionScene);// Switch to the next scene
            } else if (event.getCode() == KeyCode.ESCAPE) {
                STAGE.close();  // Close the application
            }
        });


        artSelectionScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                ArtSelectionScene.ResetImages();
                STAGE.setScene(welcomeScene);
            } else if (event.getCode() == KeyCode.LEFT) {
                ArtSelectionScene.ChangeBackgroundImage(-1);
            } else if (event.getCode() == KeyCode.RIGHT) {
                ArtSelectionScene.ChangeBackgroundImage(1);
            } else if (event.getCode() == KeyCode.UP) {
                ArtSelectionScene.ChangeCrossHairImage(1);
            } else if (event.getCode() == KeyCode.DOWN) {
                ArtSelectionScene.ChangeCrossHairImage(-1);
            } else if (event.getCode() == KeyCode.ENTER) {
                settings=new Settings(ArtSelectionScene.getCrossHair(),ArtSelectionScene.getBackgroundView(),ArtSelectionScene.getForeGroundView());
                SceneTemplate gameSceneScript = new GameScene(settings);
                Scene gameScene = gameSceneScript.CreateScene();
                STAGE.setScene(gameScene);
            }
        });




        STAGE.setScene(welcomeScene);
        STAGE.setTitle("HUBBM Duck Hunt");
        STAGE.setResizable(false);
        STAGE.getIcons().add(new Image("file:assets/favicon/1.png"));
        STAGE.show();
    }

    public static Stage getSTAGE()
    {
        return STAGE;
    }

}
