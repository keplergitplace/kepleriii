import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.input.ScrollEvent;

/**
 * This class creates the images for the planets and star and places them in a pane
 * @author Joint Project
 * @version 1.0
 * @created 13-Feb-2019 5:09:33 PM
 */

public class KeplerPane extends Pane {

	Manager mgr = new Manager();
	private boolean pressed = false;
	private boolean runImport = true;
	private boolean runOwnImport = true;
	private Button Earth;
	private Button Exit;
	private Button Help;
	private Button Import;

	// for sandbox mode only
	private Button confirm = new Button("Confirm");
	private int confirmClicked = 0;

	Button Options;
	private Circle plt[];
	private Circle str;
	private Button btmm = new Button("Main Menu");
	private MenuItem[] planet;
	private String keplerSystemName;
	MenuItem star;
	MenuBar menuBar = new MenuBar();
	Menu Planets = new Menu("Planets");
	Menu Stars = new Menu("Stars");
	Text[] display;
	Label[] labels = new Label[8];
	Button systemInput = new Button("Input Star System");
	private Button sandBoxMode;

	public KeplerPane(){
		start();
	}

	/** Initiates buttons for the main menu
	 * @param void
	 */

	public void spawnConfirmButton(Pane pane, SandBox sb)
	{

		confirm.setMinSize(50, 25);
		confirm.setLayoutX(115);
		confirm.setLayoutY(700);
		pane.getChildren().add(confirm);
		confirm.setOnAction(e1-> {

			confirmClicked++;
			sb.initSandBox(pane, confirmClicked);
			spawnConfirmButton(pane, sb);
			mainMenu();

		});

	}

	public void start(){
		Image bk = new Image("lovejoy-comet.jpg");

		BackgroundImage backgroundimage = new BackgroundImage(bk,
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT);
		Background background = new Background(backgroundimage);
		setBackground(background);

		Text welcome = new Text("Welcome to Kepler III");
		welcome.setFill(Color.WHITE);
		welcome.setLayoutX(900);
		welcome.setLayoutY(100);
		welcome.setScaleX(3);
		welcome.setScaleY(3);
		getChildren().add(welcome);

		Earth = new Button("Earth");
		Exit = new Button("Exit");
		Help = new Button("Help");
		Import = new Button("Import");
		Options = new Button("Options");
		sandBoxMode = new Button("SandBox");

		Import.setLayoutX(170);
		Import.setLayoutY(900);
		Import.setScaleX(2);
		Import.setScaleY(2);
		Import.setMinSize(100,0);

		Earth.setLayoutX(520);
		Earth.setLayoutY(900);
		Earth.setScaleX(2);
		Earth.setScaleY(2);
		Earth.setMinSize(100,0);

		sandBoxMode.setLayoutX(870);
		sandBoxMode.setLayoutY(900);
		sandBoxMode.setScaleX(2);
		sandBoxMode.setScaleY(2);
		sandBoxMode.setMinSize(100,0);
		sandBoxMode.setOnAction(e-> {

			this.getChildren().clear();

			SandBox sandBox = new SandBox();

			sandBox.initSandBox(this, confirmClicked);
			spawnConfirmButton(this, sandBox);
			mainMenu();

		});

		Help.setLayoutX(1220);
		Help.setLayoutY(900);
		Help.setScaleX(2);
		Help.setScaleY(2);
		Help.setMinSize(100,0);

		Options.setLayoutX(1570);
		Options.setLayoutY(900);
		Options.setScaleX(2);
		Options.setScaleY(2);
		Options.setMinSize(100,0);

		Exit.setLayoutX(1910);
		Exit.setLayoutY(900);
		Exit.setScaleX(2);
		Exit.setScaleY(2);
		Exit.setMinSize(100,0);

		Exit.setOnAction( e-> {
			System.exit(0);
		});
		getChildren().addAll(Earth, Exit, Help, Import, Options, sandBoxMode);
		Earth.setOnAction( e-> {
			setBackground(null);
			Default();
		});
		Import.setOnAction(e -> {
			getChildren().clear();
			importButton();
		});
	}

