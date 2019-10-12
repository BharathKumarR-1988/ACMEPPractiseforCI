package acmepAccount;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AcmepACLogin {

	@Test public void acmepLogin() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");		
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		driver.get(" https://acme-test.uipath.com/account/login");
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
		driver.findElementById("password").sendKeys("leaf@12", Keys.TAB, Keys.ENTER);
		WebElement ele = driver.findElementByXPath("(//button[@class='btn btn-default btn-lg'])[4]");
		
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		
		driver.findElementByLinkText("Search for Vendor").click();
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		driver.findElementByXPath("//button[text()='Search']").click();
		
		String text = driver.findElementByXPath("(//table[@class='table']//tr/following-sibling::tr/td)[5]").getText();
		
		System.out.println(text);
		
		Thread.sleep(1000);
		driver.findElementByLinkText("Log Out").click();
		driver.close();
	}
	
}
