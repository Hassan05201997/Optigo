import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class OptigoLogin {

	public String baseurl="http://192.168.200.203:8081/OptiGoProduct/#/login";
	WebDriver driver;

@BeforeClass
	public void setbaseURl()
{
	System.setProperty("webdriver.chrome.driver","//usr//bin//chromedriver");	

	ChromeOptions options= new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		
		  driver=new ChromeDriver(options);
			driver.get(baseurl);

	}

@Test
public void AdminUserlogin() throws InterruptedException, IOException

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
	Actions action=new Actions(driver);
//	WebElement home=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-default flter']")));
//	action.moveToElement(home).click().build().perform();
	WebElement user=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='dropdown avatarlink']/a")));
user.click();
TakesScreenshot scrShot =((TakesScreenshot)driver);
File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
File DestFile=new File("/root/Desktop/admin.png");
FileUtils.copyFile(SrcFile,DestFile);


WebElement user2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='dropdown avatarlink open']/ul/li[3]/a")));
user2.click();


}
@Test
public void HuwaeiUserlogin() throws InterruptedException, IOException

{


	String t=driver.getCurrentUrl();
	System.out.print(t);

		WebDriverWait wait = new WebDriverWait(driver, 15);

	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));


	WebElement email=driver.findElement(By.name("email"));
	email.sendKeys("Huaweiuser01");

	WebElement password=driver.findElement(By.name("password"));
	password.sendKeys("Huawei@OWS_01");
	WebElement Login=driver.findElement(By.xpath("//button[@class='btn block m-b loginbtn']"));
	Login.click();
	driver.manage().window().maximize();
	Thread.sleep(1000);
	Actions action=new Actions(driver);
	WebElement user=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='dropdown avatarlink']/a")));
user.click();
TakesScreenshot scrShot =((TakesScreenshot)driver);
File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
File DestFile=new File("/root/Desktop/Huwaeiuser.png");
FileUtils.copyFile(SrcFile,DestFile);
WebElement user2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='dropdown avatarlink open']/ul/li[2]/a")));
user2.click();

}}
//	@Test
//	public void TransportMicrowavedashboard() throws InterruptedException
//	{		
//		
//		Actions action=new Actions(driver);
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		driver.get("http://192.168.200.203:8081/OptiGoProduct/#/topology/e2e/view");
//
//		WebElement home=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-default flter']")));
//action.moveToElement(home).click().build().perform();
//		
//		WebElement dash=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='side-menu']/li/ul/li[2]/a/span[contains(text(),'Default Dashboard')]")));
//	dash.click();
//	
//	WebElement user=driver.findElement(By.xpath("//li[@class='dropdown avatarlink']"));
//action.moveToElement(user).build().perform();
//Thread.sleep(5000);
//WebElement dashboard=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[@class='col-xs-2 w120 list ng-star-inserted']/p-dropdown"));
//dashboard.click();
//Thread.sleep(3000);
//WebElement microwave=driver.findElement(By.xpath("//li[@class='ng-tns-c11-5 ui-dropdown-item ui-corner-all ng-star-inserted']/span[contains(text(),'Transport - Microwave')]"));
//microwave.click();
//Thread.sleep(2000);
//WebElement domain=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[2]"));
//domain.click();
//
//WebElement huwaei=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[2]/p-multiselect/div/div[4]/div[2]/ul/li/div/div[2]"));
//huwaei.click();
//Thread.sleep(2000);
//
//WebElement kpi=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[5]"));
//kpi.click();
//Thread.sleep(1000);
//WebElement rx=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[5]/p-dropdown/div/div[4]/div/ul/li"));
//rx.click();
//
//WebElement granularity=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div//app-duration-filter/div/p-selectbutton/div/div[1]"));
//granularity.click();
//Thread.sleep(1000);
//WebElement Apply=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[6]/button")));
//Apply.click();
//Thread.sleep(2000);
//
//WebElement east=driver.findElement(By.xpath("//div[@id='ui-panel-0-content']/div"));
//String r=east.getText();
//System.out.print(r);
//WebElement central=driver.findElement(By.xpath("//div[@id='ui-panel-1-content']/div"));
//String s=central.getText();
//String expected="No Data Found...";
//Assert.failNotEquals("There is no data in microwave dashboard", expected,r);	
	
//@Test
//public void TransportIPDashboard() throws InterruptedException
//{
//	driver.get("http://192.168.200.203:8081/OptiGoProduct/#/topology/e2e/view");
//
//	WebDriverWait wait2 = new WebDriverWait(driver, 5);
//	Actions action=new Actions(driver);
//	WebElement home=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//basic/div/navigation/nav/div/ul/li[1]/a")));
//
//	action.moveToElement(home).click().build().perform();
//	
//	WebElement dash=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='side-menu']/li/ul/li[2]/a/span[contains(text(),'Default Dashboard')]")));
//dash.click();
//
//WebElement user=driver.findElement(By.xpath("//li[@class='dropdown avatarlink']"));
//action.moveToElement(user).build().perform();
//Thread.sleep(5000);
//	Thread.sleep(5000);
//	WebElement dashboard2=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[@class='col-xs-2 w120 list ng-star-inserted']/p-dropdown"));
//	dashboard2.click();
//	WebElement IP=driver.findElement(By.xpath("//li[@class='ng-tns-c11-5 ui-dropdown-item ui-corner-all ng-star-inserted']/span[contains(text(),'Transport - IP')]"));
//	IP.click();
//	Thread.sleep(2000);
//	WebElement domain=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[2]"));
//	domain.click();
//
//	WebElement vendor=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-chkbox ui-widget ng-tns-c13-6 ng-star-inserted']/div[2]")));
//vendor.click();
//Thread.sleep(2000);
//
//WebElement kpi=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[5]"));
//kpi.click();
//Thread.sleep(1000);
//WebElement inbound=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='ng-tns-c11-1 ui-dropdown-item ui-corner-all ng-star-inserted']")));
//	inbound.click();
//	Thread.sleep(1000);
//	WebElement Apply=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[6]/button")));
//	Apply.click();
//	Thread.sleep(2000);
//	
//}
//}
