package fr.eql.autom.JpetStoreCorrection.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fr.eql.autom.JpetStoreCorrection.ToolBox;

public class PageLogin extends BandeauMenu {

	@FindBy (name = "username")
	private WebElement usernameField;
	
	@FindBy (name = "password")
	private WebElement passwordField;
	
	@FindBy (name = "update")
	private WebElement loginButton;
	
	public PageAccueil signIn(WebDriver driver, String username, String password) {
		
		ToolBox.fillInput(usernameField, username);

		ToolBox.fillInput(passwordField, password);
		
		loginButton.click();
		
		return PageFactory.initElements(driver, PageAccueil.class);
	}
	
}
