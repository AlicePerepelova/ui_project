package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ControlPage {
  private final SelenideElement
    searchBar = $(".search-bar-item__right"),
    active = $(byText("Офисное помещение")),
    selectSlot = $(".v-select__slot"),
    inputControl = $(".v-input__control"),
    value54 = $(byText("54")),
    controlCount = $(".listing-footer-controls__count");

  public void searchItem() {
    searchBar.click();
    active.click();
  }

  public void selectControl() {
    selectSlot.shouldBe(visible);
    selectSlot.scrollIntoView(true);
    inputControl.shouldBe(visible);
    inputControl.click();
  }

  public void checkControl() {
    controlCount.shouldHave(text("Показано54"));
  }
}
