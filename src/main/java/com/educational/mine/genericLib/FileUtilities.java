package com.educational.mine.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.testng.Reporter;
import com.mysql.jdbc.Driver;


/**
 * 
 * @author Soumya
 *
 */
public class FileUtilities
{
	public static Connection con;
	/**
	 * It is used to read data from propertyfile
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	public String getPropertyFile(String key) throws FileNotFoundException, IOException
	{
		Properties p=new Properties();
		p.load(new FileInputStream(AutoConstant.datapropertiesfile));
		return p.getProperty(key);
	}
	
	/**
	 * To read data from ExcelSheet
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */

//	public String getexcelfile(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
//	{
//     FileInputStream fis=new FileInputStream(AutoConstant.excelfilepath);
//     Workbook wb= WorkbookFactory.create(fis);
//     return wb.getSheet("Sheet1").getRow(rownum).getCell(cellnum).getStringCellValue(); 
//	}
	
//	@DataProvider
//	public Object[][] readExcelData() throws EncryptedDocumentException, IOException
//	{
//		FileInputStream fis=new FileInputStream(AutoConstant.excelfilepath);
//		Workbook wb= WorkbookFactory.create(fis);
//		Sheet s = wb.getSheet("Sheet1");
//		int rownum = s.getLastRowNum();
//		short cellnum = s.getRow(1).getLastCellNum();
//		
//		Object obj[][]=new Object[rownum][cellnum];
//				for(int i=0;i<=rownum;i++)
//				{
//					for(int j=0;j<=cellnum;j++)
//					{
//				    obj[i][j]=s.getRow(i+1).getCell(j).getStringCellValue();
//					System.out.println(obj[i][j]);
//					}	
//				}
//				return obj;
//	}
//	
	/**
	 * It is used to read the data from DataBase
	 * @return
	 * @throws SQLException
	 */
	
	public static Connection getDataDb() throws SQLException
	{
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		return con= DriverManager.getConnection("jdbc:mysql://localhost:3306/testing","root","7377164377");	
	}
	
	/**
	 * 
	 * @param query
	 * @param column
	 * @param epdata
	 * @param expdata
	 * @return
	 * @throws SQLException
	 */
	
	public static String queryExecution(String query,int column,String expdata) throws SQLException
	{
	   Statement statement = con.createStatement();
	   ResultSet result = statement.executeQuery(query);
	   while(result.next())
	   {
		   if(result.getString(column).equals(expdata))
		   {
			   break;
		   }
		   else
		   {
			   Reporter.log("data not matching");
		   }
	   }
	return expdata;   
}

	  void closedb() {
		
	}
}
