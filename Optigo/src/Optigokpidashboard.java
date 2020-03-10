import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Optigokpidashboard {
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
	public void kpiIPDashboardhourgranularity() throws InterruptedException, AWTException
	{
		Thread.sleep(1000);
		driver.get("http://192.168.200.203:8081/OptiGoProduct/#/topology/e2e/view");
		Actions action=new Actions(driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 5);

		WebElement home=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//basic/div/navigation/nav/div/ul/li[1]/a")));
		WebElement granularity1 =driver.findElement(By.xpath("//div[@class='ng-tns-c11-8 mr-1 mb-2 selectperiod ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix']"));;
		granularity1.click();
		Thread.sleep(5000);

		WebElement granularity2 =driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[6]"));;
		granularity2.click();
		Thread.sleep(4000);
			action.moveToElement(home).click().build().perform();
			
			WebElement dash=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='side-menu']/li/ul/li[2]/a/span[contains(text(),'Default Dashboard')]")));
			dash.click();
			
			WebElement user=driver.findElement(By.xpath("//li[@class='dropdown avatarlink']"));
			action.moveToElement(user).build().perform();
			Thread.sleep(5000);
				Thread.sleep(5000);
				WebElement dashboard2=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[@class='col-xs-2 w120 list ng-star-inserted']/p-dropdown"));
				dashboard2.click();
				WebElement IP=driver.findElement(By.xpath("//li[@class='ng-tns-c11-5 ui-dropdown-item ui-corner-all ui-state-highlight ng-star-inserted']"));
				IP.click();
				Thread.sleep(2000);
				WebElement domain=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[2]"));
				domain.click();
			
				WebElement vendor=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-chkbox ui-widget ng-tns-c13-6 ng-star-inserted']/div[2]")));
			vendor.click();
			Thread.sleep(2000);
//			WebElement zone=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-tns-c13-0 optigo-check-box ui-multiselect ui-widget ui-state-default ui-corner-all']")));
//			zone.click();
//			WebElement zone2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-xs-2 w120 list']/p-multiselect/div/div[4]/div/div/div[2]/span")));
//			zone2.click();
//			Thread.sleep(1000);
//			WebElement zone3=driver.findElement(By.xpath("//div[@class='ui-multiselect-items-wrapper']/ul/li[1]/div"));
//			zone3.click();
//			WebElement zone4=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-xs-2 w120 list']/p-multiselect/div/div[4]/div/div/div[2]")));
//			zone4.click();
//			Thread.sleep(1000);
//
//			
			WebElement kpi=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[5]"));
			kpi.click();
			Thread.sleep(1000);
			WebElement inbound=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='ng-tns-c11-1 ui-dropdown-item ui-corner-all ng-star-inserted']")));
				inbound.click();
				Thread.sleep(1000);
				WebElement granularity=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div//app-duration-filter/div/p-selectbutton/div/div[1]"));
				granularity.click();
				WebElement granluarity2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-tns-c11-4 mr-1 mb-2 selectperiod ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix']")));
				granluarity2.click();
				WebElement granluarity3=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[6]")));
				granluarity3.click();
				
				WebElement fromDat=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='ng-tns-c32-8 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']")));
				fromDat.click();
				WebElement left=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-datepicker-group ui-widget-content ng-tns-c32-8 ng-star-inserted']/div[1]/a")));
				left.click();
				WebElement Datepi=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-datepicker-calendar-container ng-tns-c32-8 ng-star-inserted']/table/tbody/tr[2]/td[3]")));
				Datepi.click();
//				WebElement fromTo=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='ng-tns-c32-9 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']")));
//				fromTo.click();
//				Robot robot = new Robot();
//				robot.keyPress(KeyEvent.VK_CONTROL);
//				robot.keyPress(KeyEvent.VK_A);
//				robot.keyRelease(KeyEvent.VK_A);
//				robot.keyRelease(KeyEvent.VK_CONTROL);
//				robot.keyPress(KeyEvent.VK_BACK_SPACE);
//				robot.keyRelease(KeyEvent.VK_BACK_SPACE);
//				fromDat.sendKeys("2020-01-15");
//				Thread.sleep(5000);
//				WebElement date=driver.findElement(By.xpath("//div[@class='ui-datepicker-calendar-container ng-tns-c32-8 ng-star-inserted']/table/tbody/tr[3]/td[4]"));
//				date.click();
				
