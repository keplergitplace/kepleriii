/**
 * The import class will open a csv file and parse through the data
 * @author Sayan, Harrison
 * @Date: 3/3/2019
 * @version: 1.3
 */
import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JFrame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class Import 
{
	/**Static Variables*/
	public static String fileName="";
	public String gFileName;
	
	public static ArrayList<String> planetData = new ArrayList<String>();
	public static ArrayList<String> hostName = new ArrayList<String>();
	public static ArrayList<String> planetLetter = new ArrayList<String>();
	public static ArrayList<String> planetName = new ArrayList<String>();
	public static ArrayList<String> discoveryMethod = new ArrayList<String>();
	public static ArrayList<String> cFlag = new ArrayList<String>();
	public static ArrayList<String> yearDisc = new ArrayList<String>();
	public static ArrayList<String> orbitPeriod = new ArrayList<String>();
	public static ArrayList<String> semiMajor = new ArrayList<String>();
	public static ArrayList<String> eccentricity = new ArrayList<String>();
	public static ArrayList<String> planetMass = new ArrayList<String>();
	public static ArrayList<String> planetRad = new ArrayList<String>();
	public static ArrayList<String> planetDensity = new ArrayList<String>();
	public static ArrayList<String> planetDistance = new ArrayList<String>();
	public static ArrayList<String> ssGravity = new ArrayList<String>();
	public static ArrayList<String> sLumin = new ArrayList<String>();
	public static ArrayList<String> sRadius = new ArrayList<String>();
	public static ArrayList<String> sMass = new ArrayList<String>();
	public static ArrayList<String> sAge = new ArrayList<String>();

	public static ArrayList<Double> orbitPeriodNum = new ArrayList<Double>();
	public static ArrayList<Double> semiMajorNum = new ArrayList<Double>();
	public static ArrayList<Double> eccentricityNum = new ArrayList<Double>();
	public static ArrayList<Double> planetMassNum = new ArrayList<Double>();
	public static ArrayList<Double> planetRadNum = new ArrayList<Double>();
	public static ArrayList<Double> planetDensityNum = new ArrayList<Double>();
	public static ArrayList<Double> planetDistanceNum = new ArrayList<Double>();
	public static ArrayList<Double> ssGravityNum = new ArrayList<Double>();
	public static ArrayList<Double> sLuminNum = new ArrayList<Double>();
	public static ArrayList<Double> sRadiusNum = new ArrayList<Double>();
	public static ArrayList<Double> sMassNum = new ArrayList<Double>();
	public static ArrayList<Double> sAgeNum = new ArrayList<Double>();

	public static void convertToOrbitDouble()
	{
		//System.out.println("Test"); //Used for Debugging
		orbitPeriodNum.add(null); //First index is non-essential
		for(int i = 1; i < orbitPeriod.size(); i++)
		{
			//orbitPeriodNum[i] = Double.parseDouble(orbitPeriod[i]);
			//orbitPeriodNum.add(Double.parseDouble(orbitPeriod.get(i)));
			if(orbitPeriod.get(i).length()!=0)
			{
				orbitPeriodNum.add(Double.parseDouble(orbitPeriod.get(i)));
			}
			else
			{
				orbitPeriodNum.add(null);
			}
		}
	}

	public static void convertToEccentricityDouble()
	{
		//System.out.println("Test"); //Used for Debugging
		eccentricityNum.add(null); //First index is non-essential
		for(int i = 1; i < semiMajor.size(); i++)
		{
			//orbitPeriodNum[i] = Double.parseDouble(orbitPeriod[i]);
			//orbitPeriodNum.add(Double.parseDouble(orbitPeriod.get(i)));
			if(eccentricity.get(i).length()!=0)
			{
				eccentricityNum.add(Double.parseDouble(eccentricity.get(i)));
			}
			else
			{
				eccentricityNum.add(null);
			}
		}
	}

	public static void convertToPlanetRadDouble()
	{
		//System.out.println("Test"); //Used for Debugging
		planetRadNum.add(null); //First index is non-essential
		for(int i = 1; i < planetRad.size(); i++)
		{
			//orbitPeriodNum[i] = Double.parseDouble(orbitPeriod[i]);
			//orbitPeriodNum.add(Double.parseDouble(orbitPeriod.get(i)));
			if(planetRad.get(i).length()!=0)
			{
				planetRadNum.add(Double.parseDouble(planetRad.get(i)));
			}
			else
			{
				planetRadNum.add(null);
			}
		}
	}

	public static void convertToPlanetDistanceDouble()
	{
		//System.out.println("Test"); //Used for Debugging
		planetDistanceNum.add(null); //First index is non-essential
		for(int i = 1; i < planetDistance.size(); i++)
		{
			//orbitPeriodNum[i] = Double.parseDouble(orbitPeriod[i]);
			//orbitPeriodNum.add(Double.parseDouble(orbitPeriod.get(i)));
			if(planetDistance.get(i).length()!=0)
			{
				planetDistanceNum.add(Double.parseDouble(planetDistance.get(i)));
			}
			else
			{
				planetDistanceNum.add(null);
			}
		}
	}

	public static void convertToPlanetDensityDouble()
	{
		//System.out.println("Test"); //Used for Debugging
		planetDensityNum.add(null); //First index is non-essential
		for(int i = 1; i < planetDensity.size(); i++)
		{
			//orbitPeriodNum[i] = Double.parseDouble(orbitPeriod[i]);
			//orbitPeriodNum.add(Double.parseDouble(orbitPeriod.get(i)));
			if(planetDensity.get(i).length()!=0)
			{
				planetDensityNum.add(Double.parseDouble(planetDensity.get(i)));
			}
			else
			{
				planetDensityNum.add(null);
			}
		}
	}

	public static void convertToPlanetMassDouble()
	{
		//System.out.println("Test"); //Used for Debugging
		planetMassNum.add(null); //First index is non-essential
		for(int i = 1; i < semiMajor.size(); i++)
		{
			//orbitPeriodNum[i] = Double.parseDouble(orbitPeriod[i]);
			//orbitPeriodNum.add(Double.parseDouble(orbitPeriod.get(i)));
			if(planetMass.get(i).length()!=0)
			{
				planetMassNum.add(Double.parseDouble(planetMass.get(i)));
			}
			else
			{
				planetMassNum.add(null);
			}
		}
	}

	public static void convertToSemiDouble()
	{
		//System.out.println("Test"); //Used for Debugging
		semiMajorNum.add(null); //First index is non-essential
		for(int i = 1; i < semiMajor.size(); i++)
		{
			//orbitPeriodNum[i] = Double.parseDouble(orbitPeriod[i]);
			//orbitPeriodNum.add(Double.parseDouble(orbitPeriod.get(i)));
			if(semiMajor.get(i).length()!=0)
			{
				semiMajorNum.add(960 + (35870.1*(Double.parseDouble(semiMajor.get(i)))));
			}
			else
			{
				semiMajorNum.add(null);
			}
		}
	}

	public static void convertToSsGravityDouble()
	{
		//System.out.println("Test"); //Used for Debugging
		ssGravityNum.add(null); //First index is non-essential
		for(int i = 1; i < ssGravity.size(); i++)
		{
			//orbitPeriodNum[i] = Double.parseDouble(orbitPeriod[i]);
			//orbitPeriodNum.add(Double.parseDouble(orbitPeriod.get(i)));
			if(ssGravity.get(i).length()!=0)
			{
				ssGravityNum.add(Double.parseDouble(ssGravity.get(i)));
			}
			else
			{
				ssGravityNum.add(null);
			}
		}
	}

	public static void convertToSLuminDouble()
	{
		//System.out.println("Test"); //Used for Debugging
		sLuminNum.add(null); //First index is non-essential
		for(int i = 1; i < sLumin.size(); i++)
		{
			//orbitPeriodNum[i] = Double.parseDouble(orbitPeriod[i]);
			//orbitPeriodNum.add(Double.parseDouble(orbitPeriod.get(i)));
			if(sLumin.get(i).length()!=0)
			{
				sLuminNum.add(Double.parseDouble(sLumin.get(i)));
			}
			else
			{
				sLuminNum.add(null);
			}
		}
	}

	public static void convertToSRadiusDouble()
	{
		//System.out.println("Test"); //Used for Debugging
		sRadiusNum.add(null); //First index is non-essential
		for(int i = 1; i < ssGravity.size(); i++)
		{
			//orbitPeriodNum[i] = Double.parseDouble(orbitPeriod[i]);
			//orbitPeriodNum.add(Double.parseDouble(orbitPeriod.get(i)));
			if(sRadius.get(i).length()!=0)
			{
				sRadiusNum.add(109 * Double.parseDouble(sRadius.get(i)));
			}
			else
			{
				sRadiusNum.add(null);
			}
		}
	}

	public static void convertToSMassDouble()
	{
		//System.out.println("Test"); //Used for Debugging
		sMassNum.add(null); //First index is non-essential
		for(int i = 1; i < sMass.size(); i++)
		{
			//orbitPeriodNum[i] = Double.parseDouble(orbitPeriod[i]);
			//orbitPeriodNum.add(Double.parseDouble(orbitPeriod.get(i)));
			if(sRadius.get(i).length()!=0)
			{
				sMassNum.add(33000* Double.parseDouble(sMass.get(i)));
			}
			else
			{
				sMassNum.add(null);
			}
		}
	}

	public static void convertToSAgeDouble()
	{
		//System.out.println("Test"); //Used for Debugging
		sAgeNum.add(null); //First index is non-essential
		for(int i = 1; i < sAge.size(); i++)
		{
			//orbitPeriodNum[i] = Double.parseDouble(orbitPeriod[i]);
			//orbitPeriodNum.add(Double.parseDouble(orbitPeriod.get(i)));
			if(sAge.get(i).length()!=0)
			{
				sAgeNum.add(Double.parseDouble(sAge.get(i)));
			}
			else
			{
				sAgeNum.add(null);
			}
		}
	}
	/**
	 * Method store default data from the exoplanets.csv data
	 * @param void
	 * @throws IOException	if a reading exception occured
	 */
	public static void storeAllDefault() throws Exception //First Attempt
	{
		// Open the file
		Import.planetData.clear();
		BufferedReader reader = new BufferedReader(new FileReader("exoplanets.csv"));
		String line;
		while ((line = reader.readLine()) != null) {
			Import.planetData.add(line);
		}
		reader.close();
		//System.out.println(planetData.get(110)); //Planet Data does not start till line 110
	}

	/**
	 * Return the Arraylist of Planet Data
	 * @param void
	 * @return planetData	an Arraylist of the planet data
	 */
	public static ArrayList<String> getAll()
	{
		return planetData;
	}

	/*public static void parseData() //Failed Experiment
	{
		String line = "";
		System.out.println("Starting Parse Data");
		for(int i = 0; i < planetData.size();i++)
		{
			//hostName.addAll(line.split(",",0));
			System.out.println(line.split(",",0));
			System.out.println(line);

		}
	}*/

	/**
	 * Stores default values for exoplanets.csv
	 * @param void
	 */
	public static void storeDataDefault() throws Exception
	{
		//Import.planetData.clear();
		BufferedReader reader = new BufferedReader(new FileReader("exoplanets.csv"));
		String line;
		while ((line = reader.readLine()) != null)
		{
			String[] splitLin = line.split(",");
			hostName.add(splitLin[0]);
			planetLetter.add(splitLin[1]);
			planetName.add(splitLin[2]);
			discoveryMethod.add(splitLin[3]);
			cFlag.add(splitLin[4]);
			yearDisc.add(splitLin[5]);
			orbitPeriod.add(splitLin[6]);//Need Double
			semiMajor.add(splitLin[8]);//Need Double
			eccentricity.add(splitLin[10]);//Need Double
			planetMass.add(splitLin[12]);//Need Double
			planetRad.add(splitLin[15]);//Need Double
			planetDensity.add(splitLin[17]);//Need Double
			//planetDistance.add(splitLin[28]);//Need Double //DO NOT USE
			ssGravity.add(splitLin[40]); //Errors will occur due to no data. 
			sLumin.add(splitLin[42]);
			sRadius.add(splitLin[46]);
			sMass.add(splitLin[44]);
			sAge.add(splitLin[51]);
		}
		reader.close();
	}

	/**
	 * Stores default values from the parameter name
	 * @param String Name
	 * @throws IOException	if a writing exception occurs
	 */
	public static void storeData(String name) throws Exception
	{
		//Import.planetData.clear();
		BufferedReader reader = new BufferedReader(new FileReader(name));
		String line;
		while ((line = reader.readLine()) != null)
		{
			String[] splitLin = line.split(",");
			hostName.add(splitLin[0]);
			planetLetter.add(splitLin[1]);
			planetName.add(splitLin[2]);
			discoveryMethod.add(splitLin[3]);
			cFlag.add(splitLin[4]);
			yearDisc.add(splitLin[5]);
			orbitPeriod.add(splitLin[6]);//Need Double
			semiMajor.add(splitLin[8]);//Need Double
			eccentricity.add(splitLin[10]);//Need Double
			planetMass.add(splitLin[12]);//Need Double
			planetRad.add(splitLin[15]);//Need Double
			planetDensity.add(splitLin[17]);//Need Double
			//planetDistance.add(splitLin[28]);//Need Double //DO NOT USE
			//ssGravity.add(splitLin[40]); //Errors will occur due to no data. 
			//sLumin.add(splitLin[42]);
			//sRadius.add(splitLin[46]);
			//sMass.add(splitLin[44]);
			//sAge.add(splitLin[51]);
			if((splitLin[40].length() != 0)&&(splitLin[40].length()<5))
				ssGravity.add(splitLin[40]);
			else
				ssGravity.add("0");
			if((splitLin[42].length() != 0)&&(splitLin[42].length()<5))
				sLumin.add(splitLin[42]);
			else
				sLumin.add("0");
			if((splitLin[46].length() != 0)&&(splitLin[46].length()<5))
				sRadius.add(splitLin[46]);
			else
				sRadius.add("0");
			if((splitLin[44].length() != 0)&&(splitLin[44].length()<5))
				sMass.add(splitLin[44]);
			else
				sMass.add("0");
			if((splitLin[51].length() != 0)&&(splitLin[51].length()<5))
				sAge.add(splitLin[51]);
			else
				sAge.add("0");
			
			/*if((splitLin[46].length()==0))
				sRadius.add("0");
			else
				sRadius.add(splitLin[46]);*/
			/*if(splitLin[46].equals(null))
				sRadius.add("0");
			else if((splitLin[46].length()==0)||(splitLin[46].length()>7))
				sRadius.add("0");
			else
				sRadius.add(splitLin[46]);*/
		}
		reader.close();
	}

	/**
	 * This method has the user select the file they wish to view.
	 * @param void
	 * @return filename	  String which holds the full filepath name of the selected file.
	 */
	public static String Name() {
		final JFrame frame = new JFrame();
		FileDialog dialog = new FileDialog(frame, "Choose a file", FileDialog.LOAD);
		//Starting user in a default C drive directory that most computers will have.
		dialog.setDirectory("C:\\Users\\");
		dialog.setFile("*.csv");
		dialog.setVisible(true);
		//String filename = dialog.getDirectory() + dialog.getFile();
		fileName = dialog.getDirectory()+dialog.getFile();
		frame.dispose();
		return fileName;
	}
	
	public Circle sendPlanetData(int i) {
		Circle planets = new Circle();
		planets.setRadius(planetRadNum.get(i));
		planets.setLayoutX(960 + semiMajorNum.get(i));
		planets.setLayoutY(540);
		return planets;
	}
	
	public Circle sendStarData(int i) {
		Circle star = new Circle();
		star.setRadius(sRadiusNum.get(i));
		star.setFill(Color.ORANGE);
		star.setLayoutX(960);
		star.setLayoutY(540);
		//System.out.println(sRadiusNum.get(i));
		return star;
	}
	
	public String[] keplerData(int i) {
		String info[] = {/*"Host Name " + hostName.get(i), */"Planet Name: " + planetName.get(i), "Discover Method: " + discoveryMethod.get(i), 
				"Year Discovered: " + yearDisc.get(i), "Orbital Period: " + orbitPeriod.get(i) + " Days"};
		return info;
	}
	
	public String[] kStarInfo(int i) {
		String info[] = {"Gravity: " + ssGravity.get(i) + " log10 cm/s^2", "Radius: " + sRadius.get(i) + " solar radii", "Mass: "
				+ sMass.get(i) + " * solar mass", "Age: " + sAge.get(i) + " Billion Years"};
		return info;
	}
	
	public String[] listPltNames(int i) {
		String info[] = {planetName.get(i), planetName.get(i+1)};
		return info;
	}
	
	public String listStrName(int i) {
		String info = hostName.get(i);
		return info;
	}
	
	public int getIndex(String name) {
		int loc = hostName.indexOf(name);
		return loc;
	}

	public void runDefault(String filePath) {
		planetData.clear();
		hostName.clear();
		planetLetter.clear();
		planetName.clear();
		discoveryMethod.clear();
		cFlag.clear();
		yearDisc.clear();
		orbitPeriod.clear();
		semiMajor.clear();
		eccentricity.clear();
		planetMass.clear();
		planetRad.clear();
		planetDensity.clear();
		planetDistance.clear();
		ssGravity.clear();
		sLumin.clear();
		sRadius.clear();
		sMass.clear();
		sAge.clear();
		orbitPeriodNum.clear();
		semiMajorNum.clear();
		eccentricityNum.clear();
		planetMassNum.clear();
		planetRadNum.clear();
		planetDensityNum.clear();
		planetDistanceNum.clear();
		ssGravityNum.clear();
		sLuminNum.clear();
		sRadiusNum.clear();
		sMassNum.clear();
		sAgeNum.clear();

		try {//Reading File
			storeData(filePath);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		convertToOrbitDouble();
		convertToEccentricityDouble();
		convertToPlanetRadDouble();
		convertToPlanetDistanceDouble();
		convertToPlanetDensityDouble();
		convertToPlanetMassDouble();
		convertToSemiDouble();
		convertToSsGravityDouble();
		convertToSLuminDouble();
		convertToSRadiusDouble();
		convertToSMassDouble();
	}
	
	/** The "main" method of the Import function, call this to run everything else.
	 * @param void
	 */
	
	public void runOwnFile()
	//public static void main(String[] args)
	{
		planetData.clear();
		hostName.clear();
		planetLetter.clear();
		planetName.clear();
		discoveryMethod.clear();
		cFlag.clear();
		yearDisc.clear();
		orbitPeriod.clear();
		semiMajor.clear();
		eccentricity.clear();
		planetMass.clear();
		planetRad.clear();
		planetDensity.clear();
		planetDistance.clear();
		ssGravity.clear();
		sLumin.clear();
		sRadius.clear();
		sMass.clear();
		sAge.clear();
		orbitPeriodNum.clear();
		semiMajorNum.clear();
		eccentricityNum.clear();
		planetMassNum.clear();
		planetRadNum.clear();
		planetDensityNum.clear();
		planetDistanceNum.clear();
		ssGravityNum.clear();
		sLuminNum.clear();
		sRadiusNum.clear();
		sMassNum.clear();
		sAgeNum.clear();
		//Calls the method Name and saves the returned file path to a string.
		String filePath = Name();
		//I/O Exception handling; if the user did not select anything and closed the window it is handled in the if statement.
		/*if (filePath == null)
			System.out.println("You cancelled the choice");
		else
			System.out.println("You chose "+filePath);*/

		try {//Reading File
			storeData(filePath);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		/*for(String line:sAge) //Printing the data called
		{
			System.out.println(line);
		}*/
		

		convertToOrbitDouble();
		convertToEccentricityDouble();
		convertToPlanetRadDouble();
		convertToPlanetDistanceDouble();
		convertToPlanetDensityDouble();
		convertToPlanetMassDouble();
		convertToSemiDouble();
		convertToSsGravityDouble();
		convertToSLuminDouble();
		convertToSRadiusDouble();
		convertToSMassDouble();

		/*for(int j = 1;j<orbitPeriodNum.size();j++)
		{
			System.out.println(orbitPeriodNum.get(j));
		}*/

		//This is for testing of the default method. Not used for functionality
		/*try {
			storeDataDefault();
			//storeAllDefault();
		}catch(Exception e1){
			e1.printStackTrace();
		}
		for (String line : hostName) //Printing Line by Line
		{
			  System.out.println(line); //Actual Data does not start till
			  							//line 110. CSV file may need to be
			  							//Modified
		}*/

	}
}
