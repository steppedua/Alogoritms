package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GoogleTest {

    @BeforeEach
    public void setup() {
        // Установка браузера по умолчанию
//        Configuration.browser = "firefox";

        // Открытие браузера в полноэкранном режиме
        Configuration.startMaximized = true;

        // Открытие ссылки в браузере
        open("http://automationpractice.com");
    }

    @Test
    public void checkIfIOnWomenPage() {
        // Клик по кнопке по ссылке по слову Women на сайте
        $(By.linkText("Women")).click();

        // Проверка на существование в элементе h2 с классом title_block слова WOMEN
        $(By.xpath("//h2[@class='title_block']")).shouldHave(text("WOMEN"));
    }

    @Test
    public void searchProduct() {
        //Ввод в селекторе(input) search_query_top слово Blouse
        $("#search_query_top").setValue("Blouse").pressEnter();
        // ИЛИ
//        $(By.id("search_query_top")).setValue("Blouse").pressEnter();
        // ИЛИ
//        element(By.id("search_query_top")).setValue("Blouse").pressEnter();


        // Проверка, что есть картинка
        $(By.xpath("//img[@title='Blouse']")).shouldBe(visible);

        // Проверка, что есть текст
        $(byText("1 result has been found.")).should(exist);
    }

    @Test
    public void addProductToCart() {

        // Клик по кнопке по ссылке по слову Faded Short Sleeve T-shirts на сайте
        SelenideElement product = $(By.linkText("Faded Short Sleeve T-shirts"));

        // Переход(пролистывание, скролл мышкой) к первому продукту(элементу)
        product.scrollTo();

        // Переместить мышь к первому продукту
        actions().moveToElement(product).perform();

        // Нажать на элемент быстрого просмотра на продукте
        $(By.xpath("(//a[@class='quick-view'])[1]")).click();


        // Найти элемент cssSelector = "iframe", а потом выдать первый из iframe
//        List<SelenideElement> iframes = $$(By.cssSelector("iframe"));
        // ИЛИ
//        List<SelenideElement> iframes = elements(By.cssSelector("iframe"));

        // Перейти на iFrame второй
//        switchTo().frame(iframes.get(1));

        // Или использовать вместо 77 строки и 72 строки
        switchTo().frame($(By.className("fancybox-iframe")));

        // Заполнить значение "количесво - quantity"
        $("#quantity_wanted").setValue("2");

        // Выбрать из выпадающего списка размеров: XS, S, M, L, XL, XXL
        $("#group_1").selectOption("M");

        // Кликнуть на добавить продукт
        $("#add_to_cart").click();

        // Кликнуть на кнопку оформления заказа
//        $(By.xpath("//*[contains(text(), 'Proceed to checkout')]")).click();
        // ИЛИ
        $(byText("Proceed to checkout")).click();

        // Проверяем, есть ли 2 продукта в корзине(У нас это находится в текством виде в корзине)
        $("#summary_products_quantity").shouldHave(text("2 Products"));
    }

    @Test
    public void testIfProductHasSocialNetworkButtons() {
        // Почитать тут про коллекции
        // - https://selenide.gitbooks.io/user-guide/content/ru/selenide-api/elements-collection.html

        // Лист с элементами cssSelector .product_img_link
//        List<SelenideElement> products = $$(".product_img_link");


        // Фильтрация по атрибуту title для товара Blouse, потом выбираем первый из товаров "блузка" и кликаем на неё
        $$(".product-name").filterBy(attribute("title", "Blouse")).first().click();

        // Лист с элементами xpath, но можно и с cssSelector
//        List<SelenideElement> buttons = $$(By.xpath("//button[@type='button']"));

        // По кнопке button проверить, что существует 4 кнопки с точными названиями: "Tweet","Share", "Google+", "Pinterest"
//        $$(".socialsharing_product.list-inline.no-print>button").shouldHave(exactTexts("Tweet","Share", "Google+", "Pinterest"));
        // ИЛИ
        $$(By.xpath("//button[@type='button']")).shouldHave(exactTexts("Tweet", "Share", "Google+", "Pinterest"));
    }

}