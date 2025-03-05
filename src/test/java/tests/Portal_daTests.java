package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CookiePopUp;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Portal_daTests extends TestBase {
  CookiePopUp cookie = new CookiePopUp();


  @Test
  @DisplayName("Проверка поиска {} по категории каталога")
  void searchCatalogTest() {

    open("/");
    cookie.checkCookiePopupDisplay();
    cookie.acceptCookie();
    $(".search-bar-item__right").click();
    $(byText("Офисное помещение")).click();

    $(".content-layout__title").shouldHave(text("Офисное помещение"));
    $$(".catalog-grid").shouldHave(texts("Офисное помещение"));
    Selenide.clearBrowserCookies();
    Selenide.closeWebDriver();
  }

  @Test
  @DisplayName("Проверка поиска {} по строке ввода")
  void searchByInputString() {
    open("/");
    cookie.checkCookiePopupDisplay();
    cookie.acceptCookie();
    $(".text-input__input").click();
    $("#query").setValue("Офисное помещение");
    $(".ml-4").click();
    $$(".catalog-grid").shouldHave(texts("Офисное помещение"));
    Selenide.clearBrowserCookies();
    Selenide.closeWebDriver();
  }

  @Test
  @DisplayName("Проверка контроллов")
  void checkControl() {
    Configuration.pollingInterval = 500;
    open("/");
    cookie.checkCookiePopupDisplay();
    cookie.acceptCookie();
    sleep(1500);
    $(".search-bar-item__right").click();
//    $(byText("Офисное помещение")).click();
    sleep(1500);
    $(".v-select__slot").scrollIntoView(true);
    ;
    $(".v-select__slot").click();
    $(byText("54")).click();
    sleep(1500);
    $(".listing-footer-controls__count").shouldHave(text("Показано 54"));

    closeWebDriver();
  }
  @Test
  @DisplayName("Проверка поиска {} в локации {}")
  void checkSearchWithLocation() {
    open("/");
    cookie.checkCookiePopupDisplay();
    cookie.acceptCookie();
  //  $(".mr-2.icon.icon-catalog-list.icon-24").click();
    $(byText("Фильтры")).click();
    $(".base-dialog-card--nopadding").shouldBe(visible);
    $(byText("Все регионы и населенные пункты")).shouldBe(visible).click();
    $(byText("Москва")).click();
    $(byText("Готово")).click();
    $("#app").$(".filter-box.ui-clickable").sibling(2).click();
    $("#filter-sale_type-direct_purchase").click();
    $("#filter-sale_type-trade").click();
    $("#filter-sale_type-bidding").click();
    $(byText("Готово")).click();

  }
}