package com.sgtesting.objectmap;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMap {
	Properties prop=null;
	public ObjectMap(String fileName)
	{
		FileInputStream fin=null;
		try
		{
			fin=new FileInputStream(fileName);
			prop=new Properties();
			prop.load(fin);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public By getLocator(String logicalname)
	{
		By by=null;
		try
		{
			String logicalValue=prop.getProperty(logicalname);
			String locator[]=logicalValue.split(";");
			String locatorName=locator[0];
			String locatorValue=locator[1];

			switch (locatorName.toLowerCase()) {
			case "id":
				by=By.id(locatorValue);
				break;
			case "name":
				by=By.name(locatorValue);
				break;
			case "xpath":
				by=By.xpath(locatorValue);
				break;
			case "linktext":
				by=By.linkText(locatorValue);
				break;
			case "tagname":
				by=By.tagName(locatorValue);
				break;
			case "classname":
				by=By.className(locatorValue);
				break;
			case "cssselector":
				by=By.cssSelector(locatorValue);
				break;
			case "partiallinktext":
				by=By.partialLinkText(locatorValue);
				break;
			default:
				System.out.println("Invalid Locator Name !!!");
				break;
			}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		return by;
	}

}
