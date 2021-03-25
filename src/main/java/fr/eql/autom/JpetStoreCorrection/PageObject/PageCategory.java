package fr.eql.autom.JpetStoreCorrection.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

public class PageCategory extends BandeauMenu {
	
	@FindBy(tagName = "h2")
	private WebElement titleCategory;


	public PageProduct selectProduct (WebDriver driver, String idProduct)	{
		WebElement productLink = driver.findElement(By.xpath("//a[contains(@href,'viewProduct.do?productId=" + idProduct + "')]"));
		productLink.click();
		return PageFactory.initElements(driver,PageProduct.class);
	}
	
	public String getTitleCategory () {
		return titleCategory.getText();
		
	}

}
