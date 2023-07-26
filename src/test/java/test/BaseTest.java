package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

  protected static WebDriver driver;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    driver.get("https://qa-scooter.praktikum-services.ru/");
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}
