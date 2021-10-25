package Keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**This class contains UI keywords which are applicable for WebElements and general actions
 * this is singleton class. to create object of this class , use{@code getInstance()}
 * @author Priyanka Kedar
 *
 */
public class UIkeywords 
{
	public  RemoteWebDriver driver =null;
	private static  UIkeywords uikeywords;
	static 
	{
		uikeywords = new UIkeywords();
	}//static
	public static UIkeywords getInstance()
	{
		return uikeywords;
	}//getInstance
    
	/**
	 * This keyword is used to launched specified browser
	 * @author Priyanka Kedar
	 * @param browsernm must be one of the following
	 * <ul>
	 * <li>chrome>
	 * <li>firefox
	 * <li>ie
	 * <li>safari
	 * </ul>
	 */
	public void openBrowser(String browsernm)
	{
		if(browsernm.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//driver= new ChromeDriver();
			
		}
		else if(browsernm.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if(browsernm.equalsIgnoreCase("safari"))
		{

			WebDriverManager.safaridriver().setup();
			driver= new SafariDriver();
		 }
		else
		
			System.out.println("Insert valid browser name"+browsernm);
			
		}//open browser function 
	
	
	/**
	 * it opens the specified url in web browser recently opened by 
	 * driver instance
	 * @param url {@code String} url to open
	 * @return void
	 */
	public void launchUrl(String url)
	{
	driver.get(url);
	}
	public void quitBrowser()
	{
		driver.quit();
	}
	public void click(WebElement element)
	{
		element.click();
	}
	
	public String getTitleOfPage()
	{
		return driver.getTitle();
	}
	public WebElement getWebElement(String locatorType, String locatorValue)
	{
		WebElement element = null;
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			element = driver.findElement(By.xpath(locatorValue));
		}
		if(locatorType.equalsIgnoreCase("css"))
		{
			element=driver.findElement(By.cssSelector(locatorValue));
		}
		if(locatorType.equalsIgnoreCase("id"))
		{
			element=driver.findElement(By.id(locatorValue));
		}
		if(locatorType.equalsIgnoreCase("class"))
		{
			element=driver.findElement(By.className(locatorValue));
		}
		if(locatorType.equalsIgnoreCase("name"))
		{
			element=driver.findElement(By.name(locatorValue));
		}
		if(locatorType.equalsIgnoreCase("tag"))
		{
			element=driver.findElement(By.tagName(locatorValue));
		}
		return element;
	}
	//This is method but that is not in used
	/**
	 * in next version of framework, this method will be deleted. Instead you can use enterText(String object,String textToEnter))
	 * @param loactorType
	 * @param locatorValue
	 */
	@Deprecated
	public void enterText(WebElement element, String textToEnter)
	{
		element.sendKeys(textToEnter);
	}
	public void enterText(String locatorType, String locatorValue, String textToEnter)
	{
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}
	public RemoteWebDriver getDriver()
	{
		return driver;
	}
	public void click(String locatorType, String locatorValue)
	{
		// TODO Auto-generated method stub
		getWebElement(locatorType, locatorValue).click();
	}
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	public void switchToFrameAt(int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToDefaultContent()
	{
		driver.switchTo().defaultContent();
	}
	public void switchToFrame(String idorname)
	{
		driver.switchTo().frame(idorname);
	}
	public void switchToFrame(WebElement frame)
	{
		driver.switchTo().frame(frame);
	}
	public void enterText(String object, String textToEnter)
	{
		String[] parts = object.split("##");
		getWebElement(parts[0],parts[1]).sendKeys(textToEnter);
	}
}
