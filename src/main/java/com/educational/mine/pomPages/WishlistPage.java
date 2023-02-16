package com.educational.mine.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage 
{
@FindBy(xpath = "//button[@aria-label='Play']")
private WebElement playButton;

@FindBy(xpath = "//span[.='Add To Wishlist']")
private WebElement addtowishlistLink;

	public WishlistPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);	}
	
	public void playvideo()
	{
		playButton.click();
	}
	
	public void addtowishlist()
	{
		addtowishlistLink.click();
	}
}
