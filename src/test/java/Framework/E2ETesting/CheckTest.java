package Framework.E2ETesting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class CheckTest {
	
	Logger log = LogManager.getLogger(CheckTest.class.getName());
	
	@Test(groups="main")
	public void c1()
	{
		System.out.println("am in c1");
		log.info("at c1");
		log.error("errored");
		log.debug("debug");
		log.fatal("fatal");
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
