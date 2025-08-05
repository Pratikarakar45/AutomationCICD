package pratikaravkar.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pratikaravkar.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;

	
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css = ".mb-3")
	List<WebElement> ListProduct;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;

	
	
	By ListProductBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By ToastMssg = By.cssSelector(".toast-message");
	
	
	public List<WebElement> getProductList() {

		waitElementAppear(ListProductBy);
		return ListProduct;
	}

	
	public WebElement getProductByName(String ProductName) {

		for (int i = 0; i < getProductList().size(); i++) {

			String productList = getProductList().get(i).findElement(By.tagName("b")).getText();

			if (productList.equals(ProductName)) {

				return getProductList().get(i);
			}
		}
		return null;	
	}

	
	public void addProductToCart(String ProductName) throws InterruptedException {
		
		WebElement prod = getProductByName(ProductName);
		prod.findElement(addToCart).click();
		waitElementAppear(ToastMssg);
		waitElementDisappear(spinner);


	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
