import javafx.scene.shape.Circle;

/**
 * @author Owner
 * @version 1.0
 * @created 13-Feb-2019 5:09:35 PM
 */
public class Planet extends CelestialObject {

	public Circle[] planets;
	
	public Planet(){
		planets = Circle[8];
		
		for (int i = 0; i < 8; i++) {
			planets[i].setRadius((m_Manager.planetRad[i]) * 10);
			
			planets[i].setLayoutX((m_Manager.semiMajor[i]) * 10);
			
			planets[i].setLayoutY(540);
			
			getChildren().add(planets[i]);
		}
		
	}

	public void finalize() throws Throwable {

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