package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.CookiePopUp;
import pages.SearchCatalog;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Portal_daTests extends TestBase {
  CookiePopUp cookie = new CookiePopUp();
  SearchCatalog search=new SearchCatalog();


  @Test
  @Feature("Проверка поиска товара")
  @Story("Позитивный тест")
  @Owner("@perepelovaAS")
  @Severity(SeverityLevel.CRITICAL)
  @Link(url = "https://portal-da.ru")
  @DisplayName("Проверка поиска {active} по категории каталога")
  void searchCatalogTest() {

    open("/");
    cookie.checkCookiePopupDisplay();
    cookie.acceptCookie();
    search.clickOnSearchBarItem();
    search.verifyCatalogContainsOfficeRooms();
    Selenide.clearBrowserCookies();
    Selenide.closeWebDriver();
  }

  @Test
  @Feature("Проверка поиска товара")
  @Story("Позитивный тест")
  @Owner("@egorovma")
  @Severity(SeverityLevel.CRITICAL)
  @Link(url = "https://sport-marafon.ru/")
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
    $(".search-bar-item__right").click();
    $(byText("Офисное помещение")).click();
    sleep(1500);
    $(".v-select__slot").shouldBe(visible);
    $(".v-select__slot").scrollIntoView(true);

    $(".v-input__control").shouldBe(visible);
    $(".v-input__control").click();
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
    $(byText("Фильтры")).click();
    $(".base-dialog-card--nopadding").shouldBe(visible);
    $(byText("Все регионы и населенные пункты")).shouldBe(visible).click();
    $(byText("Москва")).click();
    $(byText("Готово")).click();
//    $("[test_id='filter_price']").shouldBe(interactable);
//    $("[test_id='filter_sale_type']").click();

    $("[test_id='filter_price']").shouldBe(interactable);
    $("[test_id='filter_price']").click();
    $(".search-bar-dropdown-dialog").shouldBe(visible);
    $(".search-bar-dropdown-dialog input").sendKeys(Keys.BACK_SPACE);

    $$("[test_id='filter_price'] input").get(0).setValue("11");
    for(int i=1;i<5;i++)
    {
      $$("[test_id='filter_price'] input").get(1).sendKeys(Keys.BACK_SPACE);
    }
   $$("[test_id='filter_price'] input").get(1).setValue("55555");
//    $(".range-slider__input--min")
//    .shouldBe(interactable).sendKeys("1");
//    $(".range-slider__input--max").setValue("55555");
//    sleep(2000);
   $(byText("Готово")).click();
//    sleep(2000);

    $("[test_id='filter_sale_type']").shouldBe(interactable);
    $("[test_id='filter_sale_type']").click();
    $("#filter-sale_type-direct_purchase").click();
    $("#filter-sale_type-trade").click();
    $("#filter-sale_type-bidding").click();
    $(byText("Готово")).click();
    $("[test_id='filter_seller']").shouldBe(interactable);
    $("[test_id='filter_seller']").click();
    $(".search-bar-sellers-dropdown").shouldBe(interactable);
    $(byText("По типу")).click();
    $("#filter-seller_type-bank").click();
    $("#filter-seller_type-government").click();
    $("#filter-seller_type-company").click();
    $("#filter-seller_type-arbitration_manager").click();
    $("#filter-seller_type-user").click();
    $("#filter-seller_type-other").click();
    $(byText("Готово")).click();
    $(("[test_id='filter_pledge_status']"))
      .shouldHave(text("Да"))
      .click();
    $(("[test_id='filter_bankruptcy']"))
      .shouldHave(text("Да"))
      .click();
    $(("[test_id='filter_execution_procedure']"))
      .shouldHave(text("Да"))
      .click();
    sleep(2000);
    $(".base-dialog-card__btn-primary").click();
  }
}