//				robot.keyPress(KeyEvent.VK_CONTROL);
//				robot.keyPress(KeyEvent.VK_A);
//				robot.keyRelease(KeyEvent.VK_A);
//				robot.keyRelease(KeyEvent.VK_CONTROL);
//				robot.keyPress(KeyEvent.VK_BACK_SPACE);
//				robot.keyRelease(KeyEvent.VK_BACK_SPACE);
//				Thread.sleep(5000);
//				fromTo.sendKeys("2020-01-29");
Thread.sleep(5000);
				WebElement Apply=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success mr-1 btm-sm']")));
				Apply.click();
			

//				JavascriptExecutor js = (JavascriptExecutor) driver;
//				js.executeScript("window.scrollBy(0,1500)");
//				Thread.sleep(15000);
//				WebElement Chart=driver.findElement(By.xpath("//*[contains(@class,'highcharts-point ')][@fill='rgb(126,237,140)']"));
//				Thread.sleep(1000);
//				Chart.click();
//				WebElement Chart2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[local-name()='svg']//*[name()='g' and @class='highcharts-series highcharts-series-2 highcharts-column-series highcharts-tracker highcharts-series-hover']//*[name()='rect' and @class='highcharts-point highcharts-point-hover'][1]")));
//				action.moveToElement(Chart2).click().build().perform();
				
				
	}
	
	@Test(priority=3)
	public void  kpiIPDashboardDaygranularity() throws AWTException, InterruptedException{		
		WebDriverWait wait2 = new WebDriverWait(driver, 5);

		
		WebElement granularity=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div//app-duration-filter/div/p-selectbutton/div/div[2]"));
		granularity.click();
		WebElement granluarity2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-tns-c11-4 mr-1 mb-2 selectperiod ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix']")));
		granluarity2.click();
		WebElement granluarity3=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[6]")));
		granluarity3.click();
		Thread.sleep(5000);
		WebElement Apply=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success mr-1 btm-sm']")));
		Apply.click();

//		WebElement fromDat=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='ng-tns-c32-8 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']")));
//		fromDat.click();
//
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_A);
//		robot.keyRelease(KeyEvent.VK_A);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_BACK_SPACE);
//		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
//		fromDat.sendKeys("2020-01-15");
//		Thread.sleep(5000);
//		
//		WebElement date=driver.findElement(By.xpath("//div[@class='ui-datepicker-calendar-container ng-tns-c32-8 ng-star-inserted']/table/tbody/tr[3]/td[4]"));
//		date.click();
//		WebElement fromTo=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='ng-tns-c32-9 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']")));
//		fromTo.click();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_A);
//		robot.keyRelease(KeyEvent.VK_A);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_BACK_SPACE);
//		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
//		Thread.sleep(5000);
//		
		
	}
	
	@Test(priority=4)
	public void  kpiIPDashboardWeekgranularity() throws AWTException, InterruptedException{		
		WebDriverWait wait2 = new WebDriverWait(driver, 5);

		
		WebElement granularity=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div//app-duration-filter/div/p-selectbutton/div/div[3]"));
		granularity.click();
		WebElement granluarity2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-tns-c11-4 mr-1 mb-2 selectperiod ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix']")));
		granluarity2.click();
		WebElement granluarity3=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[5]")));
		granluarity3.click();
		Thread.sleep(5000);
		WebElement granluarity4=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-xs-2 wauto px-0 ng-star-inserted']/p-dropdown[1]/div")));
		granluarity4.click();
		WebElement granluarity5=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[8]")));
		granluarity5.click();
		WebElement granluarity6=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-xs-2 wauto px-0 ng-star-inserted']/p-dropdown[3]/div")));
		granluarity6.click();
		Thread.sleep(1000);
		WebElement granluarity7=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[8]")));
		granluarity7.click();
Thread.sleep(2000);		
		WebElement Apply=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success mr-1 btm-sm']")));
		Apply.click();
	}
	
	@Test(priority=5)
	public void  kpiIPDashboardMonthgranularity() throws AWTException, InterruptedException{		
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		
		WebElement granularity=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div//app-duration-filter/div/p-selectbutton/div/div[4]"));
		granularity.click();
		WebElement Apply=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success mr-1 btm-sm']")));
		Apply.click();
	}
	@Test(priority=6)
	public void kpiMicroHourdashboard() throws InterruptedException{
		Actions action=new Actions(driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		WebElement dashboard2=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[@class='col-xs-2 w120 list ng-star-inserted']/p-dropdown"));
		dashboard2.click();
		WebElement micro=driver.findElement(By.xpath("//li[@class='ng-tns-c11-5 ui-dropdown-item ui-corner-all ng-star-inserted'][1]"));
		micro.click();
		Thread.sleep(2000);
		WebElement vendor1=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[2]"));
		vendor1.click();
	
		WebElement vendor2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-chkbox ui-widget ng-tns-c13-6 ng-star-inserted']/div[2]")));
	vendor2.click();
	Thread.sleep(2000);
	WebElement zone=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-tns-c13-0 optigo-check-box ui-multiselect ui-widget ui-state-default ui-corner-all']")));
	zone.click();
	WebElement zone2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-xs-2 w120 list']/p-multiselect/div/div[4]/div/div/div[2]/span")));
	zone2.click();
	Thread.sleep(1000);
//	WebElement zone3=driver.findElement(By.xpath("//input[@class='ui-inputtext ui-widget ui-state-default ui-corner-all']"));
//	zone3.sendKeys("WEST");
	WebElement zone4=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-xs-2 w120 list']/p-multiselect/div/div[4]/div/div/div[2]")));
	zone4.click();
	Thread.sleep(1000);

	
	WebElement kpi=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[5]"));
	kpi.click();
	Thread.sleep(1000);
	WebElement Rx=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='ng-tns-c11-1 ui-dropdown-item ui-corner-all ng-star-inserted']")));
		Rx.click();
		Thread.sleep(1000);
		WebElement granularity=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div//app-duration-filter/div/p-selectbutton/div/div[1]"));
		granularity.click();
		WebElement granluarity2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-tns-c11-4 mr-1 mb-2 selectperiod ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix']")));
		granluarity2.click();
		WebElement granluarity3=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[6]")));
		granluarity3.click();
		Thread.sleep(2000);
		WebElement fromDat=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ui-datepicker-trigger ui-calendar-button ng-tns-c32-36 ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ng-star-inserted']")));
		fromDat.click();
		WebElement left=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/a[1]")));
		left.click();
		WebElement Datepi=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-datepicker-group ui-widget-content ng-tns-c32-36 ng-star-inserted']/div[2]/table/tbody/tr[3]/td[4]")));
		Datepi.click();
		WebElement Apply=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success mr-1 btm-sm']")));
		Apply.click();
		Thread.sleep(2000);
		
		
	}
	
	@Test(priority=7)
	public void kpiMicroDaydashboard() throws InterruptedException
	{
		WebDriverWait wait2 = new WebDriverWait(driver, 5);

		WebElement granularity=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div//app-duration-filter/div/p-selectbutton/div/div[2]"));
		granularity.click();
		Thread.sleep(2000);
		WebElement granluarity2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-tns-c11-4 mr-1 mb-2 selectperiod ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix']")));
		granluarity2.click();
		WebElement granluarity3=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[6]")));
		granluarity3.click();
		Thread.sleep(2000);

		WebElement Apply=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success mr-1 btm-sm']")));
		Apply.click();
		Thread.sleep(2000);
	}
	
	@Test(priority=7)
	public void kpiMicroWeekdashboard() throws InterruptedException
	{
		WebDriverWait wait2 = new WebDriverWait(driver, 5);

		WebElement granularity=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div//app-duration-filter/div/p-selectbutton/div/div[3]"));
		granularity.click();
		Thread.sleep(2000);
		WebElement granluarity2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-tns-c11-4 mr-1 mb-2 selectperiod ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix']")));
		granluarity2.click();
		WebElement granluarity3=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[5]")));
		granluarity3.click();
		Thread.sleep(2000);
		WebElement granluarity4=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-xs-2 wauto px-0 ng-star-inserted']/p-dropdown[1]/div")));
		granluarity4.click();
		WebElement granluarity5=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[8]")));
		granluarity5.click();
		WebElement granluarity6=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-xs-2 wauto px-0 ng-star-inserted']/p-dropdown[3]/div")));
		granluarity6.click();
		Thread.sleep(1000);
		WebElement granluarity7=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[8]")));
		granluarity7.click();
		WebElement Apply=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success mr-1 btm-sm']")));
		Apply.click();
		Thread.sleep(2000);
		
	}
	
	@Test(priority=8)
	public void kpiMicroMonthdashboard() throws InterruptedException
	{
WebDriverWait wait2 = new WebDriverWait(driver, 5);
		
		WebElement granularity=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div//app-duration-filter/div/p-selectbutton/div/div[4]"));
		granularity.click();
		WebElement Apply=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success mr-1 btm-sm']")));
		Apply.click();
	}
	
	@Test(priority=9)
	public void KpiopticHourdashboard() throws InterruptedException{
		Actions action=new Actions(driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		WebElement dashboard2=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[@class='col-xs-2 w120 list ng-star-inserted']/p-dropdown"));
		dashboard2.click();
		WebElement optic=driver.findElement(By.xpath("//li[@class='ng-tns-c11-5 ui-dropdown-item ui-corner-all ng-star-inserted'][2]"));
		optic.click();
		WebElement vendor1=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[2]"));
		vendor1.click();
	
		WebElement vendor2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-chkbox ui-widget ng-tns-c13-6 ng-star-inserted']/div[2]")));
	vendor2.click();
	Thread.sleep(6000);


	
	WebElement kpi=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div/div[5]"));
	kpi.click();
	Thread.sleep(1000);
	WebElement Rx=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='ng-tns-c11-1 ui-dropdown-item ui-corner-all ng-star-inserted']")));
		Rx.click();
		Thread.sleep(1000);
		WebElement granularity=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div//app-duration-filter/div/p-selectbutton/div/div[1]"));
		granularity.click();
		WebElement granluarity2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-tns-c11-4 mr-1 mb-2 selectperiod ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix']")));
		granluarity2.click();
		WebElement granluarity3=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[6]")));
		granluarity3.click();
		Thread.sleep(2000);
		WebElement fromDat=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ui-datepicker-trigger ui-calendar-button ng-tns-c32-60 ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ng-star-inserted']")));
		fromDat.click();
		WebElement left=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/a[1]")));
		left.click();
		WebElement Datepi=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-datepicker-calendar-container ng-tns-c32-60 ng-star-inserted']/table/tbody/tr[3]/td[4]")));
		Datepi.click();
		WebElement Apply=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success mr-1 btm-sm']")));
		Apply.click();
		Thread.sleep(2000);
	}
	@Test(priority=10)
	public void KpiopticDaydashboard() throws InterruptedException{

		WebDriverWait wait2 = new WebDriverWait(driver, 5);

		WebElement granularity=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div//app-duration-filter/div/p-selectbutton/div/div[2]"));
		granularity.click();
		Thread.sleep(2000);
		WebElement granluarity2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-tns-c11-4 mr-1 mb-2 selectperiod ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix']")));
		granluarity2.click();
		WebElement granluarity3=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[6]")));
		granluarity3.click();
		Thread.sleep(2000);

		WebElement Apply=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success mr-1 btm-sm']")));
		Apply.click();
		Thread.sleep(2000);
	
}
	@Test(priority=11)
	public void KpiopticWeekdashboard() throws InterruptedException{

		WebDriverWait wait2 = new WebDriverWait(driver, 5);

		WebElement granularity=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div//app-duration-filter/div/p-selectbutton/div/div[3]"));
		granularity.click();
		Thread.sleep(2000);
		WebElement granluarity2=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-tns-c11-4 mr-1 mb-2 selectperiod ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix']")));
		granluarity2.click();
		WebElement granluarity3=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[5]")));
		granluarity3.click();
		Thread.sleep(2000);
		WebElement granluarity4=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-xs-2 wauto px-0 ng-star-inserted']/p-dropdown[1]/div")));
		granluarity4.click();
		WebElement granluarity5=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[8]")));
		granluarity5.click();
		WebElement granluarity6=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-xs-2 wauto px-0 ng-star-inserted']/p-dropdown[3]/div")));
		granluarity6.click();
		Thread.sleep(1000);
		WebElement granluarity7=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[8]")));
		granluarity7.click();
		WebElement Apply=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success mr-1 btm-sm']")));
		Apply.click();
		Thread.sleep(2000);
	}
	@Test(priority=12)
	public void KpiopticMonthdashboard() throws InterruptedException{
		
WebDriverWait wait2 = new WebDriverWait(driver, 5);
		
		WebElement granularity=driver.findElement(By.xpath("//div[@class='bg-white bordernone pxy-1 pr-0 pb-0 ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix']/div//app-duration-filter/div/p-selectbutton/div/div[4]"));
		granularity.click();
		WebElement Apply=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success mr-1 btm-sm']")));
		Apply.click();
	}
	
}