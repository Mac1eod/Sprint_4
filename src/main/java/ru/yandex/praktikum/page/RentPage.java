package ru.yandex.praktikum.page;

import org.openqa.selenium.*;

public class RentPage {
    private final WebDriver webDriver;
    private final By dateInputLocator = By.xpath("//input[@placeholder = '* Когда привезти самокат']");
    private final By rentPeriodInputLocator = By.xpath("//div[text() = '* Срок аренды']");
    private final String rentPeriodItemLocator = "//div[text() = '%s']";
    private final By orderButtonLocator = By.xpath("//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Заказать']");
    private final By orderYesButtonLocator = By.xpath("//button[text() = 'Да']");


    public RentPage (WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillRentInfo(String date, String period) {
        WebElement dataInput = webDriver.findElement(dateInputLocator);
        dataInput.sendKeys(date, Keys.ENTER);

        WebElement periodInput = webDriver.findElement(rentPeriodInputLocator);
        periodInput.click();

        WebElement periodItem = webDriver.findElement(By.xpath(String.format(rentPeriodItemLocator, period)));
        periodItem.click();

    }

    public void orderButtonClick() {
        WebElement orderButton = webDriver.findElement(orderButtonLocator);
        orderButton.click();
    }

}
