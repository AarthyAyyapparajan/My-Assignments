package week4.day1.ha;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingAlert {

	public static void main(String[] args) {
		
		//Initialize ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		
		//Maximize the browser window
		driver.manage().window().maximize();
		
		//Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Load the URL (http://leaftaps.com/opentaps/control/login)
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//Enter the username and password
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click on the Login button.
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on the CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click on the Contacts button.
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//Click on Merge Contacts.
		driver.findElement(By.linkText("Merge Contacts")).click();
		
		//Click on the widget of the "From Contact".
	    driver.findElement(By.xpath("(//input[@name ='partyIdFrom']/following::img)[1]")).click();
		Set<String> parentWindow = driver.getWindowHandles();
		List<String> childWindow = new ArrayList<String>(parentWindow);
		driver.switchTo().window(childWindow.get(1));
		
		//Click on the first resulting contact.
		driver.findElement(By.xpath("(//div[contains(@class,' x-grid3-col-partyId')]/a)[1]")).click();
		
		    
		 driver.switchTo().window(childWindow.get(0));
		
		 //Click on the widget of the "To Contact".
		 driver.findElement(By.xpath("(//input[@name ='partyIdFrom']/following::img)[2]")).click(); 
		    
		    
		 Set<String> parentWindow1 = driver.getWindowHandles();
		 List<String> childWindow1 = new ArrayList<String>(parentWindow1);
		 driver.switchTo().window(childWindow1.get(1));
		
		 //Click on the second resulting contact.
		 driver.findElement(By.xpath("(//div[contains(@class,' x-grid3-col-partyId')]/a)[2]")).click();
		
		    
		 driver.switchTo().window(childWindow1.get(0));
			
		 //Click on the Merge button
		 driver.findElement(By.xpath("//a[text()='Merge']")).click();
			
		 //Accept the alert.
		 Alert msg = driver.switchTo().alert();
		 System.out.println("The Alert Message is:"+msg.getText());
		 msg.accept();
			
		 //Verify the title of the page.
		 String title = driver.getTitle();
		 System.out.println("Title of the page is:"+title);
		 if (title.contains("Merge Contacts | opentaps CRM"))
		 {
		 System.out.println("Title Matched");
		 }
		 else
		 {
		 System.out.println(" Not matched");
		 }	

		 }

}
