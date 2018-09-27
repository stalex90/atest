package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CatalogObject {

    private SelenideElement searchField = $(byClassName("newMenu__trigger"));

    /**
     * Выбирает категорию из каталога товаров
     * @param mainCategory - главная категория
     * @param subCategory - дочерняя категория
     */
    public void selectCategory(String mainCategory, String subCategory){
        searchField.hover();
        $(byXpath("//span[text()='"+mainCategory+"']")).hover();
        $(byXpath("//span[text()='"+mainCategory+"']/..//*[text()='"+subCategory+"']")).click();
    }

}
