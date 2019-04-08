import javafx.scene.shape.Circle;

/**
 * @author Owner
 * @version 1.0
 * @created 13-Feb-2019 5:09:34 PM
 */
public class Manager {
	
	Planet planet = new Planet();
	Star star = new Star(); 
	Import data = new Import();
	
	private String[] math;
	
	
	public Circle addPlanets(int i) {
			return planet.earthSystem(i);
	}
	public Circle addStars() {
		return star.earthSystem();
	}
	
	public String[] earthData(int i) {
		return planet.earthData(i);
	}
	public String[] sunData() {
		return star.sunData();
	}
	
	public void importData() {
		data.run();
	}
	
	/*public void mathData(int i) {
		math = data.mathData(i);
	}
	
	public String[] keplerData(int i) {
		return data.sendData(i);
	}*/
	
	public void calcGravitationalModel(){

	}

	public double getG(){
		return 0;
	}
}//end Manager