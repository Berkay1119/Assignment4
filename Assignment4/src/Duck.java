import javafx.animation.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
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
        keyFrames[1] = new KeyFrame(Duration.seconds(0.25), new KeyValue(duckView.imageProperty(), _duckList.get(1)));
        keyFrames[2] = new KeyFrame(Duration.seconds(0.5), new KeyValue(duckView.imageProperty(), _duckList.get(2)));
        keyFrames[3] = new KeyFrame(Duration.seconds(1), new KeyValue(duckView.imageProperty(), _duckList.get(1)));
        keyFrames[4] = new KeyFrame(Duration.seconds(1.25), new KeyValue(duckView.imageProperty(), _duckList.get(0)));


        Path path = new Path();
        path.getElements().add(new MoveTo(0, 200));  // Start point
        path.getElements().add(new LineTo(1200, 200));//// Line segment
        PathTransition transition = new PathTransition();
        transition.setDuration(Duration.seconds(4));
        transition.setPath(path);
        transition.setNode(duckView);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setAutoReverse(true);
        transition.play();

        Timeline timeline = new Timeline(keyFrames);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (duckView.getTranslateX()-duckView.getFitWidth()<=0)
                {
                    duckView.setScaleX(1);
                } else if (duckView.getTranslateX()>=1200-duckView.getFitWidth()) {
                    duckView.setScaleX(-1);
                }

            }
        };
        animationTimer.start();
    }

    public ImageView getDuckView()
    {
        return duckView;
    }
}
