package script;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.EnterPOSPage;
import page.LoginPage;

public class ValidLogin extends BaseTest
{
	@Test
	public void testValidLogin()
	{
		String un=Excel.getData(XL_PATH, "ValidLogin", 1, 0);
		String pw=Excel.getData(XL_PATH, "ValidLogin", 1, 1);
		Reporter.log(un,true);
		Reporter.log(pw,true);
		LoginPage loginPage=new LoginPage(driver);
//		1. enter valid un
		loginPage.setUserName(un);
//		2. enter valid pw
	
		loginPage.setPassword(pw);
//		3. click login button
		loginPage.clickLoginButton();
//		4. home page should be displayed
		EnterPOSPage homePage=new EnterPOSPage(driver);
		boolean result = homePage.verifyHomePageIsDisplayed(wait);
		Assert.assertTrue(result);
	}
	
	
}
