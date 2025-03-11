package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.*;

public class PortalDaTests extends TestBase {
  CookiePopUp cookie = new CookiePopUp();
  SearchCatalogPage search = new SearchCatalogPage();
  FilterPage filter = new FilterPage();
  SearchInputPage searchInput = new SearchInputPage();
  ControlPage control = new ControlPage();

  @Test
  @Feature("Проверка поиска товара")
  @Story("Позитивный тест")
  @Owner("@perepelovaAS")
  @Severity(SeverityLevel.CRITICAL)
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
  @Owner("@perepelovaas")
  @Severity(SeverityLevel.CRITICAL)
  @DisplayName("Проверка поиска {} по строке ввода")
  void searchByInputString() {
    open("/");
    cookie.checkCookiePopupDisplay();
    cookie.acceptCookie();
    searchInput.searchValue();
    searchInput.checkSearchResult();
    Selenide.clearBrowserCookies();
    Selenide.closeWebDriver();
  }

  @Test
  @Tag("POSITIVE")
  @Story("Позитивный тест")
  @Owner("@perepelovaas")
  @Severity(SeverityLevel.TRIVIAL)
  @DisplayName("Проверка контроллов")
  void checkControl() {
    Configuration.pollingInterval = 500;
    open("/");
    cookie.checkCookiePopupDisplay();
    cookie.acceptCookie();
    control.searchItem();
    control.selectControl();
    control.checkControl();
    Selenide.clearBrowserCookies();
    closeWebDriver();
  }

  @Test
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