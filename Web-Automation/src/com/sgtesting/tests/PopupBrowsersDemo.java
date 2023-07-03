package com.sgtesting.tests;
  
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopupBrowsersDemo {
	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		handlePopUpBrowsers();
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

	private static void handlePopUpBrowsers()
	{
		WebElement oLink=null;
		try
		{
			oLink=oBrowser.findElement(By.linkText("actiTIME Inc."));
			Thread.sleep(2000);
			System.out.println("Before Click on Link, Number of Popups :"+popupCount());
			oLink.click();
			Thread.sleep(2000);
			System.out.println("Before Click on Link, Number of Popups :"+popupCount());
			if(popupCount() > 0)
			{
				popupsOperations();
			}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static int popupCount()
	{
		int count=0;
		count=oBrowser.getWindowHandles().size()-1;
		return count;
	}
	
	private static void popupsOperations()
	{
		try
		{
			String parentBrowser=oBrowser.getWindowHandle();
			System.out.println("Parent Browser :"+parentBrowser);
			
			Object[] popups=oBrowser.getWindowHandles().toArray();
			for(int i=1;i<popups.length;i++)
			{
				String childBrowser=popups[i].toString();
				System.out.println("Child Browser :"+childBrowser);
				Thread.sleep(2000);
				oBrowser.switchTo().window(childBrowser);
				String url=oBrowser.getCurrentUrl();
				System.out.println("URL :"+url);
				String title=oBrowser.getTitle();
				System.out.println("Title :"+title);
				oBrowser.findElement(By.linkText("Log in")).click();
				Thread.sleep(2000);
			}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
