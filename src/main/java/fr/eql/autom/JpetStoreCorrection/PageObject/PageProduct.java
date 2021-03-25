package fr.eql.autom.JpetStoreCorrection.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageProduct extends BandeauMenu {

	public PageShoppingCart addItemToCart(WebDriver driver, String item) {
		WebElement addToCartButton = driver
				.findElement(By.xpath("//a[contains(@href,'addItemToCart.do?workingItemId=" + item + "')]"));
		addToCartButton.click();
		return PageFactory.initElements(driver, PageShoppingCart.class);
	}

}
