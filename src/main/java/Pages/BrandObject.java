package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BrandObject {

    private SelenideElement allBrandsButton = $(byXpath("//div[@class='slot-1-1']//a[text()='Все бренды']"));

    /**
     * Нажимает на бренд из списка брендов
     * Прокрутка для IE в котором панель перекрывает кнопку
     * @param brandName - название бренда
     */
    public void selectBrand(String brandName) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) getWebDriver();
        jse.executeScript("scroll(0, 500)");
        $(byXpath("//nav/a[text()='"+brandName+"']")).click();
    }

    /**
     * Нажимает на кнопку "Все бренды" на главной странице
     * Прокрутка для IE в котором панель перекрывает кнопку
     */
    public void clickAllBrands(){
        JavascriptExecutor jse = (JavascriptExecutor) getWebDriver();
        jse.executeScript("scroll(0, 100)");
        allBrandsButton.click();
    }

}
