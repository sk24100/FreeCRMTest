package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage=new LoginPage();  //---To reach home page we have to login thats why we are doing this in BeforeMethod
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	//@Test
	public void verifyHomePageTitleTest() throws InterruptedException {
		//homePage.verifyHomePageTitle();
		Assert.assertEquals(homePage.verifyHomePageTitle(), "CRM","Home Page title not matching");
	}
	
	//@Test
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	
	@Test
	public void verifyContactLinkTest() {
		contactsPage=homePage.clickOnContactsLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