	/**
	 * This method clears the pane and re-populates it with the planets for the Earth data
	 * @see #start()
	 */
	public void Default() {
		getChildren().clear();

		String solarSystem[] = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
		plt = new Circle[8];
		//get planet info from "planet" class and display
		//label planets using "labels" array and set location to planet location
		for (int i = 0; i < 8; i++) {
			labels[i] = new Label(solarSystem[i]);
			plt[i] =  mgr.addPlanets(i);
			labels[i].setLayoutX(mgr.addPlanets(i).getLayoutX());
			labels[i].setLayoutY(mgr.addPlanets(i).getLayoutY());
			labels[i].setTextFill(Color.RED);
			getChildren().addAll(plt[i], labels[i]);
		}
		getChildren().add(str = mgr.addStars());//get star info from "star" class and display
		Text scale = new Text("All measurements to scale");
		scale.setLayoutY(40);
		scale.setLayoutX(700);
		scale.setScaleX(1.5);
		scale.setScaleY(1.5);
		getChildren().add(scale);
		/*
		 * Scroll-Zoom feature
		 * Changes the scaling of the planet parameters
		 * based on how far in/out the user has already zoomed.
		 * This is custom-made for the default view.
		 */
		setOnScroll((ScrollEvent event) -> {
			double zoomFactor = 1.05;
			double deltaY = event.getDeltaY();
			if (deltaY < 0){
				zoomFactor = 2.0 - zoomFactor;
			}
			str.setLayoutX(str.getLayoutX() * zoomFactor);
			for (int i=0; i<8; i++) {
				plt[i].setScaleX(plt[i].getScaleX() * zoomFactor);
				plt[i].setScaleY(plt[i].getScaleY() * zoomFactor);
				if ((plt[i].getLayoutX() / zoomFactor) > str.getLayoutX()) {
					plt[i].setLayoutX(plt[i].getLayoutX() * zoomFactor);
					labels[i].setLayoutX(labels[i].getLayoutX() * zoomFactor);
				} else {
					plt[i].setLayoutX(plt[i].getLayoutX() * zoomFactor);
					labels[i].setLayoutX(labels[i].getLayoutX() * zoomFactor);
				}
			}
			str.setScaleX(str.getScaleX() * zoomFactor);
			str.setScaleY(str.getScaleY() * zoomFactor);
		});
		//prevent endless addition of items to menu bar if user selects the default view multiple times in one session.
		if (pressed == false) {
			menuBar.getMenus().clear();
			Planets.getItems().clear();
			Stars.getItems().clear();
			earthLists();
			pressed = true;
			mainMenu();
		}
	}
	/** Creates drop down lists
	 *
	 */
	public void earthLists() {
		Button reset = new Button("Reset View");
		reset.setLayoutX(190);
		reset.setLayoutY(15);
		reset.setScaleX(1.5);
		reset.setScaleY(1.5);
		getChildren().add(reset);
		reset.setOnAction(e -> {
			pressed = false;
			Default();
		});
		String planetName[] = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
		planet = new MenuItem[9];
		for(int i =0; i < planetName.length; i++) {
			planet[i] = new MenuItem(planetName[i]);
			Planets.getItems().add(planet[i]);
		}
		star = new MenuItem("Sun");
		Stars.getItems().add(star);
		display = new Text[4];
		menuBar.getMenus().addAll(Planets, Stars);
		getChildren().addAll(menuBar);
		menuBar.setLayoutY(15);
		menuBar.setLayoutX(350);
		menuBar.setScaleX(1.5);
		menuBar.setScaleY(1.5);
		planet[0].setOnAction( e-> {
			for(int i = 0; i < display.length; i++) {
				getChildren().remove(display[i]);
			}
			String dat[] = mgr.earthData(0);
			for ( int i =0; i < display.length; i ++) {
				display[i] = new Text(dat[i]);
			}
			int x = 200;
			int y = 100;
			for (int i = 0; i < display.length; i++) {
				display[i].setLayoutX(x);
				display[i].setLayoutY(y);
				getChildren().add(display[i] );
				y = y + 20;
			}
			for(int i = 0; i < plt.length; i++) {
				getChildren().removeAll(plt[i], labels[i]);
			}
			getChildren().remove(str);
			getChildren().addAll(plt[0], labels[0]);
			labels[0].setLayoutX(960);
			plt[0].setLayoutX(960);
			/*
			 * Scroll-Zoom feature
			 * Changes the scaling of the planet parameters
			 * based on how far in/out the user has already zoomed.
			 */
			setOnScroll((ScrollEvent event) -> {
				double zoomFactor = 1.2;
				double deltaY = event.getDeltaY();
				if (deltaY < 0){
					zoomFactor = 2.0 - zoomFactor;
				}
				plt[0].setScaleX(plt[0].getScaleX() * zoomFactor);
				plt[0].setScaleY(plt[0].getScaleY() * zoomFactor);
			});
		});
		planet[1].setOnAction( e-> {
			for(int i = 0; i < display.length; i++) {
				getChildren().remove(display[i]);
			}
			String dat[] = mgr.earthData(1);
			for ( int i =0; i < display.length; i ++) {
				display[i] = new Text(dat[i]);
			}
			int x = 200;
			int y = 100;
			for (int i = 0; i < display.length; i++) {
				display[i].setLayoutX(x);
				display[i].setLayoutY(y);
				getChildren().add(display[i]);
				y = y + 20;
			}
			for(int i = 0; i < plt.length; i++) {
				getChildren().removeAll(plt[i], labels[i]);
			}
			getChildren().remove(str);
			getChildren().addAll(plt[1], labels[1]);
			labels[1].setLayoutX(960);
			plt[1].setLayoutX(960);
			/*
			 * Scroll-zoom feature
			 * Changes the scaling of the planet parameters
			 * based on how far in/out the user has already zoomed.
			 */
			setOnScroll((ScrollEvent event) -> {
				double zoomFactor = 1.2;
				double deltaY = event.getDeltaY();
				if (deltaY < 0){
					zoomFactor = 2.0 - zoomFactor;
				}
				plt[1].setScaleX(plt[1].getScaleX() * zoomFactor);
				plt[1].setScaleY(plt[1].getScaleY() * zoomFactor);
			});
		});
		planet[2].setOnAction( e-> {
			for(int i = 0; i < display.length; i++) {
				getChildren().remove(display[i]);
			}
			String dat[] = mgr.earthData(2);
			for ( int i =0; i < display.length; i ++) {
				display[i] = new Text(dat[i]);
			}
			int x = 200;
			int y = 100;
			for (int i = 0; i < display.length; i++) {
				display[i].setLayoutX(x);
				display[i].setLayoutY(y);
				getChildren().add(display[i]);
				y = y + 20;
			}
			for(int i = 0; i < plt.length; i++) {
				getChildren().removeAll(plt[i], labels[i]);
			}
			getChildren().remove(str);
			getChildren().addAll(plt[2], labels[2]);
			labels[2].setLayoutX(960);
			plt[2].setLayoutX(960);
			/*
			 * Scroll-Zoom feature
			 * Changes the scaling of the planet parameters
			 * based on how far in/out the user has already zoomed.
			 */
			setOnScroll((ScrollEvent event) -> {
				double zoomFactor = 1.2;
				double deltaY = event.getDeltaY();
				if (deltaY < 0){
					zoomFactor = 2.0 - zoomFactor;
				}
				plt[2].setScaleX(plt[2].getScaleX() * zoomFactor);
				plt[2].setScaleY(plt[2].getScaleY() * zoomFactor);
			});
		});
		planet[3].setOnAction( e-> {
			for(int i = 0; i < display.length; i++) {
				getChildren().remove(display[i]);
			}
			String dat[] = mgr.earthData(3);
			for ( int i =0; i < display.length; i ++) {
				display[i] = new Text(dat[i]);
			}
			int x = 200;
			int y = 100;
			for (int i = 0; i < display.length; i++) {
				display[i].setLayoutX(x);
				display[i].setLayoutY(y);
				getChildren().add(display[i]);
				y = y + 20;
			}
			for(int i = 0; i < plt.length; i++) {
				getChildren().removeAll(plt[i], labels[i]);
			}
			getChildren().remove(str);
			getChildren().addAll(plt[3], labels[3]);
			labels[3].setLayoutX(960);
			plt[3].setLayoutX(960);
			/*
			 * Scroll-Zoom feature
			 * Changes the scaling of the planet parameters
			 * based on how far in/out the user has already zoomed.
			 */
			setOnScroll((ScrollEvent event) -> {
				double zoomFactor = 1.2;
				double deltaY = event.getDeltaY();
				if (deltaY < 0){
					zoomFactor = 2.0 - zoomFactor;
				}
				plt[3].setScaleX(plt[3].getScaleX() * zoomFactor);
				plt[3].setScaleY(plt[3].getScaleY() * zoomFactor);
			});
		});
		planet[4].setOnAction( e-> {
			for(int i = 0; i < display.length; i++) {
				getChildren().remove(display[i]);
			}
			String dat[] = mgr.earthData(4);
			for ( int i =0; i < display.length; i ++) {
				display[i] = new Text(dat[i]);
			}
			int x = 200;
			int y = 100;
			for (int i = 0; i < display.length; i++) {
				display[i].setLayoutX(x);
				display[i].setLayoutY(y);
				getChildren().add(display[i]);
				y = y + 20;
			}
			for(int i = 0; i < plt.length; i++) {
				getChildren().removeAll(plt[i], labels[i]);
			}
			getChildren().remove(str);
			getChildren().addAll(plt[4], labels[4]);
			labels[4].setLayoutX(960);
			plt[4].setLayoutX(960);
			/*
			 * Scroll-Zoom feature
			 * Changes the scaling of the planet parameters
			 * based on how far in/out the user has already zoomed.
			 */
			setOnScroll((ScrollEvent event) -> {
				double zoomFactor = 1.2;
				double deltaY = event.getDeltaY();
				if (deltaY < 0){
					zoomFactor = 2.0 - zoomFactor;
				}
				plt[4].setScaleX(plt[4].getScaleX() * zoomFactor);
				plt[4].setScaleY(plt[4].getScaleY() * zoomFactor);
			});
		});
		planet[5].setOnAction( e-> {
			for(int i = 0; i < display.length; i++) {
				getChildren().remove(display[i]);
			}
			String dat[] = mgr.earthData(5);
			for ( int i =0; i < display.length; i ++) {
				display[i] = new Text(dat[i]);
			}
			int x = 200;
			int y = 100;
			for (int i = 0; i < display.length; i++) {
				display[i].setLayoutX(x);
				display[i].setLayoutY(y);
				getChildren().add(display[i]);
				y = y + 20;
			}
			for(int i = 0; i < plt.length; i++) {
				getChildren().removeAll(plt[i], labels[i]);
			}
			getChildren().remove(str);
			getChildren().addAll(plt[5], labels[5]);
			labels[5].setLayoutX(960);
			plt[5].setLayoutX(960);
			/*
			 * Scroll-Zoom feature
			 * Changes the scaling of the planet parameters
			 * based on how far in/out the user has already zoomed.
			 */
			setOnScroll((ScrollEvent event) -> {
				double zoomFactor = 1.2;
				double deltaY = event.getDeltaY();
				if (deltaY < 0){
					zoomFactor = 2.0 - zoomFactor;
				}
				plt[5].setScaleX(plt[5].getScaleX() * zoomFactor);
				plt[5].setScaleY(plt[5].getScaleY() * zoomFactor);
			});
		});
		planet[6].setOnAction( e-> {
			for(int i = 0; i < display.length; i++) {
				getChildren().remove(display[i]);
			}
			String dat[] = mgr.earthData(6);
			for ( int i =0; i < display.length; i ++) {
				display[i] = new Text(dat[i]);
			}
			int x = 200;
			int y = 100;
			for (int i = 0; i < display.length; i++) {
				display[i].setLayoutX(x);
				display[i].setLayoutY(y);
				getChildren().add(display[i]);
				y = y + 20;
			}
			for(int i = 0; i < plt.length; i++) {
				getChildren().removeAll(plt[i], labels[i]);
			}
			getChildren().remove(str);
			getChildren().addAll(plt[6], labels[6]);
			labels[6].setLayoutX(960);
			plt[6].setLayoutX(960);
			/*
			 * Scroll-Zoom feature
			 * Changes the scaling of the planet parameters
			 * based on how far in/out the user has already zoomed.
			 */
			setOnScroll((ScrollEvent event) -> {
				double zoomFactor = 1.2;
				double deltaY = event.getDeltaY();
				if (deltaY < 0){
					zoomFactor = 2.0 - zoomFactor;
				}
				plt[6].setScaleX(plt[6].getScaleX() * zoomFactor);
				plt[6].setScaleY(plt[6].getScaleY() * zoomFactor);
			});
		});
		planet[7].setOnAction( e-> {
			for(int i = 0; i < display.length; i++) {
				getChildren().remove(display[i]);
			}
			String dat[] = mgr.earthData(7);
			for ( int i =0; i < display.length; i ++) {
				display[i] = new Text(dat[i]);
			}
			int x = 200;
			int y = 100;
			for (int i = 0; i < display.length; i++) {
				display[i].setLayoutX(x);
				display[i].setLayoutY(y);
				getChildren().add(display[i]);
				y = y + 20;
			}
			for(int i = 0; i < plt.length; i++) {
				getChildren().removeAll(plt[i], labels[i]);
			}
			getChildren().remove(str);
			getChildren().addAll(plt[7], labels[7]);
			labels[7].setLayoutX(960);
			plt[7].setLayoutX(960);
			/*
			 * Scroll-Zoom feature
			 * Changes the scaling of the planet parameters
			 * based on how far in/out the user has already zoomed.
			 */
			setOnScroll((ScrollEvent event) -> {
				double zoomFactor = 1.2;
				double deltaY = event.getDeltaY();
				if (deltaY < 0){
					zoomFactor = 2.0 - zoomFactor;
				}
				plt[7].setScaleX(plt[7].getScaleX() * zoomFactor);
				plt[7].setScaleY(plt[7].getScaleY() * zoomFactor);
			});
		});
		star.setOnAction( e-> {
			for(int i = 0; i < display.length; i++) {
				getChildren().remove(display[i]);
			}
			String dat[] = mgr.sunData();
			for ( int i =0; i < display.length; i ++) {
				display[i] = new Text(dat[i]);
			}
			int x = 200;
			int y = 100;
			for (int i = 0; i < display.length; i++) {
				display[i].setLayoutX(x);
				display[i].setLayoutY(y);
				getChildren().add(display[i]);
				y = y + 20;
			}
			for(int i = 0; i < plt.length; i++) {
				getChildren().removeAll(plt[i], labels[i]);
			}
			getChildren().remove(str);
			getChildren().add(str);
			/*
			 * Scroll-Zoom feature
			 * Changes the scaling of the planet parameters
			 * based on how far in/out the user has already zoomed.
			 */
			setOnScroll((ScrollEvent event) -> {
				double zoomFactor = 1.2;
				double deltaY = event.getDeltaY();
				if (deltaY < 0){
					zoomFactor = 2.0 - zoomFactor;
				}
				str.setScaleX(str.getScaleX() * zoomFactor);
				str.setScaleY(str.getScaleY() * zoomFactor);
			});
		});
	}
	/** Initiates the back to main menu button
	 *
	 */
	public void mainMenu() {
		btmm.setLayoutX(30);
		btmm.setLayoutY(15);
		btmm.setScaleX(1.5);
		btmm.setScaleY(1.5);
		getChildren().add(btmm);

		// will redraw all the buttons in the start method
		btmm.setOnAction(e-> {
			getChildren().clear();
			start();
			pressed = false;
			if(confirmClicked > 3)
				confirmClicked = 0;
		});
	}

