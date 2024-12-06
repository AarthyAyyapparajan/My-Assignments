package week4.day2.ha;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class ActionAmazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		        //- Initialize ChromeDriver
				ChromeDriver driver = new ChromeDriver();
				
				//- Load the URL 
				driver.get("https://www.amazon.in/");
						
				//Maximize the browser window
				driver.manage().window().maximize();
				
				//Add an implicit wait to ensure the webpage elements are fully loaded
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				
				//Search for "oneplus 9 pro".
				driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
				driver.findElement(By.id("nav-search-submit-button")).click();
				
				//Get the price of the first product.
				WebElement fprice = driver.findElement(By.xpath("//span[@class='a-price']"));
				String price = fprice.getText();
				System.out.println( "Price of first result mobile : "+price);
				
				// Print the number of customer ratings for the first displayed product.
				WebElement ratings = driver.findElement(By.xpath("//span[contains(@class,'a-size-base s-underline-text')]"));
				String totalrating = ratings.getText();
				System.out.println("Number of customer rating : "+ totalrating);
				
				// Click the first text link of the first image. 
				driver.findElement(By.xpath("//img[@class='s-image']")).click();
				
				Set<String> windowHandles = driver.getWindowHandles();
				List<String>mobile=new ArrayList<String>(windowHandles);
				driver.switchTo().window(mobile.get(1));
				
				Thread.sleep(3000);
				
				// Take a screenshot of the product displayed.
				File screenshot = driver.getScreenshotAs(OutputType.FILE);
				File store = new File("./snapShot/Mobpic1.png");
				FileUtils.copyFile(screenshot, store);
				
				// Click the 'Add to Cart' button.
				driver.findElement(By.xpath("(//span[@id='submit.add-to-cart']//input)[2]")).click();
				
				// Get the cart subtotal and verify if it is correct.
				driver.findElement(By.xpath("//form[contains(@id,'cart-button-form')]")).click();
				WebElement subtotal = driver.findElement(By.xpath("//span[contains(@class,'sc-product-price a-text-bold')]"));
				@SuppressWarnings("unused")
				String finaltotal = subtotal.getText();
				System.out.println("Subtotal of product: "+subtotal.getText());
				
				// Close the browser.
				
				driver.quit();

	}

}
