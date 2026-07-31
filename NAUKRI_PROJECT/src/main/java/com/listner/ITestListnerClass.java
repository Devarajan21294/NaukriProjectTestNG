package com.listner;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.base.Base_Class;

public class ITestListnerClass extends Base_Class implements ITestListener{
	

    @Override
    public void onTestStart(ITestResult result) {

        extentTest = extentReports.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        try {

            extentTest.pass(
                    result.getMethod().getMethodName() + " Passed",
                    MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    @Override
    public void onTestFailure(ITestResult result) {

        try {

            extentTest.fail(result.getThrowable(),
                    MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest.skip(result.getMethod().getMethodName() + " Skipped");

    }

}