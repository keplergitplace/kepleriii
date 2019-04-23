import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.Button;
/* To Do

    * screens: star type/size selection, planet type/size selection, add planets/distance selection, save screen
    * make the screen selection continous on seperate screens
    * button to confirm selection
    *

 */


public class SandBox extends Pane {

    private Circle planet = new Circle();
    private Circle star = new Circle();

    //private Button confirm = new Button("Confirm");
    //private int confirmClicked = 0;

    //private boolean addAnotherPlanet = true;

    /****************************First Screen Code*********************************/

    private Slider sizeOfStar = new Slider();

    private Label starSize = new Label("Size of star");

    /****************************First Screen Code*********************************/


    /****************************Second Screen Code*********************************/
    private Slider planets = new Slider();
    private Slider sizeOfPlanet = new Slider();

    private Label planetV = new Label("Planet Type: Default size");
    private Label starV = new Label("Size: Default (Earth size): ");
    private Label coloredBox = new Label();

    private int planetType;
    private boolean norm = false, tiny = false, gas = false;

    private Slider numPlanets = new Slider();

    private TextField distanceFS = new TextField();

    private Label numP = new Label("  planets to be spawned");
    private Label distance = new Label("  km from the main star");

    private int numOfPlanets;
    private float distanceFromSun;
    private double radius = 20;

    /****************************Second Screen Code*********************************/


    //boolean addAnotherPlanet
    // initializes the sand box
    public void initSandBox(Pane pane, int confirmClicked, boolean addAnotherPlanet) {

        if (addAnotherPlanet) {
            if (confirmClicked == 0) {

                starSizeAndName(pane);

            } else if (confirmClicked == 1) {

                planetTypeSizeSelect(pane);

            } else if (confirmClicked == 2) {

                // handled in kepler pane

            } else if (confirmClicked == 3) {

                // handled in kepler pane

            }
        }


    }

    // draws the star in the middle of the screen for first screen
    public void drawStar(Pane pane, double radius) {

        star.setRadius(radius);
        star.setCenterX(960);
        star.setCenterY(540);
        star.setFill(Color.YELLOW);
        pane.getChildren().add(star);

    }

    // spawns circle in the middle of selection screen
    public void drawPlanet(Pane pane, double radius) {

        planet.setRadius(radius);
        planet.setCenterX(960);
        planet.setCenterY(540);
        planet.setFill(javafx.scene.paint.Color.RED);
        pane.getChildren().add(planet);

    }

    // colored box for things
    public void drawColoredBox() {

        coloredBox.setLayoutX(0);
        coloredBox.setLayoutY(0);
        //coloredBox.setMaxSize(300, 1080);
        coloredBox.setMinSize(300, 1080);
        coloredBox.setStyle("-fx-background-color: #616161");
    }

    /****************************First Screen Code*********************************/

