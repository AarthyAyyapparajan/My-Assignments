package week4.day2.ha;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionBigBasket {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		   //Initializing the chrome driver
		   ChromeDriver driver = new ChromeDriver();
		  
		   //Maximizing the window
			driver.manage().window().maximize();
		   
		   //implicit wait
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			//Load the URL
			driver.get("https://www.bigbasket.com/"); 
			
			//click on the category
			 driver.findElement(By.xpath("(//button[contains(@id,'headlessui')])[4]")).click();
			 Thread.sleep(10000);	
			 
			//move curser to foodgrains, oil&masala
			WebElement food = driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
			Actions act = new Actions(driver);
			act.moveToElement(food).perform();
				
				
			//move to rice & rice
			Actions obj = new Actions(driver);
			WebElement rice = driver.findElement(By.linkText("Rice & Rice Products"));
			obj.moveToElement(rice).perform();
	
			//Click on "Boiled & Steam Rice
			 driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']")).click();
			 Thread.sleep(3000);	
			
			//Filter the results by selecting the brand "bb Royal".
			 driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("BB Royal");
			
			 //click the first one
			 driver.findElement(By.xpath("//input[@id='i-BBRoyal']")).click();
			 Thread.sleep(7000);
	
			 //Click on "Tamil Ponni Boiled Rice"
			 WebElement element2= driver.findElement(By.xpath("//input[@id='i-PonniBoiledRice']"));
			 ChromeDriver js2 = driver;
			 js2.executeScript("arguments[0].click();",element2);
			 Thread.sleep(5000);
				
				
			//Select the 5 Kg bag.
			WebElement size = driver.findElement(By.id("i-5kg(18+MonthsOld)"));
			act.scrollToElement(size);
			driver.executeScript("arguments[0].click();",size);
			
			//Check and note the price of the rice
			String price = driver.findElement(By.xpath("(//span[contains(@class,'StyledLabel5')])[5]")).getText();
			System.out.println("Price of rice is:"+ price);
			
			//Click "Add" to add the bag to your cart.
			driver.findElement(By.xpath("(//button[text()='Add to basket'])[1]")).click();
		
			//Verify the success message that confirms the item was added to your cart.
			String msg = driver.findElement(By.xpath("//p[contains(text(),'basket successfully')]")).getText();
			System.out.println("The msg is:"+ msg);
					Thread.sleep(5000);
				
			//Take a snapshot of the current page
			 File src = driver.getScreenshotAs(OutputType.FILE);
			 File trgt = new File("./snapshot/bigbasket.png");
			 FileUtils.copyFile(src, trgt);		 
				
			 //Close the current window.
			 driver.close();
				
			 //Close the main window.
			 driver.quit();
		
	}

}


