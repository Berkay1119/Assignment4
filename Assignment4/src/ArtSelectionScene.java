import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ArtSelectionScene {
    public static Scene CreateScene() {
        // Create and configure the next scene
        StackPane nextSceneLayout = new StackPane();
        nextSceneLayout.setStyle("-fx-background-color: skyblue;");
        Text nextSceneText = new Text("This is the next scene.");
        nextSceneText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        nextSceneText.setFill(Color.WHITE);
        nextSceneLayout.getChildren().add(nextSceneText);

        return new Scene(nextSceneLayout, 800, 600);
    }
}
