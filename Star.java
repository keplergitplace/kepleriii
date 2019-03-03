import javafx.scene.shape.Circle;


/**
 * @author Owner
 * @version 1.0
 * @created 13-Feb-2019 5:09:37 PM
 */
public class Star extends CelestialObject {
	public Circle star;
	
	public Circle earthSystem(){
		star = new Circle();
		
		star.setRadius((sRadius) * 10);
		star.setLayoutX(-950);
		star.setLayoutY(540);
		return star;
	}

	
	public void setColor(){

	}

	public void setMass(){

	}

	public void setRadius(){

	}
}//end Star