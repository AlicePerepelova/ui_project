package pages;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class CookiePopUp {
  private final SelenideElement cookiePopup = $(".cookies-alert"),
    acceptButton = $(".cookies-alert__close");

  public void checkCookiePopupDisplay () {
    cookiePopup.shouldBe(visible);
  }

  public void acceptCookie () {
    acceptButton.click();
    cookiePopup.shouldNotBe(visible);;
  }
}