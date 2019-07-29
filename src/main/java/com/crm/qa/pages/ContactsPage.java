package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[text()='Contacts']")
	@CacheLookup  								//this mean it will store in cache and speed will improved else evrytime it will look up in DOM
	WebElement contactsLabel;

	@FindBy(xpath = "//a[@href='/contacts/new']")
	@CacheLookup
	WebElement newcontactLnk;

	@FindBy(name = "first_name")
	@CacheLookup
	WebElement firstName;

	@FindBy(name = "last_name")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(xpath = "//div[@name='company']//input")
	@CacheLookup
	WebElement companyName;

	@FindBy(css = ".save")
	@CacheLookup
	WebElement saveContact;

	// @FindBy(xpath="//td[text()='Ritika Singh']//preceding-sibling::td")
	// Tomorrow name maychange right so better to apply different approach here.

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactLabel() {
		return contactsLabel.isDisplayed();
	}

	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//table//td[text()='" + name + "']//preceding-sibling::td//div")).click();
	}

	// Reference not used
	public void clickOnNewContact() {
		Actions act = new Actions(driver);
		act.moveToElement(newcontactLnk).build().perform();
	}

	public void createNewContact(String name, String lname,String companyname, String timezone, String status)
			throws InterruptedException {
		newcontactLnk.click();
		firstName.sendKeys(name);
		lastName.sendKeys(lname);
		companyName.sendKeys(companyname);

		driver.findElement(By.xpath("//div[@name='timezone']//i")).click();

		List<WebElement> timezoneoptions = driver
				.findElements(By.xpath("//div[@role='listbox'][@class='visible menu transition']//div"));

		for (WebElement option : timezoneoptions) {
			if (option.getText().equals(timezone)) {
				option.click();
				break;
			}
		}

		/// Clicking on status
		driver.findElement(By.xpath("//div[@name='status']//i")).click();

		List<WebElement> statusoptions = driver.findElements(By.xpath("//div[@role='listbox'][@class='visible menu transition']//div"));

		for (WebElement option : statusoptions) {
			if (option.getText().equals(status)) {
				option.click();
				break;
			}
		}

		saveContact.click();
		Thread.sleep(2000);

	}

}
