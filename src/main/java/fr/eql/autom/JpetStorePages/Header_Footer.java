package fr.eql.autom.JpetStorePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Header_Footer { // BendeauMenu
	
	@FindBy (xpath = "//*[@name='img_signin']")	WebElement signinButton;
	
	public PageLogin clickSigninButton(WebDriver driver) {
		signinButton.click();
		return PageFactory.initElements(driver, PageLogin.class);
	}
	
	@FindBy (xpath = "//a[@href='shop/viewCart.do']") WebElement viewCart;
	
	public PageShoppingCart clickViewCart(WebDriver driver) {
		viewCart.click();
		return PageFactory.initElements(driver, PageShoppingCart.class);
	}
	

}
