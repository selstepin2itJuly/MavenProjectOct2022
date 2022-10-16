package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LoginPage;
import pages.MyInfoPage;
import pages.PIMPage;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class MyInfoTest {
	
	WebDriver dr;
	LoginPage lp;
	PIMPage pp;
	MyInfoPage ip;
  @Test(priority=0)
  public void myInfoPageSideMenuCount() {
	  ip.clickOnMyInfo();
	  int act = ip.getSideMenuItemCount();
	  TestUtility.attachScreenshot();
	  Assert.assertEquals(act, 11);
	  
  }
  
  @Test(priority=-1)
  public void myInfoPageSideMenuItemText() {
	  ip.clickOnMyInfo();
	  List<String> act = ip.getSideMenuItemsText();
	  TestUtility.attachScreenshot();
	  List<String> exp = new ArrayList<String>();
	  exp.add("Personal Details");
	  exp.add("Contact Details");
	  exp.add("Emergency Contacts");
	  exp.add("Dependents");
	  exp.add("Immigratio");
	  exp.add("Job");
	  exp.add("Salary");
	  exp.add("Tax Exemptions");
	  exp.add("Report-to");
	  exp.add("Qualifications");
	  exp.add("Membership");
	  
	  SoftAssert sf = new SoftAssert();
	 
	  sf.assertEquals(act.get(0), exp.get(0));
	  sf.assertEquals(act.get(1), exp.get(1));
	  sf.assertEquals(act.get(2), exp.get(2));
	  sf.assertEquals(act.get(3), exp.get(3));
	  sf.assertEquals(act.get(4), exp.get(4));
	  sf.assertEquals(act.get(5), exp.get(5));
	  sf.assertEquals(act.get(6), exp.get(6));
	  sf.assertEquals(act.get(7), exp.get(7));
	  sf.assertEquals(act.get(8), exp.get(8));
	  sf.assertEquals(act.get(9), exp.get(9));
	  sf.assertEquals(act.get(10), exp.get(10));
	  
	  sf.assertAll();
	  
	 
  }
  
  @BeforeClass
  public void beforeClass() throws IOException {
	 dr =TestBase.getInstance();
	 lp = new LoginPage(dr);
	 pp	= new PIMPage(dr);
	 ip = new MyInfoPage(dr);
	 lp.loginToApp("Admin", "admin123");
  }

  @AfterClass
  public void afterClass() {
	  pp.logout();
	  dr.quit();
  }

}
