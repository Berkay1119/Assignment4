import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.List;

public class GameScene extends SceneTemplate{

    private static Settings SETTINGS;

    public GameScene(Settings settings)
    {
        SETTINGS=settings;
    }

    @Override
    Scene CreateScene() {
        StackPane gameSceneLayout = new StackPane();
        gameSceneLayout.getChildren().add(SETTINGS.get_background());
        gameSceneLayout.getChildren().add(CreateHorizontalDuck().getDuckView());
        gameSceneLayout.getChildren().add(SETTINGS.get_foreground());
        Scene scene =new Scene(gameSceneLayout,4 * 300, 3 * 300);
        scene.setCursor(new ImageCursor(SETTINGS.get_crossHair()));
        return scene;
    }
    
    public Duck CreateHorizontalDuck()
    {
        List<Image> blackDuckList= new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            blackDuckList.add(new Image("file:assets/duck_black/"+(i+4)+".png"));
        }
        Duck duck = new Duck(blackDuckList);
        duck.Animate();
        return duck;
    }
}
