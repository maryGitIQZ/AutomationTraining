package impliwait_package;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Implicit_Wait {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
@BeforeClass
	public void setup() {
		
			System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			
	}
	
	@Test
	public void launch_app() throws Exception {
	driver.get("https://pega-86-demo.iqzsystems.io/prweb/app/default/b0aUC_g2NnC90uEC3dhEbKXJdQTMkXeP*/!STANDARD");
	/*driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	@Test (dependsOnMethods = "launch_app")
	public void enter_username() throws Exception {
	WebElement username = driver.findElement(By.xpath("//input[@id='txtUserID']"));
	username.sendKeys("tcapron");
	
	}
	
	@Test (dependsOnMethods = "enter_username")
	public void enter_password() throws Exception {
	WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
	password.sendKeys("Password@123");
	
	}
	
	@Test (dependsOnMethods = "enter_password")
	public void click_login() throws Exception {
	WebElement loginbutton = driver.findElement(By.xpath("//button[@id='sub']"));
	loginbutton.click();
	
	}
	
	@AfterClass
	public void finish() {
	driver.close();
	System.out.println("Test is successful");
	}

}
