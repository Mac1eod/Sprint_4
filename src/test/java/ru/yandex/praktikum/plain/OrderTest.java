package ru.yandex.praktikum.plain;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.WebDriverFactory;
import ru.yandex.praktikum.page.MainPageGoScooter;
import ru.yandex.praktikum.page.OrderPage;
import ru.yandex.praktikum.page.RentPage;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver webDriver;
    static final String URL_MAIN_PAGE = "https://qa-scooter.praktikum-services.ru/";
    static final String BROWSER = "firefox"; //выбор браузера, подключены Chrome и Firefox
    private String name;
    private String  lastName;
    private String address;
    private String metroStation;
    private String phoneNumber;
    private String date;
    private String period;

    public OrderTest(String name, String lastName, String address, String metroStation, String phoneNumber, String date, String period) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.period = period;
    }

    @Parameterized.Parameters
    public static Object [][] date() {
        return new Object[][] {
                {"Иван", "Иванов", "Москва", "Лубянка", "12345678901", "01.05.2024", "двое суток"},
                {"Федор", "Федоров", "Москва, Ул. Центр", "Курская", "44445678901", "11.05.2025", "трое суток"}
        };

    }


    @Before
    public void startUp() {
        webDriver = WebDriverFactory.getWebDriver(BROWSER);
        webDriver.get(URL_MAIN_PAGE);

    }
    @Test
    public void createOrderUpperButton () {

        MainPageGoScooter mainPageGoScooter = new MainPageGoScooter(webDriver);
        mainPageGoScooter.cookiesButtonClick();
        mainPageGoScooter.clickUpperOrderButton();

        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.fillCustomerData(name, lastName, address, metroStation, phoneNumber);
        orderPage.nextButtonClick();

        RentPage rentPage = new RentPage(webDriver);
        rentPage.fillRentInfo(date, period);
        rentPage.orderButtonClick();
        rentPage.yesButtonClick();
        Assert.assertTrue("Должно появиться окно подтверждения Заказа", rentPage.orderConfirmedWindow());
    }

    @Test
    public void createOrderLowerButton () {

        MainPageGoScooter mainPageGoScooter = new MainPageGoScooter(webDriver);
        mainPageGoScooter.cookiesButtonClick();
        mainPageGoScooter.clickLowerOrderButton();

        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.fillCustomerData(name, lastName, address, metroStation, phoneNumber);
        orderPage.nextButtonClick();

        RentPage rentPage = new RentPage(webDriver);
        rentPage.fillRentInfo(date, period);
        rentPage.orderButtonClick();
        rentPage.yesButtonClick();
        Assert.assertTrue("Должно появиться окно подтверждения Заказа", rentPage.orderConfirmedWindow());
    }


    @After
    public void tearDown() {
        webDriver.quit();
    }

}

