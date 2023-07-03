package com.sgtesting.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WithWebElementDemo {

	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		login();
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
			oBrowser.get("http://localhost/login.do");
			Thread.sleep(5000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private static void login()
	{
		WebElement oEle=null;
		try
		{
			oEle=oBrowser.findElement(By.id("username"));
			oEle.sendKeys("DemoUser1");
			Thread.sleep(2000);
			oEle.clear();
			Thread.sleep(2000);
			oEle.sendKeys("DemoUser2");
			Thread.sleep(2000);
			oEle.clear();
			Thread.sleep(2000);
			oEle.sendKeys("DemoUser3");
			Thread.sleep(2000);
			oEle.clear();
			Thread.sleep(2000);
			oEle.sendKeys("DemoUser4");
			Thread.sleep(2000);
			oEle.clear();
			Thread.sleep(2000);
			oEle.sendKeys("DemoUser12345");
			Thread.sleep(2000);
			String v1=oEle.getAttribute("value");
			System.out.println(v1);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
