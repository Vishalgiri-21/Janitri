package com.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginPage;

public class TC_Login extends BaseClass {
	LoginPage page;

	@Test
	public void testLoginButtonDisabledWhenFieldAreEmpty() {
		page = new LoginPage(driver);
		WebElement login = page.setLoginBTN();
		boolean isEnabled = login.isEnabled();
		Assert.assertFalse(isEnabled, "Login button should be disabled when fields are empty");
	}

	@Test
	public void testPasswordMaskedbutton() {
		page = new LoginPage(driver);
		WebElement masked = page.setVisibility_Toggle();
		String fieldTypes = masked.getAttribute("pass@123");
		Assert.assertEquals(fieldTypes, "password", "Password field is masked");

	}

	@Test
	public void testInvalidLoginShowErrorMsg() {
		page = new LoginPage(driver);
		page.setUser_ID("User001");
		page.setPassword("Pass@001");
		WebElement errorMsg = page.setLoginBTN();
		String actualMsg = errorMsg.getText();
		assertEquals(" Invalid credential", actualMsg, "Error message is not correct for invalid login");
	}

}
