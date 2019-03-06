import javafx.scene.shape.Circle;

/**
 * @author Owner
 * @version 1.0
 * @created 13-Feb-2019 5:09:35 PM
 * 
 * This is the specific class for planets
 * @see CelestialObject
 */
public class Planet extends CelestialObject {

	//public Circle[] planets = new Circle[8];

	public Circle earthSystem(int i){
		Circle planets = new Circle();

		planets.setRadius(getPlanetRad(i)*5);

		planets.setLayoutX(getSemiMajor(i)/375);

		planets.setLayoutY(540);

		return planets;

	}


	public void setColor(){

	}

	public void setHeading(){

	}

	public void setMass(){

	}

	public void setOrbitalRadius(){

	}

	public void setRadius(){

	}

	public void setVelocity(){

	}
}//end Planet