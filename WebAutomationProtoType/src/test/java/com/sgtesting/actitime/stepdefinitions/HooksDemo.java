package com.sgtesting.actitime.stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksDemo {
	
	@Before
	public void iConnectToDB()
	{
		System.out.println("I connect to a Oracle Client Database !!!!!");
	}

	@After
	public void iDisConnectFromDB()
	{
		System.out.println("I dis connect from a Oracle Client Database !!!!!");
	}
}
