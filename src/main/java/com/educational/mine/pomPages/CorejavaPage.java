package com.educational.mine.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CorejavaPage {
	@FindBy(xpath = "//a[.=' Core Java For Selenium Trainin']")
	private WebElement corejavaLink;
	

	public CorejavaPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCorjavaLink() {
		return corejavaLink;
	}

	public WishlistPage Corejavaselenium(WebDriver driver)
	{
		corejavaLink.click();
		return new WishlistPage(driver);
	}
}
