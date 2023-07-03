package com.sgtesting.tests;

import org.openqa.selenium.By;      

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathAxesDemo {

	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
	//	enterSalaryForPersonSachinTendulkar();
	//	enterSalaryForRecordWhichIsNextToSachin();
	//	makeStatusAsActiveForIndianFreedomFighter();
	//	makeStatusAsActiveForRecordWhichIsPreviousToRahulDravid();
	//	basedOnTableDetailsEnterSalaryFor5thRecord();
		childElementToParentElement();
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
			oBrowser.get("file:///D:/HTML/WebTableHTML.html");
			Thread.sleep(5000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * case 1: following-sibling
	 * Enter the salary for person Sachin Tendulkar
	 */
	private static void enterSalaryForPersonSachinTendulkar()
	{
		oBrowser.findElement(By.xpath("//td[text()='Sachin Tendulkar']/following-sibling::td[4]/input")).sendKeys("25000");
	}
	
	/**
	 * case 2: following
	 * Enter the salary for the record which is next to Sachin Tendulkar
	 */
	private static void enterSalaryForRecordWhichIsNextToSachin()
	{
		oBrowser.findElement(By.xpath("//td[text()='Sachin Tendulkar']/following::tr[1]/td[6]/input")).sendKeys("22000");
	}
	
	/**
	 * case 3: preceding-sibling
	 * Make the status as active for Designation Indian Freedom Fighter
	 */
	private static void makeStatusAsActiveForIndianFreedomFighter()
	{
		oBrowser.findElement(By.xpath("//td[text()='Indian Freedom Fighter']/preceding-sibling::td[1]/preceding-sibling::td[1]/input")).click();
	}
	/**
	 * case 4: preceding
	 * Make the status as Active for Record which is previous To Rahul Dravid
	 */
	private static void makeStatusAsActiveForRecordWhichIsPreviousToRahulDravid()
	{
		oBrowser.findElement(By.xpath("//td[text()='Rahul Dravid']/preceding::tr[1]/td[1]/input")).click();
	}
	
	/**
	 * case 5: descendant
	 * Based on table details Enter Salary fro 5th Record
	 */
	private static void basedOnTableDetailsEnterSalaryFor5thRecord()
	{
		oBrowser.findElement(By.xpath("//table[@id='tbl1']/descendant::tr[5]/td[6]/input")).sendKeys("26000");
	}
	/**
	 * case 6: ancestor
	 * Based on Salary Text field details for 5th record, get table attribute details
	 */
	private static void childElementToParentElement()
	{
		WebElement oEle=oBrowser.findElement(By.xpath("//input[@id='edit4']/ancestor::tr[1]/ancestor::table"));
		System.out.println(oEle.getAttribute("id"));
	}
}
