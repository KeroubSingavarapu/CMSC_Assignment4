import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	
	Property p1 ,p2,p3, p4, p5, p6;
	ManagementCompany m ;
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		m = new ManagementCompany("Lee", "9870",4);
		
		//student add three properties, with plots, to mgmt co
		p1 = new Property("Rolling wood", "Bel Air", 2500.00, "John Twist",4,3,2,3);
		p2 = new Property("Sun Land", "Dallas", 1920.00, "Tyra Banks",2,4,2,3);
		p3 = new Property("Barrigton", "Silver Creek", 1403.00, "Billy Dave",6,2,4,8);
		
		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
		
		
	}


	@After
	public void tearDown() {
		//student set mgmt co to null  
		p1=p2=p4=null;
		m=null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		p4 = new Property ("FriendlyPlace", "Ozark", 3001, "Bob Charles");
		
		//student should add property with 8 args
		p5 = new Property("Glass Castle", "West Virginia", 1000.00, "Jeannette Walls", 6,6,5,8);
		
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
		p6 = new Property("SeaSide","Myrtle Beach", 3000.00, "Peri Luisa", 4,6,7,4);
		
	
	}
 
	@Test
	public void testMaxRentProp() {
	
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(m.maxRentProp(),2500.0,0); 
	}

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		assertEquals(m.totalRent(),5823.0,0);

	}

 }