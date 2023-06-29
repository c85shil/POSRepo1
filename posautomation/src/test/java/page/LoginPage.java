package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LoginPage {
	
	@FindBy(id="input-username")
	private WebElement unTB;
	
	@FindBy(id="input-password")
	private WebElement pwTB;
	
	@FindBy(name = "login-button")
	private WebElement loginBTN;
	
	@FindBy(xpath ="//div[contains(text(),'Invalid username ')]")
	private WebElement errMsg;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void setUserName(String un)
	{
		unTB.sendKeys(un);
	}
	
	public void setPassword(String pw)
	{
		pwTB.sendKeys(pw);
	}
	
	public void clickLoginButton()
	{
		loginBTN.click();
	}
	
	public boolean verifyErrMsgIsDisplayed(WebDriverWait wait)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(errMsg));
			Reporter.log("Err Msg is Displayed",true);
			return true;
		}
		catch (Exception e) 
		{
			Reporter.log("Err Msg is Not Displayed",true);
			return false;
		}
	}
	
	
	
}
