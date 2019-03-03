import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

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
			menuBar.setLayoutY(0);
			menuBar.setLayoutX(200);
			
			planet[2].setOnAction( e-> {
				getChildren().remove(menuBar);
			});
		
		}
	
	public void mainMenu() {
		btmm.setLayoutX(0);
		btmm.setLayoutY(0);
		getChildren().add(btmm);
		
		btmm.setOnAction(e-> {
			getChildren().clear();
			start();
			pressed = false;
		});
		
		
	}

}//end KeplerPane