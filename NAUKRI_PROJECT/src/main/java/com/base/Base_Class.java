package com.base;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Event;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base_Class {
	public static WebDriver driver;
	public static ExtentReports extentReports;
	public static File file;
	public static ExtentTest extentTest;

	protected static void launchBrowser(String browserName) {
		try {
			if(browserName.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
			
			}else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}else if(browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
				}

		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR WHEN BROWSER LAUNCH");
		}
		driver.manage().window().maximize();

	}
	protected static void launchUrl(String url) {
		try {
		driver.get(url);
		} catch (Exception e) {
			
			Assert.fail("ERROR: OCCUR WHEN URL LAUNCH");
		}
	}
	protected static void passInput(WebElement element ,String value ) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        element = wait.until(ExpectedConditions.visibilityOf(element));
	        element.clear();
		element.sendKeys(value);
		System.out.println(value);
		} catch (Exception e) {
			
			Assert.fail("ERROR: OCCUR WHEN VAUE PASSED");
		}
	}
	protected static void browserTerminate() {
		try {
		driver.quit();
		} catch (Exception e) {
		
			Assert.fail("ERROR: OCCUR DURING BROWSER TERMINATED");
		}
}
	 protected static void selectOptions( WebElement element, String type,String value ) {
		try {
			Select select =new Select(element);
		if(type.equalsIgnoreCase("text")) {
			select.selectByVisibleText(value);}
			else if(type.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));
			}else if(type.equalsIgnoreCase("value")) {
				select.selectByValue(value);
		}
				
		} catch (Exception e) {
			
			Assert.fail("ERROR: OCCUR DURING VALUE SELECTION");
		}	
	}
	
	 
	 protected static void navigateTo(String url) {
		 try {
			driver.navigate().to(url);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING NAVIGATION TO URL");
		}
	 }
	 protected static void navigateMethod(String type) {
		 try {
			 if (type.equalsIgnoreCase("back")) {
			driver.navigate().back();
		}else if(type.equalsIgnoreCase( "forward")) {
			driver.navigate().forward();
		} else if (type.equalsIgnoreCase("refresh")) {
            driver.navigate().refresh();
        }}

			 catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING NAVIGATION BACk");
		}
	 }
	 protected static String getUrl(){
		 try {  return  driver.getCurrentUrl();
					
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING GETURL");
		}
		 return null;
		 
	 }
	 protected static String getTitle(WebElement element){ 
		 try {
return driver.getTitle();
			 
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING GET TITLE");
		 
	 }
		 return null;
}
	 protected static void alertHandling(String action) {
		    try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		        if (action.equalsIgnoreCase("accept")) {
		            alert.accept();
		            System.out.println("Alert accepted");
		        } else if (action.equalsIgnoreCase("dismiss")) {
		            alert.dismiss();
		            System.out.println("Alert dismissed");
		        }
		    } catch (Exception e) {
		        Assert.fail("ERROR: OCCURRED DURING ALERT HANDLE: " + e.getMessage());
		    }
		}

	
	 protected static void clickElement(WebElement element) {
		 try {
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        element = wait.until(ExpectedConditions.elementToBeClickable(element));
		        element.click();
		        
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING CLICK ELEMENT");
		}
	 }
	 protected static String  getText(WebElement element ) {
		 try {
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        element = wait.until(ExpectedConditions.visibilityOf(element));
			String text= element.getText();
			System.out.println(text);
			return text;
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING TEXT GETTING");
			return null;
		}
	 }
		 
		 protected static String validateAssert(WebElement element, String value ) {
			 try {
				 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			        element = wait.until(ExpectedConditions.visibilityOf(element));
				String text= element.getText();
				System.out.println(text);
				Assert.assertEquals(text, value);
				return text;
			} catch (Exception e) {
				Assert.fail("ERROR: OCCUR DURING VALIDATING TEXT ASSERTION");
				return null;
			}}
		 protected static String validateAssertValue(WebElement element, String value ) {
			 try {
				 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			        element = wait.until(ExpectedConditions.visibilityOf(element));
				String text= element.getAttribute("title");
				System.out.println(text);
				Assert.assertEquals(text, value);
				return text;
			} catch (Exception e) {
				 e.printStackTrace();
				Assert.fail("ERROR: OCCUR DURING VALIDATING VALUE ASSERTION");
				return null;
			}}
		 
		 public static void extendReportStart(String location) {
			 extentReports= new ExtentReports();
			 file =new File(location);
			 ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
			 extentReports.attachReporter(sparkReporter);
			 extentReports.setSystemInfo("OS", System.getProperty("os.name"));
			 extentReports.setSystemInfo("Java version", System.getProperty("java.version"));
		 }
		 public static void extendReportTearDown(String location) throws IOException {
			 extentReports.flush();
			 file =new File(location);
			 Desktop.getDesktop().browse((file).toURI());
		 
		 
}
		 protected String takeScreenShot()throws IOException{
			 try {

				 TakesScreenshot ts = (TakesScreenshot)driver;
				String timeStamp= new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		            File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		         //   String destinationPath = "C:\\Users\\admin\\eclipse-workspace\\IPT_POM_PROJECT/"+name+".png";
		            File destinationFile = new File("Screenshpt\\.png"+"_"+timeStamp+".png");
		            FileUtils.copyFile(sourceFile, destinationFile);
		            
		           return destinationFile.getAbsolutePath();
		            
			} catch (Exception e) {
				Assert.fail("ERROR: OCCUR DURING SCREENSHOT");
			}
			 return null;
		 
}	 

protected static void fileUpload() throws AWTException {
	try {
		Robot robot =new Robot();
		StringSelection ss= new StringSelection("C:\\Users\\admin\\Downloads\\Devarajan_QAtester_3yrs.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.delay(5000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		//robot.keyPress(KeyEvent.VK_PASTE);
		robot.keyPress(KeyEvent.VK_ENTER);
	} catch (HeadlessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (AWTException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
protected static void moveToElement(WebElement element) {
	 try {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        element = wait.until(ExpectedConditions.visibilityOf(element));
	      //  JavascriptExecutor js = (JavascriptExecutor) driver;
	        //js.executeScript("arguments[0].scrollIntoView(true);", element);

	       Actions action =new Actions(driver);
	      action.moveToElement(element).perform();
	        
	} catch (Exception e) {
		Assert.fail("ERROR: OCCUR DURING MOVE TO ELEMENT");
	}
}
protected static void waitToSee(WebElement element) {
	 try {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        element = wait.until(ExpectedConditions.visibilityOf(element));
	    
	        
	} catch (Exception e) {
		Assert.fail("ERROR: OCCUR DURING WAITING TO VISIBLILITY OF ELEMENT");
	}
}
protected static void scrollTo() {
	 try {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	      //  element = wait.until(ExpectedConditions.visibilityOf(element));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0, 1000);");

	    
	        
	} catch (Exception e) {
		Assert.fail("ERROR: OCCUR DURING SCROLL TO ELEMENT");
	}
}


}

