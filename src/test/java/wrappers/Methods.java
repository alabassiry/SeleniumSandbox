package wrappers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Methods {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor javascriptExecutor;
    protected Actions actions;
    private final int REFRESH_TIMEOUT = 200;
    private final int CLEAR_TIMEOUT = 500;


    public Methods(WebDriver driver, WebDriverWait wait, JavascriptExecutor javascriptExecutor, Actions actions){
        this.driver = driver;
        this.wait = wait;
        this.javascriptExecutor = javascriptExecutor;
        this.actions = actions;
    }

    /**
     * Clicks on a WebElement using WebElement object as an argument
     * @param element
     */
    public void myClick(WebElement element) throws InterruptedException {
        Thread.sleep(REFRESH_TIMEOUT);
        element.click();
        Thread.sleep(REFRESH_TIMEOUT);
    }

    /**
     * Type string "value" into element
     * @param element
     * @param value
     * @throws InterruptedException
     */
    public void mySendKeys(WebElement element, String value) throws InterruptedException {
        Thread.sleep(REFRESH_TIMEOUT);
        element.sendKeys(value);
        Thread.sleep(REFRESH_TIMEOUT);
        try{
            Assert.assertEquals(element.getText(),value);
        } catch (AssertionError ae){
            element.clear();
            Thread.sleep(CLEAR_TIMEOUT);
            element.sendKeys(value);
            Thread.sleep(REFRESH_TIMEOUT);
        }
    }

    /**
     * Scrolls in the y-coordinate till element is into view
     * @param element
     * @throws InterruptedException
     */
    public void scrollElementIntoView(WebElement element) throws InterruptedException {
        Thread.sleep(REFRESH_TIMEOUT);
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(REFRESH_TIMEOUT);
    }
}
