package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExpensesCRUD {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup () throws InterruptedException {
		
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://web.hishabee.business/sign-in");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("[type=number]")).sendKeys("01941589494");
		driver.findElement(By.cssSelector("[type=submit]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[type=password]")).sendKeys("12345");
		driver.findElement(By.cssSelector("[type=submit]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div/div[2]/div/div/div/button")).click();
		Thread.sleep(5000);
		
	}
	
	@Test(priority = 1)
	public void CreateBill() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"tally\"]/li[5]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div/div[2]/div/div[2]/div[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[1]/form/div/div[1]/div/div[1]/input")).sendKeys("100");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[1]/form/div/div[1]/div/div[2]/input")).sendKeys("Snacks");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[1]/form/div/div[1]/div/div[3]/textarea")).sendKeys("Tea & Biscuit");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[1]/form/div/div[3]/div[2]/button")).click();
		Thread.sleep(5000);
		String ER = driver.getCurrentUrl();	
		String AR = "https://web.hishabee.business/expense";
		
		Assert.assertEquals(ER, AR);
		System.out.println("CreateBill Is Pass");	
		Thread.sleep(5000);
	}
	
	
	@Test(priority = 2)
	public void ReadBill() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div/div[1]/div/div[3]/div[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div/div[2]/div[2]/div/div[4]/button")).click();
		Thread.sleep(5000);
		String ER = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div/div[1]/div/div/div[2]/div/div[2]/p")).getText();	
		String AR = "2023";
		
		Assert.assertEquals(ER, AR);
		System.out.println("ReadBill Is Pass");	
		Thread.sleep(5000);
	}
	
	
	@Test(priority = 3)
	public void UpdateBill() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div/div[2]/div[2]/div/div[1]/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div/div[3]/div/table/tbody/tr[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/form/div/div[2]/div[3]/button[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[1]/form/div/div[1]/div/div[1]/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[1]/form/div/div[1]/div/div[1]/input")).sendKeys("120");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[1]/form/div/div[3]/div[2]/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div/div[2]/div[2]/div/div[1]/button")).click();
		
		Thread.sleep(5000);
		String ER = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div/div[3]/div/table/tbody/tr[1]/td[2]/p/span")).getText();
		String AR = "120";
		
		Assert.assertEquals(ER, AR);
		System.out.println("UpdateBill Is Pass");	
		Thread.sleep(5000);
	}
	
	
	@Test(priority = 4)
	public void DeleteBill() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div/div[2]/div[2]/div/div[1]/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div/div[3]/div/table/tbody/tr[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/form/div/div[2]/div[3]/button[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div[4]/div/div[2]/button[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div/div[2]/div[2]/div/div[1]/button")).click();
		
		Thread.sleep(5000);
		String ER = driver.getCurrentUrl();
		String AR = "https://web.hishabee.business/expense/items";
		
		Assert.assertEquals(ER, AR);
		System.out.println("DeleteBill Is Pass");	
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}

}
