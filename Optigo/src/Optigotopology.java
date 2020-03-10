import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Optigotopology {
	public String baseurl="http://192.168.200.203:8081/OptiGoProduct/#/login";
	WebDriver driver;

	@BeforeSuite
	public void browserlaunch()
	{
		System.setProperty("webdriver.chrome.driver","//usr//bin//chromedriver");	

		ChromeOptions options= new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			
			  driver=new ChromeDriver(options);
				driver.get(baseurl);
		
	}
	
	
	
	@Test(priority=1)
	public void Userlogin() throws InterruptedException
	{
		

		WebDriverWait wait = new WebDriverWait(driver, 15);

	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));


	WebElement email=driver.findElement(By.name("email"));
	email.sendKeys("cangoadmin");

	WebElement password=driver.findElement(By.name("password"));
	password.sendKeys("OptiGo@2020");
	WebElement Login=driver.findElement(By.xpath("//button[@class='btn block m-b loginbtn']"));
	Login.click();
	driver.manage().window().maximize();
	Thread.sleep(1000);		
	
	}
	@Test(priority=2)
	public void DWDMtopology() throws InterruptedException, IOException{
		Actions action=new Actions(driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		WebElement topology=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//basic/div/navigation/nav/div/ul/li[5]/a")));
		
		action.moveToElement(topology).click().build().perform();
WebElement topology2=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//basic/div/navigation/nav/div/ul/li[5]/ul/li[1]/a")));
		
		action.moveToElement(topology2).click().build().perform();
		WebElement topbutn=driver.findElement(By.xpath("//button[@class='btn btn-default flter']"));
		topbutn.click();
		WebElement domain=driver.findElement(By.xpath("//div[@class='ng-tns-c13-0 mbtw optigo-check-box ui-multiselect ui-widget ui-state-default ui-corner-all']"));
		domain.click();
		WebElement domain2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-trigger ng-trigger-overlayAnimation ng-tns-c13-0 ui-multiselect-panel ui-widget ui-widget-content ui-corner-all ui-shadow ng-star-inserted']/div[2]/ul/li[1]/div/div[2]")));
		domain2.click();
		action.moveToElement(topbutn).build().perform();
		Thread.sleep(5000);

		WebElement vendor=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-tns-c13-1 mbtw optigo-check-box ui-multiselect ui-widget ui-state-default ui-corner-all']/div[2]")));
	action.moveToElement(vendor).build().perform();
	action.click(vendor).build().perform();
	WebElement vendor2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-trigger ng-trigger-overlayAnimation ng-tns-c13-1 ui-multiselect-panel ui-widget ui-widget-content ui-corner-all ui-shadow ng-star-inserted']/div[2]/ul/li")));
	action.moveToElement(vendor2).build().perform();
	action.click(vendor2).build().perform();
	action.moveToElement(topbutn).build().perform();
	Thread.sleep(2000);
	WebElement NE=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-tns-c13-2 mbtw optigo-check-box ui-multiselect ui-widget ui-state-default ui-corner-all']")));
	action.moveToElement(NE).build().perform();
	action.click(NE).build().perform();
	WebElement NE2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-trigger ng-trigger-overlayAnimation ng-tns-c13-2 ui-multiselect-panel ui-widget ui-widget-content ui-corner-all ui-shadow ng-star-inserted']/div[2]/ul/li")));
	action.moveToElement(NE2).build().perform();
	action.click(NE2).build().perform();
	action.moveToElement(topbutn).build().perform();
	Thread.sleep(2000);
	WebElement apply=driver.findElement(By.xpath("//button[@class='btn btn-success btn-sm']"));
	apply.click();
	Thread.sleep(7000);
	TakesScreenshot scrShot =((TakesScreenshot)driver);
	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	File DestFile=new File("/root/Desktop/DWDM.png");
	FileUtils.copyFile(SrcFile,DestFile);
	
	
	}
	
	@Test(priority=3)
		public void IPTopology() throws InterruptedException, IOException{
		Thread.sleep(5000);
		Actions action=new Actions(driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		
		WebElement topbutn=driver.findElement(By.xpath("//button[@class='btn btn-default flter']"));
		topbutn.click();
		WebElement domain=driver.findElement(By.xpath("//div[@class='ng-tns-c13-3 mbtw optigo-check-box ui-multiselect ui-widget ui-state-default ui-corner-all']"));
		domain.click();
		WebElement domain2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-trigger ng-trigger-overlayAnimation ng-tns-c13-3 ui-multiselect-panel ui-widget ui-widget-content ui-corner-all ui-shadow ng-star-inserted']/div[2]/ul/li[1]")));
		domain2.click();
		WebElement IPdom=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-multiselect-items-wrapper']/ul/li[2]/div")));
		action.moveToElement(IPdom).build().perform();
		action.click(IPdom).build().perform();
		action.moveToElement(topbutn).build().perform();
		Thread.sleep(5000);

		WebElement protocol=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-tns-c13-6 mbtw optigo-check-box ui-multiselect ui-widget ui-state-default ui-corner-all']")));
	action.moveToElement(protocol).build().perform();
	action.click(protocol).build().perform();
	WebElement pro2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-widget-header ui-corner-all ui-multiselect-header ui-helper-clearfix ng-tns-c13-6 ng-star-inserted']/div[1]")));
	action.moveToElement(pro2).build().perform();
	action.click(pro2).build().perform();
	action.moveToElement(topbutn).build().perform();
	Thread.sleep(2000);
	WebElement apply=driver.findElement(By.xpath("//button[@class='btn btn-success btn-sm']"));
	apply.click();
	Thread.sleep(17000);
	TakesScreenshot scrShot =((TakesScreenshot)driver);
	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	File DestFile=new File("/root/Desktop/IPTopology.png");
	FileUtils.copyFile(SrcFile,DestFile);
			
		}
	@Test(priority=4)
	public void MicrowaveTopology() throws InterruptedException, IOException{
	Actions action=new Actions(driver);
	WebDriverWait wait2 = new WebDriverWait(driver, 5);
	
	WebElement topbutn=driver.findElement(By.xpath("//button[@class='btn btn-default flter']"));
	topbutn.click();
	WebElement domain=driver.findElement(By.xpath("//div[@class='ng-tns-c13-8 mbtw optigo-check-box ui-multiselect ui-widget ui-state-default ui-corner-all']"));
	domain.click();
	WebElement domain2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-multiselect-items-wrapper']/ul/li[2]/div")));
	domain2.click();
	WebElement Microdom=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-multiselect-items-wrapper']/ul/li[3]/div")));
	Microdom.click();
	action.moveToElement(topbutn).build().perform();
	Thread.sleep(5000);

	WebElement protocol=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-tns-c13-13 mbtw optigo-check-box ui-multiselect ui-widget ui-state-default ui-corner-all']")));
action.moveToElement(protocol).build().perform();
action.click(protocol).build().perform();
WebElement pro2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-trigger ng-trigger-overlayAnimation ng-tns-c13-13 ui-multiselect-panel ui-widget ui-widget-content ui-corner-all ui-shadow ng-star-inserted']/div[1]/div[1]/div[2]")));
action.moveToElement(pro2).build().perform();
action.click(pro2).build().perform();
action.moveToElement(topbutn).build().perform();
Thread.sleep(2000);
WebElement apply=driver.findElement(By.xpath("//button[@class='btn btn-success btn-sm']"));
apply.click();
Thread.sleep(17000);
TakesScreenshot scrShot =((TakesScreenshot)driver);
File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
File DestFile=new File("/root/Desktop/MicrowaveTopology.png");
FileUtils.copyFile(SrcFile,DestFile);
		
	}
	@Test(priority=5)
	public void TransportSDHpacketTopology() throws InterruptedException, IOException{
	Actions action=new Actions(driver);
	WebDriverWait wait2 = new WebDriverWait(driver, 5);
	
	WebElement topbutn=driver.findElement(By.xpath("//button[@class='btn btn-default flter']"));
	topbutn.click();
	WebElement domain=driver.findElement(By.xpath("//div[@class='ng-tns-c13-16 mbtw optigo-check-box ui-multiselect ui-widget ui-state-default ui-corner-all']"));
	domain.click();
	WebElement domain2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-multiselect-items-wrapper']/ul/li[3]/div")));
	domain2.click();
	WebElement Transportdom=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-multiselect-items-wrapper']/ul/li[4]/div")));
	Transportdom.click();
	action.moveToElement(topbutn).build().perform();
	Thread.sleep(5000);

	WebElement protocol=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-tns-c13-22 mbtw optigo-check-box ui-multiselect ui-widget ui-state-default ui-corner-all']")));
action.moveToElement(protocol).build().perform();
action.click(protocol).build().perform();
WebElement pro2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-widget-header ui-corner-all ui-multiselect-header ui-helper-clearfix ng-tns-c13-22 ng-star-inserted']/div[1]/div[2]")));
action.moveToElement(pro2).build().perform();
action.click(pro2).build().perform();
action.moveToElement(topbutn).build().perform();
Thread.sleep(2000);
WebElement apply=driver.findElement(By.xpath("//button[@class='btn btn-success btn-sm']"));
apply.click();
Thread.sleep(17000);
TakesScreenshot scrShot =((TakesScreenshot)driver);
File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
File DestFile=new File("/root/Desktop/TransportTopology.png");
FileUtils.copyFile(SrcFile,DestFile);
		
	}
	
	
	}
	


