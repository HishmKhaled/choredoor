package testPackage;

import com.shaft.driver.DriverFactory;
import com.shaft.driver.ShaftDriver;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.JavaScriptWaitManager;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.ValidationEnums;
import com.shaft.validation.Validations;
import com.shaft.validation.Verifications;
import guiPages.Home;
import guiPages.Results;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
    private WebDriver driver;
    private JSONFileManager testData;


    @Description("check that Google Logo is Displayed using Shaft")
    @Test(description = "check that Google logo is dsiplayed using Shaft")
    public void checkThatGoogleLogoIsDisplayedWithShaft() {
        new Home(driver).navigate();
        Validations.assertThat().element(driver, Home.Google_logo_image()).exists()
                .withCustomReportMessage("Assert that google logo is displayed")
                .perform();
    }

    @Description("search for SHAFT ENGINE and check that Result Stats is not empty")
    @Test(description = "search for SHAFT ENGINE and check that Result Stats is not empty")
    public void checkThatResultStatsIsNotEmpty() {

        new Home(driver).navigate().searchQuery(testData.getTestData("x.searchQuery"));
        Validations.assertThat().element(driver, Results.result_stats_label())
                .text().doesNotEqual("")
                .withCustomReportMessage("Assert that result stat is not empty").perform();
    }
    @Test
    public void verifyLoginToCompanyAdminWithValidCredentials () {
       BrowserActions.navigateToURL(driver,"https://staffers-985f5-dev.firebaseapp.com/");
     // ElementActions.waitForElementToBePresent(driver,By.xpath("//span[@class = 'MuiTab-wrapper'and contains (.,'Login')]"),
       //       5,true);
       ElementActions.click(driver,By.xpath("//span[@class = 'MuiTab-wrapper'and contains (.,'Login')]"));
        ElementActions.type(driver,By.id("email"),"hesham+auto@staffersapp.com");
        ElementActions.type(driver,By.id("password"),"123456");
       // ElementActions.waitForElementToBePresent(driver, By.xpath("//button[@type= 'submit']"),300,true);
        JavaScriptWaitManager.waitForLazyLoading();
         ElementActions.keyPress(driver, By.xpath("//button[@type= 'submit']"), Keys.ENTER);

        Assertions.assertElementAttribute(driver,By.xpath("//p[@class = 'MuiTypography-root MuiTypography-body1' and contains (.,'Test Automation company')]"),
                String.valueOf(Verifications.ElementAttributeType.TEXT),"Test Automation company");

    }
    @Description("")
    @Test(description = "Veify that User can't submit the form without All mandatory fields")

    public void verifyFormaValidation() {
        BrowserActions.navigateToURL(driver,"https://www.britishfashioncouncil.co.uk/application_fashiontrustv2.aspx");
        ElementActions.click(driver,By.xpath("//button[@type='button' and contains (.,'I AGREE')]"));
        ElementActions.type(driver,By.id("ctl00_Main_txtBrandName"),"Hesham");
        ElementActions.click(driver, By.id("ctl00_Main_btnsubmit"));
        Validations.assertThat().element(driver,By.id("ctl00_Main_rfvComapnyCity")).text().contains("City is required").perform();

    }
    @Test
    public void navigateToFirstUrl() {
        BrowserActions.navigateToURL(driver,"https://geheimneuken.com/");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = DriverFactory.getDriver();
        BrowserActions.fullScreenWindow(driver);

    }

    @AfterMethod
    public void afterMethod() {
       // BrowserActions.closeCurrentWindow(driver);
    }
@BeforeClass
    public void beforeClass(){
        testData = new JSONFileManager("src/test/resources/testDataFiles/googleSearch.json");
}

}
