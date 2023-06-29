package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;
import page.NewSupplierAdditionPage;
import page.UpdateSupplierPage;

public class ValidUpdateSupplier extends BaseTest{

	
	@Test
	public void updateSupplierInfo() throws InterruptedException {
		
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
		
		
		String agencyName = Excel.getData(XL_PATH, "ValidUpdateSupplier", 5, 0);
		long phNo = Excel.getIntData(XL_PATH, "ValidUpdateSupplier", 5, 1);
		
		UpdateSupplierPage updateSupplier = new UpdateSupplierPage(driver);
		updateSupplier.clickUpdate();
		updateSupplier.editInfo(agencyName, phNo);
		updateSupplier.verifyUpdatePopup(wait);
		updateSupplier.clickSubmit();
		updateSupplier.validatePhoneElement(wait);
	}
}
