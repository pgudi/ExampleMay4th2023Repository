package com.sgtesting.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionDemo1 {
	public static void main(String[] args) {
		regExpTesting1();
		regExpTesting2();
		regExpTesting3();
	}
	
	private static void regExpTesting1()
	{
		String str="Bangalore received 125 milimeter of rain yesterday";
		Pattern pattern=Pattern.compile("[0-9][0-9][0-9]");
		Matcher matcher=pattern.matcher(str);
		
		boolean v1=matcher.find();
		System.out.println(v1);
	}

	private static void regExpTesting2()
	{
		String str="Bangalore received 125 milimeter of rain yesterday";
		Pattern pattern=Pattern.compile("[0-9]{3}");
		Matcher matcher=pattern.matcher(str);
		
		String val=matcher.replaceAll("many");
		System.out.println(val);
	}
	
	private static void regExpTesting3()
	{
		String str="The temple is at the top of the hill";
		Pattern pattern=Pattern.compile("[A-Za-z]+");
		Matcher matcher=pattern.matcher(str);
		
		while(matcher.find())
		{
			System.out.println(matcher.group());
		}
	}
}
