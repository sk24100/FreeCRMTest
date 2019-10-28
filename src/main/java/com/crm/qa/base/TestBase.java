package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
 //all the other classes use inheritance
	
	public static WebDriver driver;  // Global variables
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase(){  
		//Constructor contains properties files
		try {
			 prop=new Properties();
			 FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			 prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		e_driver=new EventFiringWebDriver(driver);  //1st
		//Now create object of EventListenerHandle to register it with EventFiringWebDriver
		eventListener=new WebEventListener();   //2nd
		e_driver.register(eventListener);   //3rd
		driver=e_driver;    				//4th ---Assign it to main driver
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	


}
