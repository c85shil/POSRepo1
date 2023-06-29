package generic;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import page.EnterPOSPage;
import page.LoginPage;




public class BaseTest {
	public static final String DEFAULT_URL="https://student1.aksharatraining.in/pos/public/";
	public static final String DEFAULT_GRID="no";
	public static final String DEFAULT_BROWSER="chrome";
	public static final String XL_PATH="./data1/POSInput.xlsx";
	public String HOME_URL="https://student1.aksharatraining.in/pos/public/home";
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	@Parameters({"appurl","grid","browser"})
	@BeforeMethod
	public void preCondition(@Optional(DEFAULT_URL) String appURL,@Optional(DEFAULT_GRID) String grid,@Optional(DEFAULT_BROWSER) String browser) throws Exception {
		
		if(grid.equalsIgnoreCase("no"))
		{
			Reporter.log("Execution in local system",true);
			
			if(browser.equals("chrome"))
			{
				Reporter.log("Browser is: chrome",true);
				driver=new ChromeDriver();
			}
			else
			{
				Reporter.log("Browser is: Firefox",true);
				driver=new FirefoxDriver();
			}
			
			
		}
		else
		{
			Reporter.log("Execution in remote system",true);
			if(browser.equals("chrome"))
			{
				Reporter.log("Browser is: chrome",true);
				driver=new RemoteWebDriver(new URL(grid), new ChromeOptions());
			}
			else
			{
				Reporter.log("Browser is: Firefox",true);
				driver=new RemoteWebDriver(new URL(grid), new FirefoxOptions());
			}
			
		}
		driver.get(appURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
	}
	
//	@BeforeMethod
//	public void preTest() {
//		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//	String currentURL = driver.getCurrentUrl();
//	if(currentURL.equals("https://student1.aksharatraining.in/pos/public/"))
//		driver.navigate().to(HOME_URL);
//	System.out.println("current"+currentURL);
//	System.out.println("Home"+HOME_URL);
//	}
	
	
	
	@AfterSuite
	public void postCondition() {
		driver.quit();
	}
	
	}
