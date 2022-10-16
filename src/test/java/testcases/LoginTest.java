package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.PIMPage;
import testbase.TestBase;
import utilities.ExcelUtility;
import utilities.TestUtility;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	WebDriver dr;
	LoginPage lp;
	PIMPage pp;
	
  @Test(description="Login Success")
  public void LoginSuccess_001() throws IOException {
	  lp.loginToApp(ExcelUtility.getCellValueByRowName("username"), ExcelUtility.getCellValueByRowName("password"));
	  boolean actual = pp.isPIMHeaderDisplayed();
	  TestUtility.attachScreenshot();
	  Assert.assertEquals(actual, true);
	  pp.logout();
	  
  }
  @Test
  public void LoginUnsuccessful_002() throws IOException
  {
	  lp.loginToApp(ExcelUtility.getCellValueByRowName("username"), ExcelUtility.getCellValueByRowName("invalidpass"));
	  boolean actual = pp.isPIMHeaderDisplayed();
	  TestUtility.attachScreenshot();
	  Assert.assertEquals(actual, false);
	  Assert.assertEquals(lp.getErrorText(), "Invalid credentials");
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	 dr =TestBase.getInstance();
	 lp=new LoginPage(dr);
	 pp=new PIMPage(dr);
  }

  @AfterMethod
  public void afterMethod() {
	 
	 dr.quit();
  }

}
