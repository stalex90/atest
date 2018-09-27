package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class SearchObject {
    private SelenideElement searchField = $(byXpath("//form[@id='productSearchContainer']/input[@type='text']"));
    private SelenideElement searchSend = $(byXpath("//form[@id='productSearchContainer']/input[@type='submit']"));

    /**
     * Метод вводит в поле поиска текст
     * @param text - вводимый текст
     */
    public void setSearchField(String text){
        searchField.click();
        searchField.val(text);
    }

    /**
     * Метод нажимает на иконку лупы в строке поиска
     */
    public void clickSearchSend(){
        searchSend.click();
    }

    /**
     * Метод производит поиск по заданному тексту
     * @param text - вводимый текст
     */
    public void makeSearch(String text){
        setSearchField(text);
        clickSearchSend();
    }

    /**
     * Метод выбирает категорию в выпадающем меню поиска
     * @param nameCategory - название категории
     */
    public void selectSearchedCategory(String nameCategory){
        $(byXpath("//div[@class='digi-ac_categories digi-autocomplete-block']//div[contains(@data-fulltext,'"+nameCategory+"')]")).click();
    }
}
