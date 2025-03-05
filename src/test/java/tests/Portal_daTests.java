package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CookiePopUp;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Portal_daTests extends TestBase {
  CookiePopUp cookie= new CookiePopUp();


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
  void searchByInputString(){
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
  void checkControl(){
    Configuration.pollingInterval = 500;
    open("/");
    cookie.checkCookiePopupDisplay();
    cookie.acceptCookie();
    sleep(1500);
    $(".search-bar-item__right").click();
    $(byText("Офисное помещение")).click();
    $("div.listing-footer-controls__more span").shouldBe(interactable);

    $("div.listing-footer-controls__more span").scrollIntoView(true);

    $("div.listing-footer-controls__more span").click();

    int i = 1;

    $(".listing-footer-controls__count").shouldHave(text("Показано 18"));

    closeWebDriver();


//    sleep(2000);
//    executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
////    $(".v-icon__svg").click();
////    $(byText("54")).click();
//    executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
//    sleep(5000);
//    $("div.listing-footer-controls__more span").click();
//    sleep(5000);
//    //$(".listing-footer-controls__more button").click();
//    int childCount = $$(".catalog-grid > 54").size();
//   // $$(".catalog-grid").shouldHave(sizeGreaterThanOrEqual(54));
//    Selenide.clearBrowserCookies();
//    Selenide.closeWebDriver();

  }
//  executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
}
