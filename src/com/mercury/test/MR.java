package com.mercury.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class MR {

	WebDriver driver;
	
	public void browserMercuryAppLaunch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("http://newtours.demoaut.com/");
		Thread.sleep(3000);
	}
	
	public void browserOrangeHRMAppLaunch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(3000);
	}
	
	public void browserClose()
	{
		driver.close();
	}

	public void loginMercury() throws IOException, InterruptedException {
		WebElement uName = driver.findElement(By.xpath("//input[@name='userName']"));
		
		//WebElement uName = driver.findElement(By.name("userName"));
		uName.sendKeys("dasd");
		
		WebElement pwd = driver.findElement(By.name("password"));	
		//WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
		pwd.sendKeys("dasd");

		WebElement login = driver.findElement(By.name("login"));
		
		//WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
		login.click();

		Thread.sleep(3000);
	}
	
	public void loginOrangeHRM() throws IOException, InterruptedException {
		WebElement uName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		
		//WebElement uName = driver.findElement(By.name("txtUsername"));
		uName.sendKeys("Admin");
		
		//WebElement pwd = driver.findElement(By.name("txtPassword"));	
		WebElement pwd = driver.findElement(By.xpath("//input[@name='txtPassword']"));
		pwd.sendKeys("admin123");

		//WebElement login = driver.findElement(By.name("Submit"));
		WebElement login = driver.findElement(By.xpath("//input[@value='LOGIN']"));
		login.click();

		Thread.sleep(3000);
	}
	
	public void browserFacebookAppLaunch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://www.facebook.com/");
		Thread.sleep(3000);
	}
	public boolean verifylogin() {
		
	String actualTitle="Welcome";
	String expectTitle=driver.getTitle();
	
	if (actualTitle.equals(expectTitle))
		
	{
		return(true);
	}
	
	else {
		return(false);
	}
	
  }	
	public void loginSikulimercury() throws FindFailed, InterruptedException {
		
		//WebElement uName=driver.findElement(By.xpath("//input[@name='userName']"));
		//uName.sendKeys("dasd");
		
		//WebElement pwd=driver.findElement(By.xpath("//input[@name='password']"));
		//pwd.sendKeys("dasd");
		
		//Thread.sleep(8000);
		
		Screen screen=new Screen();
		Pattern username= new Pattern("./SikuliFiles/username.PNG");
		screen.click(username);
		screen.type("dasd");
		
		
		Screen screen1=new Screen();
		Pattern password= new Pattern("./SikuliFiles/password.PNG");
		screen1.click(password);
		screen1.type("dasd");
		
		Screen screen2=new Screen();
		Pattern signin= new Pattern("./SikuliFiles/signin.PNG");
		screen2.click(signin);
		
		
	}
	
	

	
	public void loginRobotMercury() throws AWTException {
		
		//WebElement uName=driver.findElement(By.xpath("//input[@name='userName']"));
		//uName.sendKeys("dasd");
		
		//WebElement pwd=driver.findElement(By.xpath("//input[@name='password']"));
		//pwd.sendKeys("dasd");
		
		Robot r1= new Robot();
		r1.keyPress(KeyEvent.VK_C);
		
		
		Robot r3= new Robot();
		r3.keyPress(KeyEvent.VK_ENTER);
		
		
		
	}
		
		public void autoITTest() throws Exception {
			
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(3000);
			driver.get("https://imgbb.com/");
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[contains(text(),\"Start uploading\")]")).click();
			Thread.sleep(5000);
			Runtime.getRuntime().exec("./AutoITexe/AutoITsnapshot.exe");
			
		}
		
		public void loginWithPropertyfile() throws Exception {
			
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://newtours.demoaut.com/");
			Thread.sleep(3000);
			File file = new File("./Testdata/testdata.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			
			WebElement uName = driver.findElement(By.xpath("//input[@name='userName']"));
			
			//WebElement uName = driver.findElement(By.name("userName"));
			uName.sendKeys(properties.getProperty("Username"));
			
			WebElement pwd = driver.findElement(By.name("password"));	
			//WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
			pwd.sendKeys(properties.getProperty("Password"));

			WebElement login = driver.findElement(By.name("login"));
			
			//WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
			login.click();
		}
		 public void loginDataDrivenExcelSheet() throws BiffException, IOException, InterruptedException {

			 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://newtours.demoaut.com/");
				Thread.sleep(3000);
				
			 
			 
			 File src = new File("./testdata/testdata.xls");

	           Workbook wb = Workbook.getWorkbook(src);

	           Sheet sh1 = wb.getSheet("Login");

	 

	           int rows = sh1.getRows();

	 

	           for (int i = 1; i < rows; i++) {

	                String userNameDataFromExcel = sh1.getCell(0, i).getContents();

	                String passwordDataFromExcel = sh1.getCell(1, i).getContents();

	 

	                Thread.sleep(2000);

	 

	                WebElement uName = driver.findElement(By.xpath("//input[@name='userName']"));

	                uName.sendKeys(userNameDataFromExcel);

	                Thread.sleep(2000);

	 

	                WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));

	                pwd.sendKeys(passwordDataFromExcel);

	                Thread.sleep(2000);

	 

	                WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));

	                login.click();

	                Thread.sleep(5000);

	 

	                WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));

	                home.click();

	                Thread.sleep(5000);

	           }
		
	
		 }
}
	