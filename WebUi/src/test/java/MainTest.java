import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SearchResultPage;
import pages.StartPage;
import pages.WeatherPage;

import java.util.concurrent.TimeUnit;

public class MainTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setDriver() throws Exception {
        driver = new ChromeDriver();
    }

    @Before
    public void setUp() throws Exception {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://yandex.ru/");
    }

    //public MainTest() {
    //  System.setProperty("webdriver.chrome.driver", "C:\\users\\fedorovskiiai\\chromedriver\\chromedriver.exe");
    //}

    /*@Test
    public void nspkTest() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://yandex.ru/");
        driver.findElement(By.xpath("//a[text()='Погода']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Город или район']")).sendKeys("Нью-Йорк");
        driver.findElement(By.xpath("//input[@placeholder='Город или район']")).sendKeys(Keys.ENTER);
        String actualString = driver.findElement(By.xpath("//div[@class='place-list place-list_ancient-design_yes']" +
                "/li[@class='place-list__item']")).getText();
        Assert.assertTrue("КОСЯК", actualString.contains("Нью-Йорк, Штат Нью-Йорк, США"));

        driver.quit();

    }*/

    @Test
    public void newCityCheck(){
        StartPage startPage = new StartPage(driver);
        WeatherPage weatherPage = startPage.clickonWeatherButton();
        weatherPage.typeCityIntoSearchField("Нью-Йорк");
        SearchResultPage searchResultPage = weatherPage.search();
        String actualText = searchResultPage.getFirstFoundCityText();
        Assert.assertTrue("КОСЯК", actualText.contains("Нью-Йорк, Штат Нью-Йорк, США"));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
