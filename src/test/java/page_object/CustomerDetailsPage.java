package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerDetailsPage {

  private WebDriver driver;

  //поле Имя
  private By nameField = By.cssSelector("[placeholder='* Имя']");

  //поле Фамилия
  private By surnameField = By.cssSelector("[placeholder='* Фамилия']");

  //поле Адерес
  private By addressField = By.cssSelector("[placeholder='* Адрес: куда привезти заказ']");

  //поле Станция метро
  private By stationNameField = By.cssSelector("[placeholder='* Станция метро']");

  //после станции метро с выпадающим списком
  private By stationNameDropdown = By.xpath(".//ul[@class='select-search__options']");

  //поле Телефон
  private By phoneNumberField = By.cssSelector("[placeholder='* Телефон: на него позвонит курьер']");

  //кнопка далее
  private By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


  public CustomerDetailsPage(WebDriver driver) {
    this.driver = driver;
  }

  public void fillNameField(String name) {
    driver.findElement(nameField).click();
    driver.findElement(nameField).sendKeys(name);
  }

  public void fillSurNameField(String surname) {
    driver.findElement(surnameField).click();
    driver.findElement(surnameField).sendKeys(surname);
  }

  public void fillAddressField(String address) {
    driver.findElement(addressField).click();
    driver.findElement(addressField).sendKeys(address);
  }

  public void fillStationNameField(String stationName) {
    driver.findElement(stationNameField).click();
    driver.findElement(stationNameField).sendKeys(stationName);
    WebElement stationDropdown = driver.findElement(stationNameDropdown);
    stationDropdown.findElement(By.xpath(".//div[text()='" + stationName + "']")).click();
}

  public void fillPhoneNumberField(String phoneNumber) {
    driver.findElement(phoneNumberField).click();
    driver.findElement(phoneNumberField).sendKeys(phoneNumber);
  }

  public void clickNextButton() {
    driver.findElement(nextButton).click();
  }


  public void fillOrderForm (String name, String surname, String address, String stationName, String phoneNumber) {
    fillNameField(name);
    fillSurNameField(surname);
    fillAddressField(address);
    fillStationNameField(stationName);
    fillPhoneNumberField(phoneNumber);
  }


}
