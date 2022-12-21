package guiPages;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Home {
    private final String url = System.getProperty("googleUrl");
    //variables
    private WebDriver driver;

    //constructor
    public Home(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    public static By Google_logo_image() {
        return By.xpath("//img[@alt='عيد الأم 2022']");
    }

    private static By Google_Search_textBox() {
        return By.xpath("//input[@name='q']");
    }

    //keywords

    /**
     * navigate to Google Home
     *
     * @return self-refrence
     */
    public Home navigate() {
        BrowserActions.navigateToURL(driver, url);
        return this;
    }

    /**
     * searches for a given sting and pressing Enter
     *
     * @param query the sting that you want to search fpr
     * @return self-reference
     */

    public Results searchQuery(String query) {
        (new ElementActions(driver)).type(Google_Search_textBox(), query)
                .keyPress(Home.Google_Search_textBox(), Keys.ENTER);
        return new Results(driver);
    }

}
