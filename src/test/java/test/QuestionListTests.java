package test;

import PageObject.MainPageScooter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


@RunWith(Parameterized.class)
public class QuestionListTests {

    private By questionLocator;
    private By answerLocator;
    private String expectedAnswer;

    private WebDriver driver;

    public QuestionListTests (By questionLocator, By answerLocator,  String expectedAnswer) {
        this.questionLocator = questionLocator;
        this.answerLocator = answerLocator;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object [][] getQuestionData() {
        return new Object [][] {
                {By.id("accordion__heading-0"), By.xpath(".//div[@id='accordion__panel-0']/p"),
                        "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {By.id("accordion__heading-1"), By.xpath(".//div[@id='accordion__panel-1']/p"),
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {By.id("accordion__heading-2"), By.xpath(".//div[@id='accordion__panel-2']/p"),
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {By.id("accordion__heading-3"), By.xpath(".//div[@id='accordion__panel-3']/p"),
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {By.id("accordion__heading-4"), By.xpath(".//div[@id='accordion__panel-4']/p"),
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {By.id("accordion__heading-5"), By.xpath(".//div[@id='accordion__panel-5']/p"),
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {By.id("accordion__heading-6"), By.xpath(".//div[@id='accordion__panel-6']/p"),
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {By.id("accordion__heading-7"), By.xpath(".//div[@id='accordion__panel-7']/p"),
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области."},

        };
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void shouldBeCorrectAnswer () {
        MainPageScooter mainPageScooter = new MainPageScooter(driver);
        WebElement element = driver.findElement(questionLocator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        mainPageScooter.shouldBeCorrectAnswer(questionLocator, answerLocator, expectedAnswer);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
