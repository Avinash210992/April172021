package Framework.E2ETesting;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WorkingTest extends BrowserSettings {

	WebDriverWait wait;
	WebDriver dr;
	String url;
	String click1;
	HomePage hp;
	Set<String> windowtotal;
	String Parent;
	String child1;
	ArrayList<String> al;



	@Test(priority=1,groups= {"main"})
	public void callBrowser() throws IOException, InterruptedException
	{
		dr = browser();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 wait = new WebDriverWait(dr,Duration.ofSeconds(30));
		url=urlObt;
		dr.get(url);
		 hp= new HomePage(dr);
		Actions a = new Actions(dr);
		a.moveToElement(hp.signIn).build().perform();
		Assert.assertTrue(hp.displaySignin.isDisplayed());
		 click1=Keys.chord(Keys.CONTROL,Keys.ENTER);
	
		hp.signInButton.sendKeys(click1);
	windowtotal= dr.getWindowHandles();
	al=new ArrayList<String>(windowtotal);
	Thread.sleep(10);
		
	}
	@Parameters({"useremail","password"})
	@Test(priority=2,groups= {"main"})
	public void signIN(String user,String pass) throws InterruptedException
	
	{
		dr.switchTo().window(al.get(1));
		System.out.println(dr.getTitle());
		SigninPage sp = new SigninPage(dr);
		wait.until(ExpectedConditions.visibilityOf(sp.email())).sendKeys(user);
		
		sp.continueButton().click();
		wait.until(ExpectedConditions.visibilityOf(sp.password)).sendKeys(pass);
		Thread.sleep(10);
		
		
	}
	
		@Test (priority=3,groups= {"main"})
	public void dealChocolate() throws InterruptedException
	{
		
		dr.switchTo().window(al.get(0));
		dr.manage().window().maximize();
		Thread.sleep(5);
		wait.until(ExpectedConditions.visibilityOf(hp.elect())).sendKeys(click1);;
		Set<String> win1 = dr.getWindowHandles();
		win1.removeAll(windowtotal);
		al.addAll(win1);
	dr.switchTo().window(al.get(2));
	System.out.println(dr.getCurrentUrl());
	ElectronicsPage ep = new ElectronicsPage(dr);
	String text1= ep.header().getText();
	Assert.assertTrue(text1.equals("The Electronics"));
	
	





	}
	
}
