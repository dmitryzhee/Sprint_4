package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RentDetailsPage {

  private WebDriver driver;

  //поле даты доставки самоката
  private By deliveryDate = By.cssSelector("[placeholder='* Когда привезти самокат']");

  //выпадающий календарь
  private By deliveryDateSelector = By.className("react-datepicker__month-container");

  //поле срока аренды
  private By rentDurationField = By.className("Dropdown-placeholder");

  //выпадающий список срока аренды
  private By rentDurationDropdown = By.xpath(".//div[@class='Dropdown-menu']");

  //чекбокс для цвета "черный жемчуг"
  private By colorBlack = By.xpath(".//div[@class='Order_Checkboxes__3lWSI']/label[@for='black']");

  //чекбокс для цвета "серая безысходность"
  private By colorGrey = By.xpath(".//div[@class='Order_Checkboxes__3lWSI']/label[@for='grey']");

  //поле комментария для клиента
  private By courierCommentField = By.cssSelector("[placeholder='Комментарий для курьера']");

  //кнопка подтвеждения заказа в нижней части формы
  private By bottomOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

  //подтверждение заказа
  private By confirmOrderButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']//button[text()='Да']");

  //всплывающее окно с сообщением об успешном создании заказа
  private By orderIsSuccessful = By.xpath(".//div[text()='Заказ оформлен']");

  public RentDetailsPage(WebDriver driver) {
    this.driver = driver;
  }

  public void selectCurrentDate() {
    driver.findElement(deliveryDate).click();
    WebElement calendar = driver.findElement(deliveryDateSelector);
    calendar.findElement(By.xpath(".//div[@class='react-datepicker__week']/div[@tabindex='0']")).click();
  }

  public void selectRentDuration(String rentDuration) {
    driver.findElement(rentDurationField).click();
    WebElement rentDurationOptions = driver.findElement(rentDurationDropdown);
    rentDurationOptions.findElement(By.xpath(".//div[text()='" + rentDuration + "']")).click();
  }

  public void selectColor (String color) {

    if (color == "black") {
      driver.findElement(colorBlack).click();
    } else if (color == "grey") {
      driver.findElement(colorGrey).click();
    }

  }

  public void leaveCommentForCourier (String comment) {
    driver.findElement(courierCommentField).click();
    driver.findElement(courierCommentField).sendKeys(comment);
  }

  public void pressBottomOrderButton () {
    driver.findElement(bottomOrderButton).click();
  }

  public void pressConfirmOrderButton() {
    driver.findElement(confirmOrderButton).click();
  }

  public void orderIsSuccessfulDiplayed () {
    driver.findElement(orderIsSuccessful).isDisplayed();
  }

  public void fillRentDetails (String rentDuration, String color, String comment) {
    selectCurrentDate();
    selectRentDuration(rentDuration);
    selectColor(color);
    leaveCommentForCourier(comment);
    pressBottomOrderButton();
  }





}
