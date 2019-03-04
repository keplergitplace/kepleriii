import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

	/**
	 * @author Joint Project
	 * @version 1.0
	 * @created 13-Feb-2019 5:09:33 PM
	 */
	public class KeplerPane extends Pane {

		Manager mgr = new Manager();
		private boolean pressed = false;
		private Button Earth;
		private Button Exit;
		private Button Help;
		private Button Import;
		private Button Options;
		private Circle plt = new Circle();
		private Button btmm = new Button("Main Menu");
		private MenuItem[] planet = new MenuItem[9];
		MenuItem star = new MenuItem("Sun");
		MenuBar menuBar = new MenuBar();
		Menu Planets = new Menu("Planets");
		Menu Stars = new Menu("Stars");
		private String planetName[] = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
		private Button SandboxMode;

		public KeplerPane(){
			start();
		}
		
		public void start(){
			Earth = new Button("Earth");
			Exit = new Button("Exit");
			Help = new Button("Help");
			Import = new Button("Import");
			Options = new Button("Options");
			
			Import.setLayoutX(940);
			Import.setLayoutY(120);
			Import.setScaleX(3);
			Import.setScaleY(3);
			Import.setMinSize(100,0);
			
			Earth.setLayoutX(940);
			Earth.setLayoutY(220);
			Earth.setScaleX(3);
			Earth.setScaleY(3);
			Earth.setMinSize(100,0);
			
			Help.setLayoutX(940);
			Help.setLayoutY(320);
			Help.setScaleX(3);
			Help.setScaleY(3);
			Help.setMinSize(100,0);
			
			Options.setLayoutX(940);
			Options.setLayoutY(420);
			Options.setScaleX(3);
			Options.setScaleY(3);
			Options.setMinSize(100,0);
			
			Exit.setLayoutX(940);
			Exit.setLayoutY(520);
			Exit.setScaleX(3);
			Exit.setScaleY(3);
			Exit.setMinSize(100,0);
			
			Exit.setOnAction( e-> {
				System.exit(0);
				});
			
			getChildren().addAll(Earth, Exit, Help, Import, Options);
			Earth.setOnAction( e-> {
				Default();
			});
		}
		
	public void Default() {
		getChildren().clear();
		for (int i = 0; i < 8; i++) {
		plt =  mgr.addPlanets(i);
		getChildren().add(plt);
		}
		getChildren().add(mgr.addStars());
		Text scale = new Text("Size ratio to scale. Distance ratio to scale from object centerpoint to object centerpoint.\nObjects appear larger than they are by a factor of 5.");
		scale.setLayoutY(40);
		scale.setLayoutX(600);
		scale.setScaleX(1.5);
		scale.setScaleY(1.5);
		getChildren().add(scale);
		if (pressed == false) {
				menuBar.getMenus().clear();
				Planets.getItems().clear();
				Stars.getItems().clear();
				earthLists();
				pressed = true;
				mainMenu();
			}
			
		}
	
	public void earthLists() {
			for(int i =0; i < planetName.length; i++) {
				planet[i] = new MenuItem(planetName[i]);
				Planets.getItems().add(planet[i]);
				}
			Stars.getItems().add(star);
			
			menuBar.getMenus().addAll(Planets, Stars);
			getChildren().add(menuBar);
			menuBar.setLayoutY(15);
			menuBar.setLayoutX(225);
			menuBar.setScaleX(1.5);
			menuBar.setScaleY(1.5);
			planet[2].setOnAction( e-> {
				getChildren().remove(menuBar);
			});
		
		}
	
	public void mainMenu() {
		btmm.setLayoutX(30);
		btmm.setLayoutY(15);
		btmm.setScaleX(1.5);
		btmm.setScaleY(1.5);
		getChildren().add(btmm);
		
		btmm.setOnAction(e-> {
			getChildren().clear();
			start();
			pressed = false;
		});
		
		
	}

}//end KeplerPane