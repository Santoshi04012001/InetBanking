package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class LoginPageTest extends BaseLayerTest {

	@Test
	public void tc1_loginTest() throws IOException {
		LoginPage lp= new LoginPage(driver);
		lp.enterUid(uname);
		lp.enterPwd(pwd);
		lp.clickbtn();
		lp.getTitle();
		
		if (lp.getTitle().equals("GTPL Bank Manager HomePage") ) {
			Assert.assertTrue(true);
		} else {
			takesScreenshot (driver , "tc1_logintest");
			Assert.assertTrue(false);	
		}
		
	}
	
}
