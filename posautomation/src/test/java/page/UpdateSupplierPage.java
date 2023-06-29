package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import page.NewSupplierAdditionPage;


public class UpdateSupplierPage {
	
	@FindBy(xpath="//td[text()='Sai Marbles']/..//span[@class='glyphicon glyphicon-edit']")
	private WebElement updateBtn;
	
	@FindBy(xpath="//div[@class='bootstrap-dialog-header']")
	private WebElement updatePopUp;
	
	@FindBy(xpath="//input[@name='agency_name']")
	private WebElement agencyName;
	
	@FindBy(xpath="//input[@id='phone_number']")
	private WebElement phoneNumber;
	
	
	@FindBy(id="submit")
	private WebElement submitBtn;
	
	@FindBy(xpath="//td[text()='Dev Agency']/..//span[@class='glyphicon glyphicon-phone']")
	private WebElement phoneBtn;
	
	public UpdateSupplierPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public boolean verifyUpdatePopup(WebDriverWait wait) {
		try
		{
			wait.until(ExpectedConditions.visibilityOf(updatePopUp));
			Reporter.log("Update Popup is Displayed",true);
			return true;
		}
		catch (Exception e) 
		{
			Reporter.log("Update Popup is Not Displayed",true);
			return false;
		}
		
	}
	
	public void editInfo(String agencyName,long phno) throws InterruptedException {
		System.out.println(agencyName);
		System.out.println(phno);

		Thread.sleep(1000);
		this.agencyName.clear();
		Thread.sleep(1000);
		this.phoneNumber.clear();
		Thread.sleep(1000);
		this.agencyName.sendKeys(agencyName);
		Thread.sleep(1000);
		this.phoneNumber.sendKeys(""+phno);
		Thread.sleep(1000);
	}
	
	
	
	public void clickUpdate() {
		updateBtn.click();
	}
	
	
	public void clickSubmit() {
		submitBtn.click();
	}
	
	public void validatePhoneElement(WebDriverWait wait) {
		try {
			wait.until(ExpectedConditions.visibilityOf(phoneBtn));
			Reporter.log("Phone Icon displayed successfully",true);
		}
		catch(Exception e) {
			Reporter.log("Phone Icon not displayed",true);
			e.printStackTrace();
		}
		
	}


}
