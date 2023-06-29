package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PhoneIconSendSMS {
	
	@FindBy(xpath="//td[text()='Dev Agency']/..//span[@class='glyphicon glyphicon-phone']")
	private WebElement phoneBtn;
	
	
	@FindBy(xpath="//div[@class='bootstrap-dialog-header']")
	private WebElement msgPopup;
	
	@FindBy(name="phone")
	private WebElement phone;
	
	@FindBy(id="message")
	private WebElement msgBox;
	
	@FindBy(id="submit")
	private WebElement submitBtn;
	
	public PhoneIconSendSMS(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void phoneBtnClick() {
		this.phoneBtn.click();
	}
	
	public void validateMsgPopup(WebDriverWait wait) {
		try {
		wait.until(ExpectedConditions.visibilityOf(msgPopup));
		Reporter.log("Msg Popup displayed successfully",true);
		}
		catch(Exception e) {
			Reporter.log("Msg Popup not displayed",true);
			e.printStackTrace();
		}
	}
	
	
	public void addPhno(long phno) {
		phone.clear();
		phone.sendKeys(""+phno);
	}
	
	
	public void addMsg(String msg) {
		msgBox.clear();
		msgBox.sendKeys(msg);
	}
	
	public void clickSubmit() {
		submitBtn.click();;
	}
	}
