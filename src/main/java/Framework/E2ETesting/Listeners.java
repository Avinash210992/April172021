package Framework.E2ETesting;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BrowserSettings implements ITestListener{
	
	String retriedskipped;
	String skippeddepend;
	ExtentTest test;
	ThreadLocal<ExtentTest> tl = new ThreadLocal<ExtentTest>();;
	WebDriver driver;
	ExtentReports exrep=Extentrep.getReporter();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=exrep.createTest(result.getMethod().getMethodName());
	
		tl.set(test);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		tl.get().log(Status.PASS, "Passed Testcase :"+"\t"+result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	try {
		driver =(WebDriver) result.getTestClass().getRealClass().getDeclaredField("dr").get(result.getInstance());
	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String filename= result.getMethod().getMethodName();
	
	
 tl.get().log(Status.FAIL, "Failed Testcase"+result.getMethod().getMethodName(), result.getThrowable(), null);
	try {
		tl.get().addScreenCaptureFromPath(getScreenshot(driver,filename));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

		//System.out.println(result.getMethod().getMethodName());
		//tl.get().log(Status.SKIP, result.getMethod().getDescription());
		if(result.wasRetried() && result.getStatus()==ITestResult.SKIP) {
			 retriedskipped = result.getMethod().getMethodName();
			exrep.removeTest(tl.get());
			
		}
		else if(result.wasRetried()==false && result.getStatus()==ITestResult.SKIP) {
			 skippeddepend = result.getMethod().getMethodName();
			tl.get().log(Status.SKIP, "test skipped"+result.getMethod().getMethodName());

		
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Set<ITestResult> skipped = context.getSkippedTests().getAllResults();
		Iterator<ITestResult> it = skipped.iterator();
		while(it.hasNext())
		{
			ITestResult res = it.next();
			
			ITestNGMethod method = res.getMethod();
			String methodskip=method.getMethodName();
if(retriedskipped.equals(methodskip))
		{
	skipped.remove(res);
}
		
		}
	
		exrep.flush();
	}

}
