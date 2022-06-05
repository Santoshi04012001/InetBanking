

package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//initialization of webdriver
	WebDriver driver;

	public LoginPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//find webelements
	
	@FindBy (name="uid")
	WebElement userId;
	
	@FindBy(name="password")
	WebElement pswd;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath="//a[@href='Logout.php']")
	WebElement logout;
	

	//actions
	
	public void enterUid (String uname) {
		userId.sendKeys(uname);
	}
	
	public void enterPwd(String pwd) {
		pswd.sendKeys(pwd);
	}
	
	public void clickbtn() {
		btnLogin.click();
	}
	
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public void clickLogout() {
		logout.click();
	}
}