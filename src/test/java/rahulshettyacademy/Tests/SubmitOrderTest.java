package rahulshettyacademy.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pratikaravkar.pageobjects.CheckOutPage;
import pratikaravkar.pageobjects.ConfirmationPage;
import pratikaravkar.pageobjects.LandingPage;
import pratikaravkar.pageobjects.OrderPage;
import pratikaravkar.pageobjects.ProductCatalogue;
import pratikaravkar.pageobjects.cartPage;
import rahulshettyacademy.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	String ProductName = "ZARA COAT 3";

	@Test(dataProvider= "getData", groups= {"parches"})
	public void submitOrder(HashMap<String,String>input) throws IOException, InterruptedException {

		ProductCatalogue catalogue = loginPage.loginAppn(input.get("Email"), input.get("Password"));

		List<WebElement> ListProduct = catalogue.getProductList();
		catalogue.addProductToCart(input.get("product"));
		cartPage PageCart = catalogue.goToCartPage();

		Boolean match = PageCart.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckOutPage checkOutpage = PageCart.CheckOut();
		checkOutpage.selectcountry("India");
		ConfirmationPage conformOrder = checkOutpage.SubmitOrder();

		String orderplaced = conformOrder.getConfirmMssg();
		System.out.println(orderplaced);
		Assert.assertEquals(orderplaced, "THANKYOU FOR THE ORDER.");

	}

	@Test(dependsOnMethods= {"submitOrder"})
	public void SubmitOrderPage() {
		ProductCatalogue catalogue = loginPage.loginAppn("pratika@gmail.com", "Pratik@45");
		OrderPage orderpage = catalogue.goToOrderpage();
		Assert.assertTrue(orderpage.VerifyOrderDisplay(ProductName)); 

	}

//	public void getScreenShot() {
//
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File Source = ts.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(Source,)
//
//	}

	@DataProvider
	public Object[][] getData() throws IOException{


		List<HashMap<String, String>> data = getJesonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\pratikaravkar\\data\\purchaseOrder.json");
		return new Object[][] { {data.get(0)}, {data.get(1)} };

	}


}

//@DataProvider
//public Object[][] getData(){
//	
//	return new Object[][] {{"pratika@gmail.com","Pratik@45","ZARA COAT 3"},{"atharvaa@gmail.com","Atharva@22","ADIDAS ORIGINAL"}};
//	
//}

//HashMap <String,String> datadriven = new HashMap<String,String>();
//datadriven.put("Email", "pratika@gmail.com");
//datadriven.put("Password", "Pratik@45");
//datadriven.put("product", "ZARA COAT 3");
//
//HashMap<String,String> datadriven1 = new HashMap<String,String>();
//datadriven1.put("Email", "atharvaa@gmail.com");
//datadriven1.put("Password", "Atharva@22");
//datadriven1.put("product", "ADIDAS ORIGINAL");

