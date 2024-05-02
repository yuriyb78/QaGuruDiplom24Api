package tests;


import io.qameta.allure.Feature;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.CheckCreateUser;
import steps.CheckUpdateUser;
import steps.CheckUser;


public class UserAccountTest extends BaseTest {

    @Test
    @Tag("User tests")
    @Feature("Тесты для API на сайте https://petstore.swagger.io/")
    @DisplayName("Проверка успешного создания пользователя")
    void checkCreateUserTest () {
        new CheckCreateUser().checkCreateUser();

    }

    @Test
    @Tag("User tests")
    @Feature("Тесты для API на сайте https://petstore.swagger.io/")
    @DisplayName("Проверка получения информации о пользователе")
    void checkGetUserInfoTest () {
        new CheckUser().getUserInfo();

    }

    @Test
    @Tag("User tests")
    @Feature("Тесты для API на сайте https://petstore.swagger.io/")
    @DisplayName("Проверка обновления информации о пользователе")
    void checkUpdateUserInfo () {
        new CheckUpdateUser().checkUpdateUserInfo();

    }
}
