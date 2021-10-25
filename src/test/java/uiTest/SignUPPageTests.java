package uiTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Keywords.UIkeywords;
import UtilPackage.Locator;
import UtilPackage.TestListener;
import UtilPackage.WaitFor;
import projectKeywordConfig.BaseClass;
@Listeners(TestListener.class)
public class SignUPPageTests extends BaseClass{

	private static final Logger LOG = Logger.getLogger(SignUPPageTests.class);
	UIkeywords keyword = UIkeywords.getInstance();
	
	
	@Test
	public void validateFirstNameField() 
	{
		String url = "https://ijmeet.com";
		keyword.launchUrl(url);
		LOG.info("Url is launched"+url);
		
		//Approach 1
		//WebElement signup = keyword.getDriver().findElement(By.cssSelector("li:nth-child(5) a.nav-link"));
		//keyword.click(signup);
		
		//Approach 2
		keyword.click("css","li:nth-child(5) a.nav-link");
		keyword.enterText(Locator.SIGNUP_FULLNAME,"priyanka kedar" );
		keyword.enterText(Locator.SIGNUP_COMPANYNAME,"infosis" );
		keyword.enterText(Locator.SIGNUP_EMAIL, "p@gmail.com");
		keyword.enterText(Locator.SIGNUP_CONTACT, "5675768987");
		keyword.enterText(Locator.SIGNUP_PASSWORD, "abcd");
		
		keyword.switchToFrameAt(0);
		System.out.println("Switch to frame");
		LOG.info("Switched inside a frame");
		WaitFor.elementToBeClickable(keyword.getWebElement("css","div.recaptcha-checkbox-border"));
		keyword.click("css","div.recaptcha-checkbox-border");
		keyword.switchToDefaultContent();
		LOG.info("jumped back from frame");
		
	  //keyword.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		keyword.click("css", "button[type='submit']");
		
		String actualUrl = keyword.getCurrentUrl();
		Assert.assertTrue(actualUrl.contains("dashboard"));
	}

}
