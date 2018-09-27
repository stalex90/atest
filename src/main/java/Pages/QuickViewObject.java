package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class QuickViewObject {
    private String successfulMessageText = "Товар добавлен в корзину";

    private SelenideElement availableSize = $(byXpath("//div[@class='sm-goods__param-value']"));
    private SelenideElement buyButton = $(byXpath("//div[@class='sm-goods_main_details_buttons clearfix']/sm-buybutton/a"));
    private SelenideElement successfulMessage = $(byXpath("//div[@id='basketMessage']/h1"));

    /**
     * Метод выбирает первый доступный размер в быстром просмотре товара
     */
    public void selectAvailableSize(){
        availableSize.click();
    }

    /**
     * Метод нажимает на кнопку купить в быстром просмотре
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
