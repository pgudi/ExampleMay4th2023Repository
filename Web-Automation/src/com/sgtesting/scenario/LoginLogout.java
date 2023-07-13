package com.sgtesting.scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginLogout {
	
	public static WebDriver oBrowser=null;
	@Test(priority = 1)
	public void launchBrowser()
	{
		try
		{
			oBrowser=new ChromeDriver();
			Assert.assertNotNull(oBrowser);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2, dataProvider = "navigate")
	public void navigate(String url)
	{
		String expected,actual;
		try
		{
			expected="actiTIME - Login";
			oBrowser.navigate().to(url);
			Thread.sleep(5000);
			actual=oBrowser.getTitle();
			Assert.assertEquals(expected, actual);
			
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3,dataProvider = "logindata")
	public void login(String user,String pwd)
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys(user);
			oBrowser.findElement(By.name("pwd")).sendKeys(pwd);
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(5000);
			WebElement oEle=oBrowser.findElement(By.xpath("//td[text()='Enter Time-Track']"));
			Assert.assertTrue(oEle.isDisplayed());
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void minimizeFlyOutWindow()
	{
		try
		{
			oBrowser.findElement(By.id("gettingStartedShortcutsPanelId")).click();
			Thread.sleep(2000);
			WebElement oEle=oBrowser.findElement(By.xpath("//div[@id='gettingStartedShortcutsMenuWrapper']"));
			Assert.assertEquals("display: none;", oEle.getAttribute("style"));
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 5)
	public void logout()
	{
		String expected,actual;
		try
		{
			expected="actiTIME - Login";
			oBrowser.findElement(By.linkText("Logout")).click();
			Thread.sleep(2000);
			actual=oBrowser.getTitle();
			Assert.assertEquals(expected, actual);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 6)
	public void closeApplication()
	{
		try
		{
			oBrowser.quit();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@DataProvider(name="navigate")
	public Object[][] getURL()
	{
		return new Object[][] {{"http://localhost/login.do"}};
	}
	
	@DataProvider(name="logindata")
	public Object[][] getLoginData()
	{
		return new Object[][] {{"admin","manager"}};
	}
}
