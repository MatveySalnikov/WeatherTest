package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GismeteoCityPage extends Page {

    public GismeteoCityPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/section/div[2]/div/div[1]/div/div[2]/div[1]/div[1]/a[1]/div/div[1]/div[3]/div[1]/span[1]/span")
    private WebElement temperature;

    public double getActualTemperature()
    {
        var temperatureText = temperature.getText().replace(',', '.');
        return Double.valueOf(temperatureText);
    }

}