	public void importButton() {
		Button defaultButton = new Button("Use Kepler Data");
		defaultButton.setLayoutX(880);
		defaultButton.setLayoutY(300);
		defaultButton.setScaleX(1.5);
		defaultButton.setScaleY(1.5);
		defaultButton.setMinSize(150, 0);
		defaultButton.setOnAction(e -> {
			getChildren().clear();
			setBackground(null);
			if(runImport == true) {
				mgr.importDataImport();
				mgr.getHostNameArray();
				runImport = false;
				runOwnImport = true;
			}
			drawKeplerDropDown();
			drawKeplerData();
			mainMenu();
		});

		Button ownFileButton = new Button("Use Own File");
		ownFileButton.setLayoutX(880);
		ownFileButton.setLayoutY(500);
		ownFileButton.setScaleX(1.5);
		ownFileButton.setScaleY(1.5);
		ownFileButton.setMinSize(150, 0);
		ownFileButton.setOnAction(e -> {
			getChildren().clear();
			setBackground(null);
			if(runOwnImport == true) {
				mgr.importDataOwnFile();
				mgr.getHostNameArray();
				runOwnImport = false;
				runImport = true;
			}
			drawKeplerDropDown();
			drawKeplerData();
			mainMenu();
		});
		getChildren().addAll(defaultButton, ownFileButton);
	}

