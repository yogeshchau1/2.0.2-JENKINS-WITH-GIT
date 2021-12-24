package Team.Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryReg {
	public static void main(String[] args) {
		
		
		
		System.out.println("OPEN BROWSER");
		System.setProperty("webdriver.chrome.driver", "D:\\TESTING REQUIRED APPS JARS\\Chrome 96 drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		
		driver.findElement(By.name("firstName")).sendKeys("66666");
		driver.findElement(By.name("lastName")).sendKeys("66666");
		driver.findElement(By.name("phone")).sendKeys("66666");
		driver.findElement(By.name("userName")).sendKeys("66666@gmail.com");
		driver.findElement(By.name("address1")).sendKeys("66666");
		driver.findElement(By.name("city")).sendKeys("pune");
		driver.findElement(By.name("state")).sendKeys("MH");
		driver.findElement(By.name("postalCode")).sendKeys("66666");
		driver.findElement(By.name("country")).sendKeys("INDIA");
		driver.findElement(By.name("email")).sendKeys("66666");
		driver.findElement(By.name("password")).sendKeys("666666");
		driver.findElement(By.name("confirmPassword")).sendKeys("666666");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")).click();
	}
	
}
