package fr.eql.autom.JpetStoreCorrection;

import static org.junit.Assert.*;

import java.util.concurrent.TimeoutException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JpetStoreTestExo2 extends AbstractTest {

	
	
	@Before
	public void setup() {
		selectBrowser(browser);
		System.out.println("setup");
	}
	
	@Test
	public void jPetTest() {
		
		driver.get("http://localhost:8090/jpetstore-1.0.5-env2");
		
		// Je me logue
		WebElement signinButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='shop/signonForm.do']")));
        signinButton.click();

        WebElement fieldusername = driver.findElement(By.name("username"));
        fieldusername.clear();
        fieldusername.sendKeys("j2ee");

        WebElement fieldpassword = driver.findElement(By.name("password"));
        fieldpassword.clear();
        fieldpassword.sendKeys("j2ee");

        WebElement submitLoginButton=  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("update"))));
        submitLoginButton.click();
        
        String expectedMessage = "Welcome ABC!";

        wait.until(ExpectedConditions.textToBe(By.tagName("i"), expectedMessage));

     // Cliquer sur l'image du 'Fish'
        driver.findElement(By.xpath("//*[@alt='Fish']")).click();
        String actualTitle = driver.findElement(By.tagName("h2")).getText();
        String expectedTitle = "Fish";
        assertEquals("Le titre est different de celui attendu" ,expectedTitle, actualTitle);
        
        //Selectionner le produit
        WebElement productLink = driver.findElement(By.xpath("//a[contains(@href,'viewProduct.do?productId=FI-SW-01')]"));
        productLink.click();
        
        //Ajouter le produit au panier
        WebElement addToCartLink = driver.findElement(By.xpath("//a[contains(@href,'addItemToCart.do?workingItemId=EST-1')]"));
        addToCartLink.click();
        
        //Vérifier que le panier est affiché
        String actualCartTitle = driver.findElement(By.tagName("h2")).getText();
        String expectedCartTitle = "Shopping Cart";
        assertEquals("Le titre est différent du titre attendu", expectedCartTitle, actualCartTitle);
        
     // Modifie la quantité de produits à 2
        WebElement productQuantityField = driver.findElement(By.name("EST-1"));
        productQuantityField.clear();
        productQuantityField.sendKeys("2");

        // On update le panier
        WebElement updateCartButton = driver.findElement(By.name("update"));
        updateCartButton.click();

        // On récupère le prix unitaire et total
        String unitPrice = driver.findElement(By.xpath("//td[contains(text(), '$')][1]")).getText();
        String totalPrice = driver.findElement(By.xpath("//td[contains(text(), '$')][2]")).getText();

        // On modifie nos variables en supprimant le dollar
        unitPrice = unitPrice.substring(1);
        totalPrice = totalPrice.substring(1);

        // On remplace la virgule par un point
        unitPrice = unitPrice.replace(',', '.');
        totalPrice = totalPrice.replace(',', '.');

        // On converti le string en double
        double d_unitPrice = Double.parseDouble(unitPrice);
        double d_totalPrice = Double.parseDouble(totalPrice);

        assertEquals("Le prix total ne correspond pas au prix unitaire x la quantité", 2*d_unitPrice, d_totalPrice, 0);
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}
