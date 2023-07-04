package com.sgtesting.reflection5;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RunnerScript {
	public static void main(String[] args) {
		executeMethods();

	}
	private static void executeMethods()
	{
		Workbook wb=null;
		FileInputStream fin=null;
		Sheet sh=null;
		Row row=null;
		Cell cell=null;
		try
		{
			fin=new FileInputStream(".\\DataFiles\\data_Runner.xlsx");
			wb=new XSSFWorkbook(fin);

			int sheetcount=wb.getNumberOfSheets();
			for(int s=0;s<sheetcount;s++) 
			{
				String name=wb.getSheetName(s);
				sh=wb.getSheet(name);
				System.out.println("Sheet Name :"+name);
				int rc=sh.getPhysicalNumberOfRows();
				for(int r=1;r<rc;r++)
				{
					row=sh.getRow(r);
					cell=row.getCell(0);
					String methodname=cell.getStringCellValue();
					cell=row.getCell(1);
					String pkgclassname=cell.getStringCellValue();

					System.out.println(methodname+" --> "+pkgclassname);
					//Dynamic way of object creation
					Class objClass=Class.forName(pkgclassname);
					Object obj=objClass.getConstructor().newInstance();

					Method m=obj.getClass().getMethod(methodname);
					m.invoke(obj);
				}
			}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fin.close();
				wb.close();
			}catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}

}
