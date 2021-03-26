package fr.eql.autom.JpetStoreCorrection;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToolBox {

	public static void fillInput(WebElement input, String value) {
		input.clear();
		input.sendKeys(value);
	}

	public static double parseStringToDouble(String s) {
		return Double.parseDouble(s.replace(",", "."));
	}

	public static void selectCheckBox(WebElement checkbox) {
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
	}

	/**
	 * Cette méthode permet de renvoyer une cellule de tableau sous la forme d'un
	 * WebElement
	 * 
	 * @param driver
	 * @param tableIndex l'index xpath du table dans la page
	 * @param row        l'index xpath de la ligne ciblée
	 * @param col        l'index xpath de la colonne ciblée
	 * @return
	 */
	public static WebElement getCellule(WebDriver driver, int tableIndex, int row, int col) {
		WebElement element = driver
				.findElement(By.xpath("//table[" + tableIndex + "]/tbody/tr[" + row + "]/td[" + col + "]"));
		return element;
	}
	

	public static int retournerNumeroDeLigne(WebDriver driver, int tableIndex,String s) {
		int ligneCourante = 1;
		List<WebElement> l_lignes = driver.findElements(By.xpath("//table[" + tableIndex + "]/tbody/tr"));
		for (WebElement ligne : l_lignes) {
			List<WebElement> l_cell = ligne.findElements(By.xpath("td"));
			for (WebElement cell : l_cell) {
				if (cell.getText().equals(s)) {
					return ligneCourante;
				}
			}
			ligneCourante++;
		}
		return -1;
	}

	
	public static void unselectCheckbox(WebElement checkbox) {
		if (checkbox.isSelected()) {
			checkbox.click();
		}
	}
}
