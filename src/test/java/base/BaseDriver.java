package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseDriver {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor javascriptExecutor;
    private final Exception browserNotFoundException = new Exception("Please enter a valid browser name.");

    public void initDriver(String browser, String timeout) throws Exception {
        browser = browser.toLowerCase().trim();
        switch (browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw browserNotFoundException;
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(timeout)));
        actions = new Actions(driver);
        javascriptExecutor = (JavascriptExecutor)driver;
    }
}
