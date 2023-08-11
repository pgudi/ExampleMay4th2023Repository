package com.sgtesting.tests.userspojo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UsersScenario {
	
	
	public static String user_id=null;
	@Test(priority = 1)
	public void createUser()
	{
		try
		{
			System.out.println("Creae User has executed successfully by using Post Http Method");
			RestAssured.baseURI="http://localhost:8081/springboot-sgsoftwaretestinginstitute-sgtesting/users";
			RequestSpecification httpRequest=RestAssured.given();
			
			Users usersObj=new Users(
					"demo","user1","demo@gmail.com","Attigupper,Vijayanagar",
					"6080907040","Karnataka","QA Automation",561234);
			
			ObjectMapper mapper=new ObjectMapper();
			String jsonContent=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(usersObj);
			
			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(jsonContent);
			
			//Execute http method post
			Response response=httpRequest.post();
			String responsecontent=response.getBody().asPrettyString();
			System.out.println(responsecontent);
			
			//capture id value
			JsonPath jpath=response.jsonPath();
			user_id=jpath.getString("id");
			System.out.println("the newly created user id :"+user_id);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2)
	public void displayUser()
	{
		try
		{
			System.out.println("Display User has executed successfully by using Get Http Method");
			RestAssured.baseURI="http://localhost:8081/springboot-sgsoftwaretestinginstitute-sgtesting/users/"+user_id;
			RequestSpecification httpRequest=RestAssured.given();
			
			//Execute http method Get
			Response response=httpRequest.get();
			String responsecontent=response.getBody().asPrettyString();
			System.out.println(responsecontent);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void deleteUser()
	{
		try
		{
			System.out.println("Delete User has executed successfully by using Delete Http Method");
			RestAssured.baseURI="http://localhost:8081/springboot-sgsoftwaretestinginstitute-sgtesting/users/"+user_id;
			RequestSpecification httpRequest=RestAssured.given();
			
			//Execute http method Delete
			Response response=httpRequest.delete();
			String responsecontent=response.getBody().asPrettyString();
			System.out.println(responsecontent);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
