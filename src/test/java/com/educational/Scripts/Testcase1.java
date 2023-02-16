package com.educational.Scripts;

import org.testng.annotations.Test;

import com.educational.mine.genericLib.BaseClass;
import com.educational.mine.pomPages.AddtocartPage;
import com.educational.mine.pomPages.LoginPage;
import com.educational.mine.pomPages.SkillaryDemoLoginPage;

public class Testcase1 extends BaseClass
{
	@Test
	public void testcase1()
	{
		test=reports.createTest("testcase1");
		LoginPage l=new LoginPage(driver);
		SkillaryDemoLoginPage hp = l.demoApp(driver);
		utilities.switchTab(driver);
		utilities.mouseHover(driver, hp.getCourseButton());
		AddtocartPage cart = hp.course(driver);
		utilities.doubleClick(driver, cart.getAddButton());
		cart.getAddButton().click();
//		utilities.alertPopupOk(driver);	
	}

}
