package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GismeteoMainPage extends Page {

    public GismeteoMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "js-search")
    private WebElement searchField;


    public GismeteoMainPage open(){
        driver.navigate().to("https://www.gismeteo.ru/");
        return this;
    }

    public GismeteoCityPage selectCity(String cityName, String cityId){
        searchField.sendKeys(cityName);
        var cityXpath = String.format("//*[@id=\"js-search-list\"]/div[2]/a[@data-id=\"%s\"]", cityId);
        driver.findElement(By.xpath(cityXpath)).click();
        return new GismeteoCityPage(driver);
    }
}
