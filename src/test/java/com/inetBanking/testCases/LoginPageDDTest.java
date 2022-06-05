package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtilites;

public class LoginPageDDTest extends BaseLayerTest{
	
	@Test(dataProvider="LoginData")
	public void LoginPageDDT(String user, String pwds) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.enterUid(user);
		lp.enterPwd(pwds);
		lp.clickbtn();
		
		
		if (isAlertPresent()==true) {
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
			Thread.sleep(5000);
			lp.clickLogout();
			driver.switchTo().alert().accept(); //close logout alert
			driver.switchTo().defaultContent();
		}
	}
		public boolean isAlertPresent() {
		try {
				driver.switchTo().alert();
			    return true;
		} catch(Exception e) {
			return false;
		}
	}

	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		new XLUtilites(System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetBanking\\testData\\Login_Data.xlsx");
		int rowcount=XLUtilites.getRowCount("Sheet1");
		int cellcount=XLUtilites.getCellCount("Sheet1", 1);
		
		String logindata [][]= new String [rowcount][cellcount];
		
		for (int i=1;i<=rowcount;i++) {
			for(int j=0;j<cellcount;j++) {
				logindata [i-1] [j]= XLUtilites.getCellData("Sheet1",i,j);
			}
		}
		return logindata;
	}
}
