import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

	/**
	 * @author Joint Project
	 * @version 1.0
	 * @created 13-Feb-2019 5:09:33 PM
	 */
	public class KeplerPane extends Pane {

		private Button Earth;
		private Button Exit;
		private Button Help;
		private Button Import;
		private Button Options;
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
			
			getChildren().addAll(Earth, Exit, Help, Import, Options);
			Earth.setOnAction( e-> {
				Default();
			});
		}
		
	public void Default() {
		getChildren().clear();
		start();
		earthLists();
		}
	
	public void earthLists() {
	//	Planets = new MenuBar();
		menuBar.getMenus().addAll(Planets, Stars);
		getChildren().add(menuBar);
		menuBar.setLayoutY(10);
		menuBar.setLayoutX(400);
			for(int i =0; i < planetName.length; i++) {
				planet[i] = new MenuItem(planetName[i]);
				Planets.getItems().add(planet[i]);
			}
			Stars.getItems().add(star);
			
			planet[2].setOnAction( e-> {
			
			});
		
		}

}//end KeplerPane