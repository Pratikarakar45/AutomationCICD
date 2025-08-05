package pratikaravkar.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pratikaravkar.pageobjects.OrderPage;
import pratikaravkar.pageobjects.cartPage;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorder']")
	WebElement OrderHeader;
	
	
	public void waitElementAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitElementWebAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	public cartPage goToCartPage() {

		cartHeader.click();
		cartPage PageCart = new cartPage(driver);
		return PageCart;

	}
	
	public OrderPage goToOrderpage() {
		OrderHeader.click();
		OrderPage orderpage = new OrderPage(driver);
		return orderpage;
		
	}
	
	

	public void waitElementDisappear(WebElement ele) throws InterruptedException {

		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(ele));

	}

}
