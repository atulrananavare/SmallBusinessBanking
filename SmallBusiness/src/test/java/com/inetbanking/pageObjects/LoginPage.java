package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	//input[@name='uid']
	
	@FindBy(name="uid")
	private WebElement userId;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="btnLogin")
	private WebElement btnLogin;
	
	public void setUserId(String user) {
		userId.sendKeys(user);
	}
	
	public void setpassword(String pswd) {
		password.sendKeys(pswd);
	}

	public void loginButton() {
		btnLogin.click();
	}
	
}
