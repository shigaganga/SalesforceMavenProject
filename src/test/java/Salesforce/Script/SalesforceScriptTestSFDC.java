package Salesforce.Script;
import org.testng.annotations.Test;

import Salesforce.Base.SalesforceBaseTest;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import Salesforce.Base.utility.PropertiesUtility;
public class SalesforceScriptTestSFDC extends SalesforceBaseTest {
	@Test
	public static void testcase1() throws InterruptedException {
		System.out.println("******_salesforce automation script started***********");
		String expected="Please enter your password.";
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");
		String username=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("");
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitForVisibility(usernameEle, 5, 2, "username textbox");
		enterText(usernameEle,username,"username textbox");
		WebElement passwordEle = driver.findElement(By.id("password"));
		enterText(passwordEle,password,"password textbox");
		WebElement buttonEle=driver.findElement(By.id("Login"));
		clickElement(buttonEle,"login button");
		String actual=getTextFromElement(buttonEle,"loginText");
		Assert.assertEquals(actual, expected,"Fail: testcase failed");
	}
	@Test
	public static void testcase2() throws InterruptedException {
		System.out.println("******_salesforce automation2 loginpage open started***********");
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");
		String username=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitForVisibility(usernameEle, 5, 2, "username textbox");
		enterText(usernameEle,username,"username textbox");
		WebElement passwordEle = driver.findElement(By.id("password"));
		enterText(passwordEle,password,"password textbox");
		WebElement buttonEle=driver.findElement(By.id("Login"));
		clickElement(buttonEle,"login button");
		String actual=getTextFromElement(buttonEle,"loginText");
		System.out.println("salesforce home page opened");
	}
	@Test
public static void rememberMe()throws InterruptedException{
	System.out.println("***saleforce case3 rememberme*****");
	PropertiesUtility pro=new PropertiesUtility();
	Properties appProp= pro.loadFile("applicationDataProperties");
	String username=appProp.getProperty("login.valid.userid");
	String password=appProp.getProperty("login.valid.password");
WebElement usernameEle = driver.findElement(By.id("username"));
waitForVisibility(usernameEle, 5, "username textbox");
enterText(usernameEle,username,"username textbox");
WebElement passwordEle = driver.findElement(By.id("password"));
waitForVisibility(passwordEle, 5, "password textbox");
enterText(passwordEle,password,"password textbox");
WebElement rememberme=driver.findElement(By.xpath("//label[@class='fl pr db tn3']"));
waitForVisibility(rememberme ,5, "username textbox");
clickElement(rememberme,"login button");
System.out.println("Remember me clicked");
driver.navigate().refresh();
WebElement buttonEle=driver.findElement(By.id("Login"));
waitForVisibility(buttonEle, 10, "username textbox");
clickElement(buttonEle,"login button");
driver.navigate().refresh();
//Thread.sleep(5000);
waitForVisibility(buttonEle, 10, "button textbox");
/*WebElement userId=driver.findElement(By.xpath("//div[(@id='userNavButton')]/span[@id='userNavLabel']"));
driver.navigate().refresh();
waitForVisibility(userId, 5,"useid box");
clickElement(userId,"userid button");
WebElement logoutlink=driver.findElement(By.linkText("Logout"));
waitForVisibility(logoutlink, 5,"move to");
clickElement(logoutlink,"logout button");
}*/}
	@Test
public static void login_SalesForceCase4() throws InterruptedException {

System.out.println("******login_to_salesForce automation testcase4 started***********");

PropertiesUtility pro=new PropertiesUtility();
Properties appProp= pro.loadFile("applicationDataProperties");
String username=appProp.getProperty("login.valid.userid");
String password=appProp.getProperty("login.invalid.password");
WebElement usernameEle = driver.findElement(By.id("username"));
waitForVisibility(usernameEle, 5, "username textbox");
enterText(usernameEle,username,"username textbox");
WebElement passwordEle = driver.findElement(By.id("password"));
waitForVisibility(passwordEle, 5, "password textbox");
enterText(passwordEle,password,"password textbox");
WebElement forgotPw=driver.findElement(By.xpath("//a[@id='forgot_password_link']"));
clickElement(forgotPw,"forgotpw button");
Thread.sleep(3000);
WebElement usernameEle2 = driver.findElement(By.xpath("//input[@id='un']"));
enterText(usernameEle2, username,"udername textbox");
WebElement continueClick=driver.findElement(By.xpath("//input[@id='continue']"));
clickElement(continueClick, "continue box");
System.out.println("continue clicked");
}
	@Test
	public static void login_SalesForceCase4b() throws InterruptedException {

	System.out.println("******login_to_salesForce automation testcase4B started***********");

	PropertiesUtility pro=new PropertiesUtility();
	Properties appProp= pro.loadFile("applicationDataProperties");
	String username=appProp.getProperty("login.valid.userid");
	String password=appProp.getProperty("login.invalid.password");
	WebElement usernameEle = driver.findElement(By.id("username"));
	waitForVisibility(usernameEle, 5, "username textbox");
	enterText(usernameEle,username,"username textbox");
	WebElement passwordEle = driver.findElement(By.id("password"));
	waitForVisibility(passwordEle, 5, "password textbox");
	enterText(passwordEle,password,"password textbox");
	WebElement forgotPw=driver.findElement(By.xpath("//a[@id='forgot_password_link']"));
	clickElement(forgotPw,"forgotpw button");
	Thread.sleep(3000);
	WebElement usernameEle2 = driver.findElement(By.xpath("//input[@id='un']"));
	enterText(usernameEle2, username,"udername textbox");
	WebElement continueClick=driver.findElement(By.xpath("//input[@id='continue']"));
	clickElement(continueClick, "continue box");
	System.out.println("continue clicked");
	WebElement checkEmail=driver.findElement(By.cssSelector("#header.mb12"));
	System.out.println("check email page displayed");
	}
	}

