package UtilPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	public  String getProperty(String filename,String key)
	{
		String value = " ";
		return value;
	}
	/*
	 * This method returns the value of locator mentioned in ObjectRepository
	 * @param key
	 */
	public static String getObject(String key) 
	{   String value = " ";
		String dir = System.getProperty("user.dir");
		try {
			FileInputStream fis= new FileInputStream(dir+"/src/test/resources/ObjectRepository.properties");
		    Properties prop = new Properties();
		    prop.load(fis);
		    value= prop.getProperty(key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
}
