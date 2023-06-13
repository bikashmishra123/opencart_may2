package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	//homepage , Loginpage , Myaccount 
	
	
	@Test(groups= {"Sanity","Master"})
	public void test_login() {
		try {
			
		
		logger.info("***Starting TC_002_LoginTest ***");
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("clikced on my acount");
		
		hp.clickLogin();
		logger.info("clikced on login link");
		
		LoginPage lp = new LoginPage(driver);
		logger.info("providing login details");
		
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickLogin();
		logger.info("clicked on loging button");
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetpage = macc.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true);
	}
	
	catch(Exception e) {
		
		Assert.fail();
	}
		
		logger.info("***Finished TC_002_LoginTest ***");
  }
}