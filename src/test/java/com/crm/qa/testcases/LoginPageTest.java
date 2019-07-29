package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super(); //
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		//loginPage object you have to create
		
		loginPage=new LoginPage();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginPage.validateLoginPageTitle();
		
		Assert.assertEquals(title, "Free CRM software for any Business");
	}
	
	@Test (priority=2)
	public void loginButtonTest() {
		boolean flag= loginPage.validateLoginBtnHome();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
}
