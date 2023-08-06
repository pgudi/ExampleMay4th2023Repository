package com.sgtesting.tests;
interface University
{
	void showUniversityName(String name);
}

interface College
{
	void displayCollegeName(String name);
}

class EnggCollege implements College,University
{
	public void showUniversityName(String name)
	{
		System.out.println("University Name :"+name);
	}
	
	public void displayCollegeName(String name)
	{
		System.out.println("Engineering Colege Name :"+name);
	}
}
public class MultipleInheritanceDemo {
	public static void main(String[] args) {
		University vtu=new EnggCollege();
		vtu.showUniversityName("VTU Belguam");
		
		College college= (College) vtu;
		college.displayCollegeName("BMS Engineering College");

	}

}
