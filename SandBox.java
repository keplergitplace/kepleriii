import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.beans.binding.Bindings;
/* To Do

    * screens: type/size selection, add planets/distance selection, save screen
    * make the screen selection continous on seperate screens
    * button to confirm selection
    *

 */


public class SandBox
{

    //This is just a prototype layout. Eventually we want to use the value of the sliders to correspond to the number
    // of the desired planets, moons, or stars and then draw them. Along with a save functionality.

    private Circle planet = new Circle();

    //private Button confirm = new Button("Confirm");

    /****************************First Screen Code*********************************/
    private Slider planets = new Slider();
    private Slider stars = new Slider();

    private Label planetV = new Label("Planet Type: Default size");
    private Label starV = new Label("Size: Default (Earth size): ");
    private Label coloredBox = new Label();
    private Label name = new Label("Default");

    private TextField input = new TextField();

    private int planetType;
    private boolean norm = false, tiny = false, gas = false;
    /****************************First Screen Code*********************************/

    /****************************Second Screen Code*********************************/

    private Slider numPlanets = new Slider();

    private TextField distanceFS = new TextField();

    private Label numP = new Label("  planets to be spawned");
    private Label distance = new Label("  [unit] from the main star");

    private int numOfPlanets;
    private float distanceFromSun;
    private double radius = 20;

    /****************************Second Screen Code*********************************/

    /****************************Save Screen Code*********************************/

    /****************************Save Screen Code*********************************/

    public void initSandBox(Pane pane, int confirmClicked)
    {

            if (confirmClicked == 0) {

                planetTypeSizeSelect(pane);

            } else if (confirmClicked == 1) {

                numOfPlanetsAndDistanceFromStar(pane);

            } else if (confirmClicked == 2) {
                // switch to save screen
                System.out.println("save screen");
            } else if (confirmClicked == 3) {

                // switch to display of created sandbox?
                System.out.println("go created sandbox");

            }
        }




    // spawns circle in the middle of selection screen
    public void drawPlanet(Pane pane, double radius)
    {

       planet.setRadius(radius);
       planet.setCenterX(960);
       planet.setCenterY(540);
       planet.setFill(javafx.scene.paint.Color.RED);
       pane.getChildren().add(planet);

    }

    // colored box for things
    public void drawColoredBox()
    {

        coloredBox.setLayoutX(0);
        coloredBox.setLayoutY(0);
        //coloredBox.setMaxSize(300, 1080);
        coloredBox.setMinSize(300, 1080);
        coloredBox.setStyle("-fx-background-color: #838383");
    }

