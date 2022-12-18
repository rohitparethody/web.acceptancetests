package testautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RentalCoverHomePage {

    private static WebElement element = null;

    private WebDriver driver;

    public RentalCoverHomePage(WebDriver driver){this.driver=driver;}

    private WebDriverWait wait = null;

    By quote_form = By.id("QuoteForm");
    By country_of_rental_selector = By.xpath("//*[@id='QuoteForm']/div[3]/div[1]/div[1]/div[1]/div/div/input");
    By from_date_picker = By.id("QuoteForm_FromDate-datepicker");
    By from_date = By.xpath("//*[@id='ui-datepicker-div']/div[3]/table/tbody/tr[2]/td[4]");
    By selected_from_date = By.id("QuoteForm_FromDate");
    By to_date_picker = By.id("QuoteForm_ToDate-datepicker");
    By to_date = By.xpath("//*[@id='ui-datepicker-div']/div[3]/table/tbody/tr[2]/td[4]");
    By selected_to_date = By.id("QuoteForm_ToDate");
    By country_of_residence_change_button = By.xpath("//*[@id='QuoteForm']/div[3]/div[1]/div[7]/div[1]/div/div/div[1]/a/strong");
    By country_of_residence_selector = By.xpath("//*[@id='QuoteForm-country-field']/div/input");
    By vehicle_change_button = By.xpath("//*[@id='QuoteForm']/div[3]/div[1]/div[7]/div[2]/div/div[1]/div[1]/a/strong");
    By vehicle_selector = By.id("QuoteForm_VehicleType");
    By get_quote_button = By.cssSelector("#QuoteForm > div.row > div.col-xs-12.col-md-4 > button");

    public WebElement quote_form(){
        element = driver.findElement(quote_form);
        return element;
    }

    public WebElement country_of_rental_selector(){
        element = driver.findElement(country_of_rental_selector);
        return  element;
    }

    public WebElement from_date_picker(){
        element = driver.findElement(from_date_picker);
        return  element;
    }

    public WebElement from_date(){
        element = driver.findElement(from_date);
        return  element;
    }

    public WebElement selected_from_date(){
        element = driver.findElement(selected_from_date);
        return  element;
    }

    public WebElement to_date_picker(){
        element = driver.findElement(to_date_picker);
        return  element;
    }

    public WebElement to_date(){
        element = driver.findElement(to_date);
        return  element;
    }

    public WebElement selected_to_date(){
        element = driver.findElement(selected_to_date);
        return  element;
    }

    public WebElement country_of_residence_change_button(){
        element = driver.findElement(country_of_residence_change_button);
        return  element;
    }

    public WebElement country_of_residence_selector(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(country_of_residence_selector));
        element = driver.findElement(country_of_residence_selector);
        return  element;
    }

    public WebElement vehicle_change_button(){
        element = driver.findElement(vehicle_change_button);
        return  element;
    }

    public WebElement vehicle_selector(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(vehicle_selector));
        element = driver.findElement(vehicle_selector);
        return  element;
    }

    public WebElement get_quote_button() {
        element = driver.findElement(get_quote_button);
        return element;
    }

    public String SelectVehicleType(String[] vehicleList){
        Select selectVehicle = new Select(vehicle_selector());
        List<WebElement> availableVehicles = selectVehicle.getOptions();
        boolean vehicleFound = false;
        for (WebElement vehicle:availableVehicles) {
            if(vehicle.getText().equals(vehicleList[0])){
                vehicleFound = true;
                selectVehicle.selectByValue(vehicleList[0].toLowerCase());
                break;
            }
        }
        if(!vehicleFound){
            selectVehicle.selectByValue(vehicleList[1].toLowerCase());
        }
        return selectVehicle.getFirstSelectedOption().getText();
    }

}
