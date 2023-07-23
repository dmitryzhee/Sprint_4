package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageScooter {

    private WebDriver driver;

    public MainPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //верхнаяя кнопка "Заказать"
    private By topOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");

    //нижняя кнопка "Заказать"
    private By bottomOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");



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