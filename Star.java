import javafx.scene.paint.Color;
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
		star.setFill(Color.ORANGE);
		star.setRadius(getsRadius() * 5);
		star.setLayoutX(-530);
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