package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.ProfileUpdateInterfaceElements;
import com.pageobjectmanager.PageObjectManager;
import com.utility.ExcelUtility;

public class ProfileUpdatePage extends Base_Class implements ProfileUpdateInterfaceElements {
	@FindBy (id = username_id)
	private WebElement username;
	@FindBy (xpath =title_xpath)
	private WebElement title;
	
		@FindBy (css = password_css)
	private WebElement password;
	@FindBy (xpath = loginbtn_xpath)
	private WebElement loginbtn;	
@FindBy (xpath= profileIcon_xpath)
private WebElement profileIcon;
@FindBy (xpath= viewUpdate_xpath)
private WebElement viewUpdate;
@FindBy (xpath= profileEditIcon_xpath)
private WebElement profileEditIcon;
@FindBy (xpath= fresherRadiobtn_xpath)
private WebElement fresherRadiobtn;
@FindBy (id= expErrorMsg_id)
private WebElement expErrorMsg;
@FindBy(id= salary_id)
private WebElement salary;
@FindBy (xpath= savebasicDetailsbtn_xpath)
private WebElement savebasicDetail;

public void getUsername(String user) {
	passInput(username, user);
}


public void getPassword(String pass) {
	passInput(password, pass);
}

public void validateTitletext() {
	validateAssert(title, PageObjectManager.getPageobjectmanager().getFilereader().getProperty("title"));
}

public void getLoginbtn() {
	clickElement(loginbtn);
}


public ProfileUpdatePage() {
	PageFactory.initElements(driver, this);
}


public void getProfileIcon() {
	clickElement(profileIcon);
}


public void getViewUpdate() {
	clickElement(viewUpdate);

}


public void getProfileEditIcon() {
	clickElement(profileEditIcon);

}


public void getFresherRadiobtn() {
	clickElement(fresherRadiobtn);

}


public void getExpErrorMsg() {
	validateAssert(expErrorMsg,PageObjectManager.getPageobjectmanager().getFilereader().getProperty("expErrorMsg"));

}


public void getSalary() throws IOException {
	passInput(salary, ExcelUtility.getCellValue("DATA", "ID", "Salary"));
}


public void getSavebasicDetail() {
	   moveToElement(savebasicDetail);
		clickElement(savebasicDetail);
}


}

