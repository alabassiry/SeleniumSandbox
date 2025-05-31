package tests;

import base.BaseClass;
import extentreports.TestListener;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import tests.testdata.Cities;
import utils.Utilties;

import java.io.IOException;

@Listeners(TestListener.class)
public class TestHomePageDataProvider extends BaseClass {
    HomePage homepage;
    Utilties utils;

    @Test(dataProvider = "cities", dataProviderClass = Cities.class)
    private void testReserveTable(String departureCity, String arrivalCity) throws InterruptedException {
        System.out.println("Test execution started!");
        homepage = new HomePage(driver,wait,actions,javascriptExecutor);
        homepage.selectDepartureCity(departureCity);
        homepage.selectArrivalCity(arrivalCity);
        homepage.clickFindFlightsButton();
        System.out.println("Test executed!");
        Assert.assertTrue(true);
    }

    @AfterMethod(alwaysRun = true)
    @Parameters({"url"})
    private void afterExecution(String url, ITestResult testResult) throws IOException {
        utils = new Utilties();
        if(testResult.getStatus() == ITestResult.FAILURE){
            utils.takeScreenshot(driver,testResult.getMethod().getMethodName());
        }
        driver.navigate().to(url);
    }
}