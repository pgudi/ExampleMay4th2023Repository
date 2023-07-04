package com.sgtesting.reflection6;

import java.lang.reflect.Method;

public class ExecuteParametrizedMethods {

	public static void main(String[] args) {
		executeMethods();

	}
	
	private static void executeMethods()
	{
		CustomerDetails obj=new CustomerDetails();
		try
		{
			Class strparams[]=new Class[2];
			strparams[0]=String.class;
			strparams[1]=String.class;
			
			Method m1=obj.getClass().getMethod("getPersonDetails", strparams);
			m1.invoke(obj, new String("Santosh"),new String("Bangalore"));
			
			Class intparam[]=new Class[1];
			intparam[0]=Integer.TYPE;
			
			Method m2=obj.getClass().getMethod("displayEmpNumber", intparam);
			m2.invoke(obj, 11);
			
			Class sparam[]=new Class[1];
			sparam[0]=String.class;
			
			Method m3=obj.getClass().getMethod("showStateName", sparam);
			m3.invoke(obj, new String("Karnataka"));
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
