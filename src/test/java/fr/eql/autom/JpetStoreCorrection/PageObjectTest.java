package fr.eql.autom.JpetStoreCorrection;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageObjectTest extends AbstractTest {

	@Before
	public void setup() {
		selectBrowser(browser);
	}
	
	@Test
	public void jPetTest() {
		
//PageIndex
		//Clic SignIn
		
//PageLogin		
		// Je me logue
		

//PageAccueil        
		//Verification --> Je suis loggué (Wel
		
		// Cliquer sur l'image du 'Fish'
		

//PageCategory       
		//Vérification --> Categorie fish
		
        //Selectionner le produit

//PageProduct        
        //Ajouter le produit au panier

//PageShoppingCart		
        //Vérifier que le panier est affiché
        
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

