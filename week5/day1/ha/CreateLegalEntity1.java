package week5.day1.ha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateLegalEntity1 extends ProjectSpecificMethod{
    @Test
	public void Entity1() {
		
		// Enter Name as 'Salesforce Automation by *Your Name*'
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("Salesforce Automation by Aarthy");
		
		// Click save and verify Legal Entity Name
		driver.findElement(By.xpath("//button[text()='Save'])")).click();
		
		//verify Legal Entity Name
		WebElement legalname = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']"));
		String name = legalname.getText();
		
		if (name.contains("Aarthy")) {
			System.out.println("Successfully verified!");
			
		} else {
			System.out.println("Not verified");

		}
		
		
		

	}

}
