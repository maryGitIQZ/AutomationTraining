package wait_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Explicit_Wait {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
@BeforeClass
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();
			
	}
	
	@Test
	public void launch_app() throws Exception {
	driver.get("https://pega-86-demo.iqzsystems.io/prweb/app/default/b0aUC_g2NnC90uEC3dhEbKXJdQTMkXeP*/!STANDARD");
	
	}
	@Test (dependsOnMethods = "launch_app")
	public void enter_username() throws Exception {
		/*WebDriverWait wait = new WebDriverWait(driver, 10);*/
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtUserID']")));
		WebElement username = driver.findElement(By.xpath("//input[@id='txtUserID']"));
	username.sendKeys("tcapron");
	
	}
	
	@Test (dependsOnMethods = "enter_username")
	public void enter_password() throws Exception {
		/*WebDriverWait wait =new WebDriverWait(driver, 10);*/
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtPassword']")));
	WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
	password.sendKeys("Password@123");
		}
	
	@Test (dependsOnMethods = "enter_password")
	public void click_login() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='sub']")));
	WebElement loginbutton = driver.findElement(By.xpath("//button[@id='sub']"));
	loginbutton.click();
	
	}
	
	@Test (dependsOnMethods = "enter_password")
	public void get_title() throws Exception {
	System.out.println("Page title is : " + driver.getTitle());
	
	}
	
	@AfterTest
	public void finish() {
	driver.close();
	System.out.println("Test is successful");
	}

}
