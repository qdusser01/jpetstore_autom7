package fr.eql.autom.JpetStoreCorrection.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAccueil extends BandeauMenu {
	@FindBy (tagName="i")
	private WebElement welcomeMessage;
	@FindBy(xpath="//*[@alt='Fish']")
	private WebElement linkFish;

	public String getWelcomeMessage () {
		return welcomeMessage.getText();	
	}
	
	public PageCategory clicFish(WebDriver driver) {
	linkFish.click();	
	return PageFactory.initElements(driver, PageCategory.class);	
	}

}
