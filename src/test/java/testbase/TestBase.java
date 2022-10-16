package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.log4testng.Logger;

public class TestBase {

	private final static Logger logger = Logger.getLogger(TestBase.class);
	public static WebDriver driver;
	public static Properties prop;
	public static String browser;
	public static String testdata;
	public static String url;
	public static WebDriver getInstance() throws IOException
	{
	
		String configFile = "./src/main/java/config/config.properties";
		FileInputStream stream = new FileInputStream(new File(configFile));
		logger.info(stream);
		prop = new Properties();
		prop.load(stream);
		//read browser from config
		browser=prop.getProperty("browser");
		url=prop.getProperty("url");
		logger.info(url);
		testdata=prop.getProperty("testdata");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxdriver"));
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", prop.getProperty("edgedriver"));
			driver = new EdgeDriver();
		}else
		{
			Throwable thr = new Throwable();
			thr.initCause(null);
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		//driver.manage().window().minimize();
		//driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
	}
}
