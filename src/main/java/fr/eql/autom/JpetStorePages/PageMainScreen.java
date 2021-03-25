package fr.eql.autom.JpetStorePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageMainScreen extends Header_Footer { // pageAccueil
	
	@FindBy (xpath = "//font[text()='Welcome ABC!']") WebElement welcomeMessage;
	
	@FindBy (xpath = "//*[@alt='Fish']") WebElement productFish;

}
