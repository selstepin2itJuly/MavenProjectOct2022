package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestUtility;

public class MyInfoPage {

	WebDriver dr;
	
	public MyInfoPage(WebDriver driver)
	{
		this.dr=driver;
		//Important part of Page Factory
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//span[text()='My Info']/parent::a")
	private WebElement myInfo;
	
	@FindBy(className="orangehrm-tabs-item")
	private List<WebElement> items;
	
	public void clickOnMyInfo()
	{
		myInfo.click();
	}
	
	public int getSideMenuItemCount()
	{
		TestUtility.waitForElement(items.get(0));
		return items.size();
	}
	
	public List<String> getSideMenuItemsText()
	{
		TestUtility.waitForElement(items.get(0));
		List<String> tmp = new ArrayList<String>();
		for(WebElement e:items)
		{
			tmp.add(e.getText());
		}
		return tmp;
	}
}
