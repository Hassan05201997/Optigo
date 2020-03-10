package Microservices;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Usermanagement {
	
	public String baseurl="http://192.168.200.102:9001/optigoui/";
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

@Test(priority=1)
public void ManageUser() throws InterruptedException, IOException, AWTException

{



		WebDriverWait wait = new WebDriverWait(driver, 15);

	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));


	WebElement email=driver.findElement(By.name("email"));
	email.sendKeys("cangoadmin");

	WebElement password=driver.findElement(By.name("password"));
	password.sendKeys("CanGo@2K08");
	WebElement Login=driver.findElement(By.xpath("//button[@class='btn block m-b loginbtn']"));
	Login.click();
	driver.manage().window().maximize();
	Thread.sleep(1000);
	Actions action=new Actions(driver);
	WebDriverWait wait2 = new WebDriverWait(driver, 5);

	WebElement home=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//basic/div/navigation/nav/div/ul/li[1]/a")));
	
		action.moveToElement(home).click().build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Robot robot = new Robot();  
        Thread.sleep(2000);        
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_DOWN);
        WebElement Setting=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("      //basic/div/navigation/nav/div/ul/li[14]/a")));
    	
		action.moveToElement(Setting).click().build().perform();
        WebElement user=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-md-6 px-0'][1]/div[1]/div/p-accordion/div/p-accordiontab/div[1]/a")));
user.click();
WebElement manageuser=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-accordion-content-wrapper ng-trigger ng-trigger-tabContent']/div/div[1]/h4/a")));
manageuser.click();
Thread.sleep(5000);
		
		



}

@Test(priority=2)
public void Usercreation() throws InterruptedException
{
	WebElement create=driver.findElement(By.xpath("//button[@class='btn btn-success btn-sm']"));
	create.click();
	Thread.sleep(5000);
	WebElement name=driver.findElement(By.xpath("//div[@class='form-group row'][1]/div/input"));
	name.sendKeys("AutomationUser");
	WebElement roletype=driver.findElement(By.xpath("//label[@class='ng-tns-c16-42 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']"));
roletype.click();
	WebElement user=driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[2]"));
user.click();
WebElement firstname=driver.findElement(By.xpath("//div[@class='form-group row'][4]/div/input"));
firstname.sendKeys("UserAutomation");
WebElement email=driver.findElement(By.xpath("//div[@class='form-group row'][6]/div/input"));
email.sendKeys("testautomationuser@gmail.com");
WebElement password=driver.findElement(By.xpath("//div[@class='form-group row ng-star-inserted'][1]/div/input"));
password.sendKeys("canGo@15");
WebElement Cpassword=driver.findElement(By.xpath("//div[@class='form-group row ng-star-inserted'][2]/div/input"));
Cpassword.sendKeys("canGo@15");

WebElement next=driver.findElement(By.xpath("//button[@class='btn btn-success']"));
next.click();
Thread.sleep(2000);
WebElement passwordrenewaldays=driver.findElement(By.xpath("//div[@class='form-group row'][1]/div/input"));
passwordrenewaldays.clear();
passwordrenewaldays.sendKeys("10");
WebElement passwordrenewalNoti=driver.findElement(By.xpath("//div[@class='form-group row'][7]/div/div/div[2]/input"));
passwordrenewalNoti.sendKeys("6");
WebElement save=driver.findElement(By.xpath("//button[@class='col-md-2 col-md-offset-2 btn btn-success']"));
save.click();
Thread.sleep(5000);
	
}
@Test(priority=3)
public void Admincreation() throws InterruptedException
{
	WebElement create=driver.findElement(By.xpath("//button[@class='btn btn-success btn-sm']"));
	create.click();
	Thread.sleep(5000);
	WebElement name=driver.findElement(By.xpath("//div[@class='form-group row'][1]/div/input"));
	name.sendKeys("AutomationAdmin");
//	WebElement roletype=driver.findElement(By.xpath("//label[@class='ng-tns-c16-42 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']"));
//roletype.click();
//	WebElement user=driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[1]"));
//user.click();
WebElement firstname=driver.findElement(By.xpath("//div[@class='form-group row'][4]/div/input"));
firstname.sendKeys("AdminAutomation");
WebElement email=driver.findElement(By.xpath("//div[@class='form-group row'][6]/div/input"));
email.sendKeys("testautomationAdmin@gmail.com");
WebElement password=driver.findElement(By.xpath("//div[@class='form-group row ng-star-inserted'][1]/div/input"));
password.sendKeys("canGo@15");
WebElement Cpassword=driver.findElement(By.xpath("//div[@class='form-group row ng-star-inserted'][2]/div/input"));
Cpassword.sendKeys("canGo@15");

WebElement next=driver.findElement(By.xpath("//button[@class='btn btn-success']"));
next.click();
Thread.sleep(2000);
WebElement passwordrenewaldays=driver.findElement(By.xpath("//div[@class='form-group row'][1]/div/input"));
passwordrenewaldays.clear();
passwordrenewaldays.sendKeys("10");
WebElement passwordrenewalNoti=driver.findElement(By.xpath("//div[@class='form-group row'][7]/div/div/div[2]/input"));
passwordrenewalNoti.sendKeys("6");
WebElement save=driver.findElement(By.xpath("//button[@class='col-md-2 col-md-offset-2 btn btn-success']"));
save.click();

	Thread.sleep(5000);
}
@Test(priority=4)
public void EditUser() throws InterruptedException
{
	
WebElement SearchUser=driver.findElement(By.xpath("//div[@class='ui-datatable-header ui-widget-header ng-star-inserted']/p-header/div/input"));
SearchUser.sendKeys("AutomationUser");
Thread.sleep(2000);
WebElement Searchicon=driver.findElement(By.xpath("//button[@class='ref-search bt-srch searchBtn ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only']"));
Searchicon.click();
Thread.sleep(2000);
WebElement EditUser=driver.findElement(By.xpath("//button[@class='btn btn-xs btn-primary ng-star-inserted']"));
EditUser.click();
Thread.sleep(2000);

WebElement email=driver.findElement(By.xpath("//div[@class='form-group row'][6]/div/input"));
email.clear();
email.sendKeys("Automationedit@gmail.com");
WebElement next=driver.findElement(By.xpath("//button[@class='btn btn-success']"));
next.click();
WebElement save=driver.findElement(By.xpath("//button[@class='col-md-2 col-md-offset-2 btn btn-success']"));
save.click();
Thread.sleep(2000);
}

