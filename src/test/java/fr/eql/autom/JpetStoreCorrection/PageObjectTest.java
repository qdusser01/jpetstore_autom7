package fr.eql.autom.JpetStoreCorrection;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import fr.eql.autom.JpetStoreCorrection.PageObject.PageAccueil;
import fr.eql.autom.JpetStoreCorrection.PageObject.PageCategory;
import fr.eql.autom.JpetStoreCorrection.PageObject.PageIndex;
import fr.eql.autom.JpetStoreCorrection.PageObject.PageLogin;
import fr.eql.autom.JpetStoreCorrection.PageObject.PageProduct;
import fr.eql.autom.JpetStoreCorrection.PageObject.PageSearch;
import fr.eql.autom.JpetStoreCorrection.PageObject.PageShoppingCart;

public class PageObjectTest extends AbstractTest {

	private String username = "j2ee";
	private String password = "j2ee";
	private String actualMessage;
	private String actualCartTitle;
	private String expectedMessage = "Welcome ABC!";
	private String idProduct = "FI-SW-01";
	private String excpectedTitle = "Fish";
	private String expectedCartTitle = "Shopping Cart";
	private String item = "EST-1";
	

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
		Assert.assertEquals("Le message de bienvenu ne correspond pas au message attendu", expectedMessage,
				actualMessage);

		// Cliquer sur l'image du 'Fish'
		PageCategory page_category = page_accueil.clicFish(driver);

		// PageCategory

		// Vérification --> Categorie fish
		Assert.assertEquals(excpectedTitle, page_category.getTitleCategory());
		// Selectionner le produit
		PageProduct page_product = page_category.selectProduct(driver, idProduct);
		// PageProduct

		// Ajouter le produit au panier
		PageShoppingCart page_shopping_cart = page_product.addItemToCart(driver, item);

		// PageShoppingCart

		// Vérifier que le panier est affiché
		actualCartTitle = page_shopping_cart.getTitle().getText(); 
		Assert.assertEquals("Titre incorrect", expectedCartTitle, actualCartTitle);

		// Modifie la quantité de produits à 2
		page_shopping_cart.modifyQuantity("2"); 
		// On update le panier
		page_shopping_cart.clickUpdateCart();
		
		// On recupere le prix unitaire et total
		String priceUnit = page_shopping_cart.getPriceUnit();
		String priceTotal = page_shopping_cart.getPriceTotal();
		
		// On modifie nos variables en supprimant le dollar
		priceUnit = priceUnit.substring(1);
		priceTotal = priceTotal.substring(1);
		
		
		// On convertit le string en double
		double d_priceTotal = ToolBox.parseStringToDouble(priceTotal);
		double d_priceUnit = ToolBox.parseStringToDouble(priceUnit);
		
		// Vérification --> le prix total est égal à deux fois le prix unitaire
		double sumExpected = 2 * d_priceUnit;
		assertTrue(sumExpected == d_priceTotal);
		
	}

	@After
	public void teardown() {
		driver.quit();
	}
}
