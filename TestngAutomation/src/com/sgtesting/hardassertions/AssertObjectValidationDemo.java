package com.sgtesting.hardassertions;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertObjectValidationDemo {
	
	@Test
	public void assertNullDemo()
	{
		try
		{
			File obj=null;
			Assert.assertNull(obj);
			System.out.println("This statement executes after assertNull method...");
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test
	public void assertNotNullDemo()
	{
		try
		{
			File obj=null;
			obj=new File("D:\\WELCOME");
			Assert.assertNotNull(obj);
			System.out.println("This statement executes after assertNotNull method...");
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
