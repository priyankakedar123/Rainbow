package projectKeywordConfig;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Keywords.UIkeywords;

public class BaseClass{
	UIkeywords keyword =UIkeywords.getInstance();
	//will not have any method but only instance static variables
	@BeforeMethod
	public void setUp()
	{
		
		keyword.openBrowser("chrome");
	}
	
	@AfterMethod
	public void tearDown()
	{
		keyword.quitBrowser();
	}
	
	
}
