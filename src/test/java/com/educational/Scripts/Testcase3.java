package com.educational.Scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.educational.mine.genericLib.BaseClass;
import com.educational.mine.pomPages.CorejavaPage;
import com.educational.mine.pomPages.LoginPage;
import com.educational.mine.pomPages.WishlistPage;

public class Testcase3 extends BaseClass {
	@Test
	public void testcase3() throws FileNotFoundException, IOException
	{
	test=reports.createTest("testcase3");	
			
	LoginPage lp=new LoginPage(driver);
	CorejavaPage c = lp.searchCourse(driver, fu.getPropertyFile("cn"));
	WishlistPage ad = c.Corejavaselenium(driver);
	utilities.switchFrame(driver);
	
	utilities.switchBackfromFrame(driver);
	ad.addtowishlist();
	
	Assert.assertEquals(driver.getTitle(), fu.getPropertyFile("title"));
	}

}
