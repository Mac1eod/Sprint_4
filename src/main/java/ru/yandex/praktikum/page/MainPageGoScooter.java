package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;

public class MainPageGoScooter {
    private  final WebDriver webDriver;

    //Кнопка Coockies
    private By cookiesButtonLocator = By.id("rcc-confirm-button");

    //Верхняя кнопка Заказать
    private By orderUpperButtonLocator = By.xpath("//button[@class='Button_Button__ra12g' and text() = 'Заказать']");

    //Нижняя кнопка Заказать
    private By orderlowerButtonLocator = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Заказать']");

    //Вопросы о важном - вопрос
    private final String questionLocator = "accordion__heading-%s";

    //Вопросы о важном - ответ
    private final String answerLocator = "//div[contains(@id, 'accordion__panel')][.='%s']";

    public MainPageGoScooter(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickUpperOrderButton() {
        webDriver.findElement(orderUpperButtonLocator).click();
    }

    public void clickLowerOrderButton() {
        WebElement element = webDriver.findElement(orderlowerButtonLocator);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(webDriver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(orderlowerButtonLocator));
        element.click();
    }

    public void cookiesButtonClick() {
        webDriver.findElement(cookiesButtonLocator).click();
    }

    public void questionExpand(int index) {
    WebElement element = webDriver.findElement(By.id(String.format(questionLocator, index)));
    ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    new WebDriverWait(webDriver, ofSeconds(35)).until(ExpectedConditions.elementToBeClickable(element)); //с низким значением задержки в Мозиле периодически не все вопросы Аккордиона проходят
    element.isDisplayed(); //с данным методом в Мозиле тест Аккордиона более стабилен
    element.click();
    }

    public boolean answerCheck(String expectedAnswer) {
    WebElement element = webDriver.findElement(By.xpath(String.format(answerLocator, expectedAnswer)));
    return element.isDisplayed();
    }

}
