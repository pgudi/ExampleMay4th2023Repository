package com.sgtesting.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathDemo {
	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
	//	absoluteXPath();
	//	relativeXPathByTagName();
	//	relativeXPathByTagNameWithIndex();
	//	relativeXPathByTagNameWithAttributeNameAndValue();
	//	relativeXPathByAttributeNameAndValueAlone();
	//	relativeXPathByAttributeValueAlone();
	//	relativeXPathByTagNameWithMultipleAttributeNameAndValue();
	//	relativeXPathByTagNameWithMultipleAttributeNameAndValueUsingOROperator();
	//	relativeXPathByTagNameWithMultipleAttributeNameAndValueUsingAndOperator();
	//	relativeXPathByTagNameWithPartialAttributeNameAndValue();
	//	relativeXPathByTagNameWithAttributeName();
	//	relativeXPathByTagNameWithAttributeName_01();
	//	relativeXPathByTagNameWithAttributeName_02();
	//	relativeXPathByTagNameWithAttributeName_03();
	//	relativeXPathusingTextContent();
		relativeXPathusingPartialTextContent();
	}
	
	private static void launchBrowser()
	{
		try
		{
			oBrowser=new ChromeDriver();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void navigate()
	{
		try
		{
			oBrowser.get("file:///D:/HTML/Sample.html");
			Thread.sleep(5000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private static void absoluteXPath()
	{
		oBrowser.findElement(By.xpath("html/body/div/form/input")).sendKeys("DemoUser1");
	}
	/**
	 * Case 1: Identify Element based on tagName alone
	 * Syntax: //<tagName>
	 */
	private static void relativeXPathByTagName()
	{
		oBrowser.findElement(By.xpath("//input")).sendKeys("DemoUser2");
	}
	
	/**
	 * Case 2: Identify Element based on tagName with index
	 * Syntax: //<tagName>[index]
	 */
	private static void relativeXPathByTagNameWithIndex()
	{
		oBrowser.findElement(By.xpath("//input[2]")).sendKeys("DemoUser3");
	}
	
	/**
	 * Case 3: Identify Element based on tagName with attribute Name and Value combination
	 * Syntax: //<tagName>[@attrobutename='attributevalue']
	 */
	private static void relativeXPathByTagNameWithAttributeNameAndValue()
	{
		oBrowser.findElement(By.xpath("//input[@value='Submit']")).click();
	}
	
	/**
	 * Case 4: Identify Element based on attribute Name and Value alone
	 * Syntax: //*[@attributename='attributevalue']
	 */
	private static void relativeXPathByAttributeNameAndValueAlone()
	{
		oBrowser.findElement(By.xpath("//*[@value='Submit']")).click();
	}
	
	/**
	 * Case 5: Identify Element based on attribute Value alone
	 * Syntax: //*[@*='attributevalue']
	 */
	private static void relativeXPathByAttributeValueAlone()
	{
		oBrowser.findElement(By.xpath("//*[@*='Submit']")).click();
	}
	
	/**
	 * Case 6: Identify Element based on tagName with Multiple attribute Name and Value combination
	 * Syntax: //<tagName>[@attrobutename1='attributevalue'][@attrobutename2='attributevalue']
	 */
	private static void relativeXPathByTagNameWithMultipleAttributeNameAndValue()
	{
		oBrowser.findElement(By.xpath("//input[@value='Submit'][@type='button']")).click();
	}
	
	/**
	 * Case 7: Identify Element based on tagName with Multiple attribute Name and Value combination
	 * 		   using OR Operator
	 * Syntax: //<tagName>[@attrobutename1='attributevalue' or @attrobutename2='attributevalue']
	 */
	private static void relativeXPathByTagNameWithMultipleAttributeNameAndValueUsingOROperator()
	{
		oBrowser.findElement(By.xpath("//input[@value='Submit12345' or @type='button']")).click();
	}
	
	/**
	 * Case 8: Identify Element based on tagName with Multiple attribute Name and Value combination
	 * 		   using and Operator
	 * Syntax: //<tagName>[@attrobutename1='attributevalue' or @attrobutename2='attributevalue']
	 */
	private static void relativeXPathByTagNameWithMultipleAttributeNameAndValueUsingAndOperator()
	{
		oBrowser.findElement(By.xpath("//input[@value='Submit' and @type='button']")).click();
	}
	
	/**
	 * Case 9: Identify Element based on tagName with partial attribute Name and Value combination
	 * starts-with(@attributename,'partial attribute value')
	 * ends-with(@attributename,'partial attribute value')
	 * contains(@attributename,'partial attribute value')
	 * 
	 * Syntax: //<tagName>[starts-with(@attributename,'partial attribute value')]
	 * Syntax: //<tagName>[ends-with(@attributename,'partial attribute value')]
	 * Syntax: //<tagName>[contains(@attributename,'partial attribute value')]
	 */
	private static void relativeXPathByTagNameWithPartialAttributeNameAndValue()
	{
	//	oBrowser.findElement(By.xpath("//input[starts-with(@id,'btn1')]")).click();
	//	oBrowser.findElement(By.xpath("//input[ends-with(@id,'button1')]")).click();
		oBrowser.findElement(By.xpath("//input[contains(@id,'submit')]")).click();
	}
	
	/**
	 * Case 10: Get Collection of Elements using tagName with attributeName
	 * Syntax: //<tagName>[@attributeName]
	 */
	private static void relativeXPathByTagNameWithAttributeName()
	{
		//Find Number of links in a Web Page
		List<WebElement> olinks=oBrowser.findElements(By.xpath("//a[@href]"));
		System.out.println("# of Links :"+olinks.size());
	}
	
	private static void relativeXPathByTagNameWithAttributeName_01()
	{
		//Display links in a Web Page
		List<WebElement> olinks=oBrowser.findElements(By.xpath("//a[@href]"));
		for(int i=0;i<olinks.size();i++)
		{
			WebElement link=olinks.get(i);
			System.out.println("Link Name :"+link.getText());
		}
	}
	
	private static void relativeXPathByTagNameWithAttributeName_02()
	{
		//In partial matching ends-with does not work but using ends-with
		// identify the Element
		
		List<WebElement> olinks=oBrowser.findElements(By.xpath("//a[@href]"));
		for(int i=0;i<olinks.size();i++)
		{
			WebElement link=olinks.get(i);
			if(link.getText().endsWith("Testing"))
			{
				link.click();
				break;
			}
		}
	}
	
	private static void relativeXPathByTagNameWithAttributeName_03()
	{
		// org.openqa.selenium.StaleElementReferenceException: stale element reference: 
		// stale element not found
		
		List<WebElement> olinks=oBrowser.findElements(By.xpath("//a[@href]"));
		for(int i=0;i<olinks.size();i++)
		{
			WebElement link=olinks.get(i);
			if(link.getText().startsWith("POI"))
			{
				link.click();
			}
		}
	}
	
	/**
	 * Case 11: Identify Element based on Text Content
	 * Syntax: //<tagName>[text()='text content']
	 */
	private static void relativeXPathusingTextContent()
	{
		oBrowser.findElement(By.xpath("//a[text()='Eclipse Tool']")).click();
	}
	
	/**
	 * Case 12: Identify Element based on partial Text Content
	 * starts-with(text(),'textcontent')
	 * ends-with(text(),'textcontent')
	 * contains(text(),'textcontent')
	 * Syntax: //<tagName>[starts-with(text(),'textcontent')]
	 * Syntax: //<tagName>[ends-with(text(),'textcontent')]
	 * Syntax: //<tagName>[contains(text(),'textcontent')]
	 */
	private static void relativeXPathusingPartialTextContent()
	{
	//	oBrowser.findElement(By.xpath("//a[starts-with(text(),'Eclipse')]")).click();
		oBrowser.findElement(By.xpath("//a[contains(text(),'Software')]")).click();
	}
}
