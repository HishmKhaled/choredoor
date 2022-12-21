package guiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Results {
    //variables
    private WebDriver driver;

    //constructor
    public Results(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    public static By result_stats_label() {
        return By.id("result-stats");
    }
    //keywords


}
