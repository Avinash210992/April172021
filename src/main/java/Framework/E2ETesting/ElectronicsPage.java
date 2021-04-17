package Framework.E2ETesting;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectronicsPage {

	WebDriver dr;
	ElectronicsPage(WebDriver driver)
	{
		dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'bxw-pageheader__title__text')]/h1")
	WebElement header;
	


	public WebElement header()
	{
		return header;
	}
	
	

	
	
}
