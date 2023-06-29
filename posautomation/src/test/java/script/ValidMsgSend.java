package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;
import page.NewSupplierAdditionPage;
import page.PhoneIconSendSMS;

public class ValidMsgSend extends BaseTest{

	@Test
	public void sendMsg() throws InterruptedException {
		
		String un=Excel.getData(XL_PATH, "ValidLogin", 1, 0);
		String pw=Excel.getData(XL_PATH, "ValidLogin", 1, 1);
//		Reporter.log(un,true);
//		Reporter.log(pw,true);
		LoginPage loginPage=new LoginPage(driver);
//		1. enter valid un
		loginPage.setUserName(un);
//		2. enter valid pw

		loginPage.setPassword(pw);
//		3. click login button
		loginPage.clickLoginButton();
		
		NewSupplierAdditionPage newSupplier=new NewSupplierAdditionPage(driver);
		newSupplier.addSupplierPageOpen();
		
		
		PhoneIconSendSMS phoneIcon = new PhoneIconSendSMS(driver);
		phoneIcon.phoneBtnClick();
		
		long phno=Excel.getIntData(XL_PATH, "Message", 1, 0);
		String msg=Excel.getData(XL_PATH, "Message", 1, 1);
		phoneIcon.validateMsgPopup(wait);
		phoneIcon.addPhno(phno);
		phoneIcon.addMsg(msg);
		Thread.sleep(1000);
		
		phoneIcon.clickSubmit();		
	}
	
}
