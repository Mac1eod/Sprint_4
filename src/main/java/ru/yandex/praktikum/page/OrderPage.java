package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    private  final WebDriver webDriver;
    //Ввод Имя
    private final By nameInputLocator = By.xpath("//input[@placeholder='* Имя']");

    //Ввод Фамилия
    private final By lastNameInputLocator = By.xpath("//input[@placeholder='* Фамилия']");

    //Ввод Адреса
    private final By addressInputLocator = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    //Поле станции метро
    private final By metroStationInputLocator = By.xpath("//input[@placeholder='* Станция метро']");

    //Элемент списка станций метро
    private final String metroStationItemLocator = "//div[text()='%s']";

    //Ввод телефона
    private final By phoneNumberInputLocator = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка далее
    private final By nextButtonLocator = By.xpath("//button[text() = 'Далее']");


    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillCustomerData(String name, String lastName, String address, String metroStation, String phoneNumber) {


        WebElement insertOrderName =  webDriver.findElement(nameInputLocator);
        insertOrderName.sendKeys(name);

        WebElement insertOrderLastName = webDriver.findElement(lastNameInputLocator);
        insertOrderLastName.sendKeys(lastName);

        WebElement insertOrderAddress = webDriver.findElement(addressInputLocator);
        insertOrderAddress.sendKeys(address);

        WebElement clickMetroStation = webDriver.findElement(metroStationInputLocator);
        clickMetroStation.click();

        WebElement setMetroStation = webDriver.findElement(By.xpath(String.format(metroStationItemLocator, metroStation)));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", setMetroStation);
        setMetroStation.click();

        WebElement insertPhone = webDriver.findElement(phoneNumberInputLocator);
        insertPhone.sendKeys(phoneNumber);

    }

    public void nextButtonClick() {
        WebElement nextButton = webDriver.findElement(nextButtonLocator);
        nextButton.click();
    }
}
