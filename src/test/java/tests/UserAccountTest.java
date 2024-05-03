package tests;


import config.LoginConfig;
import io.qameta.allure.Feature;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.*;


public class UserAccountTest extends BaseTest {

    CheckUserInfo checkUserInfo = new CheckUserInfo();
    LoginConfig loginConfig = ConfigFactory.create(LoginConfig.class);

    @Test
    @Feature("Тесты для API на сайте https://petstore.swagger.io/")
    @DisplayName("Проверка успешного создания пользователя")
    @Tag("CreateUser")
    void checkCreateUserTest () {
        new CheckCreateUser().checkCreateUser();

    }

    @Test
    @Feature("Тесты для API на сайте https://petstore.swagger.io/")
    @DisplayName("Проверка получения информации о пользователе")
    @Tag("CheckUserInfo")
    void checkGetUserInfoTest () {
        checkUserInfo.checkUserInfo();

    }

    @Test
    @Feature("Тесты для API на сайте https://petstore.swagger.io/")
    @DisplayName("Проверка обновления информации о пользователе")
    @Tag("UpdateUserInfo")
    void checkUpdateUserInfo () {
        new CheckUpdateUser().checkUpdateUserInfo();

    }

    @Test
    @Feature("Тесты для API на сайте https://petstore.swagger.io/")
    @DisplayName("Проверка удаления пользователя")
    @Tag("DeleteUser")
    void checkDeleteUser () {
        new CheckDeleteUser().checkDeleteUser();

    }
    @Test
    @Feature("Тесты для API на сайте https://petstore.swagger.io/")
    @DisplayName("Негативный тест. Проверка сообщения об ошибке при поиске несуществующего пользователя")
    @Tag("CheckErrorMessage")
    void checkMessageUserNotFound () {
        checkUserInfo.checkErrorMessage(loginConfig.userName());

    }

}
