package com.educational.Scripts;

import org.testng.annotations.Test;

import com.educational.mine.genericLib.Demo;
import com.educational.mine.pomPages.ContactUsPage;
import com.educational.mine.pomPages.LoginPage;

public class Testcase2 extends Demo
{
	@Test(dataProvider = "readExcelData")
	public void testcase2(String name, String mail, String sub, String msg) throws InterruptedException
	{
			test=reports.createTest("testcase2");
			LoginPage lp=new LoginPage(driver);
//			Thread.sleep(5000);
//			Point loc = lp.getContactUsLink().getLocation();
//			int x = loc.getX();
//			int y = loc.getY();
//			utilities.scrollBar(driver, x, y);
			ContactUsPage cp=lp.contact(driver);
			Thread.sleep(5000);
			cp.sendDetails(name, mail, sub, msg);	
		}
	}
	
