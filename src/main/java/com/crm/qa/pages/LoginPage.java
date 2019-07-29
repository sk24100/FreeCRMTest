package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// PageFactory - OR

	@FindBy(xpath = "//span[text()='Log In']")
	@CacheLookup
	WebElement homeLogin;

	@FindBy(xpath = "//input[@name='email']")
	@CacheLookup
	WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//div[text()='Login']")
	@CacheLookup
	WebElement loginBtn;

	@FindBy(xpath = "//span[contains(text(),'sign up')]")
	@CacheLookup  ///If you feel it wont change then only use else it will give stale element reference error.
	WebElement signUpBtn;

	// Initialising the object repository
	public LoginPage() {
		PageFactory.initElements(driver, this); // means pointing to current class object
	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();

	}

	public boolean validateLoginBtnHome() {
		return homeLogin.isDisplayed();
	}

	/// Login Page is returning HomePage object as HomePage is landing page of
	/// LoginPage

	public HomePage login(String un, String pw) throws InterruptedException {

		homeLogin.click();
		Thread.sleep(1000);

		userName.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();

		return new HomePage(); /// Important
	}

}
