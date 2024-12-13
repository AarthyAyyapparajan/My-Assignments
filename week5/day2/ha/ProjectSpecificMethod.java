package week5.day2.ha;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectSpecificMethod {
	public ChromeDriver driver;
	
	@BeforeMethod
	public void precondition() throws InterruptedException {
		
		//Disable the Notifications	
		ChromeOptions d = new ChromeOptions();
		d.addArguments("--disable-notification");
		driver = new ChromeDriver(d);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com");
		
		// Username: dilip@testleaf.com
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
		
		//Password: leaf@2024
		driver.findElement(By.id("password")).sendKeys("leaf@2024");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(30);
		
		// Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		// Click View All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("legal");
		driver.findElement(By.xpath("(//p[@class='slds-truncate'])[2]")).click();
		
		//Click on New Legal Entity
		driver.findElement(By.xpath("//div[text()='New']")).click();
		
		
	}

	@AfterMethod
	public void postcondition() {
	driver.close();
	}
}

