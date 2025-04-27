package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
	
	public RegisterPage(WebDriver driver) {
		super(driver);
	}

@FindBy(xpath="//input[@id='input-firstname']") WebElement textFirstname;
@FindBy(xpath="//input[@id='input-lastname']") WebElement textLastname;
@FindBy(xpath="//input[@id='input-email']") WebElement textEmail;
@FindBy(xpath="//input[@id='input-telephone']") WebElement textTelephone;
@FindBy(xpath="//input[@id='input-password']") WebElement textPassword;
@FindBy(xpath="//input[@id='input-confirm']") WebElement ConfirmPassword;
@FindBy(xpath="//input[@name='agree']") WebElement CheckBox;
@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirm;

public void setfirstname(String fname)
{
	textFirstname.sendKeys(fname);
}
public void setlastname(String lname)
{
	textLastname.sendKeys(lname);
}
public void setemail(String email)
{
	textEmail.sendKeys(email);
}
public void settelephone(String phone)
{
	textTelephone.sendKeys(phone);
}
public void setpassword(String pwd)
{
	textPassword.sendKeys(pwd);
}
public void confirmpassword(String confpwd)
{
	ConfirmPassword.sendKeys(confpwd);
}
public void setPrivacyPolicy()
{
CheckBox.click();	
}
public void clickContinue()
{
	btnContinue.click();
}

public String getConfirmationmsg()
{
	try {
		return (msgConfirm.getText());
	}
	catch (Exception e)
	{
		return (e.getMessage());
	}
}
}
