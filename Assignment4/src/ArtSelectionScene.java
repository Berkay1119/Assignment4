import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.List;

public class ArtSelectionScene  extends SceneTemplate{
    public static  List<Image>  backgroundList = new ArrayList<>();

    public static  List<Image> crossHairList= new ArrayList<>();

    public static  List<Image> foregroundList = new ArrayList<>();

    private static Image selectedBackgroundImage;

    private static Image selectedCrossHair;

    private static ImageView backgroundView;

    private static ImageView crossHairView;

    public static ImageView getBackgroundView() {
        return backgroundView;
    }

    public Scene CreateScene() {
        // Create and configure the next scene
        for (int i = 1; i < 7; i++) {
            backgroundList.add(new Image("file:assets/background/"+i+".png"));
        }
        for (int i = 1; i < 8; i++) {
            crossHairList.add(new Image("file:assets/crosshair/"+i+".png"));
        }
        for (int i = 1; i < 7; i++) {
            foregroundList.add(new Image("file:assets/foreground/"+i+".png"));
        }
        selectedBackgroundImage = backgroundList.get(0);
        StackPane artSelectionSceneLayout = new StackPane();
        backgroundView = new ImageView();
        backgroundView.setImage(selectedBackgroundImage);
        AdjustImageView(backgroundView);
        selectedCrossHair = crossHairList.get(0);
        crossHairView = new ImageView();
        crossHairView.setImage(selectedCrossHair);

        //following line should be adjusted by SCALE.
        crossHairView.setFitWidth(4*10);
        crossHairView.setFitHeight(3*10);
        artSelectionSceneLayout.getChildren().add(backgroundView);
        artSelectionSceneLayout.getChildren().add(crossHairView);
        return new Scene(artSelectionSceneLayout, 4*300, 3*300);
    }

    public static void ChangeBackgroundImage(int nextIndex)
    {
            int newIndex = backgroundList.indexOf(selectedBackgroundImage)+nextIndex;
            if (newIndex<0)
            {
                newIndex=newIndex+6;
            }
            newIndex=newIndex%6;
            backgroundView.setImage(backgroundList.get(newIndex));
            selectedBackgroundImage=backgroundList.get(newIndex);
    }

    public static void ChangeCrossHairImage(int nextIndex)
    {
        int newIndex = crossHairList.indexOf(selectedCrossHair)+nextIndex;
        if (newIndex<0)
        {
            newIndex=newIndex+6;
        }
        newIndex=newIndex%7;
        crossHairView.setImage(crossHairList.get(newIndex));
        selectedCrossHair=crossHairList.get(newIndex);
    }

    public static void ResetImages()
    {
        selectedCrossHair=crossHairList.get(0);
        crossHairView.setImage(selectedCrossHair);
        selectedBackgroundImage = backgroundList.get(0);
        backgroundView.setImage(selectedBackgroundImage);
    }

    private static void AdjustImageView(ImageView imageView)
    {
        imageView.fitHeightProperty().bind(DuckHunt.getSTAGE().heightProperty());
        imageView.fitWidthProperty().bind(DuckHunt.getSTAGE().widthProperty());
    }

    public static Image getCrossHair()
    {
        return selectedCrossHair;
    }

    public static ImageView getForeGroundView(){
        ImageView imageView = new ImageView();
        AdjustImageView(imageView);
        imageView.setImage(foregroundList.get(backgroundList.indexOf(selectedBackgroundImage)));
        return imageView;
    }
}
