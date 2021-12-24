package D4.Task.Product.Purchase;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoWebShop {

	
	WebDriver driver;
	@BeforeSuite
	public void OpenBrowser()
	{
		System.out.println("BROWSER OPEN");
		System.setProperty("webdriver.chrome.driver","D:\\TESTING REQUIRED APPS JARS\\Chrome 95 drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
	}
	
	@BeforeTest
	public void UrlEnter()
	{
		System.out.println("URL ENTERED");
		driver.get("http://demowebshop.tricentis.com/");
	}
	
	@BeforeClass
	public void Maximize()
	{
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void ScreenshotBefore() throws IOException
	{
	
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src,new File("I:\\FULL TIME LEC\\3 TESTING\\Screenshot\\Demo WebShop Test NG"));
	
		Set<Cookie>s=driver.manage().getCookies();
		for (Cookie cookie : s) {
			System.out.println("COOKIE   : "+cookie.getName());
		}
	}
	
	@Test(invocationCount = 3)
	public void Register()
	{
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("RANVEER");
		driver.findElement(By.id("LastName")).sendKeys("RANVEER");
		driver.findElement(By.id("Email")).sendKeys("RANVEERRANVEER401@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("RANVEER");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("RANVEER");
		driver.findElement(By.id("register-button")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[2]/input")).click();
	}
	
	@Test(enabled = false)
	public void ProductBuy()
	{
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.linkText("Books")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.linkText("Fiction")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input[id=\"add-to-cart-button-45\"]")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.linkText("Shopping cart")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.name("removefromcart")).click();
		driver.findElement(By.name("termsofservice")).click();
		driver.findElement(By.xpath("//button[@id=\"checkout\"]")).click();
		driver.findElement(By.name("BillingNewAddress.Company")).sendKeys("CJC");
		WebElement c=driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]"));
		Select s=new Select(c);
		s.selectByVisibleText("India");
		driver.findElement(By.name("BillingNewAddress.City")).sendKeys("PUNE");
		driver.findElement(By.name("BillingNewAddress.Address1")).sendKeys("KARVE NAGAR");
		driver.findElement(By.name("BillingNewAddress.ZipPostalCode")).sendKeys("411052");
		driver.findElement(By.name("BillingNewAddress.PhoneNumber")).sendKeys("1234567890");
		driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/input")).click();
		
	}
	
	@Test(enabled = false)
	public void CheckOut()
	{
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement web=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/ol/li[2]/div[2]/form/div/div/div[2]/p[1]/input[1]"));
		web.click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/ol/li[2]/div[2]/div/input")).click();
		driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[2]/a")).click();
	
	}
	
	@AfterMethod
	public void Screenshot() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src,new File("I:\\FULL TIME LEC\\3 TESTING\\Screenshot\\Demo WebShop Test NG"));
		
	}
	
	@AfterClass
	public void CookieDelete()
	{
		driver.manage().deleteAllCookies();
	}
	
	@AfterTest
	public void DbconnectionClosed()
	{
		System.out.println("DB CONNECTION CLOSED");
	}
	
	@AfterSuite
	public void BrowserClosed()
	{
		driver.close();
	}
	

}


