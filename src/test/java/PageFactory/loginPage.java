package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	@FindBy(id="email")
	WebElement txt_username;
	
	@FindBy(id="password")
	WebElement txt_password;
	
	@FindBy(xpath = "//li[@class='profile-nav']/a/label")
	WebElement login_btn;
	
	@FindBy(id="btn-submit")
	WebElement signin_btn;
	
	@FindBy(xpath = "//div[@class='account-actions']/ul/li[15]/a/span")
	WebElement logout_btn;
	
	@FindBy(xpath = "//div[@class='account-actions']/ul/li/a/span[@class='blue-text']")
	WebElement logout_btn1;
	
	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String username) {
		txt_username.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		
		txt_password.sendKeys(password);		
	}
	
	public void clickLogin() {
		login_btn.click();
	}
	
	public void clickSigin() {
		signin_btn.click();
	}
	
	public void clickLogout() throws InterruptedException {
		logout_btn.click();
		Thread.sleep(2000);
		logout_btn1.click();
	}
}
