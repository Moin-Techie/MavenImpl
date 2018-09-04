package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.utilities.HelperClass;



public class GuruLogin 
{
	public static void login(WebDriver driver,String uname, String pwd) throws Exception
	{
		String actualTitle = driver.getTitle().trim();
		String expectedTitle = " Guru99 Bank Home Page ".trim();
		Assert.assertEquals(actualTitle,expectedTitle,"Title Matches");
		
		driver.findElement(By.name("uid")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pwd);
	
		HelperClass.takeScreenshot(driver, "Login");
		
		driver.findElement(By.name("btnLogin")).click();
	
		System.out.println("Hello");
	}
}
