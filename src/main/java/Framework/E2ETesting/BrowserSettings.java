package Framework.E2ETesting;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSettings {
WebDriver dr;
String urlObt;
	public WebDriver browser() throws IOException
	{
		Properties p= new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace2\\E2ETesting\\Resources\\configBasics.properties");
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

}
