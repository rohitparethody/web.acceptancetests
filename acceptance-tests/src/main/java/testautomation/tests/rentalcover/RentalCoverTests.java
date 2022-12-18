package testautomation.tests.rentalcover;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testautomation.framework.web.BaseTest;
import testautomation.framework.web.Helper;
import testautomation.pageobjects.PolicyInformationAndPaymentPage;
import testautomation.pageobjects.RentalCoverHomePage;

public class RentalCoverTests extends BaseTest {

    RentalCoverHomePage rentalCoverHomePage = null;
    PolicyInformationAndPaymentPage policyInformationAndPaymentPage = null;
    String fromDate = null;
    String toDate = null;
    String selectedVehicle = null;

    @BeforeClass
    public void initialisePage() {
        rentalCoverHomePage = new RentalCoverHomePage(driver);
        policyInformationAndPaymentPage = new PolicyInformationAndPaymentPage(driver);
    }

    @Test(priority = 0)
    @Parameters({"url"})
    public void loadRentalCoverHomepage(String url) {
        //load the RentalCover home page
        driver.get(url);

        //verify that the quote form in the home page has loaded
        Assert.assertTrue(rentalCoverHomePage.quote_form().isDisplayed());
        Reporter.log("Rental cover page load successful");
        Helper.captureScreenShot(driver,"01verifyRentalCoverPageLoad");
    }

    @Test(priority = 1)
    @Parameters({"countryOfRental","countryOfResidence","vehicleType"})
    public void getInstantQuote(String countryOfRental, String countryOfResidence, String vehicleType){
        //fill the quote form
        rentalCoverHomePage.country_of_rental_selector().click();
        rentalCoverHomePage.country_of_rental_selector().sendKeys(countryOfRental);
        rentalCoverHomePage.country_of_rental_selector().sendKeys(Keys.RETURN);
        rentalCoverHomePage.country_of_residence_change_button().click();
        rentalCoverHomePage.country_of_residence_selector().click();
        rentalCoverHomePage.country_of_residence_selector().sendKeys(countryOfResidence);
        rentalCoverHomePage.country_of_residence_selector().sendKeys(Keys.RETURN);
        rentalCoverHomePage.from_date_picker().click();
        rentalCoverHomePage.from_date().click();
        rentalCoverHomePage.to_date().click();
        fromDate = rentalCoverHomePage.selected_from_date().getAttribute("value");
        toDate = rentalCoverHomePage.selected_to_date().getAttribute("value");
        rentalCoverHomePage.vehicle_change_button().click();
        selectedVehicle = rentalCoverHomePage.SelectVehicleType(vehicleType.split(","));
        Helper.captureScreenShot(driver,"02verifyFilledQuoteForm");
        rentalCoverHomePage.get_quote_button().click();
        Assert.assertTrue(policyInformationAndPaymentPage.quote_summary_heading().isDisplayed());
    }

    @Test(priority = 2)
    @Parameters({"countryOfRental"})
    public void verifyQuoteSummary(String countryOfRental){
        //verify the values in quote summary
        Helper.captureScreenShot(driver,"03verifyQuoteSummary");
        Assert.assertEquals(policyInformationAndPaymentPage.country_of_rental().getText(),countryOfRental);
        Assert.assertEquals(Helper.getFormattedDate(fromDate,"yyyy-MM-dd"),Helper.getFormattedDate(policyInformationAndPaymentPage.start_date().getText(),"dd MMM yyyy"));
        Assert.assertEquals(Helper.getFormattedDate(toDate,"yyyy-MM-dd"),Helper.getFormattedDate(policyInformationAndPaymentPage.end_date().getText(),"dd MMM yyyy"));
        Assert.assertEquals(policyInformationAndPaymentPage.selected_vehicle().getText(),selectedVehicle);
    }

}
