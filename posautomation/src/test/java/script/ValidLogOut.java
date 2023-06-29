package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import page.LogOutPage;
import page.LoginPage;

public class ValidLogOut extends BaseTest{
	
	@Test
	public void validateLogout() throws InterruptedException {
		
	
	
	LogOutPage logoutPage=new LogOutPage(driver);
	LoginPage loginPage=new LoginPage(driver);
	loginPage.setUserName("admin");
	loginPage.setPassword("pointofsale");
	loginPage.clickLoginButton();
	Thread.sleep(1000);
	logoutPage.clickLogOutButton();
	logoutPage.verifyLogoutPageDisplayed(wait);
	
	
	}

}
