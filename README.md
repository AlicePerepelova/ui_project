# ui_project
<h1 align="center">Portal DA – сервис от Сбербанка, 
предназначенный для покупки и продажи залогов и непрофильных активов</h1>
<a id="cases"></a>

<a id="autotests"></a>
<h1 align="center">Проект по автоматизации тестирования онлайн сервиса от Сбербанка</h1>

<p align="center">
<a href="https://portal-da.ru/"><img title="Allure Overview" src="media/logo/sber.svg"> </a>
</p>

> 

##  Содержание:
- <a href="#cases"> Тест-кейсы</a>
- <a href="#autotests"> Запуск автотестов</a>
- <a href="#jenkins"> Сборка в Jenkins</a>
- <a href="#allureReport"> Пример Allure-отчета</a>
- <a href="#tg"> Уведомления в Telegram с использованием бота</a>
- <a href="#video"> Видео примера запуска тестов в Selenoid</a>

Тесты написаны на языке <code>Java</code> с использованием фреймворка для автоматизации тестирования <code>Selenide</code>, сборщик - <code>Gradle</code>.

<code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования.
При прогоне тестов для удаленного запуска используется <code>Selenoid</code>.

Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.

Содержание Allure-отчета для каждого кейса:
* Шаги теста и результат их выполнения
* Скриншот страницы на последнем шаге (возможность визуально проанализировать, почему упал тест)
* Page Source (возможность открыть source страницы в новой вкладке и посмотреть причину падения теста)
* Логи консоли браузера
* Видео выполнения автотеста.

____
<a id="cases"></a>
## 🕵️‍♂️ Тест-кейсы
Auto:
- Проверка поиска по категории каталога
- Проверка поиска по строке ввода
- Проверка контролов
- Проверка применения Фильтров

<a id="autotests"></a>
____
## ▶️ Запуск автотестов

### Запуск тестов из терминала

Для запуска тестов локально использовать команду ниже:
```
./gradlew clean test -Denv=local
```
Для запуска тестов на Selenoid использовать команду ниже:
```
./gradlew clean test -Denv=prod 
```

---
<a id="jenkins"></a>
## <img width="20" style="vertical-align:middle" title="Jenkins" src="media/logo/jenkins.svg"> </a> Сборка в <a target="_blank" href="https://jenkins.autotests.cloud/job/sport-marafon-tests/"> Jenkins </a>
Для доступа в Jenkins необходима регистрация на ресурсе [Jenkins](https://jenkins.autotests.cloud/)
Для запуска сборки необходимо перейти в раздел <code>Build with parameters</code>, выбрать необходимые параметры и нажать кнопку <code>Build</code>.
###  Параметры сборки в Jenkins:
- TASK (набор тестов для запуска)
- ENVIRONMENT (стенд для выполнения)
- BROWSER (браузер для запуска)
- BROWSER_VERSION (версия браузера)
- BROWSER_SIZE (размер окна браузера)
- 
<p align="center">
<img title="Jenkins Build" src="src/media/screenshots/jenkins.png">
</p>
После выполнения сборки, в блоке <code>Build History</code> напротив номера сборки появится значок <code>Allure Report</code>  при клике на который откроется страница с сформированным html-отчетом.

____
<a id="allureReport"></a>
## <img width="30" style="vertical-align:middle" title="Allure Report" src="media/logo/allure.svg"> </a> Пример <a target="_blank" href="https://jenkins.autotests.cloud/job/sport-marafon-tests/8/allure/"> Allure-отчета </a>
<p align="center">
<img title="Allure Overview" src="src/media/screenshots/allure.png">
</p>

____
<a id="tg"></a>
## <img width="30" style="vertical-align:middle" title="Telegram" src="media/logo/telegram.svg"> Уведомления в Telegram с использованием бота
После завершения сборки, бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов в специально настроенный чат.
<p align="center">
<img width="40%" title="Telegram Notifications" src="src/media/screenshots/telegram.png">
</p>

____
<a id="video"></a>
## <img width="30" style="vertical-align:middle" title="Selenoid" src="media/logo/Selenoid.svg"> Видео примера запуска тестов в Selenoid
В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео прохождения теста
<p align="center">
  <img title="Selenoid Video" src="media/screenshots/video.gif">

</p>