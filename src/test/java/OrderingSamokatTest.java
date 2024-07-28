import org.junit.Test;
import pageObjects.MainPage;
import pageObjects.OrderPage;
import pageObjects.RentPage;

import static org.junit.Assert.assertTrue;

public class OrderingSamokatTest extends CommonTest {

    // Тест заказа через кнопку в заголовке
    @Test
    public void samokatOrderingByHeaderOrderButton() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickHeaderOrderButton();

        new OrderPage(driver)
                .sendClientFirstName("Алина")
                .sendClientLastName("Алина")
                .sendDeliveryAddress("Москва, Абельмановская, 1")
                .selectMetroStation("Черкизовская")
                .sendDeliveryClientPhoneNumber("89221054580")
                .clickNextButton();

        boolean isDisplayed = new RentPage(driver)
                .sendRentalDate("08.08.2024")
                .setRentalTime()
                .clickCheckBoxColourBlackPearl()
                .sendComment("АлинаАлина")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Ошибка открытия окна", isDisplayed);
    }
    // Тест заказа через кнопку в середине страницы
    @Test
    public void samokatOrderingByMiddleOrderButton() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickMiddleOrderButton();

        new OrderPage(driver)
                .sendClientFirstName("Алина")
                .sendClientLastName("Алина")
                .sendDeliveryAddress("Москва, Абельмановская, 1")
                .selectMetroStation("Черкизовская")
                .sendDeliveryClientPhoneNumber("89221054580")
                .clickNextButton();

        boolean isDisplayed = new RentPage(driver)
                .sendRentalDate("08.08.2024")
                .setRentalTime()
                .clickCheckBoxColourGreyDespair()
                .sendComment("АлинаАлина")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Ошибка открытия окна", isDisplayed);
    }
}