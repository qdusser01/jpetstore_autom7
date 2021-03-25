package fr.eql.autom.JpetStoreCorrection.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import fr.eql.autom.JpetStoreCorrection.ToolBox;

public class PageShoppingCart extends BandeauMenu {
	@FindBy(tagName = "h2")
	private WebElement title;
	
	@FindBy (name = "EST-1")
	WebElement quantityField;
	
	@FindBy (name="update") WebElement updateCartButton;
	@FindBy (xpath = "//td[contains(text(), '$')][1]") private WebElement priceUnit;
	@FindBy (xpath = "//td[contains(text(), '$')][2]") private WebElement priceTotal;
	
	
	public String getPriceUnit() {
		return priceUnit.getText();
	}
	
	public String getPriceTotal() {
		return priceTotal.getText();
	}
	
	public void clickUpdateCart() {
		updateCartButton.click();		
	}
	
	
	public void modifyQuantity(String quantity) {
		ToolBox.fillInput(quantityField, quantity);
	}
	
 
	public WebElement getTitle() {
		return title;
		
		
	}

}
