package Framework.E2ETesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {

	WebDriver dr;
	public SigninPage(WebDriver driver)
	{
		dr=driver;
		PageFactory.initElements(dr, this);
		
	}
	
	
	@FindBy(xpath="//input[@name='email']")
	WebElement signinEmail;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement ContinueButton;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	
	public WebElement email()
	{
		return signinEmail;
	}
	
	public WebElement continueButton()
	{
		return ContinueButton;
	}
	
	
	public WebElement password()
	{
		return password;
	}
	
}
