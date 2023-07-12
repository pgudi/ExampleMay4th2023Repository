 package com.sgtesting.hardassertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertConditionsDemo {
	
	@Test
	public void assertTrueDemo()
	{
		try
		{
			int x=60;
			Assert.assertTrue(x>=25);
			System.out.println("This statement executes after assertTrue method...");
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
			Assert.assertFalse(x<=25);
			System.out.println("This statement executes after assertFalse method...");
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
