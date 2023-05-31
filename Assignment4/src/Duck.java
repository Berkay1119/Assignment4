import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Duck {

    private List<Image> _duckList = new ArrayList<>();
    private ImageView duckView;

    public Duck(List<Image> duckList)
    {
        _duckList=duckList;
    }

    public void Animate()
    {
        duckView=new ImageView();
        duckView.setFitWidth(100);
        duckView.setPreserveRatio(true);
        KeyFrame[] keyFrames = new KeyFrame[5];
        keyFrames[0] = new KeyFrame(Duration.ZERO, new KeyValue(duckView.imageProperty(), _duckList.get(0)));
        keyFrames[1] = new KeyFrame(Duration.seconds(1), new KeyValue(duckView.imageProperty(), _duckList.get(1)));
        keyFrames[2] = new KeyFrame(Duration.seconds(2), new KeyValue(duckView.imageProperty(), _duckList.get(2)));
        keyFrames[3] = new KeyFrame(Duration.seconds(3), new KeyValue(duckView.imageProperty(), _duckList.get(1)));
        keyFrames[4] = new KeyFrame(Duration.seconds(4), new KeyValue(duckView.imageProperty(), _duckList.get(0)));

        Timeline timeline = new Timeline(keyFrames);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public ImageView getDuckView()
    {
        return duckView;
    }
}
