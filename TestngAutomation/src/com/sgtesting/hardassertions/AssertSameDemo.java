package com.sgtesting.hardassertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertSameDemo {

	@Test
	public void assertSameDemo()
	{
		String expected,actual;
		try
		{
			expected="JavaScripting";
			actual="JavaScripting";
			Assert.assertSame(expected, actual);
			System.out.println("This statement executes after assertSame method...");
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void assertNotSameDemo()
	{
		String expected,actual;
		try
		{
			expected="JavaScripting";
			actual="JavaScriptingNew";
			Assert.assertNotSame(expected, actual);
			System.out.println("This statement executes after assertNotSame method...");
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
