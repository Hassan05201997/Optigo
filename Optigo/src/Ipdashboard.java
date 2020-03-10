import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Ipdashboard {
	
	public String baseurl="http://192.168.200.241:8080/OptiGoProduct/#/login";
	WebDriver driver;

	@BeforeSuite
	public void browserlaunch() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","//usr//bin//chromedriver");	

		ChromeOptions options= new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			
			  driver=new ChromeDriver(options);
				driver.get(baseurl);
		Thread.sleep(5000);
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
	public void IPDashboardMinutes() throws InterruptedException
	{
		Thread.sleep(1000);
		Actions action=new Actions(driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 5);

		WebElement home=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//basic/div/navigation/nav/div/ul/li[1]/a")));
		
			action.moveToElement(home).click().build().perform();
			
			WebElement dash=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='side-menu']/li/ul/li[2]/a/span[contains(text(),'Default Dashboard')]")));
			dash.click();
			
			WebElement user=driver.findElement(By.xpath("//li[@class='dropdown avatarlink']"));
			action.moveToElement(user).build().perform();
			Thread.sleep(5000);
				WebElement das =driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm dashicon']"));
				das.click();
				Thread.sleep(2000);
				WebElement IPdas =driver.findElement(By.xpath("//div[@class='panel-group']/div[5]/div[2]/ul/li[2]"));
				IPdas.click();
				Thread.sleep(10000);
				WebElement granularity =driver.findElement(By.xpath("//div[@class='selectbtn ui-selectbutton ui-buttonset ui-widget ui-corner-all ui-buttonset-6']/div[1]"));;
				granularity.click();
				Thread.sleep(29000);
				WebElement granularity1 =driver.findElement(By.xpath("//div[@class='ng-tns-c11-8 mr-1 mb-2 selectperiod ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix']"));;
				granularity1.click();
				Thread.sleep(5000);

				WebElement granularity2 =driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[7]"));;
				granularity2.click();
				Thread.sleep(4000);
				
				WebElement UI =driver.findElement(By.xpath("//div[@class='col-xs-2 wauto px-0 duration-filter ng-star-inserted']/p-calendar[1]/span/button"));;
UI.click();				
				WebElement Left =driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/a[1]"));;
				Left.click();
				WebElement Datefr =driver.findElement(By.xpath("//div[@class='ui-datepicker-calendar-container ng-tns-c32-9 ng-star-inserted']/table/tbody/tr[3]/td[4]"));;
				Datefr.click();
				WebElement Submit =driver.findElement(By.xpath("//button[@class='btn btn-success btn-ip']"));
				Submit.click();
				Thread.sleep(38000);

}
	@Test(priority=3)
	public void IPDashboardhour() throws InterruptedException
	{
		WebElement granularity =driver.findElement(By.xpath("//div[@class='selectbtn ui-selectbutton ui-buttonset ui-widget ui-corner-all ui-buttonset-6']/div[2]"));;
		granularity.click();
		Thread.sleep(39000);
		WebElement granularity1 =driver.findElement(By.xpath("//div[@class='ng-tns-c11-8 mr-1 mb-2 selectperiod ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix']"));;
		granularity1.click();
		Thread.sleep(5000);
		
		WebElement granularity2 =driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[6]"));;
		granularity2.click();
		Thread.sleep(24000);
		
		

//		WebElement UI =driver.findElement(By.xpath("//div[@class='col-xs-2 wauto px-0 duration-filter ng-star-inserted']/p-calendar[1]/span/button"));;
//UI.click();				
//		WebElement Left =driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/a[1]"));;
//		Left.click();
//		WebElement Datefr =driver.findElement(By.xpath("//div[@class='ui-datepicker-calendar-container ng-tns-c32-9 ng-star-inserted']/table/tbody/tr[3]/td[4]"));;
//		Datefr.click();
		WebElement Submit =driver.findElement(By.xpath("//button[@class='btn btn-success btn-ip']"));
		Submit.click();
Thread.sleep(35000);
	}
	
	@Test(priority=4)
	public void IPDashboardday() throws InterruptedException
	{
		WebElement granularity =driver.findElement(By.xpath("//div[@class='selectbtn ui-selectbutton ui-buttonset ui-widget ui-corner-all ui-buttonset-6']/div[3]"));;
		granularity.click();
		Thread.sleep(29000);
		WebElement granularity1 =driver.findElement(By.xpath("//div[@class='ng-tns-c11-8 mr-1 mb-2 selectperiod ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix']"));;
		granularity1.click();
		Thread.sleep(5000);

		WebElement granularity2 =driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[6]"));;
		granularity2.click();
		Thread.sleep(4000);
		WebElement Submit =driver.findElement(By.xpath("//button[@class='btn btn-success btn-ip']"));
		Submit.click();
		Thread.sleep(39000);
	}

	@Test(priority=5)
	public void IPDashboardWeek() throws InterruptedException
	{
		WebDriverWait wait2 = new WebDriverWait(driver, 5);

		WebElement granularity =driver.findElement(By.xpath("//div[@class='selectbtn ui-selectbutton ui-buttonset ui-widget ui-corner-all ui-buttonset-6']/div[4]"));;
		granularity.click();
		Thread.sleep(39000);
		WebElement granularity1 =driver.findElement(By.xpath("//div[@class='ng-tns-c11-8 mr-1 mb-2 selectperiod ui-dropdown ui-widget ui-state-default ui-corner-all ui-helper-clearfix']"));;
		granularity1.click();
		Thread.sleep(5000);

		WebElement granularity2 =driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[5]"));;
		granularity2.click();
		Thread.sleep(4000);
		WebElement granluarity4=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-xs-2 wauto px-0 ng-star-inserted']/p-dropdown[1]/div")));
		granluarity4.click();
		WebElement granluarity5=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[8]")));
		granluarity5.click();
		WebElement granluarity6=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-xs-2 wauto px-0 ng-star-inserted']/p-dropdown[3]/div")));
		granluarity6.click();
		Thread.sleep(1000);
		WebElement granluarity7=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-dropdown-items-wrapper']/ul/li[8]")));
		granluarity7.click();
		Thread.sleep(290000);
	}
	@Test(priority=6)
	public void IPDashboardMonth() throws InterruptedException
	{
		WebElement granularity =driver.findElement(By.xpath("//div[@class='selectbtn ui-selectbutton ui-buttonset ui-widget ui-corner-all ui-buttonset-6']/div[5]"));;
		granularity.click();
	}
	
	
}
