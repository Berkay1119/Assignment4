import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Settings {
    private static final double VOLUME = 0.025;
    private static final double SCALE =3;
    private final Image _crossHair;
    private final ImageView _background;
    private final ImageView _foreground;
    public Settings(Image crossHair, ImageView background, ImageView foreground)
    {
        _foreground= foreground;
        _crossHair=crossHair;
        _background=background;
    }

    public ImageView get_background() {
        return _background;
    }

    public Image get_crossHair() {
        return _crossHair;
    }

    public ImageView get_foreground() {
        return _foreground;
    }
}
