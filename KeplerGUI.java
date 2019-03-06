import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

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
		// Set the stage for main menu
		mainStage = mmStage;
		//give a pane to the scene
		mmScene = new Scene(keplerPane, 600, 600);
		mainStage.setMaximized(true);
		mainStage.setScene(mmScene);
		mainStage.setTitle("Kepler III");
		//display GUI
		mainStage.show();
		
	/** Main for testing window
	 * 
	 */
	public static void main(String[] args) {
			launch(args);
		}

	}

}//end KeplerGUI