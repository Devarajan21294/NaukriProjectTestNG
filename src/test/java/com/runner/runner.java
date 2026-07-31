package com.runner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.Base_Class;
import com.listner.ITestListnerClass;
import com.pageobjectmanager.PageObjectManager;

@Listeners(ITestListnerClass.class)
public class runner extends Base_Class {
	

    

    @BeforeSuite
    public void beforeSuite() {

        extendReportStart(PageObjectManager.getPageobjectmanager().getFilereader().getProperty("extendStart"));

    }


	@BeforeClass
	void setup() {
		launchBrowser(PageObjectManager.getPageobjectmanager().getFilereader().getProperty("browser"));
		
		launchUrl(PageObjectManager.getPageobjectmanager().getFilereader().getProperty("url"));
			
		}
	@Test(priority = 0)
	void LoginTest() {
		PageObjectManager.getPageobjectmanager().getLoginpage().getUsername();
		PageObjectManager.getPageobjectmanager().getLoginpage().getPassword();
		PageObjectManager.getPageobjectmanager().getLoginpage().getLoginbtn();
	}
	@Test
	void ValidateHomepage() {
		PageObjectManager.getPageobjectmanager().getProfileUpdate().validateTitletext();
	}
	
	@Test
	void validateFresherBtnValidation() {
		PageObjectManager.getPageobjectmanager().getProfileUpdate().getProfileIcon();
		PageObjectManager.getPageobjectmanager().getProfileUpdate().getViewUpdate();
		PageObjectManager.getPageobjectmanager().getProfileUpdate().getProfileEditIcon();
		PageObjectManager.getPageobjectmanager().getProfileUpdate().getFresherRadiobtn();
		PageObjectManager.getPageobjectmanager().getProfileUpdate().getExpErrorMsg();
	}
	@AfterClass
	void teardown() {
		browserTerminate();
	}
	 @AfterSuite
	    public void afterSuite() throws IOException {

	        extendReportTearDown(PageObjectManager.getPageobjectmanager().getFilereader().getProperty("extendend"));

	    }
}
