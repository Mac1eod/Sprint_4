package ru.yandex.praktikum.page.plain;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.page.MainPageGoScooter;
import ru.yandex.praktikum.page.OrderPage;
import ru.yandex.praktikum.page.RentPage;


public class OrderTest {
    private WebDriver webDriver;
    private static final String URL_MAIN_PAGE = "https://qa-scooter.praktikum-services.ru/";
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void createOrderUpperButton () {
        webDriver = new ChromeDriver();
        webDriver.get(URL_MAIN_PAGE);

        MainPageGoScooter mainPageGoScooter = new MainPageGoScooter(webDriver);
        mainPageGoScooter.clickUpperOrderButton();

        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.fillCustomerData("Иван", "Иванов", "Москва", "Чертановская", "12345678901");
        orderPage.nextButtonClick();

        RentPage rentPage = new RentPage(webDriver);
        rentPage.fillRentInfo("01.05.2024", "двое суток");
        rentPage.orderButtonClick();
    }

    @Test
    public void createOrderLowerButton () {
        webDriver = new ChromeDriver();
        webDriver.get(URL_MAIN_PAGE);

        MainPageGoScooter mainPageGoScooter = new MainPageGoScooter(webDriver);
        mainPageGoScooter.clickLowerOrderButton();

        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.fillCustomerData("Федор", "Петров", "Москва, ул.Центральная", "Курская", "10987654321");
        orderPage.nextButtonClick();

        RentPage rentPage = new RentPage(webDriver);
        rentPage.fillRentInfo("10.06.2024", "сутки");
        rentPage.orderButtonClick();
    }

//*
    @After
    public void tearDown() {
        webDriver.quit();
    }
//*/
}

