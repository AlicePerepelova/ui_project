package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
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
    selectSlot.shouldBe(interactable);
    selectSlot.scrollIntoView(true);
    inputControl.shouldBe(interactable);
    inputControl.click();
    value54.shouldBe(interactable);
    value54.click();
  }

  public void checkControl() {
    controlCount.shouldHave(text("Показано54"));
  }
}
