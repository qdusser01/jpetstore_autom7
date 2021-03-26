package fr.eql.autom.JpetStoreCorrection.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import fr.eql.autom.JpetStoreCorrection.ToolBox;

public class PageMyAccount extends BandeauMenu {
	
	@FindBy(name = "account.languagePreference")
	private WebElement selectLanguage;

	@FindBy(name = "account.favouriteCategoryId")
	private WebElement selectCategory;

	@FindBy(name = "account.listOption")
	private WebElement myListCheckbox;

	@FindBy(name = "account.bannerOption")
	private WebElement myBannerCheckbox;
	
	public void selectFavoriteLanguage(String language) {
		Select select = new Select(selectLanguage);
		select.selectByValue(language);
	}
	
	public String getSelectedLanguage() {
		Select select = new Select(selectLanguage);
		return select.getFirstSelectedOption().getAttribute("value");
	}
	
	public void selectFavoriteCategory(String category) {
		Select select = new Select(selectCategory);
		select.selectByValue(category);
	}
	
	public String getSelectedCategory() {
		Select select = new Select(selectCategory);
		return select.getFirstSelectedOption().getAttribute("value");
	}

	public boolean isMyListCheckboxSelected() {
		return myListCheckbox.isSelected();
	}

	public boolean isMyBannerCheckboxSelected() {
		return myBannerCheckbox.isSelected();
	}
	
	public void unselectMyListCheckbox() {
		ToolBox.unselectCheckbox(myListCheckbox);
	}
}
