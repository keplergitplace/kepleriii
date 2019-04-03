import java.io.File;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class music extends Application
{
    // main for testing window (might need to be changed to different main)
    public static void main(String[] args) {
        launch(args);
    }

    // window function
    public void start(Stage mmStage) throws Exception {
        // set up music player
        String path = "/Users/aaronmorgado/Desktop/test.mp3";
        Media music = new Media(new File(path).toURI().toString());
        MediaPlayer song = new MediaPlayer(music);
        song.setAutoPlay(true);

        mmStage.show();

    }


}
