package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexWeatherCityPage extends Page {

    public YandexWeatherCityPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/div[6]/div[1]/div[1]/div[2]/div[1]/div[2]/a/div[1]/span[1]")
    private WebElement temperature;

    public double getActualTemperature()
    {
        var temperatureText = temperature.getText().replace(',', '.');
        return Double.valueOf(temperatureText);
    }

}
