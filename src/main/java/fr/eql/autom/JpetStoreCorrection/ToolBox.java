package fr.eql.autom.JpetStoreCorrection;

import org.openqa.selenium.WebElement;

public class ToolBox {

	public static void fillInput(WebElement input, String value) {
		input.clear();
		input.sendKeys(value);
	}
	
	public static double parseStringToDouble(String s) {
		return Double.parseDouble(s.replace(",", "."));
	}
}

