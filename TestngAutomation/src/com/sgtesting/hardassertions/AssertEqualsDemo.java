package com.sgtesting.hardassertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertEqualsDemo {
	
	@Test(enabled = false)
	public void assertEqualsDemo()
	{
		String expected,actual;
		try
		{
			expected="JavaScripting1";
			Assert.assertEquals(expected, "JavaScripting");
			System.out.println("This statement executes after assertEquals method...");
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
			Assert.assertNotEquals(expected, "JavaScripting");
			System.out.println("This statement executes after assertNotEquals method...");
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
