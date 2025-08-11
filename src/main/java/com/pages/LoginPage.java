package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	@FindBy (id="formEmail") WebElement User_ID;
	@FindBy (id="formPassword") WebElement Password;
	@FindBy (css="#root > div > div > div.login-form > div.form-content > div > form > button") WebElement LoginBTN;
	@FindBy (css="#root > div > div > div.login-form > div.form-content > div > form > div:nth-child(4) > img") WebElement Visibility_Toggle;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void setUser_ID(String user_ID) {
		User_ID.sendKeys(user_ID);
	}

	public void setPassword(String password) {
		Password.sendKeys(password);
	}

	public WebElement setLoginBTN() {
		LoginBTN.click();
		return LoginBTN;
	}

	public WebElement setVisibility_Toggle() {
		Visibility_Toggle.click();
		return LoginBTN;
	}



}
