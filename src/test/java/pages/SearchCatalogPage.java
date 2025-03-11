package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchCatalogPage {
  private final String active = "Офисное помещение";
  private final SelenideElement searchBarItem = $(".search-bar-item__right");
  private final SelenideElement officeRoomOption = $(byText(active));
  private final SelenideElement pageTitleElement = $(".content-layout__title");
  private final ElementsCollection catalogGrid = $$(".catalog-grid");


  @Step("Ищем {active}")
  public void clickOnSearchBarItem(String nameOfActive) {
    searchBarItem.click();
    officeRoomOption.click();
  }

  @Step("Проверяем, что {active} нашлось")
  public void verifyCatalogContainsOfficeRooms(String nameOfActive) {
    pageTitleElement.shouldHave(text(nameOfActive));
    catalogGrid.shouldHave(texts(nameOfActive));
  }
}
