package com.sgtesting.iodemo;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationDemo {
	public static void main(String[] args) {
		readObjectFromFile();
	}
	
	private static void readObjectFromFile()
	{
		FileInputStream fin=null;
		ObjectInputStream in=null;
		Student student=null;
		try
		{
			fin=new FileInputStream("D:\\EXAMPLE\\students.ser");
			in=new ObjectInputStream(fin);
			
			student=(Student) in.readObject();
			
			student.showRollNo();
			student.showFirstName();
			student.showBranchName();
			student.showLocation();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
