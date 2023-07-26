package page_object;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class MainPageScooter {

    private WebDriver driver;

    public MainPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //верхнаяя кнопка "Заказать"
    private By topOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");

    //нижняя кнопка "Заказать"
    private By bottomOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");


    //Вопросы в разделе "Вопросы о важном"
    private By [] questionLocators = new By[] {By.id("accordion__heading-0"), By.id("accordion__heading-1"), By.id("accordion__heading-2"),
            By.id("accordion__heading-3"), By.id("accordion__heading-4"), By.id("accordion__heading-5"), By.id("accordion__heading-6"),
            By.id("accordion__heading-7")};
    //Ответы в разделе "Вопросы о важном"
    private By [] answerLocators = new By[] {By.xpath(".//div[@id='accordion__panel-0']/p"),  By.xpath(".//div[@id='accordion__panel-1']/p"),
            By.xpath(".//div[@id='accordion__panel-2']/p"), By.xpath(".//div[@id='accordion__panel-3']/p"),
            By.xpath(".//div[@id='accordion__panel-4']/p"), By.xpath(".//div[@id='accordion__panel-5']/p"),
            By.xpath(".//div[@id='accordion__panel-6']/p"), By.xpath(".//div[@id='accordion__panel-7']/p")};


    public By getAnswerLocator(int i ) {
        return answerLocators[i];
    }
    public By getQuestionLocator(int i) {
        return questionLocators[i];
    }

    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    public void clickBottomOrderButton() {
        WebElement element = driver.findElement(bottomOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(bottomOrderButton).click();
    }

    public void shouldBeCorrectAnswer(By questionLocator, By answerLocator, String expectedAnswer) {
        driver.findElement(questionLocator).click();
        String actualAnswer = driver.findElement(answerLocator).getText();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }



}