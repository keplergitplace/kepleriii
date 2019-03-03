import javafx.scene.shape.Circle;

/**
 * @author Owner
 * @version 1.0
 * @created 13-Feb-2019 5:09:34 PM
 */
public class Manager {
	
	Planet planet = new Planet();
	Star star = new Star(); 
	
	
	public Circle addPlanets(int i) {
			return planet.earthSystem(i);
	}
	public Circle addStars() {
		return star.earthSystem();
	}
	
	public void calcGravitationalModel(){

	}

	public double getG(){
		return 0;
	}
}//end Manager