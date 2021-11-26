package wait_package;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Media_icon {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@Parameters("browserName")
		
	@BeforeTest
	public void setup(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("Firebox")) {
				System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
	}
	
	@Test
	public void launch_app() throws Exception {
	driver.get("https://freecrm.com/");
	
	}
	@Test (dependsOnMethods = "launch_app")
	public void click_twitter() throws Exception {
		
		WebElement element = driver.findElement(By.xpath("/html/body/div[1]/footer/div/div[1]/a[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		  element.click();
		
		}
	
	@Test (dependsOnMethods = "launch_app")
	public void click_facebook() throws Exception {
		
		WebElement fbicon = driver.findElement(By.xpath("/html/body/div[1]/footer/div/div[1]/a[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fbicon);
		
		  fbicon.click();
		
		}
	
	@Test (dependsOnMethods = "launch_app")
	public void click_youtubeicon() throws Exception {
		
		WebElement youtubeicon = driver.findElement(By.xpath("/html/body/div[1]/footer/div/div[1]/a[7]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", youtubeicon);
		
		youtubeicon.click();
	}
		
	/*@AfterClass
	public void finish() {
	driver.quit();
	System.out.println("Test is successful");
	}*/

}
