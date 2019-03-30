import Pages.GismeteoMainPage;
import Pages.YandexWeatherMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tests {

    private WebDriver driver;

    @BeforeSuite
    public void initializeDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void compareWeatherTest(){
        double gismeteoTemperature = new GismeteoMainPage(driver).open().selectCity("Волгоград", "5089").getActualTemperature();
        double yandexTemperature = new YandexWeatherMainPage(driver).open().selectCity("Волгоград", "38").getActualTemperature();
        Assert.assertEquals(gismeteoTemperature, yandexTemperature);
    }

    @AfterSuite
    public void quitDriver()
    {
        driver.quit();
    }
}
