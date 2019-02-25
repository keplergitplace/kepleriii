import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Owner
 * @version 1.0
 * @created 13-Feb-2019 5:09:33 PM
 */
public class KeplerPane {

	private Button Earth;
	private Button Exit;
	private Button Help;
	private Button Import;
	private Button Options;
	private MenuList Planets;
	private Button SandboxMode;
	private MenuList Stars;

	public KeplerPane(){
		genericPane = new Pane();
		Earth = new Button("Earth");
		Exit = new Button("Exit");
		Help = new Button("Help");
		Import = new Button("Import");
		Options = new Button("Options");
		
		Import.setLayoutX(250);
		Import.setLayoutY(120);
		
		Earth.setLayoutX(250);
		Earth.setLayoutY(160);
		
		Help.setLayoutX(250);
		Help.setLayoutY(200);
		
		Options.setLayoutX(250);
		Options.setLayoutY(240);
		
		Exit.setLayoutX(250);
		Exit.setLayoutY(280);
		
		genericPane.getChildren().addAll(Earth, Exit, Help, Import, Options);
	}
	}

}//end KeplerPane