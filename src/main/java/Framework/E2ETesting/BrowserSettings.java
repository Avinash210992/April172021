package Framework.E2ETesting;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSettings {
WebDriver dr;
String urlObt;
	public WebDriver browser() throws IOException
	{
		Properties p= new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\GitApr17admin\\src\\main\\java\\resources\\configBasics.properties");
		p.load(fis);
		String url = p.getProperty("url");
		String browserName = p.getProperty("browser");
		System.out.println(browserName);

		
	if(browserName.equalsIgnoreCase("chrome"))
	{

System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32 (1)\\chromedriver.exe");
 dr = new ChromeDriver();
	}
	
	else if(browserName.equalsIgnoreCase("firefox"))
	{
	System.setProperty("webdriver.gecko.driver", "D:\\Automation\\geckodriver.exe");
	dr = new FirefoxDriver();
	}
	urlObt=url;
	return dr;
	
	}
	
	public String getScreenshot(WebDriver driver, String filepath) throws IOException
	{
	
		String dest = System.getProperty("user.dir")+"\\Screenshots\\"+filepath+".png";
		TakesScreenshot tss  = ((TakesScreenshot)driver);	
		File src = tss.getScreenshotAs(OutputType.FILE);
		File destfile = new File(dest);
		
		FileUtils.copyFile(src, destfile);;
		String destpath = destfile.getAbsolutePath();
		return destpath;
		
	}
	
	

}
