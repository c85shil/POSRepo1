package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;
import page.NewSupplierAdditionPage;

public class HomePage extends BaseTest{
	
	@Test
	public void openHomePage() {
	String un=Excel.getData(XL_PATH, "ValidLogin", 1, 0);
	String pw=Excel.getData(XL_PATH, "ValidLogin", 1, 1);
	Reporter.log(un,true);
	Reporter.log(pw,true);
	LoginPage loginPage=new LoginPage(driver);
//	1. enter valid un
	loginPage.setUserName(un);
//	2. enter valid pw

	loginPage.setPassword(pw);
//	3. click login button
	loginPage.clickLoginButton();
	
	
	}
}
