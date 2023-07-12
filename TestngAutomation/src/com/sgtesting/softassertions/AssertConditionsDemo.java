package com.sgtesting.softassertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertConditionsDemo {
	SoftAssert soft=new SoftAssert();
	@Test
	public void assertTrueDemo()
	{
		try
		{
			int x=60;
			soft.assertTrue(x>=25);
			System.out.println("This statement executes after assertTrue method...");
			soft.assertAll();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test
	public void assertFalseDemo()
	{
		try
		{
			int x=60;
			soft.assertFalse(x<=25);
			System.out.println("This statement executes after assertFalse method...");
			soft.assertAll();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
