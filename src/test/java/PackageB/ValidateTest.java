package PackageB;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class ValidateTest {
	Logger log = LogManager.getLogger(ValidateTest.class.getName());
	@Test(groups="main")
	public void vt1()
	{
		
		System.out.println("am in vt1");
		
		log.info("at vt1");
		log.error("errored");
		log.debug("debug");
		log.fatal("fatal");
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
