# Проект по автоматизации тестовых сценариев для API

## :scroll: Содержание:

- [Используемый стек](#computer-используемый-стек)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testOps)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram](#-уведомления-в-telegram)

<a id="annotation"></a>
## Описание
Тестовый проект состоит из веб-тестов (UI), тестов API и мобильных тестов (Android).\
Краткий список интересных фактов о проекте:
- [x] Использование `Faker` для генерации данных
- [x] Использование `Lombok` для моделей в API тестах
- [x] Использование request/response спецификаций для API тестов
- [x] Custom Allure listener для API requests/responses логов
- [x] Интеграция с `Allure TestOps`
- [x] Возможность запуска тестов напрямую из `Allure TestOps`
- [x] Интеграция с `Jira`
- [x] Автотесты оформлены как тестовая документация посредством аннотаций `Allure`

## :computer: Используемый стек

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="media/logos/IntelijIDEA.svg"></a> 
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/logos/Java.svg"></a> 
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/logos/Gradle.svg"></a> 
<a href="https://rest-assured.io/"><img width="6%" title="Rest Assured" src="media/logos/RestAssured.png"></a> 
<a href="https://github.com/allure-framework/allure2"><img width="6%" title="Allure Report" src="media/logos/AllureReport.svg"></a> 
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/logos/JUnit5.svg"></a> 
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/logos/GitHub.svg"></a> 
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/logos/Jenkins.svg"></a> 
<a href="https://telegram.org/"><img width="6%" title="Telegram" src="media/logos/Telegram.svg"></a> 
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/logos/AllureTestOps.svg"></a> 
<a href="https://www.atlassian.com/ru/software/jira/"><img width="5%" title="Jira" src="media/logos/Jira.svg"></a> 
</p>

Тесты в проекте написаны на языке <code>Java</code> с использованием фреймворка для тестирования [Rest Assured](https://rest-assured.io/) и сборщика <code>Gradle</code>. <code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования.
Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота. Также реализована интеграция с <code>Allure TestOps</code> и <code>Jira</code>.

Содержание Allure-отчета:
* Шаги теста;
* Запрос на сервер
* Ответ сервера

<a id="cases"></a>
## Реализованные проверки
:heavy_check_mark: Проверка создания пользователя

:heavy_check_mark: Проверка получения информации о пользователе

:heavy_check_mark: Проверка обновления информации о пользователе

:heavy_check_mark: Проверка удаления пользователя

:heavy_check_mark: Негативный тест: проверка получение сообщения об ошибке при запросе информации о несуществующем пользователе 

## :arrow_forward: Запуск автотестов

### Запуск тестов из терминала (с параметрами по умолчанию)
```
gradle clean test
```

### Запуск тестов из Jenkins (с указанием параметров)
```
clean ${TYPETEST}
```

### Параметры сборки

* <code>TYPETEST</code> - выбор тестируемой функциональности
    1. Test- запуск всех тестов в проекте
    2. Create - Проверка создания пользователя
    3. Info - Проверка получения информации о пользователе
    4. Update  - Проверка обновления информации о пользователе
    5. Delete - Проверка удаления пользователя
    6. Error - Негативный тест: проверка получение сообщения об ошибке при запросе информации о несуществующем пользователе

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logos/Jenkins.svg"> [Сборка](https://jenkins.autotests.cloud/job/C24-yuriy_belyaev-DiplomTestAPI/) в Jenkins

Для запуска сборки необходимо перейти в раздел <code>Build with parameters</code> и нажать кнопку <code>Build</code>.
<p align="center">
<img title="Сборка в Jenkins" src="media/screenshots/Jenkins_diplom.png">
</p>
После выполнения сборки, в блоке <code>Build History</code> напротив номера сборки появятся значки <code>Allure Report</code> и <code>Allure TestOps</code>, при клике на которые откроется страница с сформированным html-отчетом и тестовой документацией соответственно.

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="media/logos/AllureReport.svg"> [Пример](https://jenkins.autotests.cloud/job/C24-yuriy_belyaev-HomeWorkUnit17/12/allure/) Allure-отчета
### Пример отчета с общим результатом прогона автотестов

<p align="center">
<img title="Общий вид отчёта Allure" src="media/screenshots/allure-report.png">
</p>

### Отображение результатов автоматизированного тестирования с разбивкой по тест-кейсам

<p align="center">
<img title="Список тест-кейсов в отчёте Allure" src="media/screenshots/test_suite_allurereport.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="media/logos/AllureTestOps.svg"> [Интеграция](https://allure.autotests.cloud/project/4118/dashboards) с Allure TestOps

На *Dashboard* в <code>Allure TestOps</code> видна статистика количества тестов: сколько из них добавлены и проходятся вручную, сколько автоматизированы. Новые тесты, а также результаты прогона приходят по интеграции при каждом запуске сборки.

<p align="center">
<img title="Дэшборд Allure TestOps" src="media/screenshots/allure_testops_dashboard.png">
</p>

### Результат выполнения автотеста

<p align="center">
<img title="Результаты теста в Allure TestOps" src="media/screenshots/allure-testsops-result.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Jira" src="media/logos/Jira.svg"> [Интеграция](https://jira.autotests.cloud/browse/HOMEWORK-1156) с Jira

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в тикете отображается, какие тест-кейсы были написаны в рамках задачи и их прогоны.

<p align="center">
<img title="Тикет в Jira" src="media/screenshots/jira_integration.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logos/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки специальный бот, созданный в <code>Telegram</code>, получает из Jenkins и отправляет сообщение с отчётом о прогоне тестов.

<p align="center">
<img width="50%" title="Уведомление в Telegram" src="media/screenshots/telegram_result.png">
</p>


