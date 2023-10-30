package Salesforce.Script;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Salesforce.Base.SalesforceBaseTest;
import Salesforce.Base.utility.PropertiesUtility;

public class SalesforceScriptTestCreateAccount extends SalesforceBaseTest{

	@Test
	public static void testcase5() throws InterruptedException {
		System.out.println("******_salesforce automation AccountScript started***********");
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
	WebElement accounts=driver.findElement(By.xpath("//a[text()=\"Contacts\"]"));
	MoveToElementAction(accounts, "account area");
	WebElement newEle=driver.findElement(By.xpath("//input[@class='btn' and @name='new']"));
	clickElement(newEle, "newButton box");
	WebElement accountName=driver.findElement(By.xpath("//input[@id='acc2']"));
	String sendAccountData=appProp.getProperty("account.name");
	enterText(accountName, sendAccountData, "AccountName box");
	WebElement type=driver.findElement(By.xpath("//select[@id='acc6']"));
	 selectByTextData(type, "Technology Partner","Type box");
	 WebElement priority=driver.findElement(By.id("00NHp00000blNWX"));
	 selectByIndexData(priority, 2," prioritybox");
	}
	
	@Test
	public static void testcase6() throws InterruptedException {
		System.out.println("******_salesforce automation  viewName script started***********");
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
	WebElement accounts=driver.findElement(By.xpath("//a[text()=\"Contacts\"]"));
	MoveToElementAction(accounts, "account area");
	WebElement createView=driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
	clickElement(createView, "create view");
	WebElement viewnameBox=driver.findElement(By.xpath("//input[@id='fname']"));
	
	enterText(viewnameBox, view.name, "viewName box");
	ent
}
}