import Pages.*;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.open;

public class FindItemTest extends BaseTest {

    String nameItem = "BTH18 SUPREME 2S PRO";

    @BeforeMethod
    void setUpMethod(){
        getLogger().info("BeforeMethod");
        GeolocationObject geoObject = open("https://www.sportmaster.ru/", GeolocationObject.class);
        geoObject.confirmCity();
    }

    /**
     * Проверка доступности товара через поиск по полному имени
     */
    @Test
    void test_1() {
        SearchObject searchObject = new SearchObject();
        searchObject.makeSearch(nameItem);

        ItemListObject itemObject = new ItemListObject();
        itemObject.verifyItemPresent(nameItem);
        itemObject.verifyItemAvailable(nameItem);
        itemObject.clickOnItemLink(nameItem);

        ItemPageObject itemPageObject = new ItemPageObject();
        itemPageObject.selectSize();
        itemPageObject.clickBuy();
        itemPageObject.verifyItemAdded();
    }

    /**
     * Проверка доступности товара через поиск по категории и фильтрации по цене
     */
    @Test
    void test_2() throws InterruptedException {
        String category = "Коньки";
        SearchObject searchObject = new SearchObject();
        searchObject.makeSearch(category);

        ItemListObject itemObject = new ItemListObject();
        itemObject.setPriceFilter("45000","55000");
        itemObject.verifyItemPresent(nameItem);
        itemObject.verifyItemAvailable(nameItem);
        itemObject.clickQuickView(nameItem);

        QuickViewObject quickObject = new QuickViewObject();
        quickObject.selectAvailableSize();
        quickObject.clickBuy();
        quickObject.verifyItemAdded();
    }

    /**
     * Проверка доступности товара через каталог категория Зимний спорт - Хоккей
     */
    @Test
    void test_3() {
        String mainCategory = "Зимний спорт";
        String subCategory = "Хоккей";
        String category = "Коньки";

        CatalogObject catalogObject = new CatalogObject();
        catalogObject.selectCategory(mainCategory,subCategory);

        CategoryListObject categoryObject = new CategoryListObject();
        categoryObject.clickOnCategoryCard(category);

        ItemListObject itemObject = new ItemListObject();
        itemObject.verifyItemPresent(nameItem);
        itemObject.verifyItemAvailable(nameItem);
        itemObject.clickOnItemLink(nameItem);

        ItemPageObject itemPageObject = new ItemPageObject();
        itemPageObject.selectSize();
        itemPageObject.clickBuy();
        itemPageObject.verifyItemAdded();
    }

    /**
     * Проверка доступности товара через каталог категория Зимний спорт - Ледовые коньки - Хоккейные
     */
    @Test
    void test_4() {
        String mainCategory = "Зимний спорт";
        String subCategory = "Хоккейные";

        CatalogObject catalogObject = new CatalogObject();
        catalogObject.selectCategory(mainCategory,subCategory);

        ItemListObject itemObject = new ItemListObject();
        itemObject.setPriceFilter("45000","55000");
        itemObject.verifyItemPresent(nameItem);
        itemObject.verifyItemAvailable(nameItem);
        itemObject.clickQuickView(nameItem);

        QuickViewObject quickObject = new QuickViewObject();
        quickObject.selectAvailableSize();
        quickObject.clickBuy();
        quickObject.verifyItemAdded();
    }

    /**
     * Проверка доступности товара через каталог категория Командные виды спорта - Хоккей
     */
    @Test
    void test_5() {
        String mainCategory = "Командные виды спорта";
        String subCategory = "Хоккей";
        String category = "Коньки";

        CatalogObject catalogObject = new CatalogObject();
        catalogObject.selectCategory(mainCategory,subCategory);

        CategoryListObject categoryObject = new CategoryListObject();
        categoryObject.clickOnCategoryLink(category);

        ItemListObject itemObject = new ItemListObject();
        itemObject.verifyItemPresent(nameItem);
        itemObject.verifyItemAvailable(nameItem);
        itemObject.clickOnItemLink(nameItem);

        ItemPageObject itemPageObject = new ItemPageObject();
        itemPageObject.selectSize();
        itemPageObject.clickBuy();
        itemPageObject.verifyItemAdded();
    }

    /**
     * Проверка доступности товара через каталог категория Спорт от А до Я - Хоккей
     */
    @Test
    void test_6() {
        String mainCategory = "Спорт от А до Я";
        String subCategory = "Хоккей";
        String category = "Коньки";

        CatalogObject catalogObject = new CatalogObject();
        catalogObject.selectCategory(mainCategory,subCategory);

        CategoryListObject categoryObject = new CategoryListObject();
        categoryObject.clickOnCategoryLink(category);

        ItemListObject itemObject = new ItemListObject();
        itemObject.verifyItemPresent(nameItem);
        itemObject.verifyItemAvailable(nameItem);
        itemObject.clickOnItemLink(nameItem);

        ItemPageObject itemPageObject = new ItemPageObject();
        itemPageObject.selectSize();
        itemPageObject.clickBuy();
        itemPageObject.verifyItemAdded();
    }

    /**
     * Проверка доступности товара через поиск по бренду
     */
    @Test
    void test_7() throws InterruptedException {
        String brand = "Bauer";
        String category = "Ледовые коньки";

        BrandObject brandObject = new BrandObject();
        brandObject.clickAllBrands();
        brandObject.selectBrand(brand);

        CategoryListObject categoryObject = new CategoryListObject();
        categoryObject.clickOnCategoryLink(category);

        ItemListObject itemObject = new ItemListObject();
        itemObject.setPriceFilter("45000","55000");
        itemObject.verifyItemPresent(nameItem);
        itemObject.verifyItemAvailable(nameItem);
        itemObject.clickOnItemLink(nameItem);

        ItemPageObject itemPageObject = new ItemPageObject();
        itemPageObject.selectSize();
        itemPageObject.clickBuy();
        itemPageObject.verifyItemAdded();
    }

    /**
     * Проверка доступности товара через фильтрацию списка товаров
     */
    @Test
    void test_8() {
        String mainCategory = "Зимний спорт";
        String subCategory = "Ледовые коньки";
        String sport = "Хоккей";

        CatalogObject catalogObject = new CatalogObject();
        catalogObject.selectCategory(mainCategory,subCategory);

        ItemListObject itemObject = new ItemListObject();
        itemObject.clickFilterSport(sport);
        itemObject.setPriceFilter("45000","55000");
        itemObject.verifyItemPresent(nameItem);
        itemObject.verifyItemAvailable(nameItem);
        itemObject.clickQuickView(nameItem);

        QuickViewObject quickObject = new QuickViewObject();
        quickObject.selectAvailableSize();
        quickObject.clickBuy();
        quickObject.verifyItemAdded();
    }


}
