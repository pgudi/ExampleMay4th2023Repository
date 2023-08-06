package com.sgtesting.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUtility {
	
	/**
	 * No of Records from the given Query
	 */
	public static int getRecords(String query)
	{
		int rc=0;
		Connection conn=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
			Statement stmt=conn.createStatement();
			
			ResultSet rs=stmt.executeQuery(query);
			rc=0;
			while(rs.next())
			{
				rc=rc+1;
			}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return rc;
	}
	
	/**
	 * No of Columns from the given Query
	 */
	public static int getColumns(String query)
	{
		int cc=0;
		Connection conn=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
			Statement stmt=conn.createStatement();
			
			ResultSet rs=stmt.executeQuery(query);
			ResultSetMetaData rsdata=rs.getMetaData();
			cc=rsdata.getColumnCount();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return cc;
	}

	/**
	 * Based on tableName and ColumnName, Return records
	 */
	public static ArrayList getRecords(String tableName,String columnName)
	{
		int cc=0;
		Connection conn=null;
		ArrayList obj=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
			Statement stmt=conn.createStatement();
			String query="select "+columnName+" from "+tableName;
			ResultSet rs=stmt.executeQuery(query);
			obj=new ArrayList();
			while(rs.next())
			{
				obj.add(rs.getString(columnName));
			}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return obj;
	}
	
}
