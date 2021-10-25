package TestRegression;


import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Keywords.UIkeywords;
import projectKeywordConfig.BaseClass;

//Author : Automation Tester
public class TestCasesUIKW extends BaseClass{
		UIkeywords keyword =  UIkeywords.getInstance();
	String expectedtitle = "IJmeet";
	/*@author = priyanka kedar
	 * 
	 */
	@Test
	public void titleOfHomePage()
	{
	
		keyword.launchUrl("https://ijmeet.com");
		String title = keyword.getTitleOfPage();
		Assert.assertEquals(title, expectedtitle);
	}

}