package com.pages.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class HelperClass 
{	
	public static SimpleDateFormat sd = new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
	public static String now = sd.format(new Date());
	
	
	public static void takeScreenshot(WebDriver driver,String name) throws Exception
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,  new File("./ScreenShots/"+name+now+".png"));
	}
	
	
	public static String getData(String filename, String sheetname,int row, int col) throws Exception
	{
		File f= new File("./TestData/"+filename+".xlsx");
		FileInputStream fis = new FileInputStream(f);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetname);
		
		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	public static WebDriver openBrowser(WebDriver driver, String browser)
	{
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.out.println("Browser");
			driver=new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
}
