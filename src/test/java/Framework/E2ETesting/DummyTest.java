package Framework.E2ETesting;

import org.testng.annotations.Test;

public class DummyTest {

	@Test(groups="main")
	public void m1()
	{
		System.out.println("am in m1");
	}
	
	@Test(groups="side")
	public void m2()
	{
		System.out.println("am in m2");
	}
	
	
	
	@Test(groups="side")
	public void m3()
	{
		System.out.println("am in m3");
	}
	
	

	@Test(groups="side")
	public void m4()
	{
		System.out.println("am in m4");
	}
	
	
	

	@Test(groups="side")
	public void m5()
	{
		System.out.println("am in m5");
	}
	
	
	
}
