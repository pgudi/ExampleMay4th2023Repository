package com.sgtesting.parametrization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDetails {
	
	@Test(dataProvider = "credentails")
	public void setCredentails(String user,String pwd)
	{
		System.out.println(user+"  -->  "+pwd);
	}

	@DataProvider(name="credentails")
	public Object[][] getCredentails()
	{
		return new Object[][] {{"admin","manager"},
			{"user1","Welcome1"},
			{"user2","Welcome2"}};
	}
}
