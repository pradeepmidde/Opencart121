package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//a[@title='My Account']") WebElement LnkMyAccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement LnkMyRegister;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement linkLogin;
	
	public void clickMyAccount()
	{
		LnkMyAccount.click();
	}

	public void clickMyRegister()
	{
		LnkMyRegister.click();
	}
	public void clickLogin()
	{
		linkLogin.click();	
	}
}
