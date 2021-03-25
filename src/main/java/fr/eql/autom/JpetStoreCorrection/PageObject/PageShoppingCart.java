package fr.eql.autom.JpetStoreCorrection.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageShoppingCart extends BandeauMenu {
	@FindBy(tagName = "h2")
	private WebElement title;
	
	@FindBy (name = "EST-1")
	WebElement quantityField;
	
	
	public void ModifyQuantity(String quantity) {
		quantityField.clear();
		quantityField.sendKeys(quantity);
	}
	
 
	public WebElement getTitle() {
		return title;
		
		
	}

}
