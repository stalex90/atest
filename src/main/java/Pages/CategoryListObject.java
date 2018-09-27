package Pages;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CategoryListObject {

    /**
     * Нажимает на карточку категории
     * @param nameCategory - название категории
     */
    public void clickOnCategoryCard(String nameCategory) {
        $(byXpath("//td[@class='first-child']//a[contains(text(),'"+nameCategory+"')]")).click();
    }

    /**
     * Нажимает на название категории в списке слева
     * @param nameCategory - название категории
     */
    public void clickOnCategoryLink(String nameCategory) {
        $(byXpath("//div[@class='sm-subcategory__left']//a[contains(text(),'"+nameCategory+"')]")).click();
    }


}
