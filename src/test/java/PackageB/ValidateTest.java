package PackageB;

import org.testng.annotations.Test;

public class ValidateTest {
	@Test(groups="main")
	public void vt1()
	{
		System.out.println("am in vt1");
	}
	
	@Test(groups="side")
	public void vt2()
	{
		System.out.println("am in vt2");
	}
	
	
	@Test(groups="side")
	public void vt3()
	{
		System.out.println("am in vt3");
	}
	
	
}
