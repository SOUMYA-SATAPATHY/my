package com.educational.mine.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage
{
 @FindBy(name = "name")
 private WebElement nameTextfield;
 
 @FindBy(name = "sender")
 private WebElement emailTextfield;
 
 @FindBy(name = "subject")
 private WebElement subjectTextfield;

 @FindBy(name = "message")
 private WebElement messageTextarea;
 
 @FindBy(xpath = "//button[.='Send us mail']")
 private WebElement sendusemailButton;



public ContactUsPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void sendDetails(String name,String mail,String sub,String msg )
{
	nameTextfield.sendKeys(name);
	emailTextfield.sendKeys(mail);
	subjectTextfield.sendKeys(sub);
	messageTextarea.sendKeys(msg);
	sendusemailButton.click();
}


}