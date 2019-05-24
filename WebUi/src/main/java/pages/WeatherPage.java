package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeatherPage {

    @FindBy (xpath = "//input[@placeholder='Город или район']")
    private WebElement citySearchFireld;

    private  final WebDriver driver;

    public WeatherPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void typeCityIntoSearchField (String city) {
        citySearchFireld.sendKeys(city);
    }

    public SearchResultPage search() {
        citySearchFireld.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }
}
