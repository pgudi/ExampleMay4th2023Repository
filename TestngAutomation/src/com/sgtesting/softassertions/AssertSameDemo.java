package com.sgtesting.softassertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertSameDemo {
	SoftAssert soft=new SoftAssert();
	@Test
	public void assertSameDemo()
	{
		String expected,actual;
		try
		{
			expected="JavaScripting";
			actual="JavaScripting";
			soft.assertSame(expected, actual);
			System.out.println("This statement executes after assertSame method...");
			soft.assertAll();
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
			soft.assertNotSame(expected, actual);
			System.out.println("This statement executes after assertNotSame method...");
			soft.assertAll();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
