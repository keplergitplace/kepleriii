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
    public double setStarRadius;
    public double[] setDensityRange = new double [5];
    public double[] setPlanetRadius = new double [5];
    public double setStarMass;
    public double setStarTemp;
    public double[] setPlanetSemiMajor = new double [5];
    public double[] setPlanetMass = new double [5];

    //private Button confirm = new Button("Confirm");
    //private int confirmClicked = 0;

    //private boolean addAnotherPlanet = true;

    /****************************First Screen Code*********************************/

    private Slider sizeOfStar = new Slider();
    private Slider massOfStar = new Slider();
    private Slider tempOfStar = new Slider();

    private Label starSize = new Label("Size of star");
    private Label starMass = new Label("Mass of star: Half Sun");
    private Label starTemp = new Label("Temp of star: Cool");
    

    /****************************First Screen Code*********************************/


    /****************************Second Screen Code*********************************/
    private Slider planets = new Slider();
    private Slider sizeOfPlanet = new Slider();
    private Slider semiMajorOfPlanet = new Slider();
    private Slider massOfPlanet = new Slider();

    private Label planetV = new Label("Planet Type: Small/Rocky");
    private Label starV = new Label("Size: Default (Earth size): ");
    private Label coloredBox = new Label();
    private Label sMPlanet = new Label("Distance from Star to Planet: 1 AU");
    private Label mPlanet = new Label("Mass of Planet: Mercury");    

    private int planetType;
    private boolean norm = false, tiny = false, gas = false;

    private Slider numPlanets = new Slider();

    private TextField distanceFS = new TextField();

    private Label numP = new Label("  planets to be spawned");

    private int numOfPlanets = 0;
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
        pane.getChildren().add(star);

    }

    // spawns circle in the middle of selection screen
    public void drawPlanet(Pane pane, double radius) {

        planet.setRadius(radius);
        planet.setCenterX(960);
        planet.setCenterY(540);
        pane.getChildren().add(planet);

    }

    // colored box for things
    public void drawColoredBox() {

        coloredBox.setLayoutX(0);
        coloredBox.setLayoutY(0);
        //coloredBox.setMaxSize(300, 1080);
        coloredBox.setMinSize(300, 1080);
        coloredBox.setStyle("-fx-background-color: #FFFFFF");
    }

    /****************************First Screen Code*********************************/

    // initializes slider to select size of star
    private void sliderForStarSize(Pane pane) {

        sizeOfStar.setShowTickMarks(true);
        sizeOfStar.setShowTickLabels(true);
        sizeOfStar.setSnapToTicks(true);
        sizeOfStar.setMinSize(290, 100);
        sizeOfStar.setMax(4);
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
                        setStarRadius = 0.5;
                        break;

                    case 1:
                        star.setRadius(150 * 1.5);
                        setStarRadius = (1);
                        break;
                    case 2:

                        star.setRadius(150 * 2);
                        setStarRadius = (25);
                        break;
                    case 3:
                        star.setRadius(150 * 3);
                        setStarRadius = (50);
                        break;
                    case 4:
                        star.setRadius(150 * 4);
                        setStarRadius = (100);
                        break;
                    default:
                        System.out.println("something went wrong");
                        break;
                }
            }
        });

        
        massOfStar.setShowTickMarks(true);
        massOfStar.setShowTickLabels(true);
        massOfStar.setSnapToTicks(true);
        massOfStar.setMinSize(290, 100);
        massOfStar.setMax(3);
        massOfStar.setMajorTickUnit(1);
        massOfStar.setMinorTickCount(0);
        massOfStar.setLayoutX(0);
        massOfStar.setLayoutY(630);
        massOfStar.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
            	int sMass = (int) massOfStar.getValue();
            	
            	switch (sMass) {
            		case 0: 
            			setStarMass = 0.5;
            			starMass.setText("Mass of star: Half Sun");
            			break;
            		case 1:
            			setStarMass = 1;
            			starMass.setText("Mass of star: Sun");
            			break;
            		case 2:
            			setStarMass = 5;
            			starMass.setText("Mass of star: Five times Sun");
            			break;
            		case 3:
            			setStarMass = 10;
            			starMass.setText("Mass of star: Ten times Sun");
            			break;
            	}
                                
              }
            }); 
            
            	
            
        
        tempOfStar.setShowTickMarks(true);
        tempOfStar.setShowTickLabels(true);
        tempOfStar.setSnapToTicks(true);
        tempOfStar.setMinSize(290, 100);
        tempOfStar.setMax(3);
        tempOfStar.setMajorTickUnit(1);
        tempOfStar.setMinorTickCount(0);
        tempOfStar.setLayoutX(0);
        tempOfStar.setLayoutY(440);
        tempOfStar.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
            	int sTemp = (int) tempOfStar.getValue();
            	
            	switch (sTemp) {
            		case 0: 
            			double temperature = 1000;
            			setStarTemp = temperature;
            			star.setFill(Color.DARKGOLDENROD);
            			starTemp.setText("Temp of star: Cool");
            			break;
            		case 1:
            			double temperature2 = 2500;
            			setStarTemp = temperature2;
            			star.setFill(Color.DARKORANGE);
            			starTemp.setText("Temp of star: Warm");
            			break;
            		case 2:
            			double temperature3 = 6000;
            			setStarTemp = temperature3;
            			star.setFill(Color.GOLD);
            			starTemp.setText("Temp of star: Hot");
            			break;
            		case 3:
            			double temperature4 = 20000;
            			setStarTemp = temperature4;
            			star.setFill(Color.CORNFLOWERBLUE);
            			starTemp.setText("Temp of star: Very Hot");
            			break;
            	}
                                
              }
            }); 
        
        
        pane.getChildren().addAll(sizeOfStar, massOfStar, tempOfStar);

    }

    // initializes labels for first screen
    private void starScreenLabels(Pane pane) {

        starSize.setLayoutX(75);
        starSize.setLayoutY(520);
        
        starTemp.setLayoutX(75);
        starTemp.setLayoutY(420);

        starMass.setLayoutX(75);
        starMass.setLayoutY(620);
        
        pane.getChildren().addAll(starSize, starTemp, starMass);

    }

    // init function of first screen (star screen)
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
        planets.setMax(1);
        planets.setMajorTickUnit(1);
        planets.setMinorTickCount(0);
        planets.setLayoutX(0);
        planets.setLayoutY(240);
        planets.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {

                planetType = (int) planets.getValue();

                switch (planetType) {
                    case 0:
                        planetV.setText("Planet Type: Small/Rocky");
                        norm = false;
                        tiny = true;
                        gas = false;
                        planet.setRadius(10);
                        sizeOfPlanet.setValue(0);
                        planet.setFill(Color.DARKORANGE);
                        
                        break;
                    case 1:
                        planetV.setText("Planet Type: Gas Giant");
                        norm = false;
                        tiny = false;
                        gas = true;
                        planet.setRadius(75);
                        sizeOfPlanet.setValue(0);
                        planet.setFill(Color.PALETURQUOISE);
                        
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
                        starV.setText("Size: Earth size");
                        if (tiny) {

                            radius = 10;
                            planet.setRadius(radius);
                            setPlanetRadius[(numOfPlanets - 1)] = radius;
                        } else {

                            radius = 75;
                            planet.setRadius(radius);
                            setPlanetRadius[(numOfPlanets - 1)] = radius;
                        }
                        
                        break;

                    case 1:
                        starV.setText("Size: 1.5 times Earth size");
                        if (tiny) {

                            radius = 10 * 1.5;
                            planet.setRadius(radius);
                            setPlanetRadius[(numOfPlanets - 1)] = radius;
                        } else {

                            radius = 75 * 1.5;
                            planet.setRadius(radius);
                            setPlanetRadius[(numOfPlanets - 1)] = radius;
                        }

                        break;
                    case 2:
                        starV.setText("Size: 2 times Earth size");
                        if (tiny) {

                            radius = 10 * 2;
                            planet.setRadius(radius);
                            setPlanetRadius[(numOfPlanets - 1)] = radius;
                        } else {

                            radius = 75 * 2;
                            planet.setRadius(radius);
                            setPlanetRadius[(numOfPlanets - 1)] = radius;
                        }
                        
                        break;
                    case 3:
                        starV.setText("Size: 3 times Earth size");
                        if (tiny) {

                            radius = 10 * 3;
                            planet.setRadius(radius);
                            setPlanetRadius[(numOfPlanets - 1)] = radius;
                        } else{

                            radius = 75 * 3;
                            planet.setRadius(radius);
                            setPlanetRadius[(numOfPlanets - 1)] = radius;
                        }

                        break;
                    case 4:
                        starV.setText("Size: 4 times Earth size");
                        if (tiny) {

                            radius = 10 * 4;
                            planet.setRadius(radius);
                         //   setPlanetRadius = new double[5];
                            setPlanetRadius[(numOfPlanets - 1)] = radius;
                        } else {

                            radius = 75 * 4;
                            planet.setRadius(radius);
                            setPlanetRadius[(numOfPlanets - 1)] = radius;
                        }
                        
                        break;
                    case 5:
                        starV.setText("Size: 5 times Earth size");
                        if (tiny) {

                            radius = 10 * 5;
                            planet.setRadius(radius);
                            setPlanetRadius[(numOfPlanets - 1)] = radius;

                        } else {

                            radius = 75 * 5;
                            planet.setRadius(radius);
                            setPlanetRadius[(numOfPlanets - 1)] = radius;
                        }
                        
                        break;
                    default:
                        System.out.println("something went wrong");
                        break;
                }
            }
        });
        
        
        semiMajorOfPlanet.setShowTickMarks(true);
        semiMajorOfPlanet.setShowTickLabels(true);
        semiMajorOfPlanet.setSnapToTicks(true);
        semiMajorOfPlanet.setMinSize(290, 100);
        semiMajorOfPlanet.setMax(4);
        semiMajorOfPlanet.setMajorTickUnit(1);
        semiMajorOfPlanet.setMinorTickCount(0);
        semiMajorOfPlanet.setLayoutX(0);
        semiMajorOfPlanet.setLayoutY(440);
        semiMajorOfPlanet.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
            		int sMValue = (int) semiMajorOfPlanet.getValue();
            		switch(sMValue) {
            			case 0:
            				setPlanetSemiMajor[(numOfPlanets -1)] = 1;
            				sMPlanet.setText("Distance from Star to Planet: 1 AU");
            				//1 AU
            				break;
            			case 1:
            				setPlanetSemiMajor[(numOfPlanets -1)] = 5;
            				sMPlanet.setText("Distance from Star to Planet: 5 AU");
            				//5 AU
            				break;
            			case 2:
            				setPlanetSemiMajor[(numOfPlanets -1)] = 25;
            				sMPlanet.setText("Distance from Star to Planet: 25 AU");
            				//25 AU
            				break;
            			case 3:
            				setPlanetSemiMajor[(numOfPlanets -1)] = 50;
            				sMPlanet.setText("Distance from Star to Planet: 50 AU");
            				//50 AU
            				break;
            			case 4:
            				setPlanetSemiMajor[(numOfPlanets -1)] = 100;
            				sMPlanet.setText("Distance from Star to Planet: 100 AU");
            				//100 AU
            				break;
            		}
            }
            });
        
        massOfPlanet.setShowTickMarks(true);
        massOfPlanet.setShowTickLabels(true);
        massOfPlanet.setSnapToTicks(true);
        massOfPlanet.setMinSize(290, 100);
        massOfPlanet.setMax(4);
        massOfPlanet.setMajorTickUnit(1);
        massOfPlanet.setMinorTickCount(0);
        massOfPlanet.setLayoutX(0);
        massOfPlanet.setLayoutY(340);
        massOfPlanet.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
            		int mValue = (int) semiMajorOfPlanet.getValue();
            		switch(mValue) {
            			
            			case 0:
            				setPlanetMass[(numOfPlanets - 1)] = 0.06;
            				mPlanet.setText("Mass of Planet: Mercury");
            				//mercury: 0.0553
            				break;
            			case 1:
            				setPlanetMass[(numOfPlanets - 1)] = 1;
            				mPlanet.setText("Mass of Planet: Earth");
            				//earth 1
            				break;
            			case 2:
            				setPlanetMass[(numOfPlanets - 1)] = 15;
            				mPlanet.setText("Mass of Planet: Uranus");
            				//uranus 14.5
            				break;
            			case 3:
            				setPlanetMass[(numOfPlanets - 1)] = 95;
            				mPlanet.setText("Mass of Planet: Saturn");
            				//saturn 95.2
            				break;
            			case 4:
            				setPlanetMass[(numOfPlanets - 1)] = 300;
            				mPlanet.setText("Mass of Planet: Jupiter");
            				//jupiter 317.8
            				break;
            			
            		}
            	
            }
            });
        
        pane.getChildren().addAll(planets, sizeOfPlanet, semiMajorOfPlanet, massOfPlanet);
    }

    // initialize labels for second Screen
    public void lablesForSecondScreen(Pane pane) {

        planetV.setLayoutX(75);
        planetV.setLayoutY(220);

        starV.setLayoutX(75);
        starV.setLayoutY(520);
        
        sMPlanet.setLayoutX(75);
        sMPlanet.setLayoutY(420);
        
        mPlanet.setLayoutX(75);
        mPlanet.setLayoutY(320);

        pane.getChildren().addAll(planetV, starV, sMPlanet, mPlanet);
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
        numOfPlanets++;
        
        if(tiny) {
        	setDensityRange[(numOfPlanets-1)] = 3;
        }else /*if(gas) */{
            setDensityRange[(numOfPlanets-1)] = 1;

        }
        

    }

    /****************************Second Screen Code*********************************/
    
    public double getSemiMajor(int n) {
    	double[] semiMajor = new double[5];
    	 for (int i=0; i < numOfPlanets; i++) {
    		semiMajor[i] = setPlanetSemiMajor[i];
    	}
    	
    	return semiMajor[n];
    }
    
    public double getPlanetMass(int n) {
    	double[] planetMass = new double[5];
    	
    	for (int i=0; i < numOfPlanets; i++) {
    		planetMass[i] = setPlanetMass[i];
    	}
    	
    	return planetMass[n];
    }
    
    public double getPlanetRad(int n) {
    	double[] planetRadius = new double[5];
    	
    	for (int i=0; i < numOfPlanets; i++) {
    		planetRadius[i] = setPlanetRadius[i];
    	}
    	
    	return planetRadius[n];
    }
    
    public double getPlanetDensity(int n) {
    	double[] planetDensity = new double[5];
    	
    	for (int i=0; i < numOfPlanets; i++) {
    		planetDensity[i] = setDensityRange[i];
    	}
    	
    	return planetDensity[n];
    }
    
    public double sRadius() {
    	double starRadius = setStarRadius;
    	
    	return starRadius;
    }
    
    public double sMass() {
    	double starMass = setStarMass;
    	
    	return starMass;
    }
    
    public double sTemp() {
    	double starTemp = setStarTemp;
    	
    	return starTemp;
    }
}
