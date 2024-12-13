package week5.day2.ha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateLegalEntity2 extends ProjectSpecificMethod {
     @Test
	public void entity2() {
		
		//Enter the company name as "Test Leaf"
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TestLeaf");
		
		//Enter the Description
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys("Salesforces");
		
		//Select Status as 'Active'
		WebElement status = driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__i')]"));

		Actions act = new Actions(driver);
		act.scrollToElement(status);
		driver.executeScript("arguments[0].click();", status);
		
		driver.findElement(By.xpath("//span[text()='Active']")).click();
		
		
		//Click on Save
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		//Verify the Alert message
		WebElement verifyalert = driver.findElement(By.xpath("//div[@class='fieldLevelErrors']"));
		String text = verifyalert.getText();
		System.out.println("Alert msg : "+text);
		
		if(text.contains("Legal Entity Name")) {
			System.out.println("Alert msg verified successfully!!");
		}else {
			System.out.println("alert msg not verified");
		}
		
		
			
		}
		
		
		
		

}
