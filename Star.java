import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


/**
 * @author Owner
 * @version 1.0
 * @created 13-Feb-2019 5:09:37 PM
 * 
 * This is the specific class for Stars
 * @see CelestialObject
 */
public class Star extends CelestialObject {
	private double ssGravity = 274; // m/s^2
	private double sLumin = 1;
	private double sRadius = 109; // compared to earth radius
	private double sMass =  333000; //compared to earth mass
	private double sAge = 4.603; // billions of years, literal age is too large
	public Circle star;
	
	public Circle earthSystem(){
		star = new Circle();
		star.setFill(Color.ORANGE);
		star.setRadius(sRadius * 5);
		star.setLayoutX(-530);
		star.setLayoutY(540);
		return star;
	}

	public String[] sunData() {
		String info[] = {"Gravity: " + ssGravity + " m/s^2", "Radius: " + sRadius + " in Earth Radii", 
				"Mass: " + sMass + " in Earth Masses", "Age: " + sAge + " billion years" };
		return(info);
	}

	public void setMass(){

	}

	public void setRadius(){

	}
}//end Star