package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import generic.Excel;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewSupplierAdditionPage {
	
	
	@FindBy(xpath="//a[text()='Suppliers']")
	private WebElement supplierBtn;

	@FindBy(xpath="//button[@title='New Supplier']")
	private WebElement newSupplierBtn;
	
	@FindBy(id="submit")
	private WebElement submitBtn;
	
	@FindBy(id="company_name_input")
	private WebElement companyName;

	@FindBy(id="category")
	private WebElement list;
	
	@FindBy(xpath="//input[@name='agency_name']")
	private WebElement agencyName;

	@FindBy(name="first_name")
	private WebElement firstName;

	@FindBy(name="last_name")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@name='gender' and(@value='0')]")
	private WebElement gender;
	
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='phone_number']")
	private WebElement phoneNumber;
		
	@FindBy(name="address_1")
	private WebElement address1;

	@FindBy(name="address_2")
	private WebElement address2;
	
	@FindBy(name="city")
	private WebElement city;
	
	@FindBy(name="state")
	private WebElement state;
	
	@FindBy(id="postcode")
	private WebElement zip;
	
	@FindBy(name="country")
	private WebElement country;
	
	
	@FindBy(id="comments")
	private WebElement comments;
	
	
	@FindBy(xpath="//input[@id='account_number']")
	private WebElement accountNumber;
	
	@FindBy(name="tax_id")
	private WebElement tax_id;
	
	
	@FindBy(id="submit")
	private WebElement submit;
	
	@FindBy(xpath="//span[contains(text(),'You have successfully added Supplier')]")
	private WebElement successMsg;
	
	
	



	public WebElement getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String compName) {
		companyName.sendKeys(compName);
	}



	public WebElement getList() {
		return list;
	}



	public void setList(int listNo) {
		Select select=new Select(list);
		select.selectByIndex(listNo);
	}






	public WebElement getAgencyName() {
		return agencyName;
	}



	public void setAgencyName(String agencyName) {
		this.agencyName.sendKeys(agencyName);
	}



	public WebElement getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}



	public WebElement getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}



	public WebElement getGender() {
		return gender;
	}



	public void setGender(String gend) {
		gender.click();
	}



	public WebElement getEmail() {
		return email;
	}



	public void setEmail(String emailid) {
		this.email.sendKeys(emailid);
	}



	public WebElement getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber.sendKeys(""+phoneNumber);
		
	}



	public WebElement getAddress1() {
		return address1;
	}



	public void setAddress1(String address1) {
		this.address1.sendKeys(address1);
	}



	public WebElement getAddress2() {
		return address2;
	}



	public void setAddress2(String address2) {
		this.address2.sendKeys(address2);
	}



	public WebElement getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city.sendKeys(city);;
	}



	public WebElement getState() {
		return state;
	}



	public void setState(String state) {
		this.state.sendKeys(state);;
	}



	public WebElement getZip() {
		return zip;
	}



	public void setZip(String zip) {
		this.zip.sendKeys(zip);
	}



	public WebElement getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country.sendKeys(country);
	}



	public WebElement getComments() {
		return comments;
	}



	public void setComments(String comment) {
		this.comments.sendKeys(comment);;
	}



	public WebElement getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(String acc) {
		this.accountNumber.sendKeys(acc);
	}



	public WebElement getTax_id() {
		return tax_id;
	}



	public void setTax_id(String taxid) {
		this.tax_id.sendKeys(taxid);
	}



	



	
	
	

	public NewSupplierAdditionPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	public void addSupplierPageOpen() {
		supplierBtn.click();
				
	}
	
	public void newSupplierBtnClick() {
		newSupplierBtn.click();
	}
	
	public void clickSubmit()
	{
		submitBtn.click();
	}
	
	
	
	public boolean verifySuccessMsgIsDisplayed(WebDriverWait wait)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(successMsg));
			Reporter.log("New Supplier added success msg is Displayed",true);
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			Reporter.log("New Supplier added success msg is Not Displayed",true);
			return false;
		}
	}
	
	
	
	
	public void setExcelData(WebDriver driver,String XL_PATH) {
		
		
	
	String compName=Excel.getData(XL_PATH, "ValidNewSupplier", 1, 0);
	//Reporter.log(compName,true);
	String category=Excel.getData(XL_PATH, "ValidNewSupplier", 1, 1);
	//Reporter.log(category,true);
	String agencyName=Excel.getData(XL_PATH, "ValidNewSupplier", 1, 2);
	//Reporter.log(agencyName,true);
	String firstName=Excel.getData(XL_PATH, "ValidNewSupplier", 1, 3);
	//Reporter.log(firstName,true);
	String lastName=Excel.getData(XL_PATH, "ValidNewSupplier", 1, 4);
	//Reporter.log(lastName,true);
	
	
	String gender=Excel.getData(XL_PATH, "ValidNewSupplier", 1, 5);
	//Reporter.log(gender,true);
	String email=Excel.getData(XL_PATH, "ValidNewSupplier", 1, 6);
	//Reporter.log(email,true);
	long phoneNumber=Excel.getIntData(XL_PATH, "ValidNewSupplier", 1, 7);
	//Reporter.log(phoneNumber,true);		
	String address1=Excel.getData(XL_PATH, "ValidNewSupplier", 1, 8);
	String address2=Excel.getData(XL_PATH, "ValidNewSupplier", 1, 9);
	String city=Excel.getData(XL_PATH, "ValidNewSupplier", 1, 10);
	
	
	String state=Excel.getData(XL_PATH, "ValidNewSupplier", 1, 11);
	String zip=Excel.getData(XL_PATH, "ValidNewSupplier", 1, 12);
	
	String country=Excel.getData(XL_PATH, "ValidNewSupplier", 1, 13);
	String comments=Excel.getData(XL_PATH, "ValidNewSupplier", 1, 14);
	String accountNumber=Excel.getData(XL_PATH, "ValidNewSupplier", 1, 15);
	Reporter.log(accountNumber,true);
	String taxID=Excel.getData(XL_PATH, "ValidNewSupplier", 1, 16);
	
	this.setCompanyName(compName);
	System.out.println("aaa"+this.getCompanyName().getText());
	this.setList(0);
	this.setAgencyName(agencyName);
	this.setFirstName(firstName);
	this.setLastName(lastName);
	this.setGender(gender);
	this.setEmail(email);
	this.setPhoneNumber(phoneNumber);
	this.setAddress1(address1);
	this.setAddress2(address2);
	this.setCity(city);
	this.setState(state);
	this.setZip(zip);
	this.setCountry(country);
	this.setComments(comments);
//	this.setAccountNumber(accountNumber);
//	System.out.println("aaa"+this.getAccountNumber().getText());
	this.setTax_id(taxID);
	}
}
