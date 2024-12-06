package week4.day2.ha;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebTable {
	public static void main(String[] args) {
		//- Initialize ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		
		//- Load the URL 
		driver.get("https://finance.yahoo.com/");
		
		//Maximize the browser window
		driver.manage().window().maximize();
		
		//Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click on “Crypto” tab
		WebElement market = driver.findElement(By.xpath("//span[text()='Markets']"));
		Actions act = new Actions(driver);
		act.moveToElement(market).perform();
		driver.findElement(By.xpath("(//div[text()='Crypto'])[2]")).click();
		
		//count of row
		List<WebElement> row = driver.findElements(By.xpath("//table[contains(@class,'markets-table')]/tbody/tr"));
		int rowcount = row.size();
		System.out.println("Number of rows :" +rowcount);
				
		//count of column
		List<WebElement> column = driver.findElements(By.xpath("//table[contains(@class,'market')]/tbody/tr[1]/td"));
		int columncount = column.size();
		System.out.println("Number of columns"+columncount);
			
			
		//Print the cryptocurrency names from table.
		System.out.println("Name of cryptocurrency:");
		for (int i = 1; i <= rowcount; i++) {
		String currency = driver.findElement(By.xpath("//table[contains(@class,'markets-table')]/tbody/tr["+i+"]/td[2]")).getText();
		System.out.println(i+" "+currency);
			
		}
		
		driver.close();
		
	}

}

