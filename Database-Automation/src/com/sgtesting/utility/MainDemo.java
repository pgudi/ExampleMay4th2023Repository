package com.sgtesting.utility;

import java.util.ArrayList;

public class MainDemo {

	public static void main(String[] args) {
		
		int rc=DBUtility.getRecords("select * from dept");
		System.out.println("# of Records :"+rc);

		int cc=DBUtility.getColumns("select * from dept");
		System.out.println("# of Columns :"+cc);
		
		ArrayList obj=DBUtility.getRecords("DEPT", "DNAME");
		System.out.println(obj);
	}

}
