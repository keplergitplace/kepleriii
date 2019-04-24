import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * @author Owner
 * @version 1.0
 * @created 13-Feb-2019 5:09:29 PM
 */
public class Export {

	private File String;
	public Manager m_Manager;
	//private SandBox sBox = new SandBox();

	public Export(){

	}

	public void finalize() throws Throwable {

	}
	public String nameFile(){
		return "";
	}

	public void printData(SandBox sBox)
	{
		PrintWriter out = null;
		try
		{
			for(int i = 0; i<sBox.getNumOfPlanets();i++)
			{
			//System.out.println("passed to writing method");
			//System.out.println(sBox.getSemiMajor());
			out = new PrintWriter(new BufferedWriter(new FileWriter("SandBox.csv")));
			out.println("fpl_hostname,fpl_letter,fpl_name,fpl_discmethod,fpl_controvflag,"
					+ "fpl_disc,fpl_orbper,fpl_orbperreflink,fpl_smax,fpl_smaxreflink,"
					+ "fpl_eccen,fpl_eccenreflink,fpl_bmasse,fpl_bmassprov,fpl_bmassreflink,"
					+ "fpl_rade,fpl_radreflink,fpl_dens,fpl_densreflink,fpl_eqt,fpl_eqtreflink,"
					+ "fpl_insol,fpl_insolreflink,ra_str,ra,dec_str,dec,fst_posreflink,"
					+ "fst_dist,fst_distreflink,fst_optmag,fst_optmagband,fst_optmagreflink,"
					+ "fst_nirmag,fst_nirmagband,fst_nirmagreflink,fst_spt,fst_sptreflink,"
					+ "fst_teff,fst_teffreflink,fst_logg,fst_loggreflink,fst_lum,fst_lumreflink,"
					+ "fst_mass,fst_massreflink,fst_rad,fst_radreflink,fst_met,fst_metratio,"
					+ "fst_metreflink,fst_age,fst_agereflink");
			out.print("SandStar,");
			out.print("s,");
			out.print("SandBox,");
			out.print("0,");
			out.print("0,");
			out.print("0,"); //Year Discovery Needs to be blank
			out.print("0,");
			out.print("0,");
			out.print(sBox.getSemiMajor(i)+",");
			out.print("0,");
			out.print("0,");//Eccentricity
			out.print(sBox.getPlanetMass(i)+",");
			out.print("0,");
			out.print("0,");
			out.print("0,");
			out.print(sBox.getPlanetRad(i)+",");
			out.print("0,");
			out.print(sBox.getPlanetDensity(i)+",");
			out.print("0,");
			out.print("0,");
			out.print("0,"); //24
			out.print("0,");
			out.print("0,");
			out.print("0,");
			out.print("0,");
			out.print("0,");
			out.print("0,");
			out.print("0,");
			out.print("0,");
			out.print("0,"); //33
			out.print("0,");
			out.print("0,");
			out.print("0,");
			out.print("0,");
			out.print("0,");
			out.print("0,");
			out.print("0,");
			out.print("0,");
			out.print(sBox.sTemp()+","); //42
			out.print("0,");
			out.print("0,");
			out.print("0,");
			out.print("0,");
			out.print("0,");
			out.print(sBox.sMass()+","); //48
			out.print("0,");
			out.print(sBox.sRadius()+","); //50
			out.print("0,");
			out.print("0,");
			out.print("0,");
			out.print("0,");
			out.print("0,");
			out.print("0,");
			out.print("\n");
			
			}
			
		}catch(IOException e2)
		{
			System.err.println(e2);
		}finally {
			if(out != null)
				out.close();
		}
	}
}//end Export