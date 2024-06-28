package postforjob;

import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.Toolkit;
//import java.awt.datatransfer.StringSelection;
//import java.awt.event.KeyEvent;
//import java.time.Duration;
//import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.Test;

public class PostMuralJob extends TestBaseClass {

	@Test
	public void postjobTest() throws InterruptedException, AWTException {
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
		List<WebElement> listName = driver.findElements(By.xpath("//a[@id = 'artist_first_name_sp_py']"));
		String[][] result = new String[listName.size()][3];
		int i = 0, j = 0, k = 0;
		
		for (WebElement element : listName) {

			String artistName = element.getText();
			result[i][0] = artistName;
			i++;

		}

		List<WebElement> listLoc = driver.findElements(By.xpath("//p[@id = 'artist_location_sp_py']"));
		for (WebElement element : listLoc) {
			
			String artistLoc = element.getText();
			result[j][1] = artistLoc;
			j++;

		}
		List<WebElement> listPricing = driver.findElements(By.xpath("//div[@class = 'artist__info-intro-wrap']/p[1]"));
		for (WebElement element : listPricing) {
			
			String artistPrice = element.getText();
			result[k][2] = artistPrice;
			k++;

		}

		elementInArray(result);

	}

	public static void elementInArray(String[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        for (int i = 0; i < rows; i++) {
            System.out.print("|"); 
            for (int j = 0; j < cols; j++) {
                System.out.print(" " + array[i][j] + " |"); 
            }
            System.out.println();
            
        }
	}
    
}

// Read Data and Locators from properties file
/*
 * 
 * 
 * // Accepting the cookie
 * driver.findElement(By.xpath("//button[@class = 'button-close']")).click();
 * 
 * // Checking if right web page is opened
 * Assert.assertEquals(driver.getTitle(), "Post a job - Book An Artist");
 * 
 * // Giving Project Name
 * 
 * WebElement projectTitle = driver .findElement(By.
 * xpath("//p[contains(text(), 'Give your project a name')]/../div//input"));
 * Assert.assertTrue(projectTitle.isDisplayed());
 * 
 * driver.findElement(By.id(prop.getProperty("project_id"))).sendKeys(prop.
 * getProperty("project_name"));
 * 
 * // Clicking on the Kind of Art
 * driver.findElement(By.xpath(prop.getProperty("artKind_x"))).click();
 * 
 * // Clicking on the mural location
 * driver.findElement(By.xpath(prop.getProperty("mural_loc_x"))).click();
 * 
 * // Adding values in the width textBox
 * driver.findElement(By.xpath(prop.getProperty("width_x"))).sendKeys("5");
 * 
 * // Adding values in the height textBox
 * driver.findElement(By.xpath(prop.getProperty("height_x"))).sendKeys("5");
 * 
 * // Choosing ft.
 * driver.findElement(By.xpath(prop.getProperty("unit_x"))).click();
 * 
 * // Location of the project dropdown WebElement projectLocation =
 * driver.findElement(By.xpath(prop.getProperty("locationOfProject_x")));
 * projectLocation.sendKeys("Canada Bay NSW, Australia"); Thread.sleep(3000);
 * Actions suggestionSelect = new Actions(driver);
 * suggestionSelect.keyDown(projectLocation,
 * Keys.DOWN).sendKeys(Keys.ENTER).perform();
 * 
 * // Choosing Property Type
 * driver.findElement(By.xpath(prop.getProperty("propertyType_x"))).click();
 * 
 * // Clicking on Continue button
 * driver.findElement(By.xpath(prop.getProperty("continuebtn_x"))).click();
 * Thread.sleep(2000);
 * 
 * // Validating the design page WebElement designHeader =
 * driver.findElement(By.xpath(prop.getProperty("header_x")));
 * Assert.assertEquals(designHeader.getText(), "Design");
 * 
 * // Assert if one of the option is "No idea" WebElement noIdea =
 * driver.findElement(By.xpath(prop.getProperty("noIdea_x")));
 * Assert.assertTrue(noIdea.isDisplayed()); noIdea.click();
 * 
 * // Project Description
 * driver.findElement(By.id(prop.getProperty("jobDesc_id")))
 * .sendKeys("Theme: Minimalist Nature\r\n" +
 * "Subjects: Trees, mountains, rivers, and animals\r\n" +
 * "Colors: Earth tones (greens, browns), sky blues, soft neutrals (beiges, whites)"
 * );
 * 
 * // Attaching File WebElement attachButton =
 * driver.findElement(By.xpath(prop.getProperty("attachFile_x")));
 * attachButton.click(); Thread.sleep(2000);
 * 
 * Robot robot = new Robot(); StringSelection filePath = new StringSelection(
 * "C:\\Users\\Sumit Jaiswal\\eclipse-workspace\\BookAnArtist\\Attachments\\attachment.jpg"
 * ); Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath,
 * null);
 * 
 * robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_V);
 * robot.keyRelease(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_CONTROL);
 * 
 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
 * 
 * // wait till uploaded file get showed WebDriverWait wait = new
 * WebDriverWait(driver, Duration.ofMinutes(2));
 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.
 * getProperty("validAttachment_x"))));
 * 
 * // driver.findElement(By.xpath(prop.getProperty("continuebtn_x"))).click();
 * Thread.sleep(2000);
 * 
 * // Validating the Budget & Timeline page WebElement budgetHeader =
 * driver.findElement(By.xpath(prop.getProperty("header_x")));
 * Assert.assertEquals(budgetHeader.getText(), "Budget & Timeline");
 * 
 * driver.findElement(By.id(prop.getProperty("budget_id"))).sendKeys("100.50");
 * 
 * // Sending "CAD" as Currency
 * driver.findElement(By.xpath(prop.getProperty("currencyDropdown_x"))).sendKeys
 * ("CAD");
 * 
 * // Selecting date as 31st May
 * driver.findElement(By.xpath(prop.getProperty("beforeDate_x"))).click();
 * Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("date_x"))).click();
 * 
 * // Continuing to the next page
 * driver.findElement(By.xpath(prop.getProperty("continuebtn_x"))).click();
 * Thread.sleep(2000);
 * 
 * // Validating the Budget & Timeline page WebElement contactHeader =
 * driver.findElement(By.xpath(prop.getProperty("header_x")));
 * Assert.assertEquals(contactHeader.getText(), "Contact Information");
 * 
 * // Filling contact Info
 * driver.findElement(By.xpath(prop.getProperty("individual_x"))).click();
 * driver.findElement(By.id(prop.getProperty("phone_id"))).sendKeys("7050753137"
 * );
 * driver.findElement(By.id(prop.getProperty("firstName_id"))).sendKeys("Sumit")
 * ;
 * driver.findElement(By.id(prop.getProperty("lastName_id"))).sendKeys("Jaiswal"
 * ); driver.findElement(By.id(prop.getProperty("email_id"))).sendKeys(
 * "sumitjaiswal976@gmail.com");
 * driver.findElement(By.id(prop.getProperty("password_id"))).sendKeys(
 * "Abcd@1234");
 * 
 * driver.findElement(By.id(prop.getProperty("agree_id"))).click();
 * driver.findElement(By.cssSelector(prop.getProperty("captcha_css"))).click();
 */
