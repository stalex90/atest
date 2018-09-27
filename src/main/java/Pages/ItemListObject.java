package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ItemListObject {

    private SelenideElement show120 = $(byXpath("//div[@class='sm-category__main-sorting_split']/a[contains(text(),'120')]"));

    /**
     * Метод проверяет отображаения изображения и ссылки товара
     * @param nameItem - название товара
     */
    public void verifyItemPresent(String nameItem) {
        $(byXpath("//div[@id='categoryItemContainer']//a[contains(text(),'"+nameItem+"')]")).should(visible);
        $(byXpath("//div[@id='categoryItemContainer']//img[contains(@alt,'"+nameItem+"')]")).should(visible);
    }

    /**
     * Метод проверяет отстутсвие сообщения "нет в наличии" для товара
     * @param nameItem - название товара
     */
    public void verifyItemAvailable(String nameItem) {
        $(byXpath("//div[@id='categoryItemContainer']//a[contains(text(),'"+nameItem+"')]/../..//div[@class='sm-category__item-subscription-available']")).shouldNot(visible);
    }

    /**
     * Метод нажимает на название товара
     * @param nameItem - название товара
     */
    public void clickOnItemLink(String nameItem) {
        $(byXpath("//div[@id='categoryItemContainer']//a[contains(text(),'"+nameItem+"')]")).click();
    }

    /**
     * Метод нажимает на изображение товара
     * @param nameItem - название товара
     */
    public void clickOnItemImage(String nameItem) {
        $(byXpath("//div[@id='categoryItemContainer']//img[contains(@alt,'"+nameItem+"')]")).click();
    }

    /**
     * Метод нажимает на быстрый просмотр товара
     * Прокрутка нужна для IE т.к панель верхняя перекрывает элементы
     * @param nameItem - название товара
     */
    public void clickQuickView(String nameItem) {
        JavascriptExecutor jse = (JavascriptExecutor) getWebDriver();
        jse.executeScript("scroll(100, 0)");
        $(byXpath("//div[@id='categoryItemContainer']//img[contains(@alt,'"+nameItem+"')]")).hover();
        $(byXpath("//img[contains(@alt,'"+nameItem+"')]/../div[@class='quickView']/div")).click();
    }

    /**
     * Нажимает на линк показывать по 120
     */
    public void clickShow120() {
        show120.click();
    }

    /**
     * Фильтрует список товаров по виду спорта
     * @param sportName - название вида спорта
     */
    public void clickFilterSport(String sportName){
        JavascriptExecutor jse = (JavascriptExecutor) getWebDriver();
        jse.executeScript("scroll(0, 400)");
        $(byXpath("//h3[@data-facetid='nevisp']/../div/a[contains(@onclick,'"+sportName+"')]")).click();
    }

    public void setPriceFilter(String min, String max){
        $(byId("minprice")).val(min);
        $(byId("maxprice")).val(max);
        $(byXpath("//form[@id='priceForm']//a[contains(text(),'Применить')]")).click();

    }
}
