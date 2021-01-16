package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.BaseTest;

public class TC_LoginPage extends BaseTest {
	
	
	@Test(description="Login functionality Check",groups="Smoke")
	public void TC_001() {
		
		logger.info("Web Page opened succesfuly");
		LoginPage page= new LoginPage(driver);
		
		page.setUserId(userName);
		logger.info("username entered");
		page.setpassword(password);
		logger.info("password entered");
		page.loginButton();
		
		String title=driver.getTitle();
		
		if(title.equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("on Guru99 Bank Manager HomePage");
		}
		else {
			Assert.assertTrue(false);
			logger.info("Failed to on Guru99 Bank Manager HomePage");
		}
	
	}

}
