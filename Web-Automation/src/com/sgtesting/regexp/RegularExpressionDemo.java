package com.sgtesting.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionDemo {

	public static void main(String[] args) {
	//	matchesDemo();
	//	findDemo1();
	//	patternCount();
	//	displayMatchingPattern();
	//	displayMatchingPatternPosition();
	//	repalceDemo();
		splitDemo();
	}
	
	private static void matchesDemo()
	{
		Pattern pattern=Pattern.compile("Java");
		Matcher matcher=pattern.matcher("Java");
		
		boolean v1=matcher.matches();
		System.out.println(v1);
	}
	
	private static void findDemo1()
	{
		Pattern pattern=Pattern.compile("Java");
		Matcher matcher=pattern.matcher("Java JDK JRE Java JVM Java");
		
		boolean v1=matcher.find();
		System.out.println(v1);
	}
	
	private static void patternCount()
	{
		Pattern pattern=Pattern.compile("Java");
		Matcher matcher=pattern.matcher("Java JDK JRE Java JVM Java");
		
		int count=0;
		while(matcher.find())
		{
			count=count+1;
		}
		System.out.println("# of Occurance :"+count);
	}
	
	private static void displayMatchingPattern()
	{
		Pattern pattern=Pattern.compile("Java");
		Matcher matcher=pattern.matcher("Java JDK JRE Java JVM Java");
		while(matcher.find())
		{
			System.out.println(matcher.group());
		}
	}

	private static void displayMatchingPatternPosition()
	{
		Pattern pattern=Pattern.compile("Java");
		Matcher matcher=pattern.matcher("Java JDK JRE Java JVM Java");
		while(matcher.find())
		{
			System.out.println(matcher.group()+": Start Position :"+matcher.start()+" "+"End Position :"+matcher.end());
		}
	}
	
	private static void repalceDemo()
	{
		Pattern pattern=Pattern.compile("Java");
		Matcher matcher=pattern.matcher("Java JDK JRE Java JVM Java");
		
		String str=matcher.replaceAll("Python");
		System.out.println(str);
	}
	
	private static void splitDemo()
	{
		Pattern pattern=Pattern.compile("[,#%]");
		String s[]=pattern.split("Apple,Mango#Orange%Banana");
		
		for(String str:s)
		{
			System.out.println(str);
		}	
	}
}