@Test(priority=5)
public void DeleteUser() throws InterruptedException
{
	WebElement SearchUser1=driver.findElement(By.xpath("//div[@class='ui-datatable-header ui-widget-header ng-star-inserted']/p-header/div/input"));
	SearchUser1.sendKeys("AutomationUser");
	Thread.sleep(2000);
	WebElement Searchicon=driver.findElement(By.xpath("//button[@class='ref-search bt-srch searchBtn ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only']"));
	Searchicon.click();
	Thread.sleep(1000);
	WebElement Deleteicon=driver.findElement(By.xpath("//button[@class='btn btn-xs btn-danger ng-star-inserted']"));
	Deleteicon.click();
	Thread.sleep(2000);
	WebElement accept=driver.findElement(By.xpath("//div[@class='ui-dialog-footer ui-widget-content ng-tns-c11-76 ng-star-inserted']/button[1]"));
	accept.click();
	WebElement refresh=driver.findElement(By.xpath("//button[@class='ref-search searchBtn ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ng-star-inserted']"));
	refresh.click();
	Thread.sleep(4000);
	SearchUser1.sendKeys("AutomationAdmin");
	Thread.sleep(2000);
	Searchicon.click();
	Thread.sleep(2000);
	WebElement Delete1icon=driver.findElement(By.xpath("//button[@class='btn btn-xs btn-danger ng-star-inserted']"));
	Delete1icon.click();
	WebElement accept1=driver.findElement(By.xpath("//div[@class='ui-dialog-footer ui-widget-content ng-tns-c11-76 ng-star-inserted']/button[1]"));
	accept1.click();
	Thread.sleep(2000);

	}


}

