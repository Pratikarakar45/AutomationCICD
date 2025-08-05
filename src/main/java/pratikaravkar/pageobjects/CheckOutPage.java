package pratikaravkar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pratikaravkar.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[placeholder='Select Country']")
	WebElement Country;

	@FindBy(css = ".btnn")
	WebElement submitBtn;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement SelectCountry;
	

	By results = By.cssSelector(".ta-results");

	public void selectcountry(String CountryName) {

		Actions country = new Actions(driver);

		country.sendKeys(Country, CountryName).build().perform();

		waitElementAppear(results);

		SelectCountry.click();

	}

	public ConfirmationPage SubmitOrder() {
		submitBtn.click();
		
		ConfirmationPage conformOrder = new ConfirmationPage(driver);
		return conformOrder;
		
	}
	
	
	
	
	
	
	

	
}
