package com.sgtesting.tests.pojo;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentsPojo {
	public static void main(String[] args) {
	//	createJsonObject1();
	//	createJsonObject2();
		createArrayOfJsonObject1();
	}
	
	private static void createJsonObject1()
	{
		try
		{
			Students objStud1=new Students(10, "Santosh", 
					"santosh@gmail.com", "Medical");
			
			ObjectMapper mapper=new ObjectMapper();
			String jsonContent=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objStud1);
			System.out.println(jsonContent);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void createJsonObject2()
	{
		try
		{
			Students objStud1=new Students();
			objStud1.setRollNo(11);
			objStud1.setFirstName("Gamesh");
			objStud1.setEmailId("ganesh@gmail.com");
			objStud1.setBranchName("Bio Technology");
			
			ObjectMapper mapper=new ObjectMapper();
			String jsonContent=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objStud1);
			System.out.println(jsonContent);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private static void createArrayOfJsonObject1()
	{
		try
		{
			Students objStud[]= {
					new Students(10, "Santosh", 
							"santosh@gmail.com", "Medical"),
					new Students(11, "Ganesh", 
							"ganesh@gmail.com", "BioChemical"),
					new Students(12, "Shiva", 
							"shiva@gmail.com", "Botony")
			};
			
			ObjectMapper mapper=new ObjectMapper();
			String jsonContent=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objStud);
			System.out.println(jsonContent);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
