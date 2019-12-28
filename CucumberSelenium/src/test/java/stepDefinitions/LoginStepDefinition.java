package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	WebDriver driver;

	@Given("User is on the login page")
	public void user_is_on_the_login_page() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sumeyra\\cansu\\selenium libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String url = "http://thedemosite.co.uk/login.php";
		driver.get(url);

	}

	@When("User enters username and password")
	public void user_enters_username_and_password() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("test");
		driver.findElement(By.name("password")).sendKeys("test");
		Thread.sleep(2000);
	}

	@When("User click on login button")
	public void user_click_on_login_button() {

		driver.findElement(By.name("FormsButton2")).click();
	}

	@Then("Message displayed login successfully")
	public void message_displayed_login_successfully() throws InterruptedException {

		String text = "**Successful Login**";
		WebElement msg = driver.findElement(By.xpath("//b[contains(text(),'**Successful Login**')]"));
		String expected_text = msg.getText();
		Assert.assertEquals(expected_text, text);
		Thread.sleep(2000);

	}
	
	@Then("Close the browser")
	public void close_the_browser() {
		
		driver.close();
		}


}
