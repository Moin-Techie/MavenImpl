package com.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest 
{
	public WebDriver driver;
	
	@BeforeTest(description="This method is used for set-up")
	public void start()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	}
	
	@AfterTest(description="This method is used for Garbage Collection")
	public void end()
	{
		driver.quit();
	}
}
