

/**
 * @author Owner
 * @version 1.0
 * @created 13-Feb-2019 5:09:34 PM
 */
public class Manager {

	String planetLetter[] = {"M", "V", "E" , "M", "J", "S", "U", "N"};
	String planetName[] = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
	String discoverMethed[] = {"Antiquity", "Antiquity", "Antiquity", "Antiquity", "Anitquity", "Anitquity", "Anitquity", "Anitquity",};
	double CFlag[] = {0, 0, 0, 0, 0, 0, 0, 0};
	String yearDiscovered[] = {"Antiquity", "Antiquity", "Antiquity", "Antiquity", "Anitquity", "Anitquity", "Anitquity", "Anitquity",}; 
	double orbitPeriod[] = {88, 225, 365, 687, 4380, 10585, 30660, 60225};
	double semiMajor[] = {0.387, 0.723, 1, 1.524, 5.2044, 9.5826, 19.1923, 30.11};//compared to earth
	double eccentricity[] = {0.205, 0.007, 0.0167, 0.0934, 0.048, 0.054, 0.0472, 0.0086};
	double planetMass[] = { 0.0553, 0.815, 1, 0.107, 317.8, 95.2, 14.5, 17.1}; //compared to earth
	double planetRad[] = { 0.383, 0.949, 1, 0.532, 11.21, 9.45, 4.01, 3.88}; //compared to earth	
	double planetDensity[] = { 5.427, 5.204, 5.515, 3.933, 1.326, 0.687, 1.27, 1.638}; // g/cm^3
	double planetDistance[] = {};
	double ssGravity = 274; // m/s^2
	double sLumin = 1;
	double sRadius = 109; // compared to earth radius
	double sMass =  333000; //compared to earth mass
	double sAge = 4.603; // billions of years, literal age is too large
	
	public KeplerPane m_KeplerPane;

	public Manager(){

	}

	public void calcGravitationalModel(){

	}

	public double getG(){
		return 0;
	}
}//end Manager