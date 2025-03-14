package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ControlPage {
  private final SelenideElement
    searchBar = $(".search-bar-item__right"),
    active = $(byText("Офисное помещение")),
    selectSlot = $(".v-select__slot"),
    inputControl = $(".v-input__control"),
    controlCount = $(".listing-footer-controls__count");
  private final ElementsCollection collectionOfItem = $$(".asset-card__content-wrapper");

  @Step("Поиск элементов категории 'Офисное помещение'")
  public void searchItem() {
    searchBar.click();
    active.click();
  }

  @Step("Выбор отображения {itemCount} элементов на странице")
  public void selectControl(int itemCount) {
    SelenideElement value = $(byText(String.valueOf(itemCount)));
    value.shouldBe(interactable).click();

    selectSlot.shouldBe(interactable);
    selectSlot.scrollIntoView(true);
    inputControl.shouldBe(interactable);
    inputControl.click();
    value.shouldBe(interactable).click();
  }

  @Step("Проверка, что отобразилось {int itemCount} элемента на странице")
  public void checkControl(int itemCount) {
    collectionOfItem.shouldHave(sizeGreaterThan(itemCount - 1));
    controlCount.shouldHave(text("Показано " + itemCount));
  }
}
