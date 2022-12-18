package testautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PolicyInformationAndPaymentPage {

    private static WebElement element = null;

    private WebDriver driver;

    public PolicyInformationAndPaymentPage(WebDriver driver){this.driver=driver;}

    private WebDriverWait wait = null;

    By quote_summary_heading = By.id("policy-inclusions");
    By country_of_rental = By.xpath("/html/body/section/div[2]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]");
    By start_date = By.xpath("/html/body/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/div[1]/div/div/div");
    By end_date = By.xpath("/html/body/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/div");
    By selected_vehicle = By.xpath("/html/body/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div[1]/div/div[2]");
    public WebElement quote_summary_heading(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(quote_summary_heading));
        element = driver.findElement(quote_summary_heading);
        return element;
    }

    public WebElement country_of_rental(){
        element = driver.findElement(country_of_rental);
        return element;
    }

    public WebElement start_date(){
        element = driver.findElement(start_date);
        return element;
    }

    public WebElement end_date(){
        element = driver.findElement(end_date);
        return element;
    }

    public WebElement selected_vehicle(){
        element = driver.findElement(selected_vehicle);
        return element;
    }

}
