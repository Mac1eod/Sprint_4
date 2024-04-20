package ru.yandex.praktikum.page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RentPage {
    private final WebDriver webDriver;
    //Ввод даты
    private final By dateInputLocator = By.xpath("//input[@placeholder = '* Когда привезти самокат']");

    //Ввод срока аренды
    private final By rentPeriodInputLocator = By.xpath("//div[text() = '* Срок аренды']");

    //Элемент спсика срока аренды
    private final String rentPeriodItemLocator = "//div[text() = '%s']";

    //Кнопка Заказать
    private final By orderButtonLocator = By.xpath("//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Заказать']");

    //Кнопка Да
    private final By orderYesButtonLocator = By.xpath("//button[text() = 'Да']");

    //Окно Заказ оформлен
    private final By orderConfirmedLocator = By.xpath("//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");


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

    public void yesButtonClick() {
        WebElement yesButton = webDriver.findElement(orderYesButtonLocator);
        yesButton.click();
    }

    public boolean orderConfirmedWindow() {
        WebElement orderConfirmed = webDriver.findElement(orderConfirmedLocator);
        return  orderConfirmed.isDisplayed();
    }


}
