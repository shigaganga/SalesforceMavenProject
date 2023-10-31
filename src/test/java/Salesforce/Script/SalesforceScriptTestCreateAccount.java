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
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");
		String username=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitForVisibility(usernameEle, 5, 2, "username textbox");
		enterText(usernameEle,username,"username textbox");
		WebElement passwordEle = driver.findElement(By.id("password"));
		waitForVisibility(passwordEle, 5, 2, "password textbox");
		enterText(passwordEle,password,"password textbox");
		WebElement buttonEle=driver.findElement(By.id("Login"));
		waitForVisibility(buttonEle, 5, 2, "button textbox");
		clickElement(buttonEle,"login button");
	WebElement accounts=driver.findElement(By.xpath("//a[text()='Contacts']"));
	waitForVisibility(accounts, 5, 2, "password textbox");
	MoveToElementAction(accounts, "account area");
	WebElement newEle=driver.findElement(By.xpath("//input[@class='btn' and @name='new']"));
	waitForVisibility(newEle, 5, 2, "new textbox");
	clickElement(newEle, "newButton box");
	WebElement accountName=driver.findElement(By.xpath("//input[@id='acc2']"));
	waitForVisibility(accountName, 5, 2, "accountNametextbox");
	String sendAccountData=appProp.getProperty("account.name");
	enterText(accountName, sendAccountData, "AccountName box");
	WebElement type=driver.findElement(By.xpath("//select[@id='acc6']"));
	waitForVisibility(type, 5, 2, "type textbox");
	 selectByTextData(type, "Technology Partner","Type box");
	 WebElement priority=driver.findElement(By.id("00NHp00000blNWX"));
	 waitForVisibility(priority, 5, 2, "priority textbox");
	 selectByIndexData(priority, 2," prioritybox");
	}
	
	@Test
	public static void testcase6() throws InterruptedException {
		System.out.println("******_salesforce automation testing viewName script started***********");
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
	String viewNameSend=appProp.getProperty("view.name");
	enterText(viewnameBox,viewNameSend, "viewName box");
	WebElement uniqueViewnameBox=driver.findElement(By.xpath("//input[@id='devname']"));
	String uniqueViewNameSend=appProp.getProperty("unique.view.name");
	enterText(uniqueViewnameBox,uniqueViewNameSend, "UniqueviewName box");
	//WebElement save=driver.findElement(By.id("save");
		//clickElement(save, saveclick)	;
}
}
