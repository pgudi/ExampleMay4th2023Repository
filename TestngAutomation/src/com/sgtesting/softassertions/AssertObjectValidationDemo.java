package com.sgtesting.softassertions;

import java.io.File;
                       import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertObjectValidationDemo {
	SoftAssert soft=new SoftAssert();
	@Test
	public void assertNullDemo()
	{
		try
		{
			File obj=null;
			soft.assertNull(obj);
			System.out.println("This statement executes after assertNull method...");
			soft.assertAll();
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
			soft.assertNotNull(obj);
			System.out.println("This statement executes after assertNotNull method...");
			soft.assertAll();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
