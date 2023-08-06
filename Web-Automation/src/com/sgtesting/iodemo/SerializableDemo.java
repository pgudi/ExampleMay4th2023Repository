package com.sgtesting.iodemo;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializableDemo {
	public static void main(String[] args) {
		writeObjectInToFile();

	}
	
	private static void writeObjectInToFile()
	{
		FileOutputStream fout=null;
		ObjectOutputStream out=null;
		Student student=null;
		try
		{
			fout=new FileOutputStream("D:\\EXAMPLE\\students.ser");
			out=new ObjectOutputStream(fout);
			student=new Student(10, "Santosh", "Medical", "Bangalore");
			
			out.writeObject(student);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
