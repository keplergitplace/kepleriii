import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import javafx.application.Application;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
/**
 * @author Aaron Morgado
 * @version 0.1
 * @created 13-Feb-2019 5:09:32 PM
 *
 * Notes: May need a way to pass in a pane for switching from menu to display or vise versa
 * or - we could make new windows for each view
 *
 */
public class KeplerGUI extends Application{

	KeplerPane keplerPane = new KeplerPane();
	private Stage mainStage;
	private Scene mmScene;


	/** The window function
	 * @param mmStage, keplerPane
	 * @see KeplerPane
	 */
	public void start(Stage mmStage) throws Exception {
		// set up music player
		String path = "Interstellar Main Theme - Extra Extended - Soundtrack by Hans Zimmer.mp3";
		//String path = "C:\\Users\\Owner\\Desktop\\Creedence Clearwater Revival - Fortunate Son [Music Video].mp3";
		Media music = new Media(new File(path).toURI().toString());
		MediaPlayer song = new MediaPlayer(music);
		song.setVolume(10);
		song.setAutoPlay(true);
		song.setCycleCount(MediaPlayer.INDEFINITE);
		
		keplerPane.Options.setOnAction(e -> {
			keplerPane.getChildren().clear();
			
			Button muteB = new Button("Mute/Unmute Audio");
			
			muteB.setOnAction(e1 -> {
				if(song.isMute()) {
					song.setMute(false);;
				}else {
					song.setMute(true);
				}
			});
			
			keplerPane.getChildren().add(muteB);
		});

		// Set the stage for main menu
		mainStage = mmStage;
		//give a pane to the scene
		mmScene = new Scene(keplerPane, 600, 600);
		mainStage.setMaximized(true);
		mainStage.setScene(mmScene);
		mainStage.setTitle("Kepler III");
		//display GUI
		mainStage.show();

	}
	/** Main for testing window
	 * 
	 */
	public static void main(String[] args) {
		launch(args);

	}

}//end KeplerGUI