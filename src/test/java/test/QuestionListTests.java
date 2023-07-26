package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import page_object.MainPageScooter;


@RunWith(Parameterized.class)
public class QuestionListTests extends BaseTest {

    private By questionLocator;
    private By answerLocator;
    private String expectedAnswer;

    public QuestionListTests (By questionLocator, By answerLocator,  String expectedAnswer) {
        this.questionLocator = questionLocator;
        this.answerLocator = answerLocator;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object [][] getQuestionData() {
        MainPageScooter mainPageScooter = new MainPageScooter(driver);
        return new Object [][] {
                {mainPageScooter.getQuestionLocator(0), mainPageScooter.getAnswerLocator(0),
                        "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {mainPageScooter.getQuestionLocator(1), mainPageScooter.getAnswerLocator(1),
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {mainPageScooter.getQuestionLocator(2), mainPageScooter.getAnswerLocator(2),
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {mainPageScooter.getQuestionLocator(3), mainPageScooter.getAnswerLocator(3),
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {mainPageScooter.getQuestionLocator(4), mainPageScooter.getAnswerLocator(4),
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {mainPageScooter.getQuestionLocator(5), mainPageScooter.getAnswerLocator(5),
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {mainPageScooter.getQuestionLocator(6), mainPageScooter.getAnswerLocator(6),
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {mainPageScooter.getQuestionLocator(7), mainPageScooter.getAnswerLocator(7),
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области."},

        };
    }

    @Test
    public void shouldBeCorrectAnswer () {
        MainPageScooter mainPageScooter = new MainPageScooter(driver);
        WebElement element = driver.findElement(questionLocator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        mainPageScooter.shouldBeCorrectAnswer(questionLocator, answerLocator, expectedAnswer);
    }
}
