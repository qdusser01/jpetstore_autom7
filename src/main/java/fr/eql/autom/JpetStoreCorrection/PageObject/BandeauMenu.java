package fr.eql.autom.JpetStoreCorrection.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BandeauMenu {

	@FindBy(xpath = "//a[@href='shop/signonForm.do']")
	private WebElement signInButton;
	
	@FindBy(xpath = "//*[@name='img_myaccount']/parent::a")
	private WebElement myAccountButton;
	
	public PageLogin clickSignIn(WebDriver driver) {
		signInButton.click();
		return PageFactory.initElements(driver, PageLogin.class);
	}
	
	public PageMyAccount clickMyAccount(WebDriver driver) {
		myAccountButton.click();
		return PageFactory.initElements(driver, PageMyAccount.class);
	}
	
}
