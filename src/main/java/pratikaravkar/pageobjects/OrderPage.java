package pratikaravkar.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pratikaravkar.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{

	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderName;
	
	public boolean VerifyOrderDisplay(String ProductName) {
		for (int i = 0; i < orderName.size(); i++) {
			String listCart = orderName.get(i).getText();

			if (listCart.equalsIgnoreCase(ProductName)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
}