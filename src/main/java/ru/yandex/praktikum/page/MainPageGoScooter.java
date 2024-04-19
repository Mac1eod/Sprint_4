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

    private By orderUpperButtonLocator = By.xpath("//button[@class='Button_Button__ra12g' and text() = 'Заказать']");
    private By orderlowerButtonLocator = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Заказать']");


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

}
