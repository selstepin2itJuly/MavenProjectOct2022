package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	WebDriver dr;

	public DashboardPage(WebDriver driver)
	{
		this.dr=driver;
		//Important part of Page Factory
		PageFactory.initElements(dr, this);
	}
}
