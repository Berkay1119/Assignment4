import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;


public class DuckHunt extends Application {

    private static Stage STAGE;
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
            }
        });

        //The game scene will be initialized here with selected background and cursor.


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
