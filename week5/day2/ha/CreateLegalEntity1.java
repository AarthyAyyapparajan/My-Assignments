package week5.day2.ha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLegalEntity1 extends ProjectSpecificMethod{
    @DataProvider(name="getData")
    public String[][] setValue() {
		
		return null;
    	
    }
	@Test(dataProvider="getData")
	public void Dynamic(String name) {
		
		// Enter Name as 'Salesforce Automation by *Your Name*'
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("Salesforce Automation by Aarthy");
		
		// Click save and verify Legal Entity Name
		driver.findElement(By.xpath("//button[text()='Save'])")).click();
		
		//verify Legal Entity Name
		WebElement legalname = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']"));
		String name1 = legalname.getText();
		
		if (name1.contains("Aarthy")) {
			System.out.println("Successfully verified!");
			
		} else {
			System.out.println("Not verified");

		}
		
		

	}

}
