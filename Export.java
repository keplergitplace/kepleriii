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
	private SandBox sBox = new SandBox();

	public Export(){

	}

	public void finalize() throws Throwable {

	}
	public String nameFile(){
		return "";
	}

	public void printData()
	{
		PrintWriter out = null;
		try
		{
			out = new PrintWriter(new BufferedWriter(new FileWriter("SandBox.csv")));
			out.println("This is a test to see if the print statement work");
		}catch(IOException e2)
		{
			System.err.println(e2);
		}finally {
			if(out != null)
				out.close();
		}
	}
	
}//end Export