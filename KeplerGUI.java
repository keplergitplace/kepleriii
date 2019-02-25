import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.Button;

/**
 * @author Aaron Morgado
 * @version 0.2
 * @created 13-Feb-2019 5:09:32 PM
 *
 * Notes: May need a way to pass in a pane for switching from menu to display or vise versa
 * or - we could make new windows for each view
 *
 */
public class KeplerGUI extends Application{

	private Stage mainStage;
	private Scene mmScene;
	private boolean panePassed;

	KeplerPane kp = new KeplerPane();

	// main for testing window (might need to be changed to different main)
	public static void main(String[] args) {

		launch(args);

	}

	// window function
	public void start(Stage mmStage) throws Exception {


		// Set the stage for main menu
		mainStage = mmStage;


		//give a pane to the scene
		mmScene = new Scene(kp, 600, 600);

		mainStage.setMaximized(true);
		mainStage.setScene(mmScene);
		mainStage.setTitle("Kepler III");
		//display GUI
		mainStage.show();

	}

}//end KeplerGUI