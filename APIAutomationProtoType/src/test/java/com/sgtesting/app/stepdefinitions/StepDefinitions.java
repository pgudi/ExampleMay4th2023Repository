package com.sgtesting.app.stepdefinitions;

import org.testng.Assert;
import com.sgtesting.app.users.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class StepDefinitions {
	public static RequestSpecification httpRequest=null;
	public static Response response=null;
	public static String user_id=null;
	/**
	 * I provide createUser EndPoint
	 */
	@Given("^I provide createUser EndPoint$")
	public void I_provide_createUser_EndPoint()
	{
		try
		{
			RestAssured.baseURI="http://localhost:8081/springboot-sgsoftwaretestinginstitute-sgtesting/users";
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * I get RequestSpecification object
	 */
	@And("^I get RequestSpecification object$")
	public void I_get_RequestSpecification_object()
	{
		try
		{
			 httpRequest=RestAssured.given();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * I Create user Request object
	 */
	@And("^I Create user Request object$")
	public void I_Create_user_Request_object()
	{
		try
		{
			Users usersObj=new Users(
					"demo","user1","demo@gmail.com","Attigupper,Vijayanagar",
					"6080907040","Karnataka","QA Automation",561234);
			
			ObjectMapper mapper=new ObjectMapper();
			String jsonContent=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(usersObj);
			
			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(jsonContent);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I post the request object and get the Response
	 */
	@When("^I post the request object and get the Response$")
	public void I_post_the_request_object_and_get_the_Response()
	{
		try
		{
			//Execute http method post
			response=httpRequest.post();
			String responsecontent=response.getBody().asPrettyString();
			System.out.println(responsecontent);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I get 201 status code
	 */
	@Then("^I get 201 status code$")
	public void I_get_201_status_code()
	{
		try
		{
			int statusCode=response.getStatusCode();
			Assert.assertEquals(201, statusCode);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I get user_id from newly created user
	 */
	@And("^I get user_id from newly created user$")
	public void I_get_user_id_from_newly_created_user()
	{
		try
		{
			//capture id value
			JsonPath jpath=response.jsonPath();
			user_id=jpath.getString("id");
			System.out.println("the newly created user id :"+user_id);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I provide displayUser EndPoint
	 */
	@Given("^I provide displayUser EndPoint$")
	public void I_provide_displayUser_EndPoint()
	{
		try
		{
			RestAssured.baseURI="http://localhost:8081/springboot-sgsoftwaretestinginstitute-sgtesting/users/"+user_id;
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I Get the Response object
	 */
	@When("^I Get the Response object$")
	public void I_Get_the_Response_object()
	{
		try
		{
			//Execute http method Get
			response=httpRequest.get();
			String responsecontent=response.getBody().asPrettyString();
			System.out.println(responsecontent);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I get 200 status code
	 */
	@Then("^I get 200 status code$")
	public void I_get_200_status_code()
	{
		try
		{
			int statusCode=response.getStatusCode();
			Assert.assertEquals(200, statusCode);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I provide deleteUser EndPoint
	 */
	@Given("^I provide deleteUser EndPoint$")
	public void I_provide_deleteUser_EndPoint()
	{
		try
		{
			RestAssured.baseURI="http://localhost:8081/springboot-sgsoftwaretestinginstitute-sgtesting/users/"+user_id;
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I delete the resource from server
	 */
	@When("^I delete the resource from server$")
	public void I_delete_the_resource_from_server()
	{
		try
		{
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
