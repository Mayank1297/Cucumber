package StepDefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import PageFactory.loginPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class UchefLoginStepDefination {
	WebDriver driver;
	loginPage login;
	
	@Given("^user opens the browser$")
	public void user_opens_the_browser() {
		System.out.println("Inside Step - user opens the browser");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("disable-notifications");
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver(options);
	    driver.manage().window().maximize();
	}

	@And("^enter the URL$")
	public void enter_the_url() throws InterruptedException {
		System.out.println("Inside Step - enter the URL");
		driver.get("https://uchefs.com/");
		Thread.sleep(2000);
		
	}

	@Given("^user is on home page$")
	public void user_is_on_home_page() {
		System.out.println("Inside Step - user is on home page");
		driver.getPageSource().contains("Home");
	}

	@Then("^Click on login button$")
	public void click_on_login_sign_up_button() {
		System.out.println("Inside Step - Click on login button");
		driver.findElement(By.xpath("//li[@class='profile-nav']/a/label")).click();
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		System.out.println("Inside Step - user enters username and password");
		
		login=new loginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		
		//driver.findElement(By.id("email")).sendKeys(username);
		//driver.findElement(By.id("password")).sendKeys(password);
		
	}

	@And("^clicks on Sign in button$")
	public void clicks_on_login_button() {
		System.out.println("Inside Step - clicks on Sign in button");  
		
		login.clickSigin();
		
		//driver.findElement(By.id("btn-submit")).click();
	}

	@Then("^user is navigated to the home page$")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		System.out.println("Inside Step - user is navigated to the home page"); 
		List<WebElement> cuisine_search_list = driver.findElements(By.xpath("//div[@class='cuisine_search_list']/ul/li"));
		WebElement q;
		for(int i=0;i<cuisine_search_list.size();i++) {
			q=cuisine_search_list.get(i);
			System.out.println(q.getText());
		}
		for(int i=0;i<cuisine_search_list.size();i++) {
			q= cuisine_search_list.get(i);
			q.click();
			Thread.sleep(2000);
			System.out.println("URL of = "+q.getText());
			System.out.println(driver.getCurrentUrl());
		}
	}
	
	@And("^user click on Profile button$")
	public void user_click_on_Profile_button() {
		System.out.println("Inside Step - user click on Profile button");
		driver.findElement(By.xpath("//li[@class='profile-nav']/a/label")).click();
	}
	
	@Then("^Click on setting icon$")
	public void Click_on_setting_icon() {
		System.out.println("Inside Step - Click on setting icon");
		driver.findElement(By.xpath("//a[@class='topbar-action']/img")).click();
	}
	
	@When("^CLick on Log out button$")
	public void CLick_on_Log_out_button() throws InterruptedException {
		System.out.println("Inside Step - CLick on Log out button");
		
		login.clickLogout();
		
		//driver.findElement(By.xpath("//div[@class='account-actions']/ul/li[15]/a/span")).click();
		//driver.findElement(By.xpath("//div[@class='account-actions']/ul/li/a/span[@class='blue-text']")).click();
	}
	
	@Then("^user navigate to the home page$")
	public void user_navigate_to_the_home_page() {
		System.out.println("Inside Step - user navigate to the home page");
		driver.getPageSource().contains("Home");
		driver.quit();
	}
}
