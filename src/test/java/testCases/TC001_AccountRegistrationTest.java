package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("**** Starting TC001_AccountRegistrationTest  ****");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on myaccount link");
		hp.clickMyRegister();
		logger.info("clicked on register link");
		
		RegisterPage rp=new RegisterPage(driver);
		
		logger.info("providing customer details..");
		rp.setfirstname(randomString().toUpperCase());
		rp.setlastname(randomString().toUpperCase());
		rp.setemail(randomString()+"@gmail.com"); //randomly generated the email
		rp.settelephone(randomNumber());
		
		String password = randomalphanumeric();
		rp.setpassword(password);
		rp.confirmpassword(password);
		
		rp.setPrivacyPolicy();
		rp.clickContinue();
		
		logger.info("validating expected message");
		String message = rp.getConfirmationmsg();
		if(message.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed..");
			logger.debug("debug logs...");
			Assert.assertFalse(false);
		}
		}
        catch(Exception e)
		{
		Assert.fail();
		}
		logger.info("**** finished TC001_AccountRegistrationTest  ****");
}
}
