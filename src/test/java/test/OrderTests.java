package test;

import page_object.MainPageScooter;
import page_object.CustomerDetailsPage;
import page_object.RentDetailsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderTests extends BaseTest{

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

  @Test
  public void makeOrderSuccessTopOrderButton() {
    MainPageScooter mainPageScooter = new MainPageScooter(driver);
    mainPageScooter.clickTopOrderButton();
    CustomerDetailsPage customerDetailsPage = new CustomerDetailsPage(driver);
    customerDetailsPage.fillOrderForm(name, surname, address, station, phoneNumber);
    customerDetailsPage.clickNextButton();
    RentDetailsPage rentDetailsPage = new RentDetailsPage(driver);
    rentDetailsPage.fillRentDetails(rentDuration, color , comment);
    rentDetailsPage.pressConfirmOrderButton();
    rentDetailsPage.orderIsSuccessfulDisplayed();
  }

  @Test
  public void makeOrderSuccessBottomOrderButton() {
    MainPageScooter mainPageScooter = new MainPageScooter(driver);
    mainPageScooter.clickBottomOrderButton();
    CustomerDetailsPage customerDetailsPage = new CustomerDetailsPage(driver);
    customerDetailsPage.fillOrderForm(name, surname, address, station, phoneNumber);
    customerDetailsPage.clickNextButton();
    RentDetailsPage rentDetailsPage = new RentDetailsPage(driver);
    rentDetailsPage.fillRentDetails(rentDuration, color , comment);
    rentDetailsPage.pressConfirmOrderButton();
    rentDetailsPage.orderIsSuccessfulDisplayed();
  }


}

