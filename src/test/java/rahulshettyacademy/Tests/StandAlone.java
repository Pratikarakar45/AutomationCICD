package rahulshettyacademy.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pratikaravkar.pageobjects.LandingPage;

public class StandAlone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// new comments added

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		String ProductName = "ZARA COAT 3";
		driver.get("https://rahulshettyacademy.com/client/");

		LandingPage loginPage = new LandingPage(driver);
		
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("userEmail")).sendKeys("pratika@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Pratik@45");
		driver.findElement(By.id("login")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		List<WebElement> ListProduct = driver.findElements(By.cssSelector(".mb-3"));

		for (int i = 0; i < ListProduct.size(); i++) {

			String productList = ListProduct.get(i).findElement(By.tagName("b")).getText();

			if (productList.equals(ProductName)) {

				ListProduct.get(i).findElement(By.cssSelector(".card-body button:last-of-type")).click();
				break;
			}
		}
		System.out.println(driver.findElement(By.cssSelector(".toast-message")).getText());

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-message")));

		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		List<WebElement> cartProduct = driver.findElements(By.xpath("//div[contains(@class,'cartSection')]/h3"));

		for (int i = 0; i < cartProduct.size(); i++) {
			String listCart = cartProduct.get(i).getText();

			if (listCart.equalsIgnoreCase(ProductName)) {
				driver.findElement(By.cssSelector(".totalRow button")).click();
				break;
			}
		}
		Actions country = new Actions(driver);
		
		country.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"India").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	
		driver.findElement(By.cssSelector(".btnn")).click();
		
		String orderplaced = driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(orderplaced);
		Assert.assertEquals(orderplaced, "THANKYOU FOR THE ORDER.");
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
	}

}
