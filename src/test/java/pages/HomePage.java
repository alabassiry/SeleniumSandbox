package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import wrappers.Methods;

public class HomePage extends Methods{
    Select select;
    @FindBy
    By departureCityBy = By.name("fromPort");
    @FindBy
    By arrivalCityBy = By.name("toPort");
    @FindBy
    By findFlightsButtonBy = By.xpath("//input[@value='Find Flights']");

    public HomePage(WebDriver driver, WebDriverWait wait,
                    Actions actions, JavascriptExecutor jse){
        super(driver, wait, jse, actions);
        PageFactory.initElements(driver, this);
    }

    /**
     * Select a departure city by name
     * @param name
     */
    public void selectDepartureCity(String name){
        select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(departureCityBy)));
        select.selectByVisibleText(name);
    }

    /**
     * Select a departure city by index
     * @param index
     */
    public void selectDepartureCity(int index){
        select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(departureCityBy)));
        select.selectByIndex(index);
    }

    /**
     * Select a arrival city by name
     * @param name
     */
    public void selectArrivalCity(String name){
        select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(arrivalCityBy)));
        select.selectByVisibleText(name);
    }

    /**
     * Select a arrival city by index
     * @param index
     */
    public void selectArrivalCity(int index){
        select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(arrivalCityBy)));
        select.selectByIndex(index);
    }

    public void clickFindFlightsButton() throws InterruptedException {
        myClick(wait.until(ExpectedConditions.visibilityOfElementLocated(findFlightsButtonBy)));
    }

}
