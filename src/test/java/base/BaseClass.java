package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass extends BaseDriver{
    public WebDriver webDriver;
    public WebDriverWait wait;
    public Actions actions;
    public JavascriptExecutor javascriptExecutor;


    @BeforeClass(alwaysRun = true)
    @Parameters({"browser","timeout", "url"})
    public void setup(String browser, String timeout, String url) throws Exception {
        initDriver(browser, timeout);
        webDriver = super.driver;
        wait = super.wait;
        actions = super.actions;
        javascriptExecutor = super.javascriptExecutor;
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterClass(alwaysRun = true)
    public void cleanup() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
