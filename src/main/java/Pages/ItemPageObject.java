package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ItemPageObject {
    private String successfulMessageText = "Товар добавлен в корзину";

    private SelenideElement availableSize = $(byXpath("//div[@data-selenium='enabled_product_size']"));
    private SelenideElement buyButton = $(byXpath("//div[@class='sm-goods_main_details_buttons clearfix']/a[1]"));
    private SelenideElement successfulMessage = $(byXpath("//div[@id='basketMessage']/h1"));

    /**
     * Метод выбирает первый доступный размер в карточке товара
     */
    public void selectSize(){
        availableSize.click();
    }

    /**
     * Метод нажимает на кнопку купить в карточке товара
     */
    public void clickBuy(){
        buyButton.click();
    }

    /**
     * Метод проверяет получение сообщение об успешном добавлении товара в корзину
     */
    public void verifyItemAdded(){
        successfulMessage.shouldHave(Condition.exactText(successfulMessageText));
    }

}
