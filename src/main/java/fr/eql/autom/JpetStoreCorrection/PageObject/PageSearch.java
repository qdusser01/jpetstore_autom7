package fr.eql.autom.JpetStoreCorrection.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import fr.eql.autom.JpetStoreCorrection.ToolBox;

public class PageSearch extends BandeauMenu {
	
	int indexResultTab=3;
	

	public WebElement getProductLink(WebDriver driver, String productName) {
		int rowIndex=ToolBox.retournerNumeroDeLigne(driver, indexResultTab, productName);
		System.out.println(rowIndex);
		return ToolBox.getCellule(driver, indexResultTab, rowIndex, 1);
	}
	
	public PageProduct selectProduct(WebDriver driver, WebElement link) {
		link.click();
		return PageFactory.initElements(driver, PageProduct.class);
	}
	
	
	
	
	
}
