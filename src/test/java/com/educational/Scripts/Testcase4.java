package com.educational.Scripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.educational.mine.genericLib.BaseClass;
import com.educational.mine.pomPages.JunitPage;
import com.educational.mine.pomPages.LoginPage;
import com.educational.mine.pomPages.SkillaryDemoLoginPage;

public class Testcase4 extends BaseClass 
{
	@Test
	public void testcase4() throws FileNotFoundException, IOException, SQLException
	{
		test=reports.createTest("testcase4");
		
		LoginPage lp=new LoginPage(driver);
		SkillaryDemoLoginPage hp = lp.demoApp(driver);
		utilities.switchTab(driver);
		utilities.dropdown(hp.getCourseDropdd(),fu.getPropertyFile("dd"));
		
		JunitPage jp= new JunitPage(driver);
		String query="select * from course";
		String data = fu.queryExecution(query, 1, "INR 19.00");
	}

}
