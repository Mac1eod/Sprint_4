package ru.yandex.praktikum.plain;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.WebDriverFactory;
import ru.yandex.praktikum.page.MainPageGoScooter;
import ru.yandex.praktikum.page.OrderPage;
import ru.yandex.praktikum.page.RentPage;


public class OrderTest {
    private WebDriver webDriver;
    static final String URL_MAIN_PAGE = "https://qa-scooter.praktikum-services.ru/";
    static final String BROWSER = "Chrome"; //выбор браузера, подключены Chrome и Firefox

    @Before
    public void startUp() {
        webDriver = WebDriverFactory.getWebDriver(BROWSER);
        webDriver.get(URL_MAIN_PAGE);

    }
    @Test
    public void createOrderUpperButton () {
        //webDriver = new ChromeDriver();


        MainPageGoScooter mainPageGoScooter = new MainPageGoScooter(webDriver);
        mainPageGoScooter.cookiesButtonClick();
        mainPageGoScooter.clickUpperOrderButton();

        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.fillCustomerData("Иван", "Иванов", "Москва", "Лубянка", "12345678901");
        orderPage.nextButtonClick();

        RentPage rentPage = new RentPage(webDriver);
        rentPage.fillRentInfo("01.05.2024", "двое суток");
        rentPage.orderButtonClick();
        rentPage.yesButtonClick();
        Assert.assertTrue("Должно появиться окно подтверждения Заказа", rentPage.orderConfirmedWindow());
    }

    @Test
    public void createOrderLowerButton () {
        //webDriver = new ChromeDriver();

        MainPageGoScooter mainPageGoScooter = new MainPageGoScooter(webDriver);
        mainPageGoScooter.cookiesButtonClick();
        mainPageGoScooter.clickLowerOrderButton();

        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.fillCustomerData("Федор", "Петров", "Москва, ул.Центральная", "Курская", "10987654321");
        orderPage.nextButtonClick();

        RentPage rentPage = new RentPage(webDriver);
        rentPage.fillRentInfo("10.06.2024", "сутки");
        rentPage.orderButtonClick();
        rentPage.yesButtonClick();
        Assert.assertTrue("Должно появиться окно подтверждения Заказа", rentPage.orderConfirmedWindow());
    }

//*
    @After
    public void tearDown() {
        webDriver.quit();
    }
//*/
}