    /****************************First Screen Code*********************************/
    private void initSlidersForSizeType(Pane pane)
    {

        planets.setShowTickMarks(true);
        planets.setShowTickLabels(true);
        planets.setSnapToTicks(true);
        planets.setMaxSize(200, 100);
        planets.setMinSize(290,100);
        planets.setMax(3);
        planets.setMajorTickUnit(1);
        planets.setMinorTickCount(0);
        planets.setLayoutX(0);
        planets.setLayoutY(440);
        planets.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {

                planetType = (int) planets.getValue();

                switch(planetType)
                {
                    case 0:
                        planetV.setText("Planet Type: Default size");
                        norm = true;
                        tiny = false;
                        gas = false;
                        stars.setValue(0);
                        break;

                    case 1:
                        planetV.setText("Planet Type: Earth Like");
                        norm = true;
                        tiny = false;
                        gas = false;
                        planet.setRadius(20);
                        stars.setValue(0);
                        break;
                    case 2:
                        planetV.setText("Planet Type: Small/Rocky");
                        norm = false;
                        tiny = true;
                        gas = false;
                        planet.setRadius(10);
                        stars.setValue(0);
                        break;
                    case 3:
                        planetV.setText("Planet Type: Gas Giant");
                        norm = false;
                        tiny = false;
                        gas = true;
                        planet.setRadius(75);
                        stars.setValue(0);
                        break;
                    default:
                        System.out.println("something went wrong");
                        break;
                }


            }
        });

        stars.setShowTickMarks(true);
        stars.setShowTickLabels(true);
        stars.setSnapToTicks(true);
        stars.setMinSize(290,100);
        stars.setMax(5);
        stars.setMajorTickUnit(1);
        stars.setMinorTickCount(0);
        stars.setLayoutX(0);
        stars.setLayoutY(540);
        stars.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                int planetSize = (int) stars.getValue();

                switch(planetSize)
                {
                    case 0:
                        starV.setText("Size: Default (Earth size)");
                        if(norm)
                        {

                            radius = 20;
                            planet.setRadius(radius);

                        }
                        else if(tiny)
                        {

                            radius = 10;
                            planet.setRadius(radius);

                        }
                        else if(gas)
                        {

                            radius = 75;
                            planet.setRadius(radius);

                        }

                        break;

                    case 1:
                        starV.setText("Size: 1.5 times Earth size");
                        if(norm)
                        {

                            radius = 20 * 1.5;
                            planet.setRadius(radius);

                        }
                        else if(tiny)
                        {

                            radius = 10 * 1.5;
                            planet.setRadius(radius);

                        }
                        else if(gas)
                        {

                            radius = 75 * 1.5;
                            planet.setRadius(radius);

                        }
                        break;
                    case 2:
                        starV.setText("Size: 2 times Earth size");
                        if(norm)
                        {

                            radius = 20 * 2;
                            planet.setRadius(radius);

                        }
                        else if(tiny)
                        {

                            radius = 10 * 2;
                            planet.setRadius(radius);

                        }
                        else if(gas)
                        {

                            radius = 75 * 2;
                            planet.setRadius(radius);

                        }
                        break;
                    case 3:
                        starV.setText("Size: 3 times Earth size");
                        if(norm)
                        {

                            radius = 20 * 3;
                            planet.setRadius(radius);

                        }
                        else if(tiny)
                        {

                            radius = 10 * 3;
                            planet.setRadius(radius);

                        }
                        else if(gas)
                        {

                            radius = 75 * 3;
                            planet.setRadius(radius);

                        }
                        break;
                    case 4:
                        starV.setText("Size: 4 times Earth size");
                        if(norm)
                        {

                            radius = 20 * 4;
                            planet.setRadius(radius);

                        }
                        else if(tiny)
                        {

                            radius = 10 * 4;
                            planet.setRadius(radius);

                        }
                        else if(gas)
                        {

                            radius = 75 * 4;
                            planet.setRadius(radius);

                        }
                        break;
                    case 5:
                        starV.setText("Size: 5 times Earth size");
                        if(norm)
                        {

                            radius = 20 * 5;
                            planet.setRadius(radius);

                        }
                        else if(tiny)
                        {

                            radius = 10 * 5;
                            planet.setRadius(radius);

                        }
                        else if(gas)
                        {

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

        pane.getChildren().addAll(planets, stars);
    }

    public void lablesForFirstScreen(Pane pane)
    {

        planetV.setLayoutX(75);
        planetV.setLayoutY(420);

        starV.setLayoutX(75);
        starV.setLayoutY(520);

        name.setLayoutX(125);
        name.setLayoutY(620);

        input.setLayoutX(0);
        input.setLayoutY(640);
        input.setMinSize(290,25);
        input.setPromptText("Planet name: ");
        input.setOnAction(e -> {

            name.setText(input.getText());

        });


        pane.getChildren().addAll(planetV, starV, input, name);
    }

    // screen for planet type and size selection
    public void planetTypeSizeSelect(Pane pane)
    {

        drawColoredBox();
        pane.getChildren().add(coloredBox);
        //spawnConfirmButton(pane);
        drawPlanet(pane, radius);
        initSlidersForSizeType(pane);
        lablesForFirstScreen(pane);

    }

    /****************************First Screen Code*********************************/


    /****************************Second Screen Code*********************************/

    public void initSliderForSS(Pane pane)
    {

        numPlanets.setShowTickMarks(true);
        numPlanets.setShowTickLabels(true);
        numPlanets.setSnapToTicks(true);
        numPlanets.setMaxSize(200, 100);
        numPlanets.setMinSize(290,100);
        numPlanets.setMax(10);
        numPlanets.setMajorTickUnit(1);
        numPlanets.setMinorTickCount(0);
        numPlanets.setLayoutX(0);
        numPlanets.setLayoutY(540);
        // not currently wokring correctly
        numPlanets.valueProperty().addListener(e-> {

            numOfPlanets = (int) planets.getValue();

            numP.setText(numOfPlanets + " planets to be spawned");
        });

        numPlanets.valueProperty().addListener(e-> {


        });

        pane.getChildren().add(numPlanets);

    }

    public void distanceTextField(Pane pane)
    {

        distanceFS.setLayoutX(0);
        distanceFS.setLayoutY(640);
        distanceFS.setMinSize(290,25);
        distanceFS.setPromptText("Enter Distance: ");
        distanceFS.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {

                if (!newValue.matches("\\d*")) {
                    distanceFS.setText(newValue.replaceAll("[^\\d]", ""));
                }

                distance.setText(distanceFS.getText() + " [unit] from the main star");
                distanceFromSun = Float.parseFloat(distanceFS.getText());

            }
        });

        pane.getChildren().add(distanceFS);
    }

    public void lablesForSS(Pane pane)
    {

        numP.setLayoutX(75);
        numP.setLayoutY(520);

        distance.setLayoutX(75);
        distance.setLayoutY(620);

        pane.getChildren().addAll(numP, distance);

    }

    public int getNumOfPlanets() { return numOfPlanets; }

    public float getDistanceFromSun() { return distanceFromSun; }


    public void numOfPlanetsAndDistanceFromStar(Pane pane)
    {

        pane.getChildren().clear();
        drawColoredBox();
        pane.getChildren().add(coloredBox);
        //spawnConfirmButton(pane);
        drawPlanet(pane, radius);
        distanceTextField(pane);
        initSliderForSS(pane);
        lablesForSS(pane);


    }

    /****************************Second Screen Code*********************************/


    /****************************Save Screen Code*********************************/

    public void loadSaveScreen()
    {



    }

    /****************************Save Screen Code*********************************/


}

