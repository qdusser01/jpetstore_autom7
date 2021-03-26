package fr.eql.autom.JpetStoreCorrection;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import fr.eql.autom.JpetStoreCorrection.PageObject.PageAccueil;
import fr.eql.autom.JpetStoreCorrection.PageObject.PageIndex;
import fr.eql.autom.JpetStoreCorrection.PageObject.PageLogin;
import fr.eql.autom.JpetStoreCorrection.PageObject.PageMyAccount;

public class MyAccountTest extends AbstractTest {
	
	String favLanguage = "japanese";
	String favCategory = "Reptiles";

	@Before
	public void setup() {
		selectBrowser(browser);
	}

	@Test
	public void test() {
		driver.get("http://localhost:8090/jpetstore-1.0.5-env2");
		// PageIndex
		PageIndex page_index = PageFactory.initElements(driver, PageIndex.class);

		// Clic SignIn
		PageLogin page_login = page_index.clickSignIn(driver);

		// PageLogin
		// Je me logue
		PageAccueil page_accueil = page_login.signIn(driver, login, passwd);
		
		PageMyAccount page_myaccount = page_accueil.clickMyAccount(driver);
		
		// Select japanese comme language de pref et reptile en animal favori
		page_myaccount.selectFavoriteLanguage(favLanguage);
		page_myaccount.selectFavoriteCategory(favCategory.toUpperCase());
		
		// Vérification que les select sont bien affichés
		String actualSelectedLanguage = page_myaccount.getSelectedLanguage();
		Assert.assertEquals("La langue selectionnée n'est pas celle affichée", favLanguage, actualSelectedLanguage);
		
		// Vérification que les select sont bien affichés
		String actualSelectedCategory = page_myaccount.getSelectedCategory();
		Assert.assertEquals("La catégorie selectionnée n'est pas celle affichée", favCategory.toUpperCase(), actualSelectedCategory);
		
		// Vérification que EnableMyList et EnableMyBanner sont select par defaut
		Assert.assertTrue(page_myaccount.isMyBannerCheckboxSelected());
		Assert.assertTrue(page_myaccount.isMyListCheckboxSelected());
		
		// Déselction de EnableMyList
		page_myaccount.unselectMyListCheckbox();
		Assert.assertFalse("My list n'est pas deselectionnée", page_myaccount.isMyListCheckboxSelected());
	}

}
