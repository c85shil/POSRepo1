package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class EnterPOSPage {

	@FindBy(partialLinkText="opensourcepos.org")
	private WebElement footerElement;
	
	public EnterPOSPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyHomePageIsDisplayed(WebDriverWait wait)
	{
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(footerElement));
			Reporter.log("HomePage is Displayed",true);
			return true;
		}
		catch (Exception e) 
		{
			Reporter.log("HomePage is Not Displayed",true);
			return false;
		}
	}
}
