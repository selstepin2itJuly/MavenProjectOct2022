package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver dr;
	
	public LoginPage(WebDriver driver)
	{
		this.dr=driver;
		//Important part of Page Factory
		PageFactory.initElements(dr, this);
	}
	
	//Elements or locators
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(css="input[type='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement login;
	
	@FindBy(xpath="//p[text()='Invalid credentials']")
	private WebElement errorText;
	
	//methods on the page
	public void enterUsername(String user)
	{
		username.clear();
		username.sendKeys(user);
	}
	public void enterPassword(String pass)
	{
		password.clear();
		password.sendKeys(pass);
	}
	
	public void clickOnLoginButton()
	{
		login.click();
	}
	
	public void loginToApp(String user, String pass)
	{
		enterUsername(user);
		enterPassword(pass);
		clickOnLoginButton();
	}
	
	public String getErrorText()
	{
		return errorText.getText().trim();
	}
	
}
