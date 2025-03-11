package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.CookiePopUp;
import pages.FilterPage;
import pages.SearchCatalog;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PortalDaTests extends TestBase {
  CookiePopUp cookie = new CookiePopUp();
  SearchCatalog search = new SearchCatalog();
  FilterPage filter=new FilterPage();

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
    search.clickOnSearchBarItem("Офисное помещение");
    search.verifyCatalogContainsOfficeRooms("Офисное помещение");
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

  Test
  @Tag("POSITIVE")
  @Story("Позитивный тест")
  @Owner("@perepelovaas")
  @Severity(SeverityLevel.BLOCKER)
  @DisplayName("Проверка фильтра")

  void checkFilter() {
    open("/");
    cookie.checkCookiePopupDisplay();
    cookie.acceptCookie();
    filter.openFilter();
    filter.selectRegion();
    filter.selectPriceRange();
    filter.selectSaleMethod();
    filter.verifySellerSelection();
    filter.verifyPledgeStatus();
    filter.verifyBankruptcy();
    filter.verifyExecutionProcedure();
    filter.clickShowButton();
  }
}