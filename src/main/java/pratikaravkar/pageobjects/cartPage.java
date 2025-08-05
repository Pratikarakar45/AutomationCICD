package pratikaravkar.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pratikaravkar.AbstractComponents.AbstractComponent;

public class cartPage extends AbstractComponent {

	WebDriver driver;

	
	@FindBy(xpath="//div[contains(@class,'cartSection')]/h3")
	List<WebElement> cartProduct;
	
	@FindBy(css=".totalRow button")
	WebElement checkOut;
	
	
	
	public cartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	public boolean VerifyProductDisplay(String ProductName) {
		for (int i = 0; i < cartProduct.size(); i++) {
			String listCart = cartProduct.get(i).getText();

			if (listCart.equalsIgnoreCase(ProductName)) {
				return true;
			}
		}
		return false;
	}
	
	public CheckOutPage CheckOut() {
		
		checkOut.click();
		CheckOutPage checkOutpage = new CheckOutPage(driver);
		return checkOutpage;
	}
	
//	List<WebElement> cartProduct = driver.findElements(By.xpath("//div[contains(@class,'cartSection')]/h3"));

//	driver.findElement(By.cssSelector(".totalRow button")).click();

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
