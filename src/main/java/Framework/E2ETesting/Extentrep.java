package Framework.E2ETesting;



import java.text.SimpleDateFormat;
import java.util.Date;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentrep {
	static ExtentReports ex;
public static ExtentReports getReporter()
{
 String filename = new SimpleDateFormat("dd-M-yyyy hhmmss").format(new Date());
String path=System.getProperty("user.dir")+"\\Reports\\"+filename+".html";

	ExtentSparkReporter spark = new ExtentSparkReporter(path);
	 ex= new ExtentReports();
	spark.config().setDocumentTitle("E2E testing framework");
	spark.config().setReportName("HTML Results of executions");
	ex.attachReporter(spark);
	ex.setSystemInfo("Tester Name", "Avinash");
	return ex;

	

}
		
	
	
	
	
}
