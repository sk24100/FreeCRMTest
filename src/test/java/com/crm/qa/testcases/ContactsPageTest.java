package com.crm.qa.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	String sheetName="Contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		
		loginPage=new LoginPage();  //---To reach home page we have to login thats why we are doing this in BeforeMethod
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnContactsLink();
	}
	
	//@Test
	public void verifyContactsLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactLabel());
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);  //All the rows are stored here.
		return data;
		
	}
	
	@Test(dataProvider="getCRMTestData")
	public void createNewContact(String Name,String LastName,String Company,String TimeZone,String Status) throws InterruptedException {
		contactsPage.createNewContact(Name, LastName, Company, TimeZone, Status);
	}
	
	//@Test
	public void selectContactsTest() throws InterruptedException {
		Thread.sleep(5000);
		contactsPage.selectContactsByName("Ritika Singh");
		
		Thread.sleep(2000);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}