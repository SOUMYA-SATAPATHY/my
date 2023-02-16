package com.educational.mine.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JunitPage 
{
	@FindBy(xpath = "(//a[.='munit testing '])[2]")
	private WebElement junitLink;
	
	public JunitPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getJunitLink() {
		return junitLink;
	}
	

}
