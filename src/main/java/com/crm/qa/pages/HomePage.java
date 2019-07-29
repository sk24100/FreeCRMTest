package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(css=".user-display")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(css=".users")
	@CacheLookup
	WebElement contactsLnk;
	
	@FindBy(css=".money")
	WebElement dealsLnk;
	
	@FindBy(css=".tasks")
	WebElement tasksLnk;
	
	//Initializing page object
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLnk.click();
		
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLnk.click();
		
		return new DealsPage();
	}
	
	public TaskPage clickOnTasksLink() {
		tasksLnk.click();
		
		return new TaskPage();
	}
	
	

}
