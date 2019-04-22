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
	final public long METERTOAU = 149600000000L; //Meters to AU conversion
	final public double GRAVIT = (6.67*Math.pow(10, -11));
	final public double EARTHMASS = 6*Math.pow(10, 24);
	final public double SUNMASS = 1.9885*Math.pow(10,30);
	
	
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
		data.runDefault("exoplanets2.csv");
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
	
	public String[] getKeplerDropDown() {
		String info[] = new String[hostList.size()];
		for(int i = 0; i < info.length; i++) {
			info[i] = hostList.get(i);
		}
		return info;
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
	
	public int findIndex(String planet)
	{
		int index =  -1;
		for(int i = 0;i<Import.planetName.size();i++)
		{
			if(Import.planetName.get(i).contentEquals(planet))
			{
				index = i;
				break;
			}
		}
		return index;
	}
	
	public Circle keplerPlanetData(int i) {
		return data.sendPlanetData(i);
	}
	
	public Circle keplerStarData(int i) {
		return data.sendStarData(i);
	}
	
	public String[] keplerData(int i) {
		return data.keplerData(i);
	}
	
	public String[] kStarInfo(int i) {
		return data.kStarInfo(i);
	}
	
	public Circle orbitalRadius(int i) {
		return data.orbitalRadius(i);
	}
	
	public Circle earthOrbitalRadius(int i) {
		return planet.earthOrbitalRadius(i);
	}
	
	public double perturbingEffects(String planet)
	{
		//Take out the planet in question
		//Finding index
		int index = -1;
		for(int i = 0;i<planetList.size();i++)
		{
			if(planetList.get(i).contentEquals(planet))
			{
				index = i;
				break;
			}
		}
		//Removing the planet Index
		planetList.remove(index);
		
		//Calculation of Perturbing Effects
		double sum = 0;
		for(int j =1;j<planetList.size();j++)
		{
			int index0 = findIndex(planetList.get(j)); //System.out.println(index0);
			int index1 = findIndex(planetList.get(j-1));
			double mass0 = Import.planetMassNum.get(index0)*EARTHMASS;
			double mass1 = Import.planetMassNum.get(index1)*EARTHMASS;
			double r0 = Import.semiMajorNum.get(index0)*METERTOAU;
			double r1 = Import.semiMajorNum.get(index1)*METERTOAU;
			double massSum = mass0+mass1;
			
			//Calculation of Perturbation
			double temp = (1/Math.pow(r1, 3))-(1/Math.pow(r0,3));
			sum = sum +(GRAVIT*massSum*temp);
		}
		return sum;
	}
	
	public boolean calcGravitationalModel(String planet, int planetIndex)
	{
		//int planetIndex = findIndex(planet); //Index of the planet in question
		String host = Import.hostName.get(planetIndex); //Assigns host associated with planet
		//System.out.println(host); //Used for Testing Only
		generatePlanetList(host); //Generates the list of relevant planets in system
		double sum = perturbingEffects(planet);
		//double sum = 0.0;
		
		boolean collision = false;
		double radius = Import.semiMajorNum.get(planetIndex)*METERTOAU;
		double massTotal = (Import.planetMassNum.get(planetIndex)*EARTHMASS)+(Import.sMassNum.get(planetIndex)*SUNMASS);
		double acceleration = ((-1*GRAVIT*massTotal)/(Math.pow(radius, 3)))-sum; //System.out.println(acceleration); //Only used for testing
		
		if(acceleration == 0)
		{
			collision = true;
		}
		return collision;
	}

	public double getG(){
		return 0;
	}
	
	/*
	 * @Purpose: Sets the color of the planet depending on the density of the planet
	 */
	/*public int setColorPlanet(String planet)
	{
		//String color = "";
		int color; 
		int planetIndex = findIndex(planet);
		if(Import.planetDensityNum.get(planetIndex)>=2)
		{
			//The planet is a terrestial object
			//color = "brown";
			color = 0x9b6801;
		}
		else
		{
			//The planet is a gas giant
			//color = "blue";
			color = 0x205fd6;
		}
		return color;
	}*/
	/*
	 * @Purpose: sets the color of star based on its effective temperature
	 * @Parameter: only requires the planet name. Then it will find the host
	 */
	/*public int setColorStar(String planet)
	{
		int color;
		int starIndex = findIndex(planet);
		
	}*/
	
	public static void main(String[] args)
	{
		Manager m = new Manager();
		
		m.importDataOwnFile();
		m.getHostNameArray();
		//System.out.println(m.findIndex("47 UMa b"));
		boolean collide = m.calcGravitationalModel("47 UMa b",m.findIndex("47 UMa b"));
		System.out.println(collide); 
		/*for(String line:m.hostList) //Printing the data called
		{
			System.out.println(line);
		}*/
		
		/*m.generatePlanetList("24 Sex");
		for(String line:m.planetList) //Printing the data called
		{
			System.out.println(line);
		}*/
		//System.out.println("test");
	}
}//end Manager