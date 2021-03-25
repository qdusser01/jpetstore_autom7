package fr.eql.autom.JpetStoreCorrection;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import fr.eql.autom.JpetStoreCorrection.PageObject.BandeauMenu;
import fr.eql.autom.JpetStoreCorrection.PageObject.PageAccueil;
import fr.eql.autom.JpetStoreCorrection.PageObject.PageCategory;
import fr.eql.autom.JpetStoreCorrection.PageObject.PageIndex;
import fr.eql.autom.JpetStoreCorrection.PageObject.PageLogin;

public class PageObjectTest extends AbstractTest {

	private String username = "j2ee";
	private String password = "j2ee";
	private String actualMessage;
	private String expectedMessage = "Welcome ABC!";

	@Before
	public void setup() {
		selectBrowser(browser);
	}

	@Test
	public void jPetTest() {
		driver.get("http://localhost:8090/jpetstore-1.0.5-env2");
		// PageIndex
		PageIndex page_index = PageFactory.initElements(driver, PageIndex.class);

		// Clic SignIn
		PageLogin page_login = page_index.clickSignIn(driver);

		// PageLogin
		// Je me logue
		PageAccueil page_accueil = page_login.signIn(driver, username, password);

		// PageAccueil
		// Verification --> Je suis loggué (Welcome Message)
		actualMessage = page_accueil.getWelcomeMessage();
		Assert.assertEquals("Le message de bienvenu ne correspond pas au message attendu" ,expectedMessage,  actualMessage);


		// Cliquer sur l'image du 'Fish'
		PageCategory page_category = page_accueil.clicFish(driver);

		// PageCategory
		// Vérification --> Categorie fish

		// Selectionner le produit

		// PageProduct
		// Ajouter le produit au panier

		// PageShoppingCart
		// Vérifier que le panier est affiché

		// Modifie la quantité de produits à 2

		// On update le panier

		// On récupère le prix unitaire et total

		// On modifie nos variables en supprimant le dollar

		// On remplace la virgule par un point

		// On convertit le string en double

		// Vérification --> le prix total est égal à deux fois le prix unitaire
	}

	@After
	public void teardown() {
		driver.quit();
	}
}
