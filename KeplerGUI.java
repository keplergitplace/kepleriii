import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.Button;

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

	private Pane mainPane = new Pane();
	private Pane passedPane = new Pane();
	private Stage mainStage;
	private Scene mmScene;
	private boolean panePassed;

	public KeplerGUI(){



	}

	// main for testing window (might need to be changed to different main)
	public static void main(String[] args) {

		launch(args);

	}

	// window function
	public void start(Stage mmStage) throws Exception {

		Button btn = new Button("click me");
		btn.setLayoutX(200);
		btn.setLayoutY(200);

		mainPane.getChildren().add(btn);

		// Set the stage for main menu
		mainStage = mmStage;


		//give a pane to the scene
		System.out.println("ya yeet\n");
		mmScene = new Scene(passedPane, 600, 600);
		mainStage.setMaximized(true);
		mainStage.setScene(mmScene);
		mainStage.setTitle("Kepler III");
		//display GUI
		mainStage.show();

	}

}//end KeplerGUI