import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
/**
 * @author Owner
 * @version 1.0
 * @created 13-Feb-2019 5:09:35 PM
 * 
 * This is the specific class for planets
 * @see CelestialObject
 */
public class Planet extends CelestialObject {

	private String planetLetter[] = {"M", "V", "E" , "M", "J", "S", "U", "N"};
	private String planetName[] = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
	private String discoverMethod[] = {"Antiquity", "Antiquity", "Antiquity", "Antiquity", "Anitquity", "Anitquity", "Anitquity", "Anitquity",};
	//private double CFlag[] = {0, 0, 0, 0, 0, 0, 0, 0};
	private String yearDiscovered[] = {"Antiquity", "Antiquity", "Antiquity", "Antiquity", "Anitquity", "Anitquity", "Anitquity", "Anitquity",}; 
	private double orbitPeriod[] = {88, 225, 365, 687, 4380, 10585, 30660, 60225};
	//double semiMajor[] = {0.387, 0.723, 1, 1.524, 5.2044, 9.5826, 19.1923, 30.11};//compared to earth
	private double semiMajor[] = {9108.74, 17017.1, 23538.8, 35870.1, 122494.9, 225543.74, 451725.3, 708693}; //1 = 1 earth radius
	private double eccentricity[] = {0.205, 0.007, 0.0167, 0.0934, 0.048, 0.054, 0.0472, 0.0086};
	private double planetMass[] = { 0.0553, 0.815, 1, 0.107, 317.8, 95.2, 14.5, 17.1}; //compared to earth
	private double planetRad[] = { 0.383, 0.949, 1, 0.532, 11.21, 9.45, 4.01, 3.88}; //compared to earth	
	private double planetDensity[] = { 5.427, 5.204, 5.515, 3.933, 1.326, 0.687, 1.27, 1.638}; // g/cm^3

	public Circle earthSystem(int i){
		Circle planets = new Circle();
		planets.setRadius(planetRad[i]);
		planets.setLayoutX(960 + semiMajor[i]);
		planets.setLayoutY(540);
		return planets;
	}
	
	public Circle earthOrbitalRadius(int i){
		Circle orbits = new Circle();
		orbits.setRadius(semiMajor[i]);
		orbits.setCenterX(960);
		orbits.setCenterY(540);
		return orbits;
	}

	public String[] earthData(int i) { 
	String info[] = {"Planet Name: " + planetName[i], "Discovery Method: " + discoverMethod[i], 
			"Year Discovered: " + yearDiscovered[i], "Orbital Period: " + orbitPeriod[i] + " days"};
		return info;
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