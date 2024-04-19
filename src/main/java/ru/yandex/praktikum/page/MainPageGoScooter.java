package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageGoScooter {
    private  final WebDriver webDriver;

    private By orderUpperButtonSelector = By.xpath("//button[@class='Button_Button__ra12g' and text() = 'Заказать']");
    private By orderlowerButtonSelector = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Заказать']");


    public MainPageGoScooter(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickUpperOrderButton() {
        webDriver.findElement(orderUpperButtonSelector).click();
    }
    public void clickLowerOrderButton() {

        WebElement element = webDriver.findElement(orderlowerButtonSelector);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

}
