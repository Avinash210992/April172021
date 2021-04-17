package Framework.E2ETesting;

import org.testng.annotations.Test;

public class CheckTest {
	@Test(groups="main")
	public void c1()
	{
		System.out.println("am in c1");
	}
	
	@Test(groups="side")
	public void c2()
	{
		System.out.println("am in c2");
	}
	
	
	
	@Test(groups="side")
	public void c3()
	{
		System.out.println("am in c3");
	}
	
	
}
