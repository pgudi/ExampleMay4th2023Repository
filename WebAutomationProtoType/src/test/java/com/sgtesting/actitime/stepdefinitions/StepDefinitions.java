package com.sgtesting.actitime.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	public static WebDriver oBrowser=null;
	/**
	 * I launch the Chrome Browser
	 */
	@Given("^I launch the Chrome Browser$")
	public void I_launch_the_Chrome_Browser()
	{
		try
		{
			oBrowser=new ChromeDriver();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I navigate the Application
	 */
	@And("^I navigate the Application$")
	public void I_navigate_the_Application()
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
	
	/**
	 * I enter the username in username text field
	 */
	@When("^I enter the (.*) in username text field$")
	public void I_enter_the_username_in_username_text_field(String username)
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys(username);
			Thread.sleep(1000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I enter the password in password text field
	 */
	@And("^I enter the \"(.*)\" in password text field$")
	public void I_enter_the_password_in_password_text_field(String password)
	{
		try
		{
			oBrowser.findElement(By.name("pwd")).sendKeys(password);
			Thread.sleep(1000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I click on Login button
	 */
	@And("^I click on Login button$")
	public void I_click_on_Login_button()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(5000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I find the Home page
	 */
	@Then("^I find the Home page$")
	public void I_find_the_Home_page()
	{
		try
		{
			WebElement oEle=oBrowser.findElement(By.xpath("//td[text()='Enter Time-Track']"));
			Assert.assertTrue(oEle.isDisplayed());
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I minimize flyout window
	 */
	@And("^I minimize flyout window$")
	public void I_minimize_flyout_window()
	{
		try
		{
			oBrowser.findElement(By.id("gettingStartedShortcutsPanelId")).click();
			Thread.sleep(2000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I click on Logout link
	 */
	@When("^I click on Logout link$")
	public void I_click_on_Logout_link()
	{
		try
		{
			oBrowser.findElement(By.linkText("Logout")).click();
			Thread.sleep(2000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I find the login page
	 */
	@Then("^I find the login page$")
	public void I_find_the_login_page()
	{
		String expected,actual;
		try
		{
			expected="actiTIME - Login";
			actual=oBrowser.getTitle();
			Assert.assertEquals(expected, actual);
			Thread.sleep(2000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I close the Application
	 */
	@And("^I close the Application$")
	public void I_close_the_Application()
	{
		try
		{
			oBrowser.quit();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
