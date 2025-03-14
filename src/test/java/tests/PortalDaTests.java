package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.*;

import static com.codeborne.selenide.Selenide.*;

public class PortalDaTests extends TestBase {
  CookiePopUp cookie = new CookiePopUp();
  SearchCatalogPage search = new SearchCatalogPage();
  FilterPage filter = new FilterPage();
  SearchInputPage searchInput = new SearchInputPage();
  ControlPage control = new ControlPage();
  MainPage mainPage = new MainPage();

  @Test
  @Tags({
    @Tag("SMOKE"),
    @Tag("POSITIVE"),
    @Tag("WEB")
  })
  @Feature("Проверка поиска товара по категории")
  @Story("Позитивный тест")
  @Owner("@perepelovaAS")
  @Severity(SeverityLevel.CRITICAL)
  @DisplayName("Проверка поиска {active} по категории каталога")
  void searchCatalogTest() {
    mainPage.openMainPage();
    mainPage.checkMainHeader();
    cookie.checkCookiePopupDisplay();
    cookie.acceptCookie();
    search.clickOnSearchBarItem("Офисное помещение");
    search.verifyCatalogContainsOfficeRooms("Офисное помещение");
    Selenide.clearBrowserCookies();
  }

  @Test
  @Tags({
    @Tag("WEB"),
    @Tag("POSITIVE")
  })
  @Feature("Проверка поиска товара по строке ввода")
  @Story("Позитивный тест")
  @Owner("@perepelovaas")
  @Severity(SeverityLevel.CRITICAL)
  @DisplayName("Проверка поиска {} по строке ввода")
  void searchByInputString() {
    mainPage.openMainPage();
    mainPage.checkMainHeader();
    cookie.checkCookiePopupDisplay();
    cookie.acceptCookie();
    searchInput.searchValue();
    searchInput.checkSearchResult();
  }


  @Tag("POSITIVE")
  @Story("Позитивный тест")
  @Owner("@perepelovaas")
  @Severity(SeverityLevel.TRIVIAL)
  @DisplayName("Проверка контролов")
  @ValueSource(ints = {
    18, 27, 54
  })
  @ParameterizedTest
  void checkControl(int testData) {

    Configuration.pollingInterval = 500;
    mainPage.openMainPage();
    mainPage.checkMainHeader();
    sleep(2500);
    cookie.checkCookiePopupDisplay();
    cookie.acceptCookie();
    control.searchItem();
    sleep(2500);
    control.selectControl();
    control.checkControl();
  }

  @Test
  @Tag("POSITIVE")
  @Story("Позитивный тест")
  @Owner("@perepelovaas")
  @Severity(SeverityLevel.BLOCKER)
  @DisplayName("Проверка фильтра")
  void checkFilter() {
    mainPage.openMainPage();
    mainPage.checkMainHeader();
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