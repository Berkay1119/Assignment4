
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StartScene {

    public static Scene CreateScene()
    {
        Text welcomeSceneText = new Text();
        welcomeSceneText.setText("\n\n\n\n\n\n\nPRESS ENTER TO START \n PRESS ESC TO EXIT");
        welcomeSceneText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        welcomeSceneText.setTextAlignment(TextAlignment.CENTER);
        welcomeSceneText.setFill(Color.ORANGE);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), evt -> welcomeSceneText.setVisible(false)),
                new KeyFrame(Duration.seconds(1), evt -> welcomeSceneText.setVisible(true)));
        timeline.setCycleCount(Animation.INDEFINITE);

        Image image = new Image("file:assets/welcome/1.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        StackPane layout = new StackPane();
        imageView.fitWidthProperty().bind(DuckHunt.getSTAGE().widthProperty());
        imageView.fitHeightProperty().bind(DuckHunt.getSTAGE().heightProperty());

        layout.getChildren().add(imageView);
        layout.getChildren().add(welcomeSceneText);
        timeline.play();
        return new Scene(layout, 4 * 300, 3 * 300);
    }
}
