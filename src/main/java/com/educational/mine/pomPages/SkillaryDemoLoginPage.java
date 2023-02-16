package com.educational.mine.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillaryDemoLoginPage {
	@FindBy(xpath = "//a[.='COURSE']")
	private WebElement courseButton;
	
	@FindBy(xpath = "//a[.='Selenium Training']")
	private WebElement seleniumTraining;
	
	@FindBy(name="addresstype")
	private WebElement coursedd;
	
	public WebElement getCourseDropdd() {
		return coursedd;
	}

	public SkillaryDemoLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCourseButton() {
		return courseButton;
	}

	public WebElement getSeleniumTraining() {
		return seleniumTraining;
	}
	
	public AddtocartPage course(WebDriver driver)
	{
		seleniumTraining.click();
		return new AddtocartPage(driver);
	}

}
