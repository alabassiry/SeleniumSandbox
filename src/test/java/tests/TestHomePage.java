package tests;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestHomePage extends BaseClass {
    HomePage homepage;

    @Test
    private void test1() throws InterruptedException {
        homepage = new HomePage(driver,wait,actions,javascriptExecutor);
        homepage.selectDepartureCity("Paris");
        homepage.selectArrivalCity("Cairo");
        homepage.clickFindFlightsButton();
    }
}