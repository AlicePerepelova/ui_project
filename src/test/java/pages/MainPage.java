package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
  private final ElementsCollection headerMenu = $$(".site-header__nav-left");
  @Step("Открываем главную страницу")
  public void openMainPage() {
    open("/");
  }
  @Step("Проверка 'Шапки' главной страницы")
  public void checkMainHeader() {
    headerMenu.shouldHave(texts("Купить\n" +
      "Снять\n" +
      "Сервисы\n" +
      "Тарифы"));
  }
}
