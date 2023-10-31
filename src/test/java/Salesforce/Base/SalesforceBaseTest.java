
package Salesforce.Base;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Salesforce.Base.utility.PropertiesUtility;
public class SalesforceBaseTest {
	protected static WebDriver driver=null;
	static WebDriverWait wait=null;
	
	@BeforeMethod
	@Parameters("browsername")
	public static void setUpBeforeTestMethod(@Optional("firefox") String browser_name) {
		PropertiesUtility pro=new PropertiesUtility();
		Properties applicationProFile=pro.loadFile("applicationDataProperties");
		String url=applicationProFile.getProperty("url");
		launchBrowser(browser_name);
		maximiseBrowser();
		goToUrl(url);
	}
	@AfterMethod
	public void tearDownAfterTestMethod() {
		closeBrowser();
		System.out.println("******login_to_Salesforce automation script ended***********");
	}
	
	public static void launchBrowser(String browserName) {
		switch(browserName) {
		case "firefox":driver=new FirefoxDriver();
						System.out.println("firefox browser launched");
						break;
		case "chrome":driver=new ChromeDriver();
						System.out.println("chrome browser launched");
						break;
		default: System.out.println("you have not entrered the correct browser");
		
			
		}
	}
	
	public static void goToUrl(String url) {
		driver.get(url);
		System.out.println(url+ "is entered");
	}
	
	public static void maximiseBrowser() {
		driver.manage().window().maximize();
		System.out.println("browser window has maximized");
	}
	
	public static String getTextFromElement(WebElement ele,String objectName) {
		String data=ele.getText();
		System.out.println("extracted the text from"+objectName);
		return data;
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	public static void quitBrowser() {
		driver.quit();
	}
	
	public static void enterText(WebElement ele,String data,String ObjectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("data is entered in the "+ObjectName);
		} else {
			System.out.println(ObjectName+" element is not displayed");
		}
	}
	
	public static void clickElement(WebElement ele,String ObjectName) {
		if(ele.isEnabled()) {
			ele.click();
			System.out.println(ObjectName+"button is clicked");
			}
			else {
				System.out.println("button element is not enabled");
			}
	}
	
//	//***Screenshot reusablemethod***//
//	//public static void  screenshotDriver(WebDriver driver,String filepath)throws IOException
//	{
// TakesScreenshot  screencapture=(TakesScreenshot)driver;
// File src=screencapture.getScreenshotAs(OutputType.FILE);
 //File destination=new File(filepath);
// Files.copy(src,destination);
//	}
//	public static void  screenshotElement(WebElement element,String filepath)throws IOException
//	{
 //File src=element.getScreenshotAs(OutputType.FILE);
// File destination=new File(filepath);
// Files.copy(src,destination);
	//} 
	//***wait reusable methods***********//
	public static void waitForVisibility(WebElement ele,int time,int pollingtime,String objectName) {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(time))
		.pollingEvery(Duration.ofSeconds(pollingtime))
		.ignoring(ElementNotInteractableException.class);
		
		wait.until(ExpectedConditions.visibilityOf(ele));
		System.out.println(objectName+" is waited for visibility using fluent wait");
	}
	
	public static void waitForVisibility(WebElement ele,int time,String objectName) {
		wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public static void waitUntilPresenceOfElementLocatedBy(By locator,String objectName) {
		System.out.println("waiting for an element"+objectName+"for its visibility");
		wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static void waitUntilElementToBeClickable(By locator,String objectName) {
		System.out.println("waiting for an element"+objectName+"to be clickable");
		wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void waitforAlertPresent(int time) {
	
	WebDriverWait	wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	//***selectclass reusable methods**************//

	public static void selectByTextData(WebElement element, String text,String objName)
	{
		Select selectText=new Select(element);
		selectText.selectByVisibleText(text);
		System.out.println(objName+"selected"+text);
	}
	public static void selectByIndexData(WebElement element, int index,String objName)
	{
		waitForVisibility(element, 5, objName);
		Select selectIndex=new Select(element);
		selectIndex.selectByIndex(index);
		System.out.println(objName+"selected"+index);
	}
	public static void selectByValueData(WebElement element, String text,String objName)
	{
		Select selectValue=new Select(element);
		selectValue.selectByVisibleText(text);
		System.out.println(objName+"selected"+text);
	}
	//***Action class reusable methods***//
	public static void waitUntilPageLoads() {
		System.out.println("waiting until page loads until 30seconds maximum");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	public static void MoveToElementAction(WebElement ele,String objName) {
		Actions action=new Actions(driver);
		action.moveToElement(ele).build().perform();
		System.out.println("cursor moved to the webelement"+objName);
	}
	public static void ContextClickAction(WebElement ele,String objName) {
		Actions action=new Actions(driver);
		action.contextClick(ele).build().perform();
		System.out.println("right click performed to the webelement"+objName);
	}

	public static void switchToWindowOpened(String mainWindowHandle) {
		Set<String>allWindowHandles=driver.getWindowHandles();
		for(String handle:allWindowHandles) {
			if(!mainWindowHandle.equalsIgnoreCase(handle))
				driver.switchTo().window(handle);
			
		}
		System.out.println("Switched to new window ");
	}
	public static WebElement   selectFromListUsingText(List<WebElement>list,String text) {
		WebElement element=null;
		for(WebElement i:list) {
			if(i.getText().equalsIgnoreCase(text)){
		System.out.println("Selected="+i.getText());
		element=i;
		break;
	}}return element;}
}

