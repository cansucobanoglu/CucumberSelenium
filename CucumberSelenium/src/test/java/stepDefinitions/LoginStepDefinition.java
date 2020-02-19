package stepDefinitions;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	WebDriver driver;
	public static  String userdir = System.getProperty("user.dir");
	 
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {

		System.setProperty("webdriver.chrome.driver", userdir + File.separator + "setup/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String url = "http://thedemosite.co.uk/login.php";
		driver.get(url);

	}
	
	@When("Verify page title")
	public void verify_page_title()
	{
		String actual = driver.getTitle();
        String expected = "Login example page to test the PHP MySQL online system";
		 if (actual.equals(expected)) {
             System.out.println("Sekme baþlýðý: " + actual);
		 } else {
             System.out.println("Test Failed");
		 }

	}
	
	@When("Verify header name")
	public void verify_header_name()
	{
		WebElement pageName = driver.findElement(By.xpath("//strong[contains(text(),'4. Login')]"));
		String name = pageName.getText();
		String expected = "4. Login";
		 if (name.equals(expected)) {
             System.out.println("Sayfa baþlýðý: " + name);
		 } else {
             System.out.println("Test Failed");
		 }

		
	}
	
	@When("Verify status message")
	public void verify_status_message()
	{
		WebElement status = driver.findElement(By.xpath("//b[contains(text(),'**No login attempted**')]"));
		String msgName = status.getText();
		String expected = "**No login attempted**";
		 if (msgName.equals(expected)) {
             System.out.println("Statü mesajý: " + msgName);
		 } else {
             System.out.println("Test Failed");
		 }
	}
	
	@When("Verify info message")
	public void veirfy_info_message()
	{
		String msgName = driver.findElement(By.xpath("//p[contains(text(),'Enter your login details you added on the previous')]")).getText();
		System.out.println(msgName);

	}

	@And("User enters username and password")
	public void user_enters_username_and_password() throws InterruptedException {

		WebElement username = driver.findElement(By.name("username"));		
		// Get maxlength attribute of username
		String maxLengthUsername = username.getAttribute("maxlength");
 
		if (maxLengthUsername == null) {
			System.out.println("Maksimum karakter sýnýrý yoktur.");
		}
 
		else {
		
				System.out.println("Maksimum karakter sýnýrý: " + maxLengthUsername + " karakterdir.");	
		}
		
		username.sendKeys("testuserd");
		
		WebElement password = driver.findElement(By.name("password"));
		// Get maxlength attribute of username
		String maxLengthPassword = password.getAttribute("maxlength");
		 
		if (maxLengthPassword == null) {
			System.out.println("Maksimum karakter sýnýrý yoktur.");
		}
 
		else {
		
				System.out.println("Maksimum karakter sýnýrý: " + maxLengthPassword + " karakterdir.");	
		}		
				
		password.sendKeys("testpass");
		
		Thread.sleep(2000);
	}

	@When("User click on login button")
	public void user_click_on_login_button() {

		driver.findElement(By.name("FormsButton2")).click();
	}

	@Then("Message displayed login successfully")
	public void message_displayed_login_successfully() throws InterruptedException  {

		
		String msg = driver.findElement(By.xpath("//b[contains(text(),'Login')]")).getText();
		System.out.println(msg);

		
	}
	
	@Then("Close the browser")
	public void close_the_browser() {
		
		driver.close();
		}


}