	public void drawKeplerDropDown() {
		String names[] = mgr.getKeplerDropDown();
		MenuBar Stars = new MenuBar();
		Menu Systems = new Menu("Kepler Systems");
		for(int i = 0; i < names.length; i++) {
			MenuItem name = new MenuItem(names[i]);
			Systems.getItems().add(name);
		}
		Stars.getMenus().add(Systems);
		Stars.setLayoutX(1700);
		Stars.setScaleX(1.5);
		Stars.setScaleY(1.5);
		getChildren().add(Stars);
	}

	/**gets user input star name, then gets data from arraylists in import class.
	 * @param void
	 */
	public void drawKeplerData() {
		TextField System = new TextField();
		System.setPromptText("Input Star Sytem");
		System.setLayoutX(600);
		System.setLayoutY(50);
		systemInput.setLayoutX(800);
		systemInput.setLayoutY(50);
		getChildren().addAll(System, systemInput);
		systemInput.setOnAction( e-> {
			keplerSystemName = String.valueOf(System.getText());
			try {
				mgr.generatePlanetList(keplerSystemName);
				getChildren().clear();
				mainMenu();
				menuBar.getMenus().clear();
				Planets.getItems().clear();
				Stars.getItems().clear();
				drawKeplerDropDown();
				drawKeplerDataCont();
			}catch (Exception k) {
				Text error = new Text("Star System Does Not Exist");
				error.setLayoutX(643);
				error.setLayoutY(30);
				error.setScaleX(1.5);
				error.setScaleY(1.5);
				error.setFill(Color.RED);
				getChildren().add(error);
			}
			drawKeplerData();
		});
	}
	/** populates the screen with the star system as well as buttons to navigate between objects
	 * @param void
	 */
	public void drawKeplerDataCont() {
		Button reset = new Button("Reset View");
		reset.setLayoutX(190);
		reset.setLayoutY(15);
		reset.setScaleX(1.5);
		reset.setScaleY(1.5);
		getChildren().add(reset);
		reset.setOnAction(e -> {
			mgr.generatePlanetList(keplerSystemName);
			getChildren().clear();
			mainMenu();
			menuBar.getMenus().clear();
			Planets.getItems().clear();
			Stars.getItems().clear();
			drawKeplerDropDown();
			drawKeplerDataCont();
			drawKeplerData();
		});
		plt = new Circle[mgr.planetList.size()];
		String keplerSystem[] = new String[mgr.planetList.size()];
		planet = new MenuItem[mgr.planetList.size()];
		for(int i = 0; i < mgr.planetList.size(); i++) {
			keplerSystem[i] = mgr.planetList.get(i);
		}
		int num = mgr.getIndex(keplerSystemName);
		//System.out.println(num);
		for (int i = 0; i < mgr.planetList.size(); i++) {
			labels[i] = new Label(keplerSystem[i]);
			plt[i] = mgr.keplerPlanetData(i + num);
			labels[i].setLayoutX(mgr.keplerPlanetData(i + num).getLayoutX());
			labels[i].setLayoutY(mgr.keplerPlanetData(i + num).getLayoutY());
			labels[i].setTextFill(Color.RED);
			getChildren().addAll(plt[i], labels[i]);
		}
		getChildren().add(str = mgr.keplerStarData(num));
		for(int i = 0; i < keplerSystem.length; i++) {
			planet[i] = new MenuItem(keplerSystem[i]);
			Planets.getItems().add(planet[i]);
		}
		star = new MenuItem(mgr.listStrName(num));
		Stars.getItems().add(star);
		display = new Text[4];
		menuBar.getMenus().addAll(Planets, Stars);
		getChildren().add(menuBar);
		menuBar.setLayoutY(15);
		menuBar.setLayoutX(350);
		menuBar.setScaleX(1.5);
		menuBar.setScaleY(1.5);
		setOnScroll((ScrollEvent event) -> {
			double zoomFactor = 1.05;
			double deltaY = event.getDeltaY();
			if (deltaY < 0){
				zoomFactor = 2.0 - zoomFactor;
			}
			str.setLayoutX(str.getLayoutX() * zoomFactor);
			for (int i=0; i<plt.length; i++) {
				plt[i].setScaleX(plt[i].getScaleX() * zoomFactor);
				plt[i].setScaleY(plt[i].getScaleY() * zoomFactor);
				if ((plt[i].getLayoutX() / zoomFactor) > str.getLayoutX()) {
					plt[i].setLayoutX(plt[i].getLayoutX() * zoomFactor);
					labels[i].setLayoutX(labels[i].getLayoutX() * zoomFactor);
				} else {
					plt[i].setLayoutX(plt[i].getLayoutX() * zoomFactor);
					labels[i].setLayoutX(labels[i].getLayoutX() * zoomFactor);
				}
			}
			str.setScaleX(str.getScaleX() * zoomFactor);
			str.setScaleY(str.getScaleY() * zoomFactor);
		});
		planet[0].setOnAction( e-> {
			for(int i = 0; i < display.length; i++) {
				getChildren().remove(display[i]);
			}
			String dat[] = mgr.keplerData(num);
			for ( int i =0; i < dat.length; i ++) {
				display[i] = new Text(dat[i]);
			}
			int x = 200;
			int y = 100;
			for (int i = 0; i < display.length; i++) {
				display[i].setLayoutX(x);
				display[i].setLayoutY(y);
				getChildren().add(display[i]);
				y = y + 20;
			}
			for(int i = 0; i < plt.length; i++) {
				getChildren().removeAll(plt[i], labels[i]);
			}
			getChildren().remove(str);
			getChildren().addAll(plt[0], labels[0]);
			labels[0].setLayoutX(960);
			plt[0].setLayoutX(960);
			/*
			 * Scroll-Zoom feature
			 * Changes the scaling of the planet parameters
			 * based on how far in/out the user has already zoomed.
			 */
			setOnScroll((ScrollEvent event) -> {
				double zoomFactor = 1.2;
				double deltaY = event.getDeltaY();
				if (deltaY < 0){
					zoomFactor = 2.0 - zoomFactor;
				}
				plt[0].setScaleX(plt[0].getScaleX() * zoomFactor);
				plt[0].setScaleY(plt[0].getScaleY() * zoomFactor);
			});
		});
		try {
			planet[1].setOnAction( e-> {
				for(int i = 0; i < display.length; i++) {
					getChildren().remove(display[i]);
				}
				String dat[] = mgr.keplerData(num + 1);
				for ( int i =0; i < dat.length; i ++) {
					display[i] = new Text(dat[i]);
				}
				int x = 200;
				int y = 100;
				for (int i = 0; i < display.length; i++) {
					display[i].setLayoutX(x);
					display[i].setLayoutY(y);
					getChildren().add(display[i]);
					y = y + 20;
				}
				for(int i = 0; i < plt.length; i++) {
					getChildren().removeAll(plt[i], labels[i]);
				}
				getChildren().remove(str);
				getChildren().addAll(plt[1], labels[1]);
				labels[1].setLayoutX(960);
				plt[1].setLayoutX(960);
				/*
				 * Scroll-Zoom feature
				 * Changes the scaling of the planet parameters
				 * based on how far in/out the user has already zoomed.
				 */
				setOnScroll((ScrollEvent event) -> {
					double zoomFactor = 1.2;
					double deltaY = event.getDeltaY();
					if (deltaY < 0){
						zoomFactor = 2.0 - zoomFactor;
					}
					plt[1].setScaleX(plt[1].getScaleX() * zoomFactor);
					plt[1].setScaleY(plt[1].getScaleY() * zoomFactor);
				});

			});
		} catch (Exception e) {
		}try {
			planet[2].setOnAction( e-> {
				for(int i = 0; i < display.length; i++) {
					getChildren().remove(display[i]);
				}
				String dat[] = mgr.keplerData(num + 2);
				for ( int i =0; i < dat.length; i ++) {
					display[i] = new Text(dat[i]);
				}
				int x = 200;
				int y = 100;
				for (int i = 0; i < display.length; i++) {
					display[i].setLayoutX(x);
					display[i].setLayoutY(y);
					getChildren().add(display[i]);
					y = y + 20;
				}
				for(int i = 0; i < plt.length; i++) {
					getChildren().removeAll(plt[i], labels[i]);
				}
				getChildren().remove(str);
				getChildren().addAll(plt[2], labels[2]);
				labels[2].setLayoutX(960);
				plt[2].setLayoutX(960);
				/*
				 * Scroll-Zoom feature
				 * Changes the scaling of the planet parameters
				 * based on how far in/out the user has already zoomed.
				 */
				setOnScroll((ScrollEvent event) -> {
					double zoomFactor = 1.2;
					double deltaY = event.getDeltaY();
					if (deltaY < 0){
						zoomFactor = 2.0 - zoomFactor;
					}
					plt[2].setScaleX(plt[2].getScaleX() * zoomFactor);
					plt[2].setScaleY(plt[2].getScaleY() * zoomFactor);
				});
			});
		}catch (Exception e) {
		} try {
			planet[3].setOnAction( e-> {
				for(int i = 0; i < display.length; i++) {
					getChildren().remove(display[i]);
				}
				String dat[] = mgr.keplerData(num + 3);
				for ( int i =0; i < dat.length; i ++) {
					display[i] = new Text(dat[i]);
				}
				int x = 200;
				int y = 100;
				for (int i = 0; i < display.length; i++) {
					display[i].setLayoutX(x);
					display[i].setLayoutY(y);
					getChildren().add(display[i]);
					y = y + 20;
				}
				for(int i = 0; i < plt.length; i++) {
					getChildren().removeAll(plt[i], labels[i]);
				}
				getChildren().remove(str);
				getChildren().addAll(plt[3], labels[3]);
				labels[3].setLayoutX(960);
				plt[3].setLayoutX(960);
				/*
				 * Scroll-Zoom feature
				 * Changes the scaling of the planet parameters
				 * based on how far in/out the user has already zoomed.
				 */
				setOnScroll((ScrollEvent event) -> {
					double zoomFactor = 1.2;
					double deltaY = event.getDeltaY();
					if (deltaY < 0){
						zoomFactor = 2.0 - zoomFactor;
					}
					plt[3].setScaleX(plt[3].getScaleX() * zoomFactor);
					plt[3].setScaleY(plt[3].getScaleY() * zoomFactor);
				});
			});
		}catch (Exception e) {
		} try {
			planet[4].setOnAction( e-> {
				for(int i = 0; i < display.length; i++) {
					getChildren().remove(display[i]);
				}
				String dat[] = mgr.keplerData(num + 4);
				for ( int i =0; i < dat.length; i ++) {
					display[i] = new Text(dat[i]);
				}
				int x = 200;
				int y = 100;
				for (int i = 0; i < display.length; i++) {
					display[i].setLayoutX(x);
					display[i].setLayoutY(y);
					getChildren().add(display[i]);
					y = y + 20;
				}
				for(int i = 0; i < plt.length; i++) {
					getChildren().removeAll(plt[i], labels[i]);
				}
				getChildren().remove(str);
				getChildren().addAll(plt[4], labels[4]);
				labels[4].setLayoutX(960);
				plt[4].setLayoutX(960);
				/*
				 * Scroll-Zoom feature
				 * Changes the scaling of the planet parameters
				 * based on how far in/out the user has already zoomed.
				 */
				setOnScroll((ScrollEvent event) -> {
					double zoomFactor = 1.2;
					double deltaY = event.getDeltaY();
					if (deltaY < 0){
						zoomFactor = 2.0 - zoomFactor;
					}
					plt[4].setScaleX(plt[4].getScaleX() * zoomFactor);
					plt[4].setScaleY(plt[4].getScaleY() * zoomFactor);
				});
			});
		}catch (Exception e) {
		}
		star.setOnAction( e-> {
			for(int i = 0; i < display.length; i++) {
				getChildren().remove(display[i]);
			}
			String dat[] = mgr.kStarInfo(num);
			for ( int i =0; i < display.length; i ++) {
				display[i] = new Text(dat[i]);
			}
			int x = 200;
			int y = 100;
			for (int i = 0; i < display.length; i++) {
				display[i].setLayoutX(x);
				display[i].setLayoutY(y);
				getChildren().add(display[i]);
				y = y + 20;
			}
			for(int i = 0; i < plt.length; i++) {
				getChildren().removeAll(plt[i], labels[i]);
			}
			getChildren().remove(str);
			getChildren().add(str);
			/*
			 * Scroll-Zoom feature
			 * Changes the scaling of the planet parameters
			 * based on how far in/out the user has already zoomed.
			 */
			setOnScroll((ScrollEvent event) -> {
				double zoomFactor = 1.2;
				double deltaY = event.getDeltaY();
				if (deltaY < 0){
					zoomFactor = 2.0 - zoomFactor;
				}
				str.setScaleX(str.getScaleX() * zoomFactor);
				str.setScaleY(str.getScaleY() * zoomFactor);
			});
		});

	}
}//end KeplerPane