package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import testbase.TestBase;

public class TestUtility extends TestBase{

	
	public static void scrollToElement(WebElement ele)
	{
		Actions ac = new Actions(driver);
		ac.scrollToElement(ele).perform();
		ac.scrollByAmount(0, 300).perform();
	}
	
	public static void scrollToElementJS(WebElement ele)
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(false);", ele); //default is true
		je.executeScript("window.scrollBy(0,300)", "");
	}

	public static void clickOnElementJS(WebElement ele)
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", ele); //default is true
		
	}
	
	public static void captureScreenshot() throws IOException
	{
		
		File f = new File("C://screenshot");
		System.out.println("Folder available:"+f.isDirectory());
		if(!f.isDirectory())
		{
			//FileHandler.createDir(new File("screenshot"));
			f.mkdir();
		}
		TakesScreenshot sc = (TakesScreenshot) driver;
		File file = sc.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(f+"/"+getDate()+"_image.jpg")); //jpg or png

	}
	
	static String getDate()
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MMM_dd_HH_mm_ss_SSS");
		String date = sdf.format(d);
		//System.out.println(date);
		return date;
	}
	
	public static void attachScreenshot()
	{
		TakesScreenshot sc = (TakesScreenshot) driver;
		String str = sc.getScreenshotAs(OutputType.BASE64);
		System.out.println(str);
		Reporter.log(str);
		String img ="<img src=\"data:image/png;base64,"+str+"\" height=\"600\" width=\"800\" />";
		Reporter.log(img);
		
	}
	public static void waitForElement(WebElement ele)
	{
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void waitForElementClickable(WebElement ele)
	{
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
}
