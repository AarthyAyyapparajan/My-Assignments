package week4.day2.ha;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionSnapDeal {
	

		public static void main(String[] args) throws IOException, InterruptedException 
		{
			   //Initializing the chrome driver
			   ChromeDriver driver = new ChromeDriver();
			  
			   //Maximizing the window
				driver.manage().window().maximize();
			    
				//implicit wait
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				 //Load the URL
				 driver.get("https://www.snapdeal.com/"); 
				 
				    //using actions mousehover on mens fashion
				    WebElement mouseOver = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
					 
				    //object for actions to click sports shoe
					Actions builder = new Actions(driver);
					builder.moveToElement(mouseOver).perform();
					driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
					
					//Prints the msg of total count
					String count = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
					System.out.println("Total count is:"+count);
					
					//Click on "Training Shoes".
					driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
					
					//Filtering the results
					driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
					
					//by low to high products
					driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
					Thread.sleep(3000);
				
					//Check if the displayed items are sorted correctly
					List<WebElement> sort = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
					for(int i=0;i<sort.size()-1;i++)
					System.out.println(" Sort Order:"+sort.get(i).getText());
					
					//Select a price range (e.g., 500-700)
		            WebElement minPrice = driver.findElement(By.xpath("//input[@name='fromVal']"));
		            minPrice.clear();
		            minPrice.sendKeys("500");
		            WebElement maxPrice = driver.findElement(By.xpath("//input[@name='toVal']"));
		            maxPrice.clear();
		            maxPrice.sendKeys("700");
		            driver.findElement(By.xpath("//div[contains(@class,'price-go')]")).click();
		            Thread.sleep(5000);
		            
		            //Filter by any colour
		            WebElement filterColor= driver.findElement(By.xpath("(//div[@class='filter-content ']//label)[1]"));
		            filterColor.click();
		            
		            //Verify all the applied filters
		            System.out.println("Applied Filters");
		            WebElement priceRangeText = driver.findElement(By.xpath("(//a[contains(@class,'clear-filter')])[1]"));
		            System.out.println("Price Range: " + priceRangeText.getText());
		            WebElement colorText = driver.findElement(By.xpath("//a[text()=' Black']"));
		            System.out.println("Color: " + colorText.getText());
		            
		            //Mouse hover on the first resulting "Training Shoes"
		            WebElement firstProduct = driver.findElement(By.xpath("(//div[contains(@class,'product-tuple-listing')])[1]"));
		            Actions actions = new Actions(driver);
		            actions.moveToElement(firstProduct).perform();
		            
		            //Click the "Quick View" button
		            driver.findElement(By.xpath("(//div[@class='clearfix row-disc'])[1]")).click();
		            
		            //Print the cost and the discount percentage
		            WebElement cost = driver.findElement(By.xpath("(//span[contains(@id,'display-price')])[1]"));
		            System.out.println("Cost: " + cost.getText());
		            WebElement discount = driver.findElement(By.xpath("(//div[@class='product-discount'])[1]"));
		            System.out.println("Discount: " + discount.getText());
		            
		            Thread.sleep(3000);
		         
		    		//Take a snapshot of the shoes 
		            File src = driver.getScreenshotAs(OutputType.FILE);
		    		File trgt = new File("./snapshot/quickView.png");
		    		FileUtils.copyFile(src, trgt);
		    		
		    		
		            //Close the current window 
		            driver.close();
		            //Close the main window
		            driver.quit();
					


			          

		}

	}

