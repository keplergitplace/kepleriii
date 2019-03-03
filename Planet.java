import javafx.scene.shape.Circle;

/**
 * @author Owner
 * @version 1.0
 * @created 13-Feb-2019 5:09:35 PM
 */
public class Planet extends CelestialObject {

	//public Circle[] planets = new Circle[8];
	
	public Circle earthSystem(int i){
		Circle planets = new Circle();
			
			planets.setRadius(getPlanetRad(i)*5);
			
			System.out.println("" + planets.getRadius());
		
			planets.setLayoutX(semiMajor[i]/50);
			System.out.println("" + planets.getLayoutX());
			
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