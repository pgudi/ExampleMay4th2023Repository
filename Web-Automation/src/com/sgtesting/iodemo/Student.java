package com.sgtesting.iodemo;

import java.io.Serializable;

public class Student implements Serializable{
	
	private int rollNo;
	private String firstName;
	private String branchName;
	private String location;
	
	public Student(int rollNo,String firstName,String bName,String location)
	{
		this.rollNo=rollNo;
		this.firstName=firstName;
		this.branchName=bName;
		this.location=location;
	}
	
	public void showFirstName()
	{
		System.out.println("First Name of the Student :"+firstName);
	}
	
	public void showRollNo()
	{
		System.out.println("Roll Number of the Student :"+rollNo);
	}

	public void showBranchName()
	{
		System.out.println("Brnahc Name of the Student :"+branchName);
	}
	
	public void showLocation()
	{
		System.out.println("Location of the Student :"+location);
	}
}
