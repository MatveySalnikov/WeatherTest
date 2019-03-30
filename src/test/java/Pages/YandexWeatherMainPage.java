package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexWeatherMainPage extends Page {

    public YandexWeatherMainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "header2input")
    private WebElement serchField;

    public YandexWeatherMainPage open(){
        driver.navigate().to("https://yandex.ru/pogoda/");
        return this;
    }

    public YandexWeatherCityPage selectCity(String cityName, String cityId){
        serchField.sendKeys(cityName);
        serchField.click();
        var cityXpath = String.format("/html/body/div[3]/div/div/ul/li[a/@href=\"https://yandex.ru/pogoda/%s/?\"]/a", cityId);
        driver.findElement(By.xpath(cityXpath)).click();
        return new YandexWeatherCityPage(driver);
    }

}
