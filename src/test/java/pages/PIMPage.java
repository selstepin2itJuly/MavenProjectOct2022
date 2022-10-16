package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestUtility;

public class PIMPage {

WebDriver dr;
	
	public PIMPage(WebDriver driver)
	{
		this.dr=driver;
		//Important part of Page Factory
		PageFactory.initElements(dr, this);
	}
	//locators
	@FindBy(xpath="//h6[text()='PIM']")
	private WebElement pimHeader;
	
	@FindBy(className="oxd-userdropdown-name")
	private WebElement logoutArrow;
	
	@FindBy(linkText="Logout")
	private WebElement logout;
	
	//methods
	public boolean isPIMHeaderDisplayed()
	{
		boolean b=false;
		try {
			TestUtility.waitForElement(pimHeader);
			b=pimHeader.isDisplayed();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
		
	}
	
	public void logout()
	{
		logoutArrow.click();
		TestUtility.waitForElementClickable(logout);
		logout.click();
	}
}
