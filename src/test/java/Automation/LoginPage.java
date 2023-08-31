package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPage {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() throws InterruptedException {
		
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://web.hishabee.business/sign-in");
		Thread.sleep(5000);
		
	}
	
	@Test(priority = 1)
	public void ValidMobileNumber() throws InterruptedException {
		
		driver.findElement(By.cssSelector("[type=number]")).sendKeys("01941589494");
		driver.findElement(By.cssSelector("[type=submit]")).click();
		Thread.sleep(5000);
		String ER = driver.getCurrentUrl();	
		String AR = "https://web.hishabee.business/sign-in/pin";	
		
		Assert.assertEquals(ER, AR);
		System.out.println("ValidMobileNumber Is Pass");	
		driver.navigate().back();
		Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	public void WrongMobileNumber() throws InterruptedException {
		
		driver.findElement(By.cssSelector("[type=number]")).sendKeys("01941589493");
		driver.findElement(By.cssSelector("[type=submit]")).click();
		Thread.sleep(5000);
		String ER = driver.getCurrentUrl();	
		String AR = "https://web.hishabee.business/register/verify";	
		
		Assert.assertEquals(ER, AR);
		System.out.println("WrongMobileNumber Is Pass");	
		driver.navigate().back();
		Thread.sleep(5000);
	}
	
	
	@Test(priority = 3)
	public void InvalidMobileNumber() throws InterruptedException {
		
		driver.findElement(By.cssSelector("[type=number]")).sendKeys("1941589494");
		driver.findElement(By.cssSelector("[type=submit]")).click();
		Thread.sleep(5000);
		String ER = driver.getCurrentUrl();	
		String AR = "https://web.hishabee.business/sign-in";	
		
		Assert.assertEquals(ER, AR);
		System.out.println("InvalidMobileNumber Is Pass");	
		driver.navigate().back();
		Thread.sleep(5000);
	}
	
	
	@Test(priority = 4)
	public void BlankMobileNumber() throws InterruptedException {
		
		driver.findElement(By.cssSelector("[type=number]")).sendKeys("");
		driver.findElement(By.cssSelector("[type=submit]")).click();
		Thread.sleep(5000);
		String ER = driver.getCurrentUrl();	
		String AR = "https://web.hishabee.business/sign-in";	
		
		Assert.assertEquals(ER, AR);
		System.out.println("BlankMobileNumber Is Pass");	
		driver.navigate().to("https://web.hishabee.business/sign-in");
		Thread.sleep(5000);
	}
	
	
	@Test(priority = 5)
	public void ValidPinNumber() throws InterruptedException {
		
		driver.findElement(By.cssSelector("[type=number]")).sendKeys("01941589494");
		driver.findElement(By.cssSelector("[type=submit]")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("[type=password]")).sendKeys("12345");
		driver.findElement(By.cssSelector("[type=submit]")).click();
		Thread.sleep(5000);
		String ER = driver.getCurrentUrl();	
		String AR = "https://web.hishabee.business/select/shop";	
		
		Assert.assertEquals(ER, AR);
		System.out.println("ValidPinNumber Is Pass");	
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div/div[2]/div/div/div/button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a")).click();
		Thread.sleep(5000);
	}
	
	
	@Test(priority = 6)
	public void InvalidPinNumber() throws InterruptedException {
		
		driver.findElement(By.cssSelector("[type=number]")).sendKeys("01941589494");
		driver.findElement(By.cssSelector("[type=submit]")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("[type=password]")).sendKeys("112233");
		driver.findElement(By.cssSelector("[type=submit]")).click();
		Thread.sleep(5000);
		String ER = driver.getCurrentUrl();	
		String AR = "https://web.hishabee.business/sign-in/pin";	
		
		Assert.assertEquals(ER, AR);
		System.out.println("ValidPinNumber Is Pass");	
	}
	
	
	@AfterClass
	public void teardown() {
		driver.close();
	}

}
