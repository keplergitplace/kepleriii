import javafx.scene.shape.Circle;


/**
 * @author Owner
 * @version 1.0
 * @created 13-Feb-2019 5:09:37 PM
 */
public class Star extends CelestialObject {
	public Circle star;
	
	public Star(){
		star = new Circle();
		
		star.setRadius((m_Manager.sRadius) * 10);
		star.setLayoutX(0);
		star.setLayout(540);
	}

	
	public void setColor(){

	}

	public void setMass(){

	}

	public void setRadius(){

	}
}//end Star