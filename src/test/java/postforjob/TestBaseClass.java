package postforjob;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestBaseClass {

	public WebDriver driver = null;
	public Properties prop = null;

	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		prop = new Properties();
		try {
			FileInputStream fStream = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\PostJob.properties");
			prop.load(fStream);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void finish() {
		driver.quit();
	}
	
	
	
	
	
	

}
