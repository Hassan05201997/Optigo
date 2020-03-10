import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

import junit.framework.Assert;

public class Optigotrends {
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
	public void IPTrendsLast7days() throws InterruptedException, IOException{
		Actions action=new Actions(driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		WebElement Trend=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//basic/div/navigation/nav/div/ul/li[2]/a")));
		
		action.moveToElement(Trend).click().build().perform();
		WebElement user=driver.findElement(By.xpath("//li[@class='dropdown avatarlink']"));
		action.moveToElement(user).build().perform();
		WebElement domain=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[1]/p-dropdown")));
domain.click();
WebElement IPdomain=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[1]/p-dropdown/div/div[4]/div/ul/li[1]")));
IPdomain.click();
WebElement vendor=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[2]"));
vendor.click();
WebElement vendor2=driver.findElement(By.xpath("//div[@class='ui-chkbox ui-widget ng-tns-c13-3 ng-star-inserted']"));
vendor2.click();
WebElement granularity=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[5]/p-selectbutton/div/div[3]"));
granularity.click();
WebElement granularity2=driver.findElement(By.xpath("//div[@class='ng-tns-c11-1 mr-1 mb-2 selectperiod ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix']"));
granularity2.click();
WebElement granularity3=driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[1]"));
granularity3.click();
WebElement KPI=driver.findElement(By.xpath("//div[@class='form-group']/input"));
KPI.sendKeys("inbound utilization");
Thread.sleep(8000);
WebElement KPIinb=driver.findElement(By.xpath("//div[@class='ui-panel-content-wrapper ng-trigger ng-trigger-panelContent']/div/p-tree/div/ul/p-treenode[1]/li/ul/p-treenode/li/ul/p-treenode/li/div/span[2]/span/p"));
KPIinb.click();


Thread.sleep(8000);
TakesScreenshot scrShot =((TakesScreenshot)driver);
File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
File DestFile=new File("/root/Desktop/trendIP7days.png");
FileUtils.copyFile(SrcFile,DestFile);

WebElement Result=driver.findElement(By.xpath("//div[@class='nodata text-center anodata ng-star-inserted']"));

String s=Result.getText();
String r="No Data Found..";
if(s.equals(r))
{
	Assert.fail("there is no data in IP Trends");

}	
	
	
	Thread.sleep(5000);
	}
	
	@Test(priority=4)
	public void IPTrendsLast30days() throws InterruptedException, IOException{
		Actions action=new Actions(driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		WebElement granularity=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[5]/p-selectbutton/div/div[3]"));
		granularity.click();
WebElement granularity2=driver.findElement(By.xpath("//div[@class='ng-tns-c11-1 mr-1 mb-2 selectperiod ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix']"));
granularity2.click();
WebElement granularity3=driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[3]"));
granularity3.click();
//JavascriptExecutor js = (JavascriptExecutor) driver;
//js.executeScript("window.scrollBy(0,1000)");
//Thread.sleep(5000);
TakesScreenshot scrShot =((TakesScreenshot)driver);
File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
File DestFile=new File("/root/Desktop/trendIP30days.png");
FileUtils.copyFile(SrcFile,DestFile);
	
Thread.sleep(5000);

	}
	
	@Test(priority=3)
	public void IPTrendsLast14days() throws InterruptedException, IOException{
		Actions action=new Actions(driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		WebElement granularity=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[5]/p-selectbutton/div/div[3]"));
		granularity.click();
WebElement granularity2=driver.findElement(By.xpath("//div[@class='ng-tns-c11-1 mr-1 mb-2 selectperiod ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix']"));
granularity2.click();
WebElement granularity3=driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[2]"));
granularity3.click();
//JavascriptExecutor js = (JavascriptExecutor) driver;
//js.executeScript("window.scrollBy(0,1000)");
//Thread.sleep(5000);
TakesScreenshot scrShot =((TakesScreenshot)driver);
File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
File DestFile=new File("/root/Desktop/trendIP14days.png");
FileUtils.copyFile(SrcFile,DestFile);
//WebElement Result=driver.findElement(By.xpath("//div[@class='nodata text-center anodata ng-star-inserted']"));

//String s=Result.getText();
//String r="2000 : Server Error";
//if(s.equals(r))
//{
//	Assert.fail("server error in IP Trends 14 days granularity");
//
//}	
//
Thread.sleep(5000);

	}
	@Test(priority=5)
	public void IPTrendsLast2months() throws InterruptedException, IOException{
		Actions action=new Actions(driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		WebElement granularity=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[5]/p-selectbutton/div/div[3]"));
		granularity.click();
WebElement granularity2=driver.findElement(By.xpath("//div[@class='ng-tns-c11-1 mr-1 mb-2 selectperiod ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix']"));
granularity2.click();
WebElement granularity3=driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[4]"));
granularity3.click();
//JavascriptExecutor js = (JavascriptExecutor) driver;
//js.executeScript("window.scrollBy(0,1000)");
//Thread.sleep(5000);
TakesScreenshot scrShot =((TakesScreenshot)driver);
File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
File DestFile=new File("/root/Desktop/trendIP14days.png");
FileUtils.copyFile(SrcFile,DestFile);
Thread.sleep(5000);

	}
	@Test(priority=6)
	public void IPTrendsLast6months() throws InterruptedException, IOException{
		Actions action=new Actions(driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		WebElement granularity=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[5]/p-selectbutton/div/div[3]"));
		granularity.click();
WebElement granularity2=driver.findElement(By.xpath("//div[@class='ng-tns-c11-1 mr-1 mb-2 selectperiod ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix']"));
granularity2.click();
WebElement granularity3=driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[5]"));
granularity3.click();
//JavascriptExecutor js = (JavascriptExecutor) driver;
//js.executeScript("window.scrollBy(0,1000)");
//Thread.sleep(5000);
TakesScreenshot scrShot =((TakesScreenshot)driver);
File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
File DestFile=new File("/root/Desktop/trendIP14days.png");
FileUtils.copyFile(SrcFile,DestFile);
Thread.sleep(5000);

	}
@Test(enabled=false)
public void MicrowaveTrends() throws InterruptedException
{
	Actions action=new Actions(driver);
	WebDriverWait wait2 = new WebDriverWait(driver, 5);
	WebElement domain2=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[1]/p-dropdown")));
	domain2.click();
	WebElement Microdomain=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[1]/p-dropdown/div/div[4]/div/ul/li[2]")));
	Microdomain.click();
	WebElement vendor=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[2]"));
	vendor.click();
	WebElement huwaei=driver.findElement(By.xpath("//div[@class='ui-multiselect-filter-container ng-tns-c13-3 ng-star-inserted']/input"));
	huwaei.sendKeys("hua");
	Thread.sleep(2000);
	WebElement vendor2=driver.findElement(By.xpath("//div[@class='ui-chkbox ui-widget ng-tns-c13-3 ng-star-inserted']"));
	WebElement granularity=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[5]/p-selectbutton/div/div[3]"));
	granularity.click();
	WebElement granularity2=driver.findElement(By.xpath("//div[@class='ng-tns-c11-1 mr-1 mb-2 selectperiod ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix']"));
	granularity2.click();
	WebElement granularity3=driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[1]"));
	granularity3.click();

	WebElement KPI=driver.findElement(By.xpath("//div[@class='form-group']/input"));
	KPI.sendKeys("RX utilization");
	Thread.sleep(8000);
	WebElement KPIinb=driver.findElement(By.xpath("//div[@class='ui-panel-content-wrapper ng-trigger ng-trigger-panelContent']/div/p-tree/div/ul/p-treenode[1]/li/ul/p-treenode/li/ul/p-treenode/li/div/span[2]/span/p"));
	KPIinb.click();
		
//	WebElement Result=driver.findElement(By.xpath("//div[@class='nodata text-center anodata ng-star-inserted']"));
//	String s=Result.getText();
//	String r="No Data Found..";
//	if(s.equals(r))
//	{
//		Assert.fail("there is no data in IP Trends");
//
//	}	
	
	
}
}
