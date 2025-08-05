package pratikaravkar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pratikaravkar.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	WebElement userEmails = driver.findElement(By.id("userEmail"));
//	driver.findElement(By.id("userPassword")).sendKeys("Pratik@45");
//	driver.findElement(By.id("login")).click();

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement submit;

	@FindBy(css = ".toast-message")
	WebElement ErrorMssg;

	public ProductCatalogue loginAppn(String email, String pwd) {

		userEmail.sendKeys(email);
		password.sendKeys(pwd);
		submit.click();
		ProductCatalogue catalogue = new ProductCatalogue(driver);
		return catalogue;

	}

	public String GetErrorMessage() {
		waitElementWebAppear(ErrorMssg);
		return ErrorMssg.getText();
		
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");

	}

}
