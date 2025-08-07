package rahulshettyacademy.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pratikaravkar.pageobjects.CheckOutPage;
import pratikaravkar.pageobjects.ConfirmationPage;
import pratikaravkar.pageobjects.LandingPage;
import pratikaravkar.pageobjects.ProductCatalogue;
import pratikaravkar.pageobjects.cartPage;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.RetryAnalyse;

public class ErrorValidation extends BaseTest{

//	cross checking error validation

	@Test(retryAnalyzer = RetryAnalyse.class)
	public void ErrorValidationTest() throws IOException, InterruptedException {

		
		loginPage.loginAppn("pratika@gmail.com", "Pra@45");
		Assert.assertEquals("Incorrect email or password.",loginPage.GetErrorMessage()); 
	}

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {
		
		String ProductName = "ZARA COAT 3";
		ProductCatalogue catalogue = loginPage.loginAppn("pratika@gmail.com", "Pratik@45");
		List<WebElement> ListProduct = catalogue.getProductList();
		catalogue.addProductToCart(ProductName);
		cartPage PageCart = catalogue.goToCartPage();

		Boolean match = PageCart.VerifyProductDisplay("ZARAA COAT 3");
		Assert.assertFalse(match);
		
	}
	

}
