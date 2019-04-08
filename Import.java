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
public class Import 
{
	/**Static Variables*/
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
				semiMajorNum.add(Double.parseDouble(semiMajor.get(i)));
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
				sRadiusNum.add(Double.parseDouble(sRadius.get(i)));
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
				sMassNum.add(Double.parseDouble(sMass.get(i)));
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
				orbitPeriod.add(splitLin[6]);//Need double
				semiMajor.add(splitLin[11]);//Need Double
				eccentricity.add(splitLin[16]);//Need Double
				planetMass.add(splitLin[21]);//Need double
				planetRad.add(splitLin[27]);//Need Double
				planetDensity.add(splitLin[32]);//Need Double
				planetDistance.add(splitLin[52]);//Need Double
				//ssGravity.add(splitLin[74]); //Errors will occur due to no data. 
				//sLumin.add(splitLin[79]);
				//sRadius.add(splitLin[89]);
				//sMass.add(splitLin[84]);
				//sAge.add(splitLin[100]);
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
				semiMajor.add(splitLin[11]);//Need Double
				eccentricity.add(splitLin[16]);//Need Double
				planetMass.add(splitLin[21]);//Need Double
				planetRad.add(splitLin[27]);//Need Double
				planetDensity.add(splitLin[32]);//Need Double
				planetDistance.add(splitLin[52]);//Need Double
				//ssGravity.add(splitLin[74]); //Errors will occur due to no data. 
				//sLumin.add(splitLin[79]);
				//sRadius.add(splitLin[89]);
				//sMass.add(splitLin[84]);
				//sAge.add(splitLin[100]);
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
		String filename = dialog.getDirectory() + dialog.getFile();
		frame.dispose();
		return filename;
	}
	
	/** The "main" method of the Import function, call this to run everything else.
	 * @param void
	 */
	//public static void run()
	public static void main(String[] args)
	{
		//Calls the method Name and saves the returned file path to a string.
		String filePath = Name();
		//I/O Exception handling; if the user did not select anything and closed the window it is handled in the if statement.
		if (filePath == null)
				System.out.println("You cancelled the choice");
		else
				System.out.println("You chose "+filePath);
		
		try {//Reading File
			storeData(filePath);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		/*for(String line:orbitPeriod) //Printing the data called
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

		for(int j = 1;j<orbitPeriodNum.size();j++)
		{
			System.out.println(planetRadNum.get(j));
		}
		
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
