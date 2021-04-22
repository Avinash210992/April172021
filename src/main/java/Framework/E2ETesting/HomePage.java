package Framework.E2ETesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver dr;
	public HomePage(WebDriver driver)
	{
		dr=driver;
		PageFactory.initElements(dr,this);
	}
	
	@FindBy(css="#nav-link-accountList")
	WebElement signIn;
	 
	@FindBy(css="div#nav-al-container")
	WebElement displaySignin;
	
	@FindBy(xpath="//div[@id='nav-tools']//a[2]")
	WebElement signInButton;
	
	@FindBy(css=(".a-link-normal.a-inline-block img[title*='20% off on Chocolates']"))
	WebElement chocolate;
	
	@FindBy(xpath="//a[text()=' Electronics ']")
	WebElement electronics;
	
	
	

	public WebElement signin()
	{
		return signIn;
	}
	
	public WebElement displaySignin()
	{
		return displaySignin;
	}
	
	public WebElement signinButton()
	{
		return signInButton;
	}
	
	
	public WebElement choc()
	{
		return chocolate;
	}
	
	public WebElement elect()
	{
		return electronics;
	}
	
	
	//Window Handling
	
	
	
}


