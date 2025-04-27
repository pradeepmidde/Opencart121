package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.Dataproviders;

/*Data is valid- login success -test pass-logout
 *               login failed-test fail
 * 
 * data is invalid-login success -test fail - logout
 *               login failed-test pass
 */

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=Dataproviders.class,groups="DataDriven")
	public void verify_loginDDT(String email, String password, String exp )
	{
		logger.info("*********** starting TC003_loginDDT*************");
		try
		{
		//homepage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//login page
		LoginPage lp=new LoginPage(driver);
		lp.setemail(email);
		lp.setpassword(password);
		lp.clicklogin();
		
		//myaccount
		MyAccountPage mp=new MyAccountPage(driver);
		boolean targetpage = mp.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage==true)
			{
				mp.clicklogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				mp.clicklogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*********** Finished TC003_loginDDT*************");

	}

}
