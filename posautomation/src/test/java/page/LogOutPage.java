package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class LogOutPage {
	

	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutBtn;
	
	@FindBy(id="//span[contains(text(),'Open Source')]")
	private WebElement footMsg;
	
	
	public LogOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public void clickLogOutButton()
	{
		logoutBtn.click();
	}
	
	
	public boolean verifyLogoutPageDisplayed(WebDriverWait wait)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(footMsg));
			Reporter.log("Login Page is displayed",true);
			return true;
		}
		catch (Exception e) 
		{
			Reporter.log("Login Page is not displayed",true);
			return false;
		}
	}
}
