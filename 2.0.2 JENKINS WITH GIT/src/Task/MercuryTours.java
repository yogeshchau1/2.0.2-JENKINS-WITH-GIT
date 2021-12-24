package Task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MercuryTours {
	WebDriver driver;
	@BeforeSuite
	public void OpenBrowser()
	{
		System.out.println("OPEN BROWSER");
		System.setProperty("webdriver.chrome.driver", "D:\\TESTING REQUIRED APPS JARS\\Chrome 96 drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@BeforeTest
	public void EnterUrl()
	{
		System.out.println("URL ENTER");
		driver.get("http://demo.guru99.com/test/newtours/register.php");
	}
	
	@BeforeClass
	public void MaxWindow()
	{
		System.out.println("COOKIES DISPLAY");
		Set<Cookie> c=driver.manage().getCookies();
		for(Cookie co:c)
		{
			System.out.println("COOKIE  : "+co.getName());
		}
		System.out.println("WINDOW MAXIMIZE");
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void Screenshot() throws IOException
	{
		System.out.println("TAKE SCREENSHOT");
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src,new File("I:\\FULL TIME LEC\\3 TESTING\\Screenshot\\TASK MERCURY DEMO"));
	}
	
	@Test(dataProvider = "data",invocationCount = 5)
	public void Register(String fname,String lname,String phone,String email,String address,String city,String state,String pin,String co,String uname,String pass,String cpass)
	{
		System.out.println("REGISTER START");
		
		driver.findElement(By.name("firstName")).sendKeys(fname);
		driver.findElement(By.name("lastName")).sendKeys(lname);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("userName")).sendKeys(email);
		driver.findElement(By.name("address1")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("postalCode")).sendKeys(pin);
		driver.findElement(By.name("country")).sendKeys(co);
		driver.findElement(By.name("email")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("confirmPassword")).sendKeys(cpass);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")).click();
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		
	}
	
	@AfterMethod
	public void Screenshot1() throws IOException
	{
		File src1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src1,new File("I:\\FULL TIME LEC\\3 TESTING\\Screenshot\\TASK MERCURY DEMO"));
	}
	
	@AfterClass
	public void CookiesDelete()
	{
		System.out.println("DELET COOKIE");
		driver.manage().deleteAllCookies();
	}
	@AfterTest
	public void DbcollectionClosed()
	{
		System.out.println("DB COLLECTION CLOSED");
	}
	@AfterSuite
	public void BrowserClosed()
	{
		System.out.println("BROWSER CLOSED");
		//driver.close();
	}
	
	@DataProvider
	public Object[][] data() throws IOException
	{
		FileInputStream io=new FileInputStream("D:\\TESTING REQUIRED APPS JARS\\FILES\\TASK mercury tours.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(io);
		XSSFSheet sheet=book.getSheet("Sheet1");
		XSSFRow row=sheet.getRow(1);
		XSSFCell cell=row.getCell(0);
		String fname=cell.getStringCellValue();
		XSSFCell cell1=row.getCell(1);
		String lname=cell1.getStringCellValue();
		XSSFCell cell2=row.getCell(2);
		String phone=cell2.getStringCellValue();
		XSSFCell cell3=row.getCell(3);
		String email=cell3.getStringCellValue();
		XSSFCell cell4=row.getCell(4);
		String address=cell4.getStringCellValue();
		XSSFCell cell5=row.getCell(5);
		String city=cell5.getStringCellValue();
		XSSFCell cell6=row.getCell(6);
		String state=cell6.getStringCellValue();
		XSSFCell cell7=row.getCell(7);
		String pin=cell7.getStringCellValue();
		XSSFCell cell8=row.getCell(8);
		String co=cell8.getStringCellValue();
		XSSFCell cell9=row.getCell(9);
		String uname=cell9.getStringCellValue();
		XSSFCell cell10=row.getCell(10);
		String pass=cell10.getStringCellValue();
		XSSFCell cell11=row.getCell(11);
		String cpass=cell11.getStringCellValue();
		return new Object[][]
				{
				new Object[] {fname,lname,phone,email,address,city,state,pin,co,uname,pass,cpass}
				};
	}
}
