package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.loginPageInterfaceElements;
import com.pageobjectmanager.PageObjectManager;
import com.utility.ExcelUtility;

public class LoginPage extends Base_Class implements loginPageInterfaceElements{
	@FindBy (id = username_id)
	private WebElement username;
	@FindBy (css = password_css)
	private WebElement password;
	@FindBy (xpath = loginbtn_xpath)
	private WebElement loginbtn;
	@FindBy (xpath =title_xpath)
	private WebElement title;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void getUsername() {
		passInput(username, PageObjectManager.getPageobjectmanager().getFilereader().getProperty("username"));
	}

	public void getPassword() {
		passInput(password, PageObjectManager.getPageobjectmanager().getFilereader().getProperty("password"));
	}

	public void getLoginbtn() {
		clickElement(loginbtn);
		
	}

	public void getTitle(String titlePage) {
		validateAssert(title, titlePage);
	}
	
	
	
	
	
	
	

}
