package com.sgtesting.softassertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertEqualsDemo {
	SoftAssert soft=new SoftAssert();
	@Test
	public void assertEqualsDemo()
	{
		String expected,actual;
		try
		{
			expected="JavaScripting1";
			soft.assertEquals(expected, "JavaScripting");
			System.out.println("This statement executes after assertEquals method...");
			soft.assertAll();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test
	public void assertNotEqualsDemo()
	{
		String expected,actual;
		try
		{
			expected="JavaScriptingNew";
			soft.assertNotEquals(expected, "JavaScripting");
			System.out.println("This statement executes after assertNotEquals method...");
			soft.assertAll();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
