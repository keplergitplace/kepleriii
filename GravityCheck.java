import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class GravityCheck{
	public static Import a1;
	public static Manager mgr;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Start of tests...");
		a1 =new Import();
		mgr = new Manager();
		a1.runOwnFile();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("All the test cases are Done....");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("--------Test Case----------");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("------End test Case---------");
	}

	@Test
	void check24Sex()
	{
		assertEquals(false, mgr.calcGravitationalModel("24 Sex b", mgr.findIndex("24 Sex b")));
	}
	
	@Test
	void check24Boo()
	{
		assertEquals(false, mgr.calcGravitationalModel("24 Boo b", mgr.findIndex("24 Boo b")));
	}
	
	@Test
	void check55Cnc()
	{
		assertEquals(false, mgr.calcGravitationalModel("55 Cnc b", mgr.findIndex("55 Cnc b")));
	}
	
	@Test
	void check8UMi()
	{
		assertEquals(false, mgr.calcGravitationalModel("8 UMi b", mgr.findIndex("8 UMi b")));
	}
	
}
