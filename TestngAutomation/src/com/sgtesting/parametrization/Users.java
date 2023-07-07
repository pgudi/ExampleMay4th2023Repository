package com.sgtesting.parametrization;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Users {
	@Parameters(value="username")
	@Test
	public void createUser(String username)
	{
		System.out.println("The User "+username+" has created successfully");
	}

	@Test
	public void modifyUser()
	{
		System.out.println("The User demoUser1 has modified successfully");
	}
	
	@Test
	public void deleteUser()
	{
		System.out.println("The User demoUser1 has deleted successfully");
	}
	
	@BeforeClass
	public void setUp()
	{
		System.out.println("Launches Browser, Navigate the URL and Login into the Application");
	}
	@AfterClass
	public void tearDown()
	{
		System.out.println("Logout from the Application and Closes the Application");
		System.out.println("+++++++++++++++++++++++++++++++++");
	}
}
