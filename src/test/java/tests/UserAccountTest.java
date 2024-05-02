package tests;


import config.LoginConfig;
import io.qameta.allure.Feature;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.*;


public class UserAccountTest extends BaseTest {

    CheckUserInfo checkUserInfo = new CheckUserInfo();
    LoginConfig loginConfig = ConfigFactory.create(LoginConfig.class);

    @Test
    @Feature("Тесты для API на сайте https://petstore.swagger.io/")
    @DisplayName("Проверка успешного создания пользователя")
    void checkCreateUserTest () {
        new CheckCreateUser().checkCreateUser();

    }

    @Test
    @Feature("Тесты для API на сайте https://petstore.swagger.io/")
    @DisplayName("Проверка получения информации о пользователе")
    void checkGetUserInfoTest () {
        checkUserInfo.getUserInfo();

    }

    @Test
    @Feature("Тесты для API на сайте https://petstore.swagger.io/")
    @DisplayName("Проверка обновления информации о пользователе")
    void checkUpdateUserInfo () {
        new CheckUpdateUser().checkUpdateUserInfo();

    }

    @Test
    @Feature("Тесты для API на сайте https://petstore.swagger.io/")
    @DisplayName("Проверка удаления пользователя")
    void checkDeleteUser () {
        new CheckDeleteUser().checkDeleteUser();

    }
    @Test
    @Feature("Тесты для API на сайте https://petstore.swagger.io/")
    @DisplayName("Негативный тест. Проверка сообщения об ошибке при поиске несуществующего пользователя")
    void checkMessageUserNotFound () {
        checkUserInfo.getErrorMessage(loginConfig.userName());

    }

}
