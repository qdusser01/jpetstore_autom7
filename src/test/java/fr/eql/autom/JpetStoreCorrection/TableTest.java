package fr.eql.autom.JpetStoreCorrection;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import fr.eql.autom.JpetStoreCorrection.PageObject.PageAccueil;
import fr.eql.autom.JpetStoreCorrection.PageObject.PageIndex;
import fr.eql.autom.JpetStoreCorrection.PageObject.PageLogin;
import fr.eql.autom.JpetStoreCorrection.PageObject.PageProduct;
import fr.eql.autom.JpetStoreCorrection.PageObject.PageSearch;

public class TableTest extends AbstractTest{

	String query="dog";
	String productName="Dalmation";
	
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
		
		// Je recherche "dog"
		PageSearch page_search=page_accueil.search(driver, query);
		
		
		WebElement productLink=page_search.getProductLink(driver, productName);
		
		PageProduct page_product = page_search.selectProduct(driver, productLink);
		
	}

}