    // initializes slider to select size of star
    private void sliderForStarSize(Pane pane) {

        sizeOfStar.setShowTickMarks(true);
        sizeOfStar.setShowTickLabels(true);
        sizeOfStar.setSnapToTicks(true);
        sizeOfStar.setMinSize(290, 100);
        sizeOfStar.setMax(5);
        sizeOfStar.setMajorTickUnit(1);
        sizeOfStar.setMinorTickCount(0);
        sizeOfStar.setLayoutX(0);
        sizeOfStar.setLayoutY(540);
        sizeOfStar.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                int starSize = (int) sizeOfStar.getValue();

                switch (starSize) {
                    case 0:
                        star.setRadius(150);
                        break;

                    case 1:
                        star.setRadius(150 * 1.5);
                        break;
                    case 2:

                        star.setRadius(150 * 2);
                        break;
                    case 3:
                        star.setRadius(150 * 3);
                        break;
                    case 4:
                        star.setRadius(150 * 4);
                        break;
                    case 5:
                        star.setRadius(150 * 5);
                        break;
                    default:
                        System.out.println("something went wrong");
                        break;
                }
            }
        });

        pane.getChildren().add(sizeOfStar);

    }

    // initializes labels for first screen
    private void starScreenLabels(Pane pane) {

        starSize.setLayoutX(115);
        starSize.setLayoutY(520);
        starSize.setTextFill(Color.BLACK);

        pane.getChildren().add(starSize);

    }

    // init function of first scree (star screen)
    public void starSizeAndName(Pane pane) {

        drawStar(pane, 150);
        drawColoredBox();
        pane.getChildren().add(coloredBox);
        sliderForStarSize(pane);
        starScreenLabels(pane);

    }

    /****************************First Screen Code*********************************/

    /****************************Second Screen Code*********************************/
    // initialize sliders for second screen
    private void initSlidersForSizeType(Pane pane) {

        planets.setShowTickMarks(true);
        planets.setShowTickLabels(true);
        planets.setSnapToTicks(true);
        planets.setMaxSize(200, 100);
        planets.setMinSize(290, 100);
        planets.setMax(3);
        planets.setMajorTickUnit(1);
        planets.setMinorTickCount(0);
        planets.setLayoutX(0);
        planets.setLayoutY(440);
        planets.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {

                planetType = (int) planets.getValue();

                switch (planetType) {
                    case 0:
                        planetV.setText("Planet Type: Default size");
                        norm = true;
                        tiny = false;
                        gas = false;
                        sizeOfPlanet.setValue(0);
                        break;

                    case 1:
                        planetV.setText("Planet Type: Earth Like");
                        norm = true;
                        tiny = false;
                        gas = false;
                        planet.setRadius(20);
                        sizeOfPlanet.setValue(0);
                        break;
                    case 2:
                        planetV.setText("Planet Type: Small/Rocky");
                        norm = false;
                        tiny = true;
                        gas = false;
                        planet.setRadius(10);
                        sizeOfPlanet.setValue(0);
                        break;
                    case 3:
                        planetV.setText("Planet Type: Gas Giant");
                        norm = false;
                        tiny = false;
                        gas = true;
                        planet.setRadius(75);
                        sizeOfPlanet.setValue(0);
                        break;
                    default:
                        System.out.println("something went wrong");
                        break;
                }


            }
        });

        sizeOfPlanet.setShowTickMarks(true);
        sizeOfPlanet.setShowTickLabels(true);
        sizeOfPlanet.setSnapToTicks(true);
        sizeOfPlanet.setMinSize(290, 100);
        sizeOfPlanet.setMax(5);
        sizeOfPlanet.setMajorTickUnit(1);
        sizeOfPlanet.setMinorTickCount(0);
        sizeOfPlanet.setLayoutX(0);
        sizeOfPlanet.setLayoutY(540);
        sizeOfPlanet.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                int planetSize = (int) sizeOfPlanet.getValue();

                switch (planetSize) {
                    case 0:
                        starV.setText("Size: Default (Earth size)");
                        if (norm) {

                            radius = 20;
                            planet.setRadius(radius);

                        } else if (tiny) {

                            radius = 10;
                            planet.setRadius(radius);

                        } else if (gas) {

                            radius = 75;
                            planet.setRadius(radius);

                        }

                        break;

                    case 1:
                        starV.setText("Size: 1.5 times Earth size");
                        if (norm) {

                            radius = 20 * 1.5;
                            planet.setRadius(radius);

                        } else if (tiny) {

                            radius = 10 * 1.5;
                            planet.setRadius(radius);

                        } else if (gas) {

                            radius = 75 * 1.5;
                            planet.setRadius(radius);

                        }
                        break;
                    case 2:
                        starV.setText("Size: 2 times Earth size");
                        if (norm) {

                            radius = 20 * 2;
                            planet.setRadius(radius);

                        } else if (tiny) {

                            radius = 10 * 2;
                            planet.setRadius(radius);

                        } else if (gas) {

                            radius = 75 * 2;
                            planet.setRadius(radius);

                        }
                        break;
                    case 3:
                        starV.setText("Size: 3 times Earth size");
                        if (norm) {

                            radius = 20 * 3;
                            planet.setRadius(radius);

                        } else if (tiny) {

                            radius = 10 * 3;
                            planet.setRadius(radius);

                        } else if (gas) {

                            radius = 75 * 3;
                            planet.setRadius(radius);

                        }
                        break;
                    case 4:
                        starV.setText("Size: 4 times Earth size");
                        if (norm) {

                            radius = 20 * 4;
                            planet.setRadius(radius);

                        } else if (tiny) {

                            radius = 10 * 4;
                            planet.setRadius(radius);

                        } else if (gas) {

                            radius = 75 * 4;
                            planet.setRadius(radius);

                        }
                        break;
                    case 5:
                        starV.setText("Size: 5 times Earth size");
                        if (norm) {

                            radius = 20 * 5;
                            planet.setRadius(radius);

                        } else if (tiny) {

                            radius = 10 * 5;
                            planet.setRadius(radius);

                        } else if (gas) {

                            radius = 75 * 5;
                            planet.setRadius(radius);

                        }
                        break;
                    default:
                        System.out.println("something went wrong");
                        break;
                }
            }
        });

        pane.getChildren().addAll(planets, sizeOfPlanet);
    }

    // initialize labels for second Screen
    public void lablesForSecondScreen(Pane pane) {

        planetV.setLayoutX(75);
        planetV.setLayoutY(420);
        planetV.setTextFill(Color.BLACK);

        starV.setLayoutX(75);
        starV.setLayoutY(520);
        starV.setTextFill(Color.BLACK);

        distance.setLayoutX(75);
        distance.setLayoutY(620);
        distance.setTextFill(Color.BLACK);

        pane.getChildren().addAll(planetV, starV, distance);
    }

    // initialies textfield for second screen
    public void distanceTextField(Pane pane) {

        distanceFS.setLayoutX(0);
        distanceFS.setLayoutY(650);
        distanceFS.setMinSize(290, 25);
        distanceFS.setPromptText("Enter Distance: ");
        distanceFS.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {

                if (!newValue.matches("\\d*")) {
                    distanceFS.setText(newValue.replaceAll("[^\\d]", ""));
                }

                distance.setText(distanceFS.getText() + " km from the main star");
                distanceFromSun = Float.parseFloat(distanceFS.getText());

            }
        });

        pane.getChildren().add(distanceFS);
    }

    // getters for values set using the sliders and text field
    public int getNumOfPlanets() {
        return numOfPlanets;
    }

    public float getDistanceFromSun() {
        return distanceFromSun;
    }

    // screen for planet type and size selection
    public void planetTypeSizeSelect(Pane pane) {

        pane.getChildren().clear();
        drawColoredBox();
        pane.getChildren().add(coloredBox);
        drawPlanet(pane, radius);
        initSlidersForSizeType(pane);
        lablesForSecondScreen(pane);
        distanceTextField(pane);

    }

    /****************************Second Screen Code*********************************/

}
