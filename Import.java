import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
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
	
	/*Method to Store Data*/
	public static void storeAll() throws Exception //First Attempt
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
	
	public static ArrayList<String> getAll()
	{
		return planetData;
	}
	
	public static ArrayList<String> getHostName()
	{
		return hostName;
	}
	
	/**public static void parseData() //Failed Experiment
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
	
	public static void storeData() throws Exception
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
				orbitPeriod.add(splitLin[6]);//
				semiMajor.add(splitLin[11]);
				eccentricity.add(splitLin[16]);
				planetMass.add(splitLin[21]);
				planetRad.add(splitLin[27]);
				planetDensity.add(splitLin[32]);
				planetDistance.add(splitLin[52]);
				//ssGravity.add(splitLin[74]); //Errors will occur due to no data. 
				//sLumin.add(splitLin[79]);
				//sRadius.add(splitLin[89]);
				//sMass.add(splitLin[84]);
				//sAge.add(splitLin[100]);
			}
			reader.close();
	}
	
	public static void main(String[] args)
	{
		try {
			storeData();
			//storeAll();
		}catch(Exception e1){
			e1.printStackTrace();
		}
		for (String line : hostName) //Printing Line by Line
		{
			  System.out.println(line); //Actual Data does not start till
			  							//line 110. CSV file may need to be
			  							//Modified
		}
		//Calls the method Name and saves the returned file path to a string.
		String filePath = Name();
		//I/O Exception handling; if the user did not select anything and closed the window it is handled in the if statement.
		if (filePath == null)
				System.out.println("You cancelled the choice");
		else
				System.out.println("You chose "+filePath);

		
	}
	
	//This method has the user select the file they wish to view and returns the filepath name.
		public static String Name() {
			final JFrame frame = new JFrame();
			FileDialog dialog = new FileDialog(frame, "Choose a file", FileDialog.LOAD);
			dialog.setDirectory("C:\\Users\\hdhar\\Desktop");
			dialog.setFile("*.csv");
			dialog.setVisible(true);
			String filename = dialog.getDirectory() + dialog.getFile();
			frame.dispose();
			return filename;
		}
}
