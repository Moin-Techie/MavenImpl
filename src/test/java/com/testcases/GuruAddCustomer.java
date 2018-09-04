package com.testcases;

import org.testng.annotations.Test;

import com.pages.GuruLogin;
import com.pages.utilities.HelperClass;
import com.utilities.BaseTest;

public class GuruAddCustomer extends BaseTest
{
	@Test
	public void runner() throws Exception
	{
		driver=HelperClass.openBrowser(driver,HelperClass.getData("GuruTestData", "Login", 1, 0));
		driver.get(HelperClass.getData("GuruTestData", "Login", 1, 1));
		GuruLogin.login(driver, HelperClass.getData("GuruTestData", "Login", 1, 2), HelperClass.getData("GuruTestData", "Login", 1, 3));
		
		Thread.sleep(3000);
	}
}
