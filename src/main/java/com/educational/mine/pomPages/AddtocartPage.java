package com.educational.mine.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtocartPage {
	@FindBy(id="add")
	private WebElement	addButton;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-lg btn-flat']")
	private WebElement addtoCartButton;
	
	public AddtocartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddButton() {
		return addButton;
	}

	public WebElement getAddtoCartButton() {
		return addtoCartButton;
	}
}
