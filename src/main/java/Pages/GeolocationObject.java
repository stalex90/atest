package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GeolocationObject {
    private SelenideElement confirmCityButton = $(byXpath("//input[@data-selenium='confirm_default_city']"));

    /**
     * Метод подтверждает предложенный город
     * Условие нужно при параллельном выполнении, т.к окно пропадает через некоторое время
     */
    public void confirmCity(){
        if (confirmCityButton.isDisplayed()) {
            confirmCityButton.click();
        }
    }

}
