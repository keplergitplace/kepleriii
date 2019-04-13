import java.util.ArrayList;
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
	public String fileName;
	public ArrayList<String> hostList = new ArrayList<String>();
	public ArrayList<String> planetList = new ArrayList<String>();
	
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
	
	public void importDataImport() {
		data.runDefault("exoplanets.csv");
	}
	
	public String[] listPltNames(int i) {
		return data.listPltNames(i);
	}
	
	public String listStrName(int i) {
		return data.listStrName(i);
	}
		
	public int getIndex(String name) {
		return data.getIndex(name);
	}
	
	public void importDataOwnFile() {
		data.runOwnFile();
		this.fileName = Import.fileName + "";
		
	}
	
	/*
	 * @purpose: To return an arraylist that contains all the system names
	 */
	public void getHostNameArray()
	{
		//Only used for testing
		//System.out.println(fileName);
		/*for(String line:Import.hostName) //Printing the data called
		{
			System.out.println(line);
		}*/
		String temp = Import.hostName.get(1);
		hostList.add(temp);
		for(int counter = 2;counter<Import.hostName.size();counter++)
		{
			if(Import.hostName.get(counter).equals(temp))
			{
				//System.out.println("Found Duplicate");
			}
			else
			{
				temp = new String(Import.hostName.get(counter));
				hostList.add(temp);
			}
		}
	}
	
	/*
	 * @purpose: To go through planet name data and select the relevant planets
	 * @parameter: Input string for host (star)
	 */
	public void generatePlanetList(String hostName)
	{
		planetList.clear();
		for(int count = 1; count<Import.hostName.size();count++)
		{
			if(Import.hostName.get(count).contentEquals(hostName))
			{
				planetList.add(Import.planetName.get(count));
			}
		}
	}
	
	/*public void mathData(int i) {
		math = data.mathData(i);
	}*/
	
	public Circle keplerPlanetData(int i) {
		return data.sendPlanetData(i);
	}
	
	public Circle keplerStarData(int i) {
		return data.sendStarData(i);
	}
	
	public String[] keplerData(int i) {
		return data.keplerData(i);
	}
	
	public void calcGravitationalModel(){

	}

	public double getG(){
		return 0;
	}
}//end Manager