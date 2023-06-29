package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;
import page.NewSupplierAdditionPage;
import page.OpenHomePage;

public class ValidNewSupplierAdd extends BaseTest{
	

	@Test
	public void testValidNewSupplierAddition()	{
		
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
		
		try {
		NewSupplierAdditionPage newSupplier = new NewSupplierAdditionPage(driver);
		newSupplier.addSupplierPageOpen();
		newSupplier.newSupplierBtnClick();
		
		newSupplier.setExcelData(driver, XL_PATH);
		newSupplier.clickSubmit();
		newSupplier.verifySuccessMsgIsDisplayed(wait);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
}
