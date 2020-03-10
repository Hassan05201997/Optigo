import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

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

public class MicrowaveDashboardHuawei {
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
	public void MicrowaveDashboardHuaweiMinutes() throws InterruptedException, IOException
	{
		Thread.sleep(1000);
		Actions action=new Actions(driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		Thread.sleep(5000);

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
				WebElement Microdas =driver.findElement(By.xpath("//div[@class='animated fadeInLeft boxshadow navigator col-md-3 otherdashboardnav ng-star-inserted']/div[2]/div/div[6]/div[2]/ul/li[3]"));
				Microdas.click();
				Thread.sleep(25000);
				
				WebElement granularity =driver.findElement(By.xpath("//div[@class='selectbtn ui-selectbutton ui-buttonset ui-widget ui-corner-all ui-buttonset-6']/div[1]"));;
				granularity.click();
				Thread.sleep(29000);

				String mainWindow=driver.getWindowHandle();

				WebElement biterror =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-list ng-star-inserted']/ul/li[1]/label[2]/i[2]")));
				action.moveToElement(biterror).click().build().perform();
				Set<String> set =driver.getWindowHandles();
				Iterator<String> itr= set.iterator();
				while(itr.hasNext()){
					String childWindow=itr.next();
					if(!mainWindow.equals(childWindow)){
						driver.switchTo().window(childWindow);
						System.out.println(driver.switchTo().window(childWindow).getTitle());
						Thread.sleep(5000);
						TakesScreenshot scrShot =((TakesScreenshot)driver);
						File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
						File DestFile=new File("/root/Desktop/Biterrorminute.png");
						FileUtils.copyFile(SrcFile,DestFile);
						driver.close();
					}
				}
					
						driver.switchTo().window(mainWindow);
						WebElement radiolink =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-list ng-star-inserted']/ul/li[2]/label[2]/i[2]")));
						action.moveToElement(radiolink).click().build().perform();
						Set<String> set2 =driver.getWindowHandles();
						Iterator<String> itr2= set2.iterator();
						while(itr2.hasNext()){
							String childWindow2=itr2.next();
							if(!mainWindow.equals(childWindow2)){
								driver.switchTo().window(childWindow2);
								System.out.println(driver.switchTo().window(childWindow2).getTitle());
								Thread.sleep(5000);
								TakesScreenshot scrShot2 =((TakesScreenshot)driver);
								File SrcFile2=scrShot2.getScreenshotAs(OutputType.FILE);
								File DestFile2=new File("/root/Desktop/radiolinkminute.png");
								FileUtils.copyFile(SrcFile2,DestFile2);
								driver.close();
							}
						}
								driver.switchTo().window(mainWindow);
								WebElement radiolinksev =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-list ng-star-inserted']/ul/li[3]/label[2]/i[2]")));
								action.moveToElement(radiolinksev).click().build().perform();
								Set<String> set3 =driver.getWindowHandles();
								Iterator<String> itr3= set3.iterator();
								while(itr3.hasNext()){
									String childWindow3=itr3.next();
									if(!mainWindow.equals(childWindow3)){
										driver.switchTo().window(childWindow3);
										System.out.println(driver.switchTo().window(childWindow3).getTitle());
										Thread.sleep(5000);
										TakesScreenshot scrShot3 =((TakesScreenshot)driver);
										File SrcFile3=scrShot3.getScreenshotAs(OutputType.FILE);
										File DestFile3=new File("/root/Desktop/radiolinksevminute.png");
										FileUtils.copyFile(SrcFile3,DestFile3);
										driver.close();
						
						
					}
				}
	
								
								driver.switchTo().window(mainWindow);
								String mainWindow2=driver.getWindowHandle();

								WebElement radiolinksunavai =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-list ng-star-inserted']/ul/li[4]/label[2]/i[2]")));
								action.moveToElement(radiolinksunavai).click().build().perform();
								
								Set<String> set4 =driver.getWindowHandles();
								Iterator<String> itr4= set4.iterator();
								while(itr4.hasNext()){
									String childWindow3=itr4.next();
									if(!mainWindow2.equals(childWindow3)){
										driver.switchTo().window(childWindow3);
									
										System.out.println(driver.switchTo().window(childWindow3).getTitle());
										Thread.sleep(5000);
										TakesScreenshot scrShot4 =((TakesScreenshot)driver);
										File SrcFile4=scrShot4.getScreenshotAs(OutputType.FILE);
										File DestFile4=new File("/root/Desktop/radiolinksevunavaiminute.png");
										FileUtils.copyFile(SrcFile4,DestFile4);
										driver.close();
	
									}}
									
	
								driver.switchTo().window(mainWindow);
								Thread.sleep(10000);

	}
	

	@Test(priority=3)
	public void MicrowaveDashboardHuaweiHour() throws InterruptedException, IOException
	{
		
		WebElement granularity =driver.findElement(By.xpath("//div[@class='selectbtn ui-selectbutton ui-buttonset ui-widget ui-corner-all ui-buttonset-6']/div[2]"));;
		granularity.click();
		Thread.sleep(29000);
		Actions action=new Actions(driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		String mainWindow=driver.getWindowHandle();

		WebElement biterror =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-list ng-star-inserted']/ul/li[1]/label[2]/i[2]")));
		action.moveToElement(biterror).click().build().perform();
		Set<String> set =driver.getWindowHandles();
		Iterator<String> itr= set.iterator();
		while(itr.hasNext()){
			String childWindow=itr.next();
			if(!mainWindow.equals(childWindow)){
				driver.switchTo().window(childWindow);
				System.out.println(driver.switchTo().window(childWindow).getTitle());
				Thread.sleep(5000);
				TakesScreenshot scrShot =((TakesScreenshot)driver);
				File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
				File DestFile=new File("/root/Desktop/Biterrorhour.png");
				FileUtils.copyFile(SrcFile,DestFile);
				driver.close();
			}
		}
			
				driver.switchTo().window(mainWindow);
				WebElement radiolink =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-list ng-star-inserted']/ul/li[2]/label[2]/i[2]")));
				action.moveToElement(radiolink).click().build().perform();
				Set<String> set2 =driver.getWindowHandles();
				Iterator<String> itr2= set2.iterator();
				while(itr2.hasNext()){
					String childWindow2=itr2.next();
					if(!mainWindow.equals(childWindow2)){
						driver.switchTo().window(childWindow2);
						System.out.println(driver.switchTo().window(childWindow2).getTitle());
						Thread.sleep(5000);
						TakesScreenshot scrShot2 =((TakesScreenshot)driver);
						File SrcFile2=scrShot2.getScreenshotAs(OutputType.FILE);
						File DestFile2=new File("/root/Desktop/radiolinkhour.png");
						FileUtils.copyFile(SrcFile2,DestFile2);
						driver.close();
					}
				}
						driver.switchTo().window(mainWindow);
						WebElement radiolinksev =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-list ng-star-inserted']/ul/li[3]/label[2]/i[2]")));
						action.moveToElement(radiolinksev).click().build().perform();
						Set<String> set3 =driver.getWindowHandles();
						Iterator<String> itr3= set3.iterator();
						while(itr3.hasNext()){
							String childWindow3=itr3.next();
							if(!mainWindow.equals(childWindow3)){
								driver.switchTo().window(childWindow3);
								System.out.println(driver.switchTo().window(childWindow3).getTitle());
								Thread.sleep(5000);
								TakesScreenshot scrShot3 =((TakesScreenshot)driver);
								File SrcFile3=scrShot3.getScreenshotAs(OutputType.FILE);
								File DestFile3=new File("/root/Desktop/radiolinksevhour.png");
								FileUtils.copyFile(SrcFile3,DestFile3);
								driver.close();
				
				
			}
		}

						
						driver.switchTo().window(mainWindow);
						String mainWindow2=driver.getWindowHandle();

						WebElement radiolinksunavai =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-list ng-star-inserted']/ul/li[4]/label[2]/i[2]")));
						action.moveToElement(radiolinksunavai).click().build().perform();
						
						Set<String> set4 =driver.getWindowHandles();
						Iterator<String> itr4= set4.iterator();
						while(itr4.hasNext()){
							String childWindow3=itr4.next();
							if(!mainWindow2.equals(childWindow3)){
								driver.switchTo().window(childWindow3);
							
								System.out.println(driver.switchTo().window(childWindow3).getTitle());
								Thread.sleep(5000);
								TakesScreenshot scrShot4 =((TakesScreenshot)driver);
								File SrcFile4=scrShot4.getScreenshotAs(OutputType.FILE);
								File DestFile4=new File("/root/Desktop/radiolinksevunavaihour.png");
								FileUtils.copyFile(SrcFile4,DestFile4);
								driver.close();

							}}
							

						driver.switchTo().window(mainWindow);
						Thread.sleep(10000);

		
	}
	
	@Test(priority=4)
	public void MicrowaveDashboardHuaweiDay() throws InterruptedException, IOException
	{
		WebElement granularity =driver.findElement(By.xpath("//div[@class='selectbtn ui-selectbutton ui-buttonset ui-widget ui-corner-all ui-buttonset-6']/div[3]"));;
		granularity.click();
		Thread.sleep(29000);
		Actions action=new Actions(driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		String mainWindow=driver.getWindowHandle();

		WebElement biterror =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-list ng-star-inserted']/ul/li[1]/label[2]/i[2]")));
		action.moveToElement(biterror).click().build().perform();
		Set<String> set =driver.getWindowHandles();
		Iterator<String> itr= set.iterator();
		while(itr.hasNext()){
			String childWindow=itr.next();
			if(!mainWindow.equals(childWindow)){
				driver.switchTo().window(childWindow);
				System.out.println(driver.switchTo().window(childWindow).getTitle());
				Thread.sleep(5000);
				TakesScreenshot scrShot =((TakesScreenshot)driver);
				File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
				File DestFile=new File("/root/Desktop/Biterrorday.png");
				FileUtils.copyFile(SrcFile,DestFile);
				driver.close();
			}
		}
			
				driver.switchTo().window(mainWindow);
				WebElement radiolink =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-list ng-star-inserted']/ul/li[2]/label[2]/i[2]")));
				action.moveToElement(radiolink).click().build().perform();
				Set<String> set2 =driver.getWindowHandles();
				Iterator<String> itr2= set2.iterator();
				while(itr2.hasNext()){
					String childWindow2=itr2.next();
					if(!mainWindow.equals(childWindow2)){
						driver.switchTo().window(childWindow2);
						System.out.println(driver.switchTo().window(childWindow2).getTitle());
						Thread.sleep(5000);
						TakesScreenshot scrShot2 =((TakesScreenshot)driver);
						File SrcFile2=scrShot2.getScreenshotAs(OutputType.FILE);
						File DestFile2=new File("/root/Desktop/radiolinkday.png");
						FileUtils.copyFile(SrcFile2,DestFile2);
						driver.close();
					}
				}
						driver.switchTo().window(mainWindow);
						WebElement radiolinksev =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-list ng-star-inserted']/ul/li[3]/label[2]/i[2]")));
						action.moveToElement(radiolinksev).click().build().perform();
						Set<String> set3 =driver.getWindowHandles();
						Iterator<String> itr3= set3.iterator();
						while(itr3.hasNext()){
							String childWindow3=itr3.next();
							if(!mainWindow.equals(childWindow3)){
								driver.switchTo().window(childWindow3);
								System.out.println(driver.switchTo().window(childWindow3).getTitle());
								Thread.sleep(5000);
								TakesScreenshot scrShot3 =((TakesScreenshot)driver);
								File SrcFile3=scrShot3.getScreenshotAs(OutputType.FILE);
								File DestFile3=new File("/root/Desktop/radiolinksevday.png");
								FileUtils.copyFile(SrcFile3,DestFile3);
								driver.close();
				
				
			}
		}

						
						driver.switchTo().window(mainWindow);
						String mainWindow2=driver.getWindowHandle();

						WebElement radiolinksunavai =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-list ng-star-inserted']/ul/li[4]/label[2]/i[2]")));
						action.moveToElement(radiolinksunavai).click().build().perform();
						
						Set<String> set4 =driver.getWindowHandles();
						Iterator<String> itr4= set4.iterator();
						while(itr4.hasNext()){
							String childWindow3=itr4.next();
							if(!mainWindow2.equals(childWindow3)){
								driver.switchTo().window(childWindow3);
							
								System.out.println(driver.switchTo().window(childWindow3).getTitle());
								Thread.sleep(5000);
								TakesScreenshot scrShot4 =((TakesScreenshot)driver);
								File SrcFile4=scrShot4.getScreenshotAs(OutputType.FILE);
								File DestFile4=new File("/root/Desktop/radiolinksevunavaiday.png");
								FileUtils.copyFile(SrcFile4,DestFile4);
								driver.close();

							}}
							

						driver.switchTo().window(mainWindow);
						Thread.sleep(10000);

		
	}

	@Test(priority=5)
	public void MicrowaveDashboardHuaweiWeek() throws InterruptedException, IOException
	{
		WebElement granularity =driver.findElement(By.xpath("//div[@class='selectbtn ui-selectbutton ui-buttonset ui-widget ui-corner-all ui-buttonset-6']/div[4]"));;
		granularity.click();
		Thread.sleep(29000);
		Actions action=new Actions(driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		String mainWindow=driver.getWindowHandle();

		WebElement biterror =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-list ng-star-inserted']/ul/li[1]/label[2]/i[2]")));
		action.moveToElement(biterror).click().build().perform();
		Set<String> set =driver.getWindowHandles();
		Iterator<String> itr= set.iterator();
		while(itr.hasNext()){
			String childWindow=itr.next();
			if(!mainWindow.equals(childWindow)){
				driver.switchTo().window(childWindow);
				System.out.println(driver.switchTo().window(childWindow).getTitle());
				Thread.sleep(5000);
				TakesScreenshot scrShot =((TakesScreenshot)driver);
				File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
				File DestFile=new File("/root/Desktop/Biterrorweek.png");
				FileUtils.copyFile(SrcFile,DestFile);
				driver.close();
			}
		}
			
				driver.switchTo().window(mainWindow);
				WebElement radiolink =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-list ng-star-inserted']/ul/li[2]/label[2]/i[2]")));
				action.moveToElement(radiolink).click().build().perform();
				Set<String> set2 =driver.getWindowHandles();
				Iterator<String> itr2= set2.iterator();
				while(itr2.hasNext()){
					String childWindow2=itr2.next();
					if(!mainWindow.equals(childWindow2)){
						driver.switchTo().window(childWindow2);
						System.out.println(driver.switchTo().window(childWindow2).getTitle());
						Thread.sleep(5000);
						TakesScreenshot scrShot2 =((TakesScreenshot)driver);
						File SrcFile2=scrShot2.getScreenshotAs(OutputType.FILE);
						File DestFile2=new File("/root/Desktop/radiolinkweek.png");
						FileUtils.copyFile(SrcFile2,DestFile2);
						driver.close();
					}
				}
						driver.switchTo().window(mainWindow);
						WebElement radiolinksev =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-list ng-star-inserted']/ul/li[3]/label[2]/i[2]")));
						action.moveToElement(radiolinksev).click().build().perform();
						Set<String> set3 =driver.getWindowHandles();
						Iterator<String> itr3= set3.iterator();
						while(itr3.hasNext()){
							String childWindow3=itr3.next();
							if(!mainWindow.equals(childWindow3)){
								driver.switchTo().window(childWindow3);
								System.out.println(driver.switchTo().window(childWindow3).getTitle());
								Thread.sleep(5000);
								TakesScreenshot scrShot3 =((TakesScreenshot)driver);
								File SrcFile3=scrShot3.getScreenshotAs(OutputType.FILE);
								File DestFile3=new File("/root/Desktop/radiolinksevweek.png");
								FileUtils.copyFile(SrcFile3,DestFile3);
								driver.close();
				
				
			}
		}

						
						driver.switchTo().window(mainWindow);
						String mainWindow2=driver.getWindowHandle();

						WebElement radiolinksunavai =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-list ng-star-inserted']/ul/li[4]/label[2]/i[2]")));
						action.moveToElement(radiolinksunavai).click().build().perform();
						
						Set<String> set4 =driver.getWindowHandles();
						Iterator<String> itr4= set4.iterator();
						while(itr4.hasNext()){
							String childWindow3=itr4.next();
							if(!mainWindow2.equals(childWindow3)){
								driver.switchTo().window(childWindow3);
							
								System.out.println(driver.switchTo().window(childWindow3).getTitle());
								Thread.sleep(5000);
								TakesScreenshot scrShot4 =((TakesScreenshot)driver);
								File SrcFile4=scrShot4.getScreenshotAs(OutputType.FILE);
								File DestFile4=new File("/root/Desktop/radiolinksevunavaiweek.png");
								FileUtils.copyFile(SrcFile4,DestFile4);
								driver.close();

							}}
							

						driver.switchTo().window(mainWindow);
						Thread.sleep(10000);

		
	}
	@Test(priority=6)
	public void MicrowaveDashboardHuaweiMonth() throws InterruptedException, IOException
	{
		WebElement granularity =driver.findElement(By.xpath("//div[@class='selectbtn ui-selectbutton ui-buttonset ui-widget ui-corner-all ui-buttonset-6']/div[5]"));;
		granularity.click();
		Thread.sleep(29000);
		Actions action=new Actions(driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		String mainWindow=driver.getWindowHandle();

		WebElement biterror =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-list ng-star-inserted']/ul/li[1]/label[2]/i[2]")));
		action.moveToElement(biterror).click().build().perform();
		Set<String> set =driver.getWindowHandles();
		Iterator<String> itr= set.iterator();
		while(itr.hasNext()){
			String childWindow=itr.next();
			if(!mainWindow.equals(childWindow)){
				driver.switchTo().window(childWindow);
				System.out.println(driver.switchTo().window(childWindow).getTitle());
				Thread.sleep(5000);
				TakesScreenshot scrShot =((TakesScreenshot)driver);
				File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
				File DestFile=new File("/root/Desktop/Biterrormonth.png");
				FileUtils.copyFile(SrcFile,DestFile);
				driver.close();
			}
		}
			
				driver.switchTo().window(mainWindow);
				WebElement radiolink =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-list ng-star-inserted']/ul/li[2]/label[2]/i[2]")));
				action.moveToElement(radiolink).click().build().perform();
				Set<String> set2 =driver.getWindowHandles();
				Iterator<String> itr2= set2.iterator();
				while(itr2.hasNext()){
					String childWindow2=itr2.next();
					if(!mainWindow.equals(childWindow2)){
						driver.switchTo().window(childWindow2);
						System.out.println(driver.switchTo().window(childWindow2).getTitle());
						Thread.sleep(5000);
						TakesScreenshot scrShot2 =((TakesScreenshot)driver);
						File SrcFile2=scrShot2.getScreenshotAs(OutputType.FILE);
						File DestFile2=new File("/root/Desktop/radiolinkmonth.png");
						FileUtils.copyFile(SrcFile2,DestFile2);
						driver.close();
					}
				}
						driver.switchTo().window(mainWindow);
						WebElement radiolinksev =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-list ng-star-inserted']/ul/li[3]/label[2]/i[2]")));
						action.moveToElement(radiolinksev).click().build().perform();
						Set<String> set3 =driver.getWindowHandles();
						Iterator<String> itr3= set3.iterator();
						while(itr3.hasNext()){
							String childWindow3=itr3.next();
							if(!mainWindow.equals(childWindow3)){
								driver.switchTo().window(childWindow3);
								System.out.println(driver.switchTo().window(childWindow3).getTitle());
								Thread.sleep(5000);
								TakesScreenshot scrShot3 =((TakesScreenshot)driver);
								File SrcFile3=scrShot3.getScreenshotAs(OutputType.FILE);
								File DestFile3=new File("/root/Desktop/radiolinksevmonth.png");
								FileUtils.copyFile(SrcFile3,DestFile3);
								driver.close();
				
				
			}
		}

						
						driver.switchTo().window(mainWindow);
						String mainWindow2=driver.getWindowHandle();

						WebElement radiolinksunavai =wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-list ng-star-inserted']/ul/li[4]/label[2]/i[2]")));
						action.moveToElement(radiolinksunavai).click().build().perform();
						
						Set<String> set4 =driver.getWindowHandles();
						Iterator<String> itr4= set4.iterator();
						while(itr4.hasNext()){
							String childWindow3=itr4.next();
							if(!mainWindow2.equals(childWindow3)){
								driver.switchTo().window(childWindow3);
							
								System.out.println(driver.switchTo().window(childWindow3).getTitle());
								Thread.sleep(5000);
								TakesScreenshot scrShot4 =((TakesScreenshot)driver);
								File SrcFile4=scrShot4.getScreenshotAs(OutputType.FILE);
								File DestFile4=new File("/root/Desktop/radiolinksevunavaimonth.png");
								FileUtils.copyFile(SrcFile4,DestFile4);
								driver.close();

							}}
							

						driver.switchTo().window(mainWindow);
						Thread.sleep(10000);

	}
	
	
	
	
}


			





