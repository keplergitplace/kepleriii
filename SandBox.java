import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;

import javax.swing.plaf.metal.MetalBorders;

public class SandBox extends Pane
{

    //This is just a prototype layout. Eventually we want to use the value of the sliders to correspond to the number
    // of the desired planets, moons, or stars and then draw them. Along with a save functionality.

    private Slider planets = new Slider();
    private Slider stars = new Slider();
    private Slider moons = new Slider();

    private Label planetV = new Label("Planets: ");
    private Label starV = new Label("Stars: ");
    private Label moonV = new Label("Moons: ");
    private Label name = new Label("name");

    private TextField input = new TextField();

    public SandBox()
    {

        initSliderS();
        labelInit();

    }

    private void initSliderS()
    {

        planets.setShowTickMarks(true);
        planets.setShowTickLabels(true);
        planets.setSnapToTicks(true);
        planets.setMaxSize(200, 100);
        planets.setMinSize(200,100);
        planets.setMax(5);
        planets.setMajorTickUnit(1);
        planets.setMinorTickCount(0);
        planets.setLayoutX(0);
        planets.setLayoutY(0);
        planets.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                int planetValue = (int) planets.getValue();
                planetV.setText("Planets: " + String.format("%d", planetValue));
            }
        });

        stars.setShowTickMarks(true);
        stars.setShowTickLabels(true);
        stars.setSnapToTicks(true);
        stars.setMaxSize(200, 100);
        stars.setMinSize(200,100);
        stars.setMax(5);
        stars.setMajorTickUnit(1);
        stars.setMinorTickCount(0);
        stars.setLayoutX(0);
        stars.setLayoutY(100);
        stars.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                int planetValue = (int) stars.getValue();
                starV.setText("Stars: " + String.format("%d", planetValue));
            }
        });

        moons.setShowTickMarks(true);
        moons.setShowTickLabels(true);
        moons.setSnapToTicks(true);
        moons.setMaxSize(200, 100);
        moons.setMinSize(200,100);
        moons.setMax(5);
        moons.setMajorTickUnit(1);
        moons.setMinorTickCount(0);
        moons.setLayoutX(0);
        moons.setLayoutY(200);
        moons.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                int planetValue = (int) moons.getValue();
                moonV.setText("Moons: " + String.format("%d", planetValue));
            }
        });

        this.getChildren().addAll(planets, stars, moons);
    }

    public void labelInit()
    {

        planetV.setLayoutX(250);
        planetV.setLayoutY(50);

        starV.setLayoutX(250);
        starV.setLayoutY(150);

        moonV.setLayoutX(250);
        moonV.setLayoutY(250);

        name.setLayoutX(300);
        name.setLayoutY(350);

        input.setLayoutX(0);
        input.setLayoutY(350);
        input.setMinSize(280,25);
        input.setPromptText("Enter a name for your planet, star, or moon");
        input.setOnAction(e -> {

            name.setText(input.getText());

        });


        this.getChildren().addAll(planetV, starV, moonV, input, name);
    }

}
