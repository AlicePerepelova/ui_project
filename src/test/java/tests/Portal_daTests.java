package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class Portal_daTests {

  @Test
  @DisplayName("Проверка открытия главной страницы")
  void mainPageOpenTest() {
    open("https://portal-da.ru/");
    $("#query").setValue("694291");
    $(".btn-primary").pressEnter();
    $(".asset-card__asset-info").shouldHave(Condition.text("Сухогрузное судно общего назначения"));
  }
}
