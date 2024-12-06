package week4.day1.ha;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) {
		//Initialize ChromeDriver
		ChromeDriver driver = new ChromeDriver();
				
		//Maximize the browser window
		driver.manage().window().maximize();
				
		//Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
		//Load the URL (http://leaftaps.com/opentaps/control/login)
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		
		//Switch to the frame
		driver.switchTo().frame(0);
		
		//Click the "Try It" button inside the frame 
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
				
		//Click OK/Cancel in the alert that appears 
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("AARTHY");
		alert.accept();
				
		//Confirm the action is performed correctly by verifying the text displayed
		WebElement text = driver.findElement(By.xpath("//p[contains(text(),'AARTHY')]"));
		boolean displayed = text.isDisplayed();
		System.out.println(displayed);
				  
		//text output
		WebElement optext = driver.findElement(By.id("demo"));
		String outtext = optext.getText();
		System.out.println(outtext);
				 
		driver.close();
				
	}

	
		
	}


