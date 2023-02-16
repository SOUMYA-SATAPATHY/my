package com.educational.mine.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Soumya
 *
 */

public class LoginPage 
{
	/**
	 * It is used to store all the login elements
	 */
	
@FindBy(xpath = "//a[.=' GEARS ']")
private WebElement gearButton;

@FindBy(xpath = "(//a[.=' SkillRary Demo APP'])[2]")
private WebElement skillaryDemoAppLink;

	@FindBy(xpath = "//a[.=' Contact Us ']")
	private WebElement contactUsLink;

	@FindBy(name="q")
	private WebElement searchTextbox;
	
	@FindBy(xpath = "//input[@value='go']")
	private WebElement searchButton;

	
public WebElement getSearchTextbox() {
		return searchTextbox;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

public LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public SkillaryDemoLoginPage demoApp(WebDriver driver)
{
	gearButton.click();
	skillaryDemoAppLink.click();
	return new SkillaryDemoLoginPage(driver);
}

public ContactUsPage contact(WebDriver driver)
{
	contactUsLink.click();
	return new ContactUsPage(driver);
}

public CorejavaPage searchCourse(WebDriver driver,String coursename) 
{
	searchTextbox.sendKeys(coursename);
	searchButton.click();
	return new CorejavaPage(driver);
	
}

public WebElement getContactUsLink() {
	return contactUsLink;
}

public WebElement getGearButton() {
	return gearButton;
}

public WebElement getSkillaryDemoAppLink() {
	return skillaryDemoAppLink;
}
}
