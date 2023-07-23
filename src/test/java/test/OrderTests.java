package test;

import PageObject.MainPageScooter;
import PageObject.CustomerDetailsPage;
import PageObject.RentDetailsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class OrderTests {

  private WebDriver driver;

  private String name;
  private String surname;
  private String address;
  private String station;
  private String phoneNumber;
  private String rentDuration;
  private String color;
  private String comment;

  public OrderTests (String name, String surname, String address, String station, String phoneNumber, String rentDuration, String color, String comment) {
    this.name = name;
    this.surname = surname;
    this.address = address;
    this.station = station;
    this.phoneNumber = phoneNumber;
    this.rentDuration = rentDuration;
    this.color = color;
    this.comment = comment;
  }
  @Parameterized.Parameters
  public static Object [][] getQuestionData() {
    return new Object [][] {
            {"Иван", "Иванов", "Арбат 1-1", "ВДНХ", "89051010202", "сутки", "black", "Привет курьер"},
            {"Вася", "Петров", "Пушкина 11", "Пушкинская", "89051010333", "двое суток", "grey", "Привет"}
    };
  }

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    driver.get("https://qa-scooter.praktikum-services.ru/");
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  }

  @Test
  public void makeOrder_success_topOrderButton() {
    MainPageScooter mainPageScooter = new MainPageScooter(driver);
    mainPageScooter.clickTopOrderButton();
    CustomerDetailsPage customerDetailsPage = new CustomerDetailsPage(driver);
    customerDetailsPage.fillOrderForm(name, surname, address, station, phoneNumber);
    customerDetailsPage.clickNextButton();
    RentDetailsPage rentDetailsPage = new RentDetailsPage(driver);
    rentDetailsPage.fillRentDetails(rentDuration, color , comment);
    rentDetailsPage.pressConfirmOrderButton();
    rentDetailsPage.orderIsSuccessfulDiplayed();
  }

  @Test
  public void makeOrder_success_bottomOrderButton() {
    MainPageScooter mainPageScooter = new MainPageScooter(driver);
    mainPageScooter.clickBottomOrderButton();
    CustomerDetailsPage customerDetailsPage = new CustomerDetailsPage(driver);
    customerDetailsPage.fillOrderForm(name, surname, address, station, phoneNumber);
    customerDetailsPage.clickNextButton();
    RentDetailsPage rentDetailsPage = new RentDetailsPage(driver);
    rentDetailsPage.fillRentDetails(rentDuration, color , comment);
    rentDetailsPage.pressConfirmOrderButton();
    rentDetailsPage.orderIsSuccessfulDiplayed();
  }



  @After
  public void tearDown() {
    driver.quit();
  }
}

