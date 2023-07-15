package com.sgtesting.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectorDemo {
	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
	//	absolutecssSelector();
	//	relativecssUsingtagName();
	//	relativecssUsingtagNameWithIdAttributeValue();
	//	relativecssUsingIdAttributeValue();
	//	relativecssUsingtagNameWithClassAttributeValue();
	//	relativecssUsingClassAttributeValue();
	//	relativecssUsingTagNameWithAttributeNameValue();
	//	relativecssUsingTagNameWithMultipleAttributeNameValue();
	//	relativecssUsingTagNameWithPartialMatchngOfAttributeValue();
	//	relativecssUsingTagNameWithAttributeName();
	//	relativecssUsingTagNameWithAttributeName_01();
	//	relativecssUsingTagNameWithAttributeName_02();
	//	relativecssUsingTagNameWithAttributeName_03();
	//	relativecssUsingParentElement();
	//	relativecssUsingnthChildConcept();
		relativecssUsingSiblingConcept();
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
	
	private static void absolutecssSelector()
	{
		oBrowser.findElement(By.cssSelector("html body div form input")).sendKeys("DemoUser1");
	}

	/**
	 * Case 1: Identify the Element based on TagName
	 * Syntax: <tagName>
	 */
	private static void relativecssUsingtagName()
	{
		oBrowser.findElement(By.cssSelector("input")).sendKeys("DemoUser1");
	}
	
	/**
	 * Case 2: Identify the Element based on TagName with id attribite value
	 * Syntax: <tagName>#<id attribute value>
	 */
	private static void relativecssUsingtagNameWithIdAttributeValue()
	{
		oBrowser.findElement(By.cssSelector("input#pwd1pass1word1")).sendKeys("Password123");
	}
	
	/**
	 * Case 3: Identify the Element based on id attribite value
	 * Syntax: #<id attribute value>
	 */
	private static void relativecssUsingIdAttributeValue()
	{
		oBrowser.findElement(By.cssSelector("#pwd1pass1word1")).sendKeys("Password123");
	}
	
	/**
	 * Case 4: Identify the Element based on TagName with class attribite value
	 * Syntax: <tagName>.<class attribute value>
	 */
	private static void relativecssUsingtagNameWithClassAttributeValue()
	{
		oBrowser.findElement(By.cssSelector("input.pass1word1")).sendKeys("Password123");
	}
	
	/**
	 * Case 5: Identify the Element based on class attribite value
	 * Syntax: .<class attribute value>
	 */
	private static void relativecssUsingClassAttributeValue()
	{
		oBrowser.findElement(By.cssSelector(".pass1word1")).sendKeys("Password123");
	}
	
	/**
	 * Case 6: Identify the Element based on tagName with attribute name and value combination
	 * Syntax: <tagName>[attributeName='attributeValue']
	 */
	private static void relativecssUsingTagNameWithAttributeNameValue()
	{
		oBrowser.findElement(By.cssSelector("input[type='button']")).click();
	}
	
	/**
	 * Case 7: Identify the Element based on tagName with Multiple attribute name and value combination
	 * Syntax: <tagName>[attributeName='attributeValue'][attributeName='attributeValue']
	 */
	private static void relativecssUsingTagNameWithMultipleAttributeNameValue()
	{
		oBrowser.findElement(By.cssSelector("input[type='button'][value='Submit']")).click();
	}
	
	/**
	 * Case 8: Identify the Element based on tagName with Partial Matching of Attribute Value
	 * Syntax: 
	 *    starts-With
	 *   <tagName>[attributeName ^= 'attributeValue']
	 *    ends-with
	 *   <tagName>[attributeName $= 'attributeValue']
	 *    contains
	 *   <tagName>[attributeName *= 'attributeValue'] 
	 */
	private static void relativecssUsingTagNameWithPartialMatchngOfAttributeValue()
	{
	//	oBrowser.findElement(By.cssSelector("input[id ^= 'btn1']")).click();
		oBrowser.findElement(By.cssSelector("input[id *= 'submit1']")).click();
	}
	
	/**
	 * Case 9: Identify the Element based on tagName with attributeName combination
	 * Syntax: <tagName>[attributeName='attributeValue']
	 */
	private static void relativecssUsingTagNameWithAttributeName()
	{
		// find out number of links in the application
		List<WebElement> oLinks=oBrowser.findElements(By.cssSelector("a[href]"));
		System.out.println("# of Links :"+oLinks.size());
	}
	
	private static void relativecssUsingTagNameWithAttributeName_01()
	{
		// Display of link names in the application
		List<WebElement> oLinks=oBrowser.findElements(By.cssSelector("a[href]"));
		for(int i=0;i<oLinks.size();i++)
		{
			WebElement link=oLinks.get(i);
			System.out.println(link.getText());
		}
	}
	
	private static void relativecssUsingTagNameWithAttributeName_02()
	{
		// Click on particular Link using ends with Text Content
		List<WebElement> oLinks=oBrowser.findElements(By.cssSelector("a[href]"));
		for(int i=0;i<oLinks.size();i++)
		{
			WebElement link=oLinks.get(i);
			if(link.getText().endsWith("Testing"))
			{
				link.click();
				break;
			}
		}
	}
	
	private static void relativecssUsingTagNameWithAttributeName_03()
	{
		// org.openqa.selenium.StaleElementReferenceException: stale element reference: 
		// stale element not found
		List<WebElement> oLinks=oBrowser.findElements(By.cssSelector("a[href]"));
		for(int i=0;i<oLinks.size();i++)
		{
			WebElement link=oLinks.get(i);
			if(link.getText().startsWith("S G"))
			{
				link.click();
			}
		}
	}
	
	/**
	 * Case 10: Identify the Element based on Parent Element
	 * Syntax: <ParentElement> > <childElement>
	 */
	private static void relativecssUsingParentElement()
	{
		oBrowser.findElement(By.cssSelector("form#frm2 > input")).click();
	}
	
	/**
	 * Case 11: Identify the Element based on nth Child Concept
	 * Syntax: :nth-child(number)
	 */
	private static void relativecssUsingnthChildConcept()
	{
	//	oBrowser.findElement(By.cssSelector("form#frm3 > :nth-child(5)")).sendKeys("DemoUser5");
		oBrowser.findElement(By.cssSelector("form#frm3 > :nth-child(2)")).sendKeys("DemoUser2");
	}
	
	/**
	 * Case 12: Identify the Element based on sibling Concept
	 * Syntax: : <tagName> + <tagName> + .... N
	 */
	private static void relativecssUsingSiblingConcept()
	{
		oBrowser.findElement(By.cssSelector("form#frm3 > input + input + input")).sendKeys("DemoUser3");
	}
}
