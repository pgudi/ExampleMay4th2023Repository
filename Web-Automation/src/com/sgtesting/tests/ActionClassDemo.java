package com.sgtesting.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDemo {
	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		handleMouseMovements();
	}
	
	private static void launchBrowser()
	{
		try
		{
			oBrowser=new ChromeDriver();
			oBrowser.manage().window().maximize();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void navigate()
	{
		try
		{
			oBrowser.get("https://www.flipkart.com/");
			Thread.sleep(5000);
			WebElement oEle=oBrowser.findElement(By.xpath("//button[text()='✕']"));
			if(oEle.isDisplayed()==true)
			{
				oEle.click();
			}
			Thread.sleep(5000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void handleMouseMovements()
	{
		try
		{
			WebElement oEltronics=oBrowser.findElement(By.xpath("//div[text()='Electronics']"));
			Thread.sleep(2000);
			Actions oMouse=new Actions(oBrowser);
			oMouse.moveToElement(oEltronics).build().perform();
			Thread.sleep(2000);
			WebElement oEle1=oBrowser.findElement(By.linkText("Computer Peripherals"));
			oMouse.moveToElement(oEle1).build().perform();
			Thread.sleep(2000);
			oBrowser.findElement(By.linkText("Projectors")).click();
			
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
