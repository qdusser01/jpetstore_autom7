package fr.eql.autom.JpetStorePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin extends Header_Footer {
	
	
	
	@FindBy (xpath = "//input[@name='username']") WebElement username_field;
	@FindBy (xpath = "//input[@name='password']") WebElement pwd_field;
	@FindBy (xpath = "//input[@name='update']") WebElement submitButton;
	
	public PageMainScreen login(WebDriver driver, String username, String password) {
		username_field.clear();
		username_field.sendKeys(username);
		pwd_field.clear();
		pwd_field.sendKeys(password);
		submitButton.click();
		return PageFactory.initElements(driver, PageMainScreen.class);
		
	}
	
	

}